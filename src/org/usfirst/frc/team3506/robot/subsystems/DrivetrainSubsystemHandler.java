package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystemHandler {

	private static LeftDrivetrainSubsystem leftTrain = Robot.leftMainDrivetrainSubsystem;
	private static RightDrivetrainSubsystem rightTrain = Robot.rightDrivetrainSubsystem;

	public static enum DrivetrainFeedbackType {
		RATE, DISTANCE
	}

	public static void resetEncoders() {
		leftTrain.resetEncoders();
		rightTrain.resetEncoders();
	}
	
	public static void enableVelocityPID() {
		leftTrain.enable();
		rightTrain.enable();
	}
	
	public static void disableVelocityPID() {
		leftTrain.disable();
		rightTrain.disable();
	}
	
	public static void startDistancePID(double distance) {
		leftTrain.startDistancePID(distance);
		rightTrain.startDistancePID(distance);
	}
	
	public static void startDistancePID(double leftDistance, double rightDistance) {
		leftTrain.startDistancePID(leftDistance);
		rightTrain.startDistancePID(rightDistance);
	}
	
	public static void disableDistancePID() {
		leftTrain.disableDistancePID();
		rightTrain.disableDistancePID();
	}
	
	public static boolean reachedDistance () {
		return (leftTrain.getDistanceError() <= 0) && (rightTrain.getDistanceError() <= 0);
	}
	
	public static void setVelocitySetpoint(double setpoint) {
		leftTrain.setSetpoint(setpoint);
		rightTrain.setSetpoint(setpoint);
	}
	
	public static void setVelocitySetpoint(double leftSetpoint, double rightSetpoint) {
		leftTrain.setSetpoint(leftSetpoint);
		rightTrain.setSetpoint(rightSetpoint);
	}
	
	public static void publishSmartDashboardValues() {
		SmartDashboard.getNumber("LeftTrain Setpoint", leftTrain.getSetpoint());
		SmartDashboard.getNumber("LeftTrain Position", leftTrain.getPosition());
		SmartDashboard.getNumber("RightTrain Setpoint", rightTrain.getSetpoint());
		SmartDashboard.getNumber("RightTrain Position", rightTrain.getPosition());
	}
}
