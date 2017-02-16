package org.usfirst.frc.team3506.robot.commands.turretpitch;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IncreasePitchCommand extends Command {

    public IncreasePitchCommand() {
    	requires(Robot.turretPitchSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.turretPitchSubsystem.increasePitch();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
