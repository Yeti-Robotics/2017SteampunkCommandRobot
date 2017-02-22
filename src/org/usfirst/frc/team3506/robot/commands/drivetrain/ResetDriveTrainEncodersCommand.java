package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class ResetDriveTrainEncodersCommand extends Command {

    public ResetDriveTrainEncodersCommand() {
    	requires(Robot.driveTrainSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrainSubsystem.resetEncoders();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	Scheduler.getInstance().add(new UserDriveCommand());
    }

    protected void interrupted() {
    	Scheduler.getInstance().add(new UserDriveCommand());
    }
}
