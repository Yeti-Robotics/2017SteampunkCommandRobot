package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.subsystems.ClimberSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearDispenserSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.GearShiftSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem.IntakeState;
import org.usfirst.frc.team3506.robot.subsystems.TowerSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretFlywheelSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretPitchSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.TurretRotationSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot {

	public static DrivetrainSubsystem driveTrainSubsystem;
	public static GearShiftSubsystem gearShiftSubsystem;
	public static IntakeSubsystem intakeSubsystem;
	public static TurretRotationSubsystem turretRotationSubsystem;
	public static TowerSubsystem towerSubsystem;
	public static ClimberSubsystem climberSubsystem;
	public static GearDispenserSubsystem gearDispenserSubsystem;
	public static TurretFlywheelSubsystem turretFlywheelSubsystem;
	public static TurretPitchSubsystem turretPitchSubsystem;

	public static OI oi;

	public void robotInit() {
		turretRotationSubsystem = new TurretRotationSubsystem();
		driveTrainSubsystem = new DrivetrainSubsystem();
		gearShiftSubsystem = new GearShiftSubsystem();
		intakeSubsystem = new IntakeSubsystem();
		towerSubsystem = new TowerSubsystem();
		climberSubsystem = new ClimberSubsystem();
		gearDispenserSubsystem = new GearDispenserSubsystem();
		turretFlywheelSubsystem = new TurretFlywheelSubsystem();
		turretPitchSubsystem = new TurretPitchSubsystem();
		oi = new OI();
	}

	public void disabledInit() {
		intakeSubsystem.intakeState = IntakeState.OFF;
	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
	}

	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		turretRotationSubsystem.getDesiredRotationSpeed(turretRotationSubsystem.getAreas()[0], turretRotationSubsystem.getCenterX()[0]);
	}

	public void testPeriodic() {
		LiveWindow.run();
	}
}