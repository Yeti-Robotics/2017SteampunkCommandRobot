package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightUntilDistanceCommand extends Command {
	
	double speed;
	double distance;

	public DriveStraightUntilDistanceCommand(double speed, double distance) {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.speed = -speed;
		this.distance = distance;
		requires(Robot.driveTrainSubsystem);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveTrainSubsystem.tankDrive(speed, speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.driveTrainSubsystem.getLeftEncoderDistance() >= distance;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveTrainSubsystem.tankDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
