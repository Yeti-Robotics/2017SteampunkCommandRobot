package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.UserDriveCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

	Spark frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark;

	public DrivetrainSubsystem() {
		frontLeftSpark = new Spark(RobotMap.FRONT_LEFT_SPARK);
		backLeftSpark = new Spark(RobotMap.BACK_LEFT_SPARK);
		frontRightSpark = new Spark(RobotMap.FRONT_RIGHT_SPARK);
		backRightSpark = new Spark(RobotMap.BACK_RIGHT_SPARK);

		// spark3.setInverted(true);
		// spark4.setInverted(true);
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
}