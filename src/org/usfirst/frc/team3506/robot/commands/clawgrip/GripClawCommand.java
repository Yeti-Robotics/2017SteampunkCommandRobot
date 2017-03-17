package org.usfirst.frc.team3506.robot.commands.clawgrip;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GripClawCommand extends Command {

	public GripClawCommand() {
		requires(Robot.clawGripSubsystem);
	}

	protected void initialize() {
		if (Robot.clawGripSubsystem.getGripState() == RobotMap.CLAW_GRIPPED_STATE) {
			Robot.clawGripSubsystem.ungripClaw();
		} else {
			Robot.clawGripSubsystem.gripClaw();
		}
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		
	}
}
