package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PointTurnPIDCommand extends Command {

	private double degrees, turnArcLength;
	/**
	 * @param degrees The amount, in degrees, to turn. A positive value will turn clockwise and a negative counter clockwise.
	 */
	public PointTurnPIDCommand(double degrees) {
    	this.degrees = degrees;
    	requires(Robot.leftMainDrivetrainSubsystem);
    	requires(Robot.rightDrivetrainSubsystem);
    }

	protected void initialize() {
		DrivetrainSubsystemHandler.resetEncoders();
		turnArcLength = Math.abs((degrees / 360.0) * (RobotMap.ROBOT_TRACK_WIDTH_FT * Math.PI));

		if(degrees > 0){
			DrivetrainSubsystemHandler.startDistancePID(turnArcLength, -turnArcLength);
    	} else if(degrees < 0){
			DrivetrainSubsystemHandler.startDistancePID(-turnArcLength, turnArcLength);
    	}
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return DrivetrainSubsystemHandler.reachedRotateDistance();
	}

	protected void end() {
		
	}

	protected void interrupted() {

	}
}
