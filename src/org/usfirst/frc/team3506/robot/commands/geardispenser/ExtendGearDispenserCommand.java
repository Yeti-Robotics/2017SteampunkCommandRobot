package org.usfirst.frc.team3506.robot.commands.geardispenser;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ExtendGearDispenserCommand extends Command {

    public ExtendGearDispenserCommand() {
    	requires(Robot.gearDispenserSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gearDispenserSubsystem.extendDispenser();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
