package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler.DrivetrainFeedbackType;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightPIDCommand extends Command {

	private double distance;

	public DriveStraightPIDCommand(double distance) {
		requires(Robot.rightDrivetrainSubsystem);
		requires(Robot.leftMainDrivetrainSubsystem);
		this.distance = distance;
	}

	protected void initialize() {
		DrivetrainSubsystemHandler.resetEncoders();
		DrivetrainSubsystemHandler.setFeedbackType(DrivetrainFeedbackType.DISTANCE);
		DrivetrainSubsystemHandler.setSetpoint(distance);
    	DrivetrainSubsystemHandler.enable();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (Robot.leftMainDrivetrainSubsystem.getSetpoint() - Robot.leftMainDrivetrainSubsystem.getPosition() <= 0)
				&& (Robot.rightDrivetrainSubsystem.getSetpoint() - Robot.rightDrivetrainSubsystem.getPosition() <= 0);
	}

	protected void end() {
    	DrivetrainSubsystemHandler.disable();
	}

	protected void interrupted() {

	}
}
