package org.usfirst.frc.team3506.robot.commands.intake;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpurtOutCommand extends Command {

	public SpurtOutCommand() {
		requires(Robot.intakeSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.intakeSubsystem.floorSpurtOut();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
