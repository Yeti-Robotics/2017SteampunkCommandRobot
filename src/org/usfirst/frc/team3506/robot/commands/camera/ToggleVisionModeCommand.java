package org.usfirst.frc.team3506.robot.commands.camera;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleVisionModeCommand extends Command {

    public ToggleVisionModeCommand() {
    	
    }

    protected void initialize() {
    	if (Robot.runVisionThread) {
    		Robot.disableVisionProcessing();
    	} else {
    		Robot.enableVisionProcessing();
    	}
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
