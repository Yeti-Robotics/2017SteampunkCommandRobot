package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.UserDriveCommand;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends Subsystem {

	Spark frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark;
	private Encoder leftEnc, rightEnc;

	public DrivetrainSubsystem() {
		frontLeftSpark = new Spark(RobotMap.FRONT_LEFT_SPARK);
		backLeftSpark = new Spark(RobotMap.BACK_LEFT_SPARK);
		frontRightSpark = new Spark(RobotMap.FRONT_RIGHT_SPARK);
		backRightSpark = new Spark(RobotMap.BACK_RIGHT_SPARK);
		

		frontLeftSpark.setInverted(true);
		backLeftSpark.setInverted(true);
		
		//leftEnc = new Encoder(RobotMap.LEFT_ENCODER_PORT[0], RobotMap.LEFT_ENCODER_PORT[1], false, EncodingType.k4X);
		//rightEnc = new Encoder(RobotMap.RIGHT_ENCODER_PORT[0], RobotMap.RIGHT_ENCODER_PORT[1], false, EncodingType.k1X);
		//leftEnc.setDistancePerPulse(RobotMap.DRIVE_TRAIN_ENCODER_DISTANCE_PER_PULSE);
 		//rightEnc.setDistancePerPulse(RobotMap.DRIVE_TRAIN_ENCODER_DISTANCE_PER_PULSE);
		//NEED TO PUT ENCOER VALUS/PORTS IN ROBOT MAP
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
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
		moveLeftTrain(left);
		moveRightTrain(right);
	}
	public void driveStraight(double speed) {
		moveLeftTrain(speed);
		moveRightTrain(speed);
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
		SmartDashboard.putNumber("Left drive encoder velocity", getRawLeftEncoderVel());
		SmartDashboard.putNumber("Right drive encoder positon (raw)", getRawRightEncoderPos());
			SmartDashboard.putNumber("Right drive encoder velocity (raw)", getRawRightEncoderVel());
}
	}