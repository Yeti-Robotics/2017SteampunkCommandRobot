package org.usfirst.frc.team3506.robot;

import java.util.Collections;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3506.robot.commands.commandgroups.CenterGearCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.LeftCenterCommandGroup;
import org.usfirst.frc.team3506.robot.commands.commandgroups.RightGearCommandGroup;
import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearDispenserSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearPickerSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearShiftSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem.IntakeState;
import org.usfirst.frc.team3506.robot.subsystems.TowerSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretFlywheelSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretPitchSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretRotationSubsystem;
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

	public static DrivetrainSubsystem driveTrainSubsystem;
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

	public static Command autonomousCommand;

	private VisionThread visionThread;
	private final Object imgLock = new Object();
	public static double visionCenterX;
	public static double visionArea;

	public static enum AutoModes {
		CENTER_GEAR, LEFT_GEAR, RIGHT_GEAR
	}

	public void robotInit() {
		turretRotationSubsystem = new TurretRotationSubsystem();
		driveTrainSubsystem = new DrivetrainSubsystem();
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
		autoChooser.addDefault("Center Gear", AutoModes.CENTER_GEAR);
		autoChooser.addObject("Left Gear", AutoModes.LEFT_GEAR);
		autoChooser.addObject("Right Gear", AutoModes.RIGHT_GEAR);
		autonomousCommand = new CenterGearCommandGroup();
		SmartDashboard.putData("Auto Chooser", autoChooser);

		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
		camera.setResolution(RobotMap.IMG_WIDTH, RobotMap.IMG_HEIGHT);
		visionThread = new VisionThread(camera, new RedContourVisionPipeline(), pipeline -> {
			if (!pipeline.findContoursOutput().isEmpty()) {
				Collections.sort(pipeline.convexHullsOutput(), (first, second) -> {
					if (first.size().area() > second.size().area()) {
						return -1;
					} else if (first.size().area() == second.size().area()) {
						return 0;
					} else {
						return 1;
					}
				});
				Rect rectangle = Imgproc.boundingRect(pipeline.convexHullsOutput().get(0));
				synchronized (imgLock) {
					Robot.visionCenterX = rectangle.x + (rectangle.width / 2);
					Robot.visionArea = rectangle.area();
				}
			}
		});
		visionThread.start();
	}

	public void disabledInit() {
		intakeSubsystem.intakeState = IntakeState.OFF;
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		switch ((AutoModes) autoChooser.getSelected()) {
		case CENTER_GEAR:
			autonomousCommand = new CenterGearCommandGroup();
			break;
		case LEFT_GEAR:
			autonomousCommand = new LeftCenterCommandGroup();
			break;
		case RIGHT_GEAR:
			autonomousCommand = new RightGearCommandGroup();
			break;
		default:
			autonomousCommand = new CenterGearCommandGroup();
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
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}
