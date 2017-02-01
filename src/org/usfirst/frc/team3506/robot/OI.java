package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleIntakeCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleOutputCommand;
import org.usfirst.frc.team3506.robot.commands.tower.LiftDumbWaiterCommand;
import org.usfirst.frc.team3506.robot.commands.tower.LowerDumbWaiterCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
	public Joystick leftJoystick, rightJoystick;

	public OI() {
		leftJoystick = new Joystick(RobotMap.LFFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);

		setJoystickButtonWhenPressedCommand(rightJoystick, 1, new ToggleGearShiftCommand());
		setJoystickButtonWhenPressedCommand(rightJoystick, 2, new ToggleOutputCommand());
		setJoystickButtonWhenPressedCommand(rightJoystick, 3, new ToggleIntakeCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 4, new LiftDumbWaiterCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 5, new LowerDumbWaiterCommand());
	}

	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whileHeld(command);
	}

	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
	}
}
 