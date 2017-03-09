package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveStraightDistanceAtPower extends Command {

	double power, distance;

	/**
	 * @param power
	 *            The speed at which to drive. A negative value will cause the
	 *            robot to drive backwards.
	 * @param distance
	 *            The distance, in feet, to drive.
	 */
	public DriveStraightDistanceAtPower(double power, double distance) {
		this.power = power;
		this.distance = distance;
		requires(Robot.leftMainDrivetrainSubsystem);
	}

	protected void initialize() {
		Robot.leftMainDrivetrainSubsystem.resetEncoders();
	}

	@Override
	protected void execute() {
		Robot.leftMainDrivetrainSubsystem.driveStraight(power);
	}

	@Override
	protected boolean isFinished() {
		return Math.abs(Robot.leftMainDrivetrainSubsystem.getLeftEncoderDistance()) >= distance;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}
}
