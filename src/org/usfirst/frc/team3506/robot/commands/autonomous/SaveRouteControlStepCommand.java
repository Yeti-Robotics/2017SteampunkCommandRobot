package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SaveRouteControlStepCommand extends Command {

    public SaveRouteControlStepCommand() {
    	
    }

    protected void initialize() {
    	Robot.autonomousRouteControl.saveStep();
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
