package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.climber.ClimbUpCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.ToggleDrivetrainControlTypeCommand;
import org.usfirst.frc.team3506.robot.commands.dumbwaiter.LowerTowerCommand;
import org.usfirst.frc.team3506.robot.commands.dumbwaiter.RaiseTowerCommand;
import org.usfirst.frc.team3506.robot.commands.geardispenser.RetractGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.geardispenser.ExtendGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleIntakeCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleOutputCommand;
import org.usfirst.frc.team3506.robot.commands.turretflywheel.ActivateFlywheelCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
	public Joystick leftStick, rightStick, shooterStick;

	public OI() {
		leftStick = new Joystick(RobotMap.LFFT_JOYSTICK_PORT);
		rightStick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
		shooterStick = new Joystick(RobotMap.SHOOTER_JOYSTICK_PORT);

		// Left joystick
		setJoystickButtonWhenPressedCommand(leftStick, 1, new ToggleGearShiftCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 3, new RetractGearPickerCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 5, new ExtendGearPickerCommand());

		// Right joystick
		setJoystickButtonWhilePressedCommand(rightStick, 1, new ClimbUpCommand());

		// Shooter joystick
		setJoystickButtonWhilePressedCommand(shooterStick, 1, new ActivateFlywheelCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 2, new LowerTowerCommand());
		setJoystickButtonWhilePressedCommand(shooterStick, 3, new RaiseTowerCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 7, new ToggleIntakeCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 6, new ToggleOutputCommand());
//		setJoystickButtonWhilePressedCommand(shooterStick, 4, new ManualRotateReverseCommand());
//		setJoystickButtonWhilePressedCommand(shooterStick, 5, new ManualRotateCommand());w
	}
	
	public double getShooterY() {
		if (!(shooterStick == null)) {
			return -deadZoneMod(shooterStick.getY());
		} else {
			return 0;
		}
	}

	public double getRightX() {
		if (!(rightStick == null)) {
			return deadZoneMod(rightStick.getX());
		} else {
			return 0;
		}
	}

	public double getLeftX() {
		if (!(leftStick == null)) {
			return deadZoneMod(leftStick.getX());
		} else {
			return 0;
		}
	}

	public double getRightY() {
		if (!(rightStick == null)) {
			return -deadZoneMod(rightStick.getY());
		} else {
			return 0;
		}
	}

	public double getLeftY() {
		if (!(leftStick == null)) {
			return -deadZoneMod(leftStick.getY());
		} else {
			return 0;
		}
	}

	private double deadZoneMod(double val) {
		if (Math.abs(val) <= RobotMap.JOYSTICK_DEADZONE) {
			return 0;
		} else {
			return val;
		}
	}

	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whileHeld(command);
	}

	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}

}
