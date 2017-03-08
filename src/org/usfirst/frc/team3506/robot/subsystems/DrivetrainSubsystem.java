package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.UserDriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends Subsystem {

	Spark frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark;
	private Encoder leftEnc, rightEnc;
	ControlType controlType;
	private RobotDrive drive;
	
	public static enum ControlType {
		TANK, ARCADE;
	}

	public DrivetrainSubsystem() {
		frontLeftSpark = new Spark(RobotMap.FRONT_LEFT_SPARK);
		backLeftSpark = new Spark(RobotMap.BACK_LEFT_SPARK);
		frontRightSpark = new Spark(RobotMap.FRONT_RIGHT_SPARK);
		backRightSpark = new Spark(RobotMap.BACK_RIGHT_SPARK);

		frontLeftSpark.setInverted(true);
		backLeftSpark.setInverted(true);
		
		drive = new RobotDrive(frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark);
		
		controlType = ControlType.TANK;

		leftEnc = new Encoder(RobotMap.LEFT_DRIVE_ENCODER[0], RobotMap.LEFT_DRIVE_ENCODER[1], false, EncodingType.k4X);
		rightEnc = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER[0], RobotMap.RIGHT_DRIVE_ENCODER[1], true, EncodingType.k4X);
		leftEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
		rightEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}
	
	public ControlType getControlType() {
		return controlType;
	}
	
	public void setControlType(ControlType controlType) {
		this.controlType = controlType;
	}

	public void moveLeftTrain(double speed) {
		frontLeftSpark.set(speed);
		backLeftSpark.set(speed);
	}

	public void moveRightTrain(double speed) {
		frontRightSpark.set(speed);
		backRightSpark.set(speed);
	}

	public void tankDrive(double left, double right) {
		drive.tankDrive(-left, right);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		drive.arcadeDrive(moveSpeed, rotateSpeed);
	}

	public void driveStraight(double speed) {
		moveLeftTrain(-RobotMap.LEFT_DRIVETRAIN_TRIM * speed);
		moveRightTrain(-RobotMap.RIGHT_DRIVETRAIN_TRIM * speed);
	}

	public double getRawLeftEncoderPos() {
		return leftEnc.getRaw();
	}

	public double getLeftEncoderDistance() {
		return leftEnc.getDistance();
	}

	public double getRightEncoderDistance() {
		return rightEnc.getDistance();
	}

	public double getRawRightEncoderPos() {
		return rightEnc.getRaw();
	}

	public double getRawAvgEncoderPos() {
		return (getRawLeftEncoderPos() + getRawRightEncoderPos()) / 2;
	}
	
	public double getAvgEncoderDistance() {
		return (getRightEncoderDistance() + getLeftEncoderDistance()) / 2;
	}

	public double getRawLeftEncoderVel() {
		return leftEnc.getRate();
	}

	public double getRawRightEncoderVel() {
		return rightEnc.getRate();
	}

	public void resetEncoders() {
		leftEnc.reset();
		rightEnc.reset();
	}

	public double convertToRadians(double degrees) {
		return 2 * Math.PI * (degrees / 360.0);
	}

	public void publishEncoderValues() {
		SmartDashboard.putNumber("Left drive encoder position (raw)", getRawLeftEncoderPos());
		SmartDashboard.putNumber("Left drive encoder position (modded)", leftEnc.get());
		SmartDashboard.putNumber("Left drive encoder position (in ft)", getLeftEncoderDistance());
		SmartDashboard.putNumber("Left drive encoder velocity (raw)", getRawLeftEncoderVel());
		SmartDashboard.putNumber("Right drive encoder positon (raw)", getRawRightEncoderPos());
		SmartDashboard.putNumber("Right drive encoder positon (in ft)", getRightEncoderDistance());
		SmartDashboard.putNumber("Right drive encoder velocity (raw)", getRawRightEncoderVel());
	}
}