package org.usfirst.frc.team3506.robot.commands.tower;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDumbWaiterCommand extends Command {

    public LiftDumbWaiterCommand() {
    	requires(Robot.towerSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.towerSubsystem.liftDumbWaiter();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.towerSubsystem.stopDumbWaiter();
    }
}
