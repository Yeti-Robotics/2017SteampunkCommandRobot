package org.usfirst.frc.team3506.robot.commands.climber;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ClimbUpCommand extends Command {

    public ClimbUpCommand() {
    	requires(Robot.climberSubsystem);
    }
    

    protected void initialize() {
    	Robot.climberSubsystem.climbUp();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.climberSubsystem.stopClimber();
    }
}
