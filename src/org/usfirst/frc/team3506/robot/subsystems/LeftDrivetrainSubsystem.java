package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.UserDriveCommand;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler.DrivetrainFeedbackType;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LeftDrivetrainSubsystem extends PIDSubsystem {

	private ControlType controlType;
	private DrivetrainFeedbackType feedbackType;
	private RobotDrive drive;
	
	private Spark frontLeftSpark = new Spark(RobotMap.FRONT_LEFT_SPARK);
	private Spark backLeftSpark = new Spark(RobotMap.BACK_LEFT_SPARK);

	private Encoder leftEnc = new Encoder(RobotMap.LEFT_DRIVE_ENCODER[0], RobotMap.LEFT_DRIVE_ENCODER[1], false, EncodingType.k4X);
	
	public static enum ControlType {
		TANK, ARCADE;
	}

	public LeftDrivetrainSubsystem() {
		super("Left Drivetrain", RobotMap.P, RobotMap.I, RobotMap.D);
    	setOutputRange(RobotMap.MIN_DRIVETRAIN_OUTPUT, RobotMap.MAX_DRIVETRAIN_OUTPUT);
    	disable();

		frontLeftSpark.setInverted(true);
		backLeftSpark.setInverted(true);
		
		drive = new RobotDrive(frontLeftSpark, backLeftSpark, Robot.rightDrivetrainSubsystem.frontRightSpark, Robot.rightDrivetrainSubsystem.backRightSpark);
		
		controlType = ControlType.TANK;
		feedbackType = DrivetrainFeedbackType.RATE;

		leftEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}

    protected double returnPIDInput() {
        return feedbackType == DrivetrainFeedbackType.DISTANCE ? getLeftEncoderDistance() : getLeftEncoderVel();
    }

    protected void usePIDOutput(double output) {
    	moveLeftTrain(feedbackType == DrivetrainFeedbackType.DISTANCE ? RobotMap.LEFT_DRIVETRAIN_TRIM * output : output);
    }
	
	public DrivetrainFeedbackType getFeedbackType() {
		return feedbackType;
	}

	public void setFeedbackType(DrivetrainFeedbackType feedbackType) {
		this.feedbackType = feedbackType;
	}

	public ControlType getControlType() {
		return controlType;
	}
	
	public void setControlType(ControlType controlType) {
		this.controlType = controlType;
	}

	public void moveLeftTrain(double speed) {
		if (Math.abs(speed) > RobotMap.JOYSTICK_DEADZONE) {
			frontLeftSpark.set(-speed);
			backLeftSpark.set(-speed);
		}
	}

	public void tankDrive(double left, double right) {
		drive.tankDrive(-left, right);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		drive.arcadeDrive(moveSpeed, rotateSpeed);
	}

	public void driveStraight(double speed) {
		moveLeftTrain(-RobotMap.LEFT_DRIVETRAIN_TRIM * speed);
	}

	public double getRawLeftEncoderPos() {
		return leftEnc.getRaw();
	}

	public double getLeftEncoderDistance() {
		return leftEnc.getDistance();
	}

	public double getLeftEncoderVel() {
		return leftEnc.getRate() / RobotMap.MAX_DRIVE_RATE;
	}

	public void resetEncoders() {
		leftEnc.reset();
	}

	public double convertToRadians(double degrees) {
		return 2 * Math.PI * (degrees / 360.0);
	}

	public void publishEncoderValues() {
		SmartDashboard.putNumber("Left drive encoder position (raw)", getRawLeftEncoderPos());
		SmartDashboard.putNumber("Left drive encoder position (modded)", leftEnc.get());
		SmartDashboard.putNumber("Left drive encoder position (in ft)", getLeftEncoderDistance());
		SmartDashboard.putNumber("Left drive encoder velocity (raw)", getLeftEncoderVel());
	}
}