package org.usfirst.frc.team3506.robot.commands.camera;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleCameraCommand extends Command {

    public ToggleCameraCommand() {
    	
    }

    protected void initialize() {
    	if (Robot.usingCamera1) {
    		Robot.server.setSource(Robot.camera2);
    		Robot.usingCamera1 = false;
    	} else {
    		Robot.usingCamera1 = true;
    		Robot.server.setSource(Robot.camera1);
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
