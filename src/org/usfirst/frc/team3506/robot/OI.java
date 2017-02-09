package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.turretrotation.FindTargetCommand;
import org.usfirst.frc.team3506.robot.commands.turretrotation.ManualRotateCommand;
import org.usfirst.frc.team3506.robot.commands.turretrotation.ManualRotateReverseCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class OI {
	public Joystick leftJoystick, rightJoystick;

	public OI() {
		leftJoystick = new Joystick(RobotMap.LFFT_JOYSTICK_PORT);
		rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT);

//		setJoystickButtonWhenPressedCommand(rightJoystick, 1, new ToggleGearShiftCommand());
//		setJoystickButtonWhilePressedCommand(rightJoystick, 2, new OutputCommand());
//		setJoystickButtonWhilePressedCommand(rightJoystick, 3, new IntakeCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 3, new FindTargetCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 4, new ManualRotateCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 5, new ManualRotateReverseCommand());
	}

	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whileHeld(command);
	}

	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
		
	}
	
}
