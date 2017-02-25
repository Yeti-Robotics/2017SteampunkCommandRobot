package org.usfirst.frc.team3506.robot.commands.gearpicker;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RetractGearDispenserCommand extends Command {

    public RetractGearDispenserCommand() {
    	requires(Robot.gearDispenserSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gearDispenserSubsystem.retractDispenser();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
