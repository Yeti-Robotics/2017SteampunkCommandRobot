package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.camera.ToggleCameraCommand;
import org.usfirst.frc.team3506.robot.commands.clawgrip.GripClawCommand;
import org.usfirst.frc.team3506.robot.commands.clawlift.LiftClawCommand;
import org.usfirst.frc.team3506.robot.commands.clawlift.LowerClawCommand;
import org.usfirst.frc.team3506.robot.commands.climber.ClimbUpCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.ResetDriveTrainEncodersCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.ExtendGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.RetractGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;

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
		setJoystickButtonWhenPressedCommand(leftStick, 2, new ToggleCameraCommand());
		setJoystickButtonWhenPressedCommand(leftStick, 3, new DriveStraightPIDCommand(-5));
		setJoystickButtonWhenPressedCommand(leftStick, 4, new DriveStraightPIDCommand(5));

		// Right joystick
		setJoystickButtonWhilePressedCommand(rightStick, 1, new ClimbUpCommand());
		setJoystickButtonWhenPressedCommand(rightStick, 2, new DriveStraightPIDCommand(5));
		setJoystickButtonWhenPressedCommand(rightStick, 3, new PointTurnPIDCommand(180));

		// Shooter joystick
		setJoystickButtonWhenPressedCommand(shooterStick, 1, new GripClawCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 2, new LowerClawCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 3, new LiftClawCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 6, new ExtendGearPickerCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 7, new RetractGearPickerCommand());
		setJoystickButtonWhenPressedCommand(shooterStick, 9, new ResetDriveTrainEncodersCommand());
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
