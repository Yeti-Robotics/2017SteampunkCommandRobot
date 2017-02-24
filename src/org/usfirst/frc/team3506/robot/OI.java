package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.climber.ClimbUpCommand;
import org.usfirst.frc.team3506.robot.commands.dumbwaiter.LowerTowerCommand;
import org.usfirst.frc.team3506.robot.commands.dumbwaiter.RaiseTowerCommand;
import org.usfirst.frc.team3506.robot.commands.geardispenser.ExtendGearDispenserCommand;
import org.usfirst.frc.team3506.robot.commands.geardispenser.RetractGearDispenserCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleIntakeCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleOutputCommand;
import org.usfirst.frc.team3506.robot.commands.turretflywheel.ActivateFlywheelCommand;
import org.usfirst.frc.team3506.robot.commands.turretrotation.ManualRotateCommand;
import org.usfirst.frc.team3506.robot.commands.turretrotation.ManualRotateReverseCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
	public Joystick leftJoystick, rightJoystick, shooterJoystick;

	public OI() {
		leftJoystick = new Joystick(RobotMap.LFFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);
		shooterJoystick = new Joystick(RobotMap.SHOOTER_JOYSTICK_PORT);

		// Left joystick
		setJoystickButtonWhenPressedCommand(leftJoystick, 1, new ToggleGearShiftCommand());
		setJoystickButtonWhenPressedCommand(leftJoystick, 3, new ExtendGearDispenserCommand());
		setJoystickButtonWhenPressedCommand(leftJoystick, 5, new RetractGearDispenserCommand());

		// Right joystick
		setJoystickButtonWhilePressedCommand(rightJoystick, 1, new ClimbUpCommand());
		setJoystickButtonWhenPressedCommand(rightJoystick, 4, new ToggleIntakeCommand());
		setJoystickButtonWhenPressedCommand(rightJoystick, 6, new ToggleOutputCommand());

		// Shooter joystick
		setJoystickButtonWhilePressedCommand(shooterJoystick, 1, new ActivateFlywheelCommand());
		setJoystickButtonWhilePressedCommand(shooterJoystick, 2, new LowerTowerCommand());
		setJoystickButtonWhilePressedCommand(shooterJoystick, 3, new RaiseTowerCommand());
		setJoystickButtonWhilePressedCommand(shooterJoystick, 4, new ManualRotateReverseCommand());
		setJoystickButtonWhilePressedCommand(shooterJoystick, 5, new ManualRotateCommand());
	}

	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whileHeld(command);
	}

	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}

}
