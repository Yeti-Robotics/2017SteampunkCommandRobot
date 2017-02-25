package org.usfirst.frc.team3506.robot.commands.geardispenser;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ExtendGearPickerCommand extends Command {

    public ExtendGearPickerCommand() {
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
