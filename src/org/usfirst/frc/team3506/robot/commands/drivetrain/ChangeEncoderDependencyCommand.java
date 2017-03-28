package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ChangeEncoderDependencyCommand extends Command {

    public ChangeEncoderDependencyCommand() {
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.leftMainDrivetrainSubsystem.useEncoders = !Robot.leftMainDrivetrainSubsystem.useEncoders;
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
