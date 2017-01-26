package org.usfirst.frc.team3506.robot.commands.intake;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeCommand extends Command {

	public IntakeCommand() {
		requires(Robot.intakeSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		Robot.intakeSubsystem.runIntake();
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
		Robot.intakeSubsystem.stopIntake();
	}
}
