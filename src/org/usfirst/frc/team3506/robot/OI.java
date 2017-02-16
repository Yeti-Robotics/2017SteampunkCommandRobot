package org.usfirst.frc.team3506.robot;

import org.usfirst.frc.team3506.robot.commands.climber.ClimbDownCommand;
import org.usfirst.frc.team3506.robot.commands.climber.ClimbUpCommand;
import org.usfirst.frc.team3506.robot.commands.dumbwaiter.RaiseTowerCommand;
import org.usfirst.frc.team3506.robot.commands.dumbwaiter.LowerTowerCommand;
import org.usfirst.frc.team3506.robot.commands.geardispenser.ExtendGearDispenserCommand;
import org.usfirst.frc.team3506.robot.commands.geardispenser.RetractGearDispenserCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ToggleGearShiftCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleIntakeCommand;
import org.usfirst.frc.team3506.robot.commands.intake.ToggleOutputCommand;
import org.usfirst.frc.team3506.robot.commands.turretflywheel.ActivateFlywheelCommand;
import org.usfirst.frc.team3506.robot.commands.turretpitch.DecreasePitchCommand;
import org.usfirst.frc.team3506.robot.commands.turretpitch.IncreasePitchCommand;
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

		setJoystickButtonWhilePressedCommand(leftJoystick, 1, new ActivateFlywheelCommand());
		setJoystickButtonWhilePressedCommand(leftJoystick, 5, new ClimbUpCommand());
		setJoystickButtonWhilePressedCommand(leftJoystick, 3, new ClimbDownCommand());
		setJoystickButtonWhilePressedCommand(leftJoystick, 6, new IncreasePitchCommand());
		setJoystickButtonWhilePressedCommand(leftJoystick, 4, new DecreasePitchCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 9, new ManualRotateCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 10, new ManualRotateReverseCommand());
		setJoystickButtonWhenPressedCommand(leftJoystick, 11, new RetractGearDispenserCommand());
		setJoystickButtonWhenPressedCommand(leftJoystick, 12, new ExtendGearDispenserCommand());
		
		setJoystickButtonWhenPressedCommand(rightJoystick, 1, new ToggleGearShiftCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 6, new ToggleOutputCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 4, new ToggleIntakeCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 5, new RaiseTowerCommand());
		setJoystickButtonWhilePressedCommand(rightJoystick, 3, new LowerTowerCommand());
		
//		setJoystickButtonWhilePressedCommand(rightJoystick, 3, new FindTargetCommand());
	}

	private void setJoystickButtonWhilePressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whileHeld(command);
	}

	private void setJoystickButtonWhenPressedCommand(Joystick joystick, int button, Command command) {
		new JoystickButton(joystick, button).whenPressed(command);
		
	}
	
}
