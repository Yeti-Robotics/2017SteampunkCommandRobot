package org.usfirst.frc.team3506.robot.commands.gearshift;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftDownCommand extends Command {

	public ShiftDownCommand() {
    	requires(Robot.gearshiftsubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gearshiftsubsystem.shiftDown();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
