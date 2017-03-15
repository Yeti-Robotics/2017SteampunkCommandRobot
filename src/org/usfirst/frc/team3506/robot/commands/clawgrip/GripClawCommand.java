package org.usfirst.frc.team3506.robot.commands.clawgrip;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripClawCommand extends Command {

    public GripClawCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.clawGripSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.clawGripSubsystem.getGripState() == Value.kForward){
    		Robot.clawGripSubsystem.ungripClaw();
    	}
    	else {
    		Robot.clawGripSubsystem.gripClaw();
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
