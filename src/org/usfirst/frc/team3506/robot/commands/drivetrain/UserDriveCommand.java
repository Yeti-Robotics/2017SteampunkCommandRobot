package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem.ControlType;

import edu.wpi.first.wpilibj.command.Command;

public class UserDriveCommand extends Command {

    public UserDriveCommand() {
    	requires(Robot.driveTrainSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Robot.driveTrainSubsystem.getControlType() == ControlType.TANK) {
    		Robot.driveTrainSubsystem.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
    	} else {
    		Robot.driveTrainSubsystem.arcadeDrive(-Robot.oi.getRightX(), Robot.oi.getLeftY());
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
