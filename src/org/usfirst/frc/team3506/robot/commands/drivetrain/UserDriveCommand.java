package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler.DrivetrainFeedbackType;

import edu.wpi.first.wpilibj.command.Command;

public class UserDriveCommand extends Command {

    public UserDriveCommand() {
    	requires(Robot.rightDrivetrainSubsystem);
    	requires(Robot.leftMainDrivetrainSubsystem);
    }

    protected void initialize() {
    	DrivetrainSubsystemHandler.resetEncoders();
    	DrivetrainSubsystemHandler.setFeedbackType(DrivetrainFeedbackType.RATE);
    	DrivetrainSubsystemHandler.enable();
    }

    protected void execute() {
//    	if (Robot.leftMainDrivetrainSubsystem.getControlType() == ControlType.TANK) {
//    		Robot.leftMainDrivetrainSubsystem.tankDrive(Robot.oi.getLeftY(), Robot.oi.getRightY());
//    	} else {
//    		Robot.leftMainDrivetrainSubsystem.arcadeDrive(-Robot.oi.getRightX(), Robot.oi.getLeftY());
//    	}
    	DrivetrainSubsystemHandler.setSetpoint(Robot.oi.getLeftY(), Robot.oi.getRightY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	DrivetrainSubsystemHandler.disable();
    }
}
