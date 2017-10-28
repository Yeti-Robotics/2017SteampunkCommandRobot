package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;

import edu.wpi.first.wpilibj.command.Command;

public class UserDriveCommand extends Command {

    public UserDriveCommand() {
    	requires(Robot.rightDrivetrainSubsystem);
    	requires(Robot.leftMainDrivetrainSubsystem);
    }

    protected void initialize() {
    	DrivetrainSubsystemHandler.resetEncoders();
    	DrivetrainSubsystemHandler.disableDistancePID();
    }

    protected void execute() {
    	Robot.leftMainDrivetrainSubsystem.moveLeftTrain(Robot.oi.getLeftY());
    	Robot.rightDrivetrainSubsystem.moveRightTrain(Robot.oi.getRightY());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	
    }
}
