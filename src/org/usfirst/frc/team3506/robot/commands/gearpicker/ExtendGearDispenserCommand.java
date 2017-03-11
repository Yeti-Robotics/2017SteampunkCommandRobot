package org.usfirst.frc.team3506.robot.commands.gearpicker;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExtendGearDispenserCommand extends Command {

    public ExtendGearDispenserCommand() {
    	requires(Robot.gearPickerSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.gearPickerSubsystem.extendDispenser();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
