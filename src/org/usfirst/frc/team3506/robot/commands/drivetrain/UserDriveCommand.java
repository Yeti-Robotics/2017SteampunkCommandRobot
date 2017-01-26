package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class UserDriveCommand extends Command {

    public UserDriveCommand() {
    	requires(Robot.driveTrainSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrainSubsystem.tankDrive(Robot.oi.leftJoystick.getY(), Robot.oi.rightJoystick.getY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
