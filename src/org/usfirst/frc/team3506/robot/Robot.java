package org.usfirst.frc.team3506.robot;

import java.util.Collections;

import org.usfirst.frc.team3506.robot.commands.autonomous.AutonomousRouteControl;
import org.usfirst.frc.team3506.robot.commands.autonomous.CenterGearAutonomous;
import org.usfirst.frc.team3506.robot.commands.autonomous.DriveForwardAutonomous;
import org.usfirst.frc.team3506.robot.commands.autonomous.LeftCenterAutonomous;
import org.usfirst.frc.team3506.robot.commands.autonomous.RightGearAutonomous;
import org.usfirst.frc.team3506.robot.subsystems.ClawGripSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ClawLiftSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;
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

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
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
	public static GearPickerSubsystem gearPickerSubsystem;
	public static ClawGripSubsystem clawGripSubsystem;
	public static ClawLiftSubsystem clawLiftSubsystem;
	public static TurretFlywheelSubsystem turretFlywheelSubsystem;
	public static TurretPitchSubsystem turretPitchSubsystem;
	public static AutonomousRouteControl autonomousRouteControl;
	public SendableChooser<Robot.AutoModes> autoChooser;
	public static OI oi;
	public static UsbCamera camera1;
	public static UsbCamera camera2;
	public static VideoSink server;
	public static boolean usingCamera1 = true;

	public static Command autonomousCommand;

	private VisionThread visionThread;
	private final Object imgLock = new Object();
	public static boolean runVisionThread;

	public static enum AutoModes {
		CENTER_GEAR, LEFT_GEAR, RIGHT_GEAR, DRIVE_FORWARD, ROUTE_CONTROL
	}

	public void robotInit() {
		turretRotationSubsystem = new TurretRotationSubsystem();
		rightDrivetrainSubsystem = new RightDrivetrainSubsystem();
		leftMainDrivetrainSubsystem = new LeftDrivetrainSubsystem();
		gearShiftSubsystem = new GearShiftSubsystem();
		intakeSubsystem = new IntakeSubsystem();
		clawGripSubsystem = new ClawGripSubsystem();
		clawLiftSubsystem = new ClawLiftSubsystem();
		towerSubsystem = new TowerSubsystem();
		climberSubsystem = new ClimberSubsystem();
		gearPickerSubsystem = new GearPickerSubsystem();
		turretFlywheelSubsystem = new TurretFlywheelSubsystem();
		turretPitchSubsystem = new TurretPitchSubsystem();
		autonomousRouteControl = new AutonomousRouteControl();
		oi = new OI();
		autoChooser = new SendableChooser<AutoModes>();
		autoChooser.addDefault("Drive Forward", AutoModes.DRIVE_FORWARD);
		autoChooser.addObject("Center Gear", AutoModes.CENTER_GEAR);
		autoChooser.addObject("Left Gear", AutoModes.LEFT_GEAR);
		autoChooser.addObject("Right Gear", AutoModes.RIGHT_GEAR);
		autoChooser.addObject("Route Control", AutoModes.ROUTE_CONTROL);
		autonomousCommand = new DriveForwardAutonomous();
		SmartDashboard.putData("Auto Chooser", autoChooser);
		SmartDashboard.putData(Scheduler.getInstance());

		camera1 = CameraServer.getInstance().startAutomaticCapture(0);
		camera2 = CameraServer.getInstance().startAutomaticCapture(1);
		camera1.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		camera2.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		server = CameraServer.getInstance().getServer();
		disableVisionProcessing();
		if (camera1.isConnected() || camera2.isConnected()) {
			visionThread = new VisionThread(camera1, new RedContourVisionPipeline(), pipeline -> {
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
	
	public static void enableVisionProcessing() {
		camera1.setBrightness(RobotMap.CAM_BRIGHTNESS_VISION);
		camera1.setExposureManual(RobotMap.CAM_EXPOSURE_VISION);
		camera2.setBrightness(RobotMap.CAM_BRIGHTNESS_VISION);
		camera2.setExposureManual(RobotMap.CAM_EXPOSURE_VISION);
		runVisionThread = true;
	}
	
	public static void disableVisionProcessing() {
		camera1.setBrightness(RobotMap.CAM_BRIGHTNESS_DRIVING);
		camera1.setExposureManual(RobotMap.CAM_EXPOSURE_DRIVING);
		camera2.setBrightness(RobotMap.CAM_BRIGHTNESS_DRIVING);
		camera2.setExposureManual(RobotMap.CAM_EXPOSURE_DRIVING);
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
			case ROUTE_CONTROL:
				autonomousCommand = autonomousRouteControl;
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
