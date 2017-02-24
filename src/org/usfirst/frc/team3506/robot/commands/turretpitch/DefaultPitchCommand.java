package org.usfirst.frc.team3506.robot.commands.turretpitch;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DefaultPitchCommand extends Command {

	public DefaultPitchCommand() {
		requires(Robot.turretPitchSubsystem);
	}

	protected void initialize() {
	}

	protected void execute() {
		if (Math.abs(Robot.turretPitchSubsystem.rightServoDesired - Robot.turretPitchSubsystem.rightServo.get()) > RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE) {
			Robot.turretPitchSubsystem.setRightPitch();
		}
		if (Math.abs(Robot.turretPitchSubsystem.leftServoDesired - Robot.turretPitchSubsystem.leftServo.get()) > RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE) {
			Robot.turretPitchSubsystem.setLeftPitch();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
