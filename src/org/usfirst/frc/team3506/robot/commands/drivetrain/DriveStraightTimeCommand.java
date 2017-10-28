package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightTimeCommand extends Command {

	double time;
	
    public DriveStraightTimeCommand(double time) {
    	requires(Robot.rightDrivetrainSubsystem);
    	requires(Robot.leftMainDrivetrainSubsystem);
    	this.time = time;
    }

    protected void initialize() {
    	setTimeout(time);
    	DrivetrainSubsystemHandler.tankDrive(RobotMap.AUTO_DRIVE_STRAIGHT_POWER, RobotMap.AUTO_DRIVE_STRAIGHT_POWER);
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	DrivetrainSubsystemHandler.tankDrive(0, 0);
    }

    protected void interrupted() {
    	
    }
}
