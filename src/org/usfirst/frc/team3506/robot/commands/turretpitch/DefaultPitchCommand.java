package org.usfirst.frc.team3506.robot.commands.turretpitch;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.IntakeSubsystem.IntakeState;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DefaultPitchCommand extends Command {

	public DefaultPitchCommand() {
		requires(Robot.turretPitchSubsystem);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Math.abs(Robot.turretPitchSubsystem.rightServoDesired - Robot.turretPitchSubsystem.rightServo.get()) > RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE) {
			Robot.turretPitchSubsystem.setRightPitch();
		}
		if (Math.abs(Robot.turretPitchSubsystem.leftServoDesired - Robot.turretPitchSubsystem.leftServo.get()) > RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE) {
			Robot.turretPitchSubsystem.setLeftPitch();
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
