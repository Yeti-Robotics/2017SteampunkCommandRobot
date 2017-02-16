package org.usfirst.frc.team3506.robot.commands.dumbwaiter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseTowerCommand extends Command {

    public RaiseTowerCommand() {
    	requires(Robot.towerSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.towerSubsystem.raiseTower();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.towerSubsystem.stopTower();
    }
}
