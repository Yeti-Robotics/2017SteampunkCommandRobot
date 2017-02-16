package org.usfirst.frc.team3506.robot.commands.dumbwaiter;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LowerTowerCommand extends Command {

    public LowerTowerCommand() {
    	requires(Robot.towerSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.towerSubsystem.lowerTower();
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
