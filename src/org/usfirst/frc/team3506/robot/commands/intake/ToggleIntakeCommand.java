package org.usfirst.frc.team3506.robot.commands.intake;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem.IntakeState;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleIntakeCommand extends Command {

	public ToggleIntakeCommand() {
		requires(Robot.intakeSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		if (Robot.intakeSubsystem.intakeState != IntakeState.IN) {
			Robot.intakeSubsystem.intakeState = IntakeState.IN;
		} else {
			Robot.intakeSubsystem.intakeState = IntakeState.OFF;
		}
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
