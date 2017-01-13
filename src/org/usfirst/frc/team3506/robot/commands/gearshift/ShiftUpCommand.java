package org.usfirst.frc.team3506.robot.commands.gearshift;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShiftUpCommand extends Command {

	public ShiftUpCommand() {
    	requires(Robot.gearshiftsubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gearshiftsubsystem.shiftUp();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
