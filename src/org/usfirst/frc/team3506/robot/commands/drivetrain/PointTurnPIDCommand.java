package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler.DrivetrainFeedbackType;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PointTurnPIDCommand extends Command {

	private double degrees, power, turnArcLength;
	/**
	 * @param degrees The amount, in degrees, to turn. A positive value will turn clockwise and a negative counter clockwise.
	 * @param power The speed at which to turn. A negative value will cause the robot to turn in the opposite direction specified by degrees.
	 */
	public PointTurnPIDCommand(double degrees, double power) {
    	this.degrees = degrees;
    	this.power = power;
    	requires(Robot.leftMainDrivetrainSubsystem);
    	requires(Robot.rightDrivetrainSubsystem);
    }

	protected void initialize() {
		DrivetrainSubsystemHandler.resetEncoders();
		DrivetrainSubsystemHandler.setFeedbackType(DrivetrainFeedbackType.DISTANCE);
		turnArcLength = Math.abs((degrees / 360.0) * (RobotMap.ROBOT_TRACK_WIDTH_FT * Math.PI));

		if(degrees > 0){
			DrivetrainSubsystemHandler.setSetpoint(turnArcLength, -turnArcLength);
    	} else if(degrees < 0){

			DrivetrainSubsystemHandler.setSetpoint(-turnArcLength, turnArcLength);
    	}
		
    	DrivetrainSubsystemHandler.enable();
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return (Math.abs(Robot.leftMainDrivetrainSubsystem.getPosition()) >= turnArcLength)
				&& (Math.abs(Robot.leftMainDrivetrainSubsystem.getPosition()) >= turnArcLength);
	}

	protected void end() {
    	DrivetrainSubsystemHandler.disable();
	}

	protected void interrupted() {

	}
}
