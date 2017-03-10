package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystemHandler {

	private static DrivetrainFeedbackType drivetrainFeedbackType;
	private static LeftDrivetrainSubsystem leftTrain = Robot.leftMainDrivetrainSubsystem;
	private static RightDrivetrainSubsystem rightTrain = Robot.rightDrivetrainSubsystem;

	public static enum DrivetrainFeedbackType {
		RATE, DISTANCE
	}

	public static void resetEncoders() {
		leftTrain.resetEncoders();
		rightTrain.resetEncoders();
	}

	public static void setFeedbackType(DrivetrainFeedbackType drivetrainFeedbackType) {
		leftTrain.setFeedbackType(drivetrainFeedbackType);
		rightTrain.setFeedbackType(drivetrainFeedbackType);
		DrivetrainSubsystemHandler.drivetrainFeedbackType = drivetrainFeedbackType;
	}

	public static DrivetrainFeedbackType getDrivetrainFeedbackType() {
		return drivetrainFeedbackType;
	}
	
	public static void enable() {
		leftTrain.enable();
		rightTrain.enable();
	}
	
	public static void disable() {
		leftTrain.disable();
		rightTrain.disable();
	}
	
	public static void setSetpoint(double setpoint) {
		leftTrain.setSetpoint(setpoint);
		rightTrain.setSetpoint(setpoint);
	}
	
	public static void setSetpoint(double leftSetpoint, double rightSetpoint) {
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
