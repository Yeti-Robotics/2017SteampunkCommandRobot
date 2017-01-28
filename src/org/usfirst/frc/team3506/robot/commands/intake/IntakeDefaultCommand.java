package org.usfirst.frc.team3506.robot.commands.intake;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem.IntakeState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeDefaultCommand extends Command {

    public IntakeDefaultCommand() {
        requires(Robot.intakeSubsystem);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	if(Robot.intakeSubsystem.intakeState == IntakeState.IN) {
    		Robot.intakeSubsystem.runIntake();
    	} else if (Robot.intakeSubsystem.intakeState == IntakeState.OUT) {
    		Robot.intakeSubsystem.runOutput();
    	} else {
    		Robot.intakeSubsystem.stopIntake();
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
