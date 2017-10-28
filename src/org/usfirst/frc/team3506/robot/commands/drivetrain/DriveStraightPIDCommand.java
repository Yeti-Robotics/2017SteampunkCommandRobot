package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;

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
		DrivetrainSubsystemHandler.startDistancePID(distance);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return DrivetrainSubsystemHandler.reachedStraightDistance();
	}

	protected void end() {
    	DrivetrainSubsystemHandler.disableDistancePID();
	}

	protected void interrupted() {

	}
}
