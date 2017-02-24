package org.usfirst.frc.team3506.robot.commands.turretpitch;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DecreasePitchCommand extends Command {

    public DecreasePitchCommand() {
    	requires(Robot.turretPitchSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.turretPitchSubsystem.decreasePitch();
    	Robot.turretPitchSubsystem.setLeftPitch();
    	Robot.turretPitchSubsystem.setRightPitch();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
