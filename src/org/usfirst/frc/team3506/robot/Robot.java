package org.usfirst.frc.team3506.robot;

import java.util.Collections;

import org.usfirst.frc.team3506.robot.commands.autonomous.CenterGearAutonomous;
import org.usfirst.frc.team3506.robot.commands.autonomous.DriveForwardAutonomous;
import org.usfirst.frc.team3506.robot.commands.autonomous.LeftCenterAutonomous;
import org.usfirst.frc.team3506.robot.commands.autonomous.RightGearAutonomous;
import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;
import org.usfirst.frc.team3506.robot.subsystems.GearDispenserSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearPickerSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearShiftSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem.IntakeState;
import org.usfirst.frc.team3506.robot.subsystems.LeftDrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.RightDrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TowerSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretFlywheelSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretPitchSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretRotationSubsystem;
import org.usfirst.frc.team3506.robot.vision.GearTargetInfo;
import org.usfirst.frc.team3506.robot.vision.RedContourVisionPipeline;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

public class Robot extends IterativeRobot {

	public static RightDrivetrainSubsystem rightDrivetrainSubsystem;
	public static LeftDrivetrainSubsystem leftMainDrivetrainSubsystem;
	public static GearShiftSubsystem gearShiftSubsystem;
	public static IntakeSubsystem intakeSubsystem;
	public static TurretRotationSubsystem turretRotationSubsystem;
	public static TowerSubsystem towerSubsystem;
	public static ClimberSubsystem climberSubsystem;
	public static GearDispenserSubsystem gearDispenserSubsystem;
	public static GearPickerSubsystem gearPickerSubsystem;
	public static TurretFlywheelSubsystem turretFlywheelSubsystem;
	public static TurretPitchSubsystem turretPitchSubsystem;
	public SendableChooser<Robot.AutoModes> autoChooser;
	public static OI oi;
	public static UsbCamera camera;

	public static Command autonomousCommand;

	private VisionThread visionThread;
	private final Object imgLock = new Object();
	private boolean runVisionThread;

	public static enum AutoModes {
		CENTER_GEAR, LEFT_GEAR, RIGHT_GEAR, DRIVE_FORWARD
	}

	public void robotInit() {
		turretRotationSubsystem = new TurretRotationSubsystem();
		rightDrivetrainSubsystem = new RightDrivetrainSubsystem();
		leftMainDrivetrainSubsystem = new LeftDrivetrainSubsystem();
		gearShiftSubsystem = new GearShiftSubsystem();
		intakeSubsystem = new IntakeSubsystem();
		towerSubsystem = new TowerSubsystem();
		climberSubsystem = new ClimberSubsystem();
		gearDispenserSubsystem = new GearDispenserSubsystem();
		gearPickerSubsystem = new GearPickerSubsystem();
		turretFlywheelSubsystem = new TurretFlywheelSubsystem();
		turretPitchSubsystem = new TurretPitchSubsystem();
		oi = new OI();
		autoChooser = new SendableChooser<AutoModes>();
		autoChooser.addDefault("Drive Forward", AutoModes.DRIVE_FORWARD);
		autoChooser.addObject("Center Gear", AutoModes.CENTER_GEAR);
		autoChooser.addObject("Left Gear", AutoModes.LEFT_GEAR);
		autoChooser.addObject("Right Gear", AutoModes.RIGHT_GEAR);
		autonomousCommand = new DriveForwardAutonomous();
		SmartDashboard.putData("Auto Chooser", autoChooser);
		SmartDashboard.putData(Scheduler.getInstance());

		camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		disableVisionProcessing();
		if (camera.isConnected()) {
			visionThread = new VisionThread(camera, new RedContourVisionPipeline(), pipeline -> {
				if (runVisionThread) {
					Collections.sort(pipeline.convexHullsOutput(), (first, second) -> {
						if (first.size().area() > second.size().area()) {
							return -1;
						} else if (first.size().area() == second.size().area()) {
							return 0;
						} else {
							return 1;
						}
					});
					GearTargetInfo.setTargetContours(pipeline.convexHullsOutput());
				}
			});
			visionThread.start();
		}
	}
	
	public void enableVisionProcessing() {
		camera.setBrightness(RobotMap.CAM_BRIGHTNESS_VISION);
		camera.setExposureManual(RobotMap.CAM_EXPOSURE_VISION);
		runVisionThread = true;
	}
	
	public void disableVisionProcessing() {
		camera.setBrightness(RobotMap.CAM_BRIGHTNESS_DRIVING);
		camera.setExposureManual(RobotMap.CAM_EXPOSURE_DRIVING);
		runVisionThread = false;
	}

	public void disabledInit() {
		intakeSubsystem.intakeState = IntakeState.OFF;
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
//		if (!camera.isConnected()) {
//			if (camera.getBrightness() != SmartDashboard.getNumber("Camera Brightness", 100)) {
//				camera.setBrightness((int) SmartDashboard.getNumber("Camera Brightness", 100));
//			}
//			if (currentCameraExposure != SmartDashboard.getNumber("Camera exposure", 0)) {
//				camera.setExposureManual((int) SmartDashboard.getNumber("Camera exposure", 0));
//				currentCameraExposure = (int) SmartDashboard.getNumber("Camera exposure", 0);
//			} 
//		}
	}

	public void autonomousInit() {
		switch ((AutoModes) autoChooser.getSelected()) {
			case DRIVE_FORWARD:
				autonomousCommand = new DriveForwardAutonomous();
				break;
			case CENTER_GEAR:
				autonomousCommand = new CenterGearAutonomous();
				break;
			case LEFT_GEAR:
				autonomousCommand = new LeftCenterAutonomous();
				break;
			case RIGHT_GEAR:
				autonomousCommand = new RightGearAutonomous();
				break;
			default:
				autonomousCommand = new DriveForwardAutonomous();
		}
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		rightDrivetrainSubsystem.publishEncoderValues();
		leftMainDrivetrainSubsystem.publishEncoderValues();
		DrivetrainSubsystemHandler.publishSmartDashboardValues();
		GearTargetInfo.publishTargetValues();
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
