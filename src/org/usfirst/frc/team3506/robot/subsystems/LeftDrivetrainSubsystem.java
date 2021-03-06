package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.UserDriveCommand;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LeftDrivetrainSubsystem extends PIDSubsystem {

	private ControlType controlType;
	private Spark frontLeftSpark = new Spark(RobotMap.FRONT_LEFT_SPARK);
	private Spark backLeftSpark = new Spark(RobotMap.BACK_LEFT_SPARK);

	private Encoder leftEnc = new Encoder(RobotMap.LEFT_DRIVE_ENCODER[0], RobotMap.LEFT_DRIVE_ENCODER[1], false,
			EncodingType.k4X);

	private PIDController drivetrainDistancePID;

	public static enum ControlType {
		TANK, ARCADE;
	}

	public LeftDrivetrainSubsystem() {
		super("Left Drivetrain", RobotMap.LEFT_RATE_FORWARDS_SCALAR, RobotMap.LEFT_RATE_I, RobotMap.LEFT_RATE_D);
		setOutputRange(RobotMap.MIN_RATE_DRIVETRAIN_OUTPUT, RobotMap.MAX_RATE_DRIVETRAIN_OUTPUT);
		enable();

		frontLeftSpark.setInverted(true);
		backLeftSpark.setInverted(true);

		controlType = ControlType.TANK;

		leftEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
		leftEnc.setPIDSourceType(PIDSourceType.kDisplacement);

		drivetrainDistancePID = new PIDController(RobotMap.LEFT_DISTANCE_P, RobotMap.LEFT_DISTANCE_I,
				RobotMap.LEFT_DISTANCE_D, leftEnc, output -> {
					if (DrivetrainSubsystemHandler.useEncoders) {
						Robot.leftMainDrivetrainSubsystem.setSetpoint(output);
					} else {
						Robot.leftMainDrivetrainSubsystem.moveLeftTrain(output);
					}
				});
		drivetrainDistancePID.setOutputRange(RobotMap.MIN_DISTANCE_DRIVETRAIN_OUTPUT, RobotMap.MAX_DISTANCE_DRIVETRAIN_OUTPUT);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}

	protected double returnPIDInput() {
		return getLeftEncoderVel();
	}

	public PIDController getDistancePIDController() {
		return drivetrainDistancePID;
	}

	protected void usePIDOutput(double output) {
		moveLeftTrain(output);
	}

	public ControlType getControlType() {
		return controlType;
	}

	public void setControlType(ControlType controlType) {
		this.controlType = controlType;
	}

	public void moveLeftTrain(double speed) {
		if (getSetpoint() > 0) {
			getPIDController().setPID(RobotMap.LEFT_RATE_FORWARDS_SCALAR, RobotMap.LEFT_RATE_I, RobotMap.LEFT_RATE_D);
		} else {
			getPIDController().setPID(RobotMap.LEFT_RATE_BACKWARDS_SCALAR, RobotMap.LEFT_RATE_I, RobotMap.LEFT_RATE_D);
		}

		if (Math.abs(speed) >= RobotMap.RATE_ERROR_TOLERANCE) {
			frontLeftSpark.set(-speed);
			backLeftSpark.set(-speed);
		} else {
			frontLeftSpark.set(0);
			backLeftSpark.set(0);
		}
	}

	public void startDistancePID(double distance) {
		drivetrainDistancePID.setSetpoint(distance);
		drivetrainDistancePID.enable();
	}

	public void disableDistancePID() {
		drivetrainDistancePID.disable();
	}

	public double getDistanceSetpoint() {
		return drivetrainDistancePID.getSetpoint();
	}

	public double getDistanceError() {
		return drivetrainDistancePID.getError();
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