package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PointTurnDegreesAtPowerCommand extends Command {
	private double degrees, power, turnArcLength;
	/**
	 * @param degrees The amount, in degrees, to turn. A positive value will turn clockwise and a negative counter clockwise.
	 * @param power The speed at which to turn. A negative value will cause the robot to turn in the opposite direction specified by degrees.
	 */
    public PointTurnDegreesAtPowerCommand(double degrees, double power) {
    	this.degrees = degrees;
    	this.power = power;
    	requires(Robot.driveTrainSubsystem);
    }

    protected void initialize() {
    	Robot.driveTrainSubsystem.resetEncoders();
    	//turnArcLength = (degrees / 360.0) * (RobotMap.ROBOT_TRACK_WIDTH_FT * Math.PI);
    	//ADD TRACK WIDTH IN ROBOT MAP
    }

    protected void execute() {
    	if(degrees > 0){
    		Robot.driveTrainSubsystem.moveLeftTrain(power);
    		Robot.driveTrainSubsystem.moveRightTrain(-power);
    	} else if(degrees < 0){
    		Robot.driveTrainSubsystem.moveLeftTrain(-power);
    		Robot.driveTrainSubsystem.moveRightTrain(power);
    	}
    }

    protected boolean isFinished() {
    	return Math.abs(Robot.driveTrainSubsystem.getLeftEncoderDistance()) >= turnArcLength;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
