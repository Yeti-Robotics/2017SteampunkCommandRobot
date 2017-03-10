package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler.DrivetrainFeedbackType;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RightDrivetrainSubsystem extends PIDSubsystem {

//	Spark frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark;
//	private Encoder leftEnc, rightEnc;
	
	public Spark frontRightSpark = new Spark(RobotMap.FRONT_RIGHT_SPARK);
	public Spark backRightSpark = new Spark(RobotMap.BACK_RIGHT_SPARK);
	private DrivetrainFeedbackType feedbackType;

	private Encoder rightEnc = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER[0], RobotMap.RIGHT_DRIVE_ENCODER[1], true, EncodingType.k4X);
	
	public RightDrivetrainSubsystem() {
		super("Right Drivetrain", .5, .05, .01);
    	setOutputRange(RobotMap.MIN_DRIVETRAIN_OUTPUT, RobotMap.MAX_DRIVETRAIN_OUTPUT);
    	disable();

		rightEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
		feedbackType = DrivetrainFeedbackType.RATE;
	}

	public void initDefaultCommand() {
		
	}

    protected double returnPIDInput() {
    	return feedbackType == DrivetrainFeedbackType.DISTANCE ? getRightEncoderDistance() : getRightEncoderVel();
    }

    protected void usePIDOutput(double output) {
    	moveRightTrain(feedbackType == DrivetrainFeedbackType.DISTANCE ? RobotMap.RIGHT_DRIVETRAIN_TRIM * output : output);
    }
	
	public DrivetrainFeedbackType getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(DrivetrainFeedbackType feedbackType) {
		this.feedbackType = feedbackType;
	}
    
	public void moveRightTrain(double speed) {
		if (Math.abs(speed) > RobotMap.JOYSTICK_DEADZONE) {
			frontRightSpark.set(-speed);
			backRightSpark.set(-speed);
		}
	}

	public double getRightEncoderDistance() {
		return rightEnc.getDistance();
	}

	public double getRawRightEncoderPos() {
		return rightEnc.getRaw();
	}

	public double getRightEncoderVel() {
		return rightEnc.getRate() / RobotMap.MAX_DRIVE_RATE;
	}

	public void resetEncoders() {
		rightEnc.reset();
	}

	public double convertToRadians(double degrees) {
		return 2 * Math.PI * (degrees / 360.0);
	}

	public void publishEncoderValues() {
		SmartDashboard.putNumber("Right drive encoder positon (raw)", getRawRightEncoderPos());
		SmartDashboard.putNumber("Right drive encoder positon (in ft)", getRightEncoderDistance());
		SmartDashboard.putNumber("Right drive encoder velocity (raw)", getRightEncoderVel());
	}
}