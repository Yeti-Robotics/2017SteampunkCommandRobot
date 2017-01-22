package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.UserDriveCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DrivetrainSubsystem extends Subsystem {

	Spark spark1, spark2, spark3, spark4;

	public DrivetrainSubsystem() {
		spark1 = new Spark(RobotMap.FRONT_LEFT_SPARK);
		spark2 = new Spark(RobotMap.BACK_LEFT_SPARK);
		spark3 = new Spark(RobotMap.FRONT_RIGHT_SPARK);
		spark4 = new Spark(RobotMap.BACK_RIGHT_SPARK);

		// spark3.setInverted(true);
		// spark4.setInverted(true);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new UserDriveCommand());
	}

	public void moveLeftTrain(double speed) {
		spark1.set(speed);
		spark2.set(speed);
	}

	public void moveRightTrain(double speed) {
		spark3.set(speed);
		spark4.set(speed);
	}

	public void tankDrive(double left, double right) {
		moveLeftTrain(left);
		moveRightTrain(right);
	}
}