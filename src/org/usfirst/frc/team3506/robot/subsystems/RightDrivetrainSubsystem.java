package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler.DrivetrainFeedbackType;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RightDrivetrainSubsystem extends PIDSubsystem {
	
	public Spark frontRightSpark = new Spark(RobotMap.FRONT_RIGHT_SPARK);
	public Spark backRightSpark = new Spark(RobotMap.BACK_RIGHT_SPARK);

	private Encoder rightEnc = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER[0], RobotMap.RIGHT_DRIVE_ENCODER[1], true, EncodingType.k4X);
	
	private PIDController drivetrainDistancePID;
	
	public RightDrivetrainSubsystem() {
		super("Right Drivetrain", RobotMap.RIGHT_RATE_P, RobotMap.RIGHT_RATE_I, RobotMap.RIGHT_RATE_D);
    	setOutputRange(RobotMap.MIN_DRIVETRAIN_OUTPUT, RobotMap.MAX_DRIVETRAIN_OUTPUT);
    	enable();

		rightEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
		rightEnc.setPIDSourceType(PIDSourceType.kDisplacement);
	
		drivetrainDistancePID = new PIDController(RobotMap.RIGHT_DISTANCE_P, RobotMap.RIGHT_DISTANCE_I, RobotMap.RIGHT_DISTANCE_D, rightEnc, output -> {
			Robot.rightDrivetrainSubsystem.setSetpoint(output);
		});
	}

	public void initDefaultCommand() {
		
	}

    protected double returnPIDInput() {
    	return getRightEncoderVel();
    }

    protected void usePIDOutput(double output) {
    	moveRightTrain(output);
    }

	public void moveRightTrain(double speed) {
		if (Math.abs(speed) > RobotMap.JOYSTICK_DEADZONE) {
			frontRightSpark.set(-speed);
			backRightSpark.set(-speed);
		}
	}

	public void startDistancePID (double distance) {
		drivetrainDistancePID.setSetpoint(distance);
		drivetrainDistancePID.enable();
	}

	public void disableDistancePID () {
		drivetrainDistancePID.disable();
	}
	
	public double getDistanceSetpoint() {
		return drivetrainDistancePID.getSetpoint();
	}
	
	public double getDistanceError() {
		return drivetrainDistancePID.getError();
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