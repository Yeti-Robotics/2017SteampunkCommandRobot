package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystemHandler {

	private static LeftDrivetrainSubsystem leftTrain;
	private static RightDrivetrainSubsystem rightTrain;
	public static boolean useEncoders = true;

	public static enum DrivetrainFeedbackType {
		RATE, DISTANCE
	}

	public static void grabSubsystems() {
		leftTrain = Robot.leftMainDrivetrainSubsystem;
		rightTrain = Robot.rightDrivetrainSubsystem;
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

	public static boolean reachedStraightDistance() {
		return (leftTrain.getDistanceError() <= RobotMap.STRAIGHT_DISTANCE_ERROR_TOLERANCE)
				&& (rightTrain.getDistanceError() <= RobotMap.STRAIGHT_DISTANCE_ERROR_TOLERANCE);
	}

	public static boolean reachedRotateDistance() {
		return (leftTrain.getDistanceError() <= RobotMap.ROTATE_DISTANCE_ERROR_TOLERANCE)
				&& (rightTrain.getDistanceError() <= RobotMap.ROTATE_DISTANCE_ERROR_TOLERANCE);
	}

	public static void setVelocitySetpoint(double setpoint) {
		leftTrain.setSetpoint(setpoint);
		rightTrain.setSetpoint(setpoint);
	}

	public static void setVelocitySetpoint(double leftSetpoint, double rightSetpoint) {
		leftTrain.setSetpoint(leftSetpoint);
		rightTrain.setSetpoint(rightSetpoint);
	}

	public static void tankDrive(double leftSpeed, double rightSpeed) {
		leftTrain.moveLeftTrain(leftSpeed);
		rightTrain.moveRightTrain(rightSpeed);
	}

	public static void publishSmartDashboardValues() {
		 SmartDashboard.getNumber("LeftTrain Setpoint",
		 leftTrain.getSetpoint());
		 SmartDashboard.getNumber("LeftTrain Position",
		 leftTrain.getPosition());
		 SmartDashboard.getNumber("RightTrain Setpoint",
		 rightTrain.getSetpoint());
		 SmartDashboard.getNumber("RightTrain Position",
		 rightTrain.getPosition());
		 SmartDashboard.putData("RightDrivetrainVelocity", rightTrain);
		 SmartDashboard.putData("LeftDrivetrainVelocity", leftTrain);
		 SmartDashboard.putData("RightDrivetrainDistance",
		 rightTrain.getDistancePIDController());
		 SmartDashboard.putData("LeftDrivetrainDistance",
		 leftTrain.getDistancePIDController());
		 SmartDashboard.putData("LeftDrivetrainRate", leftTrain.getPIDController());
		 SmartDashboard.putData("RightDrivetrainRate", rightTrain.getPIDController());
	}
}
