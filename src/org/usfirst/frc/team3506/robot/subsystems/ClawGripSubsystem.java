package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawGripSubsystem extends Subsystem {
	DoubleSolenoid clawPiston;

	public ClawGripSubsystem() {
		clawPiston = new DoubleSolenoid(RobotMap.CLAW_GRIP_SOLENOID[0], RobotMap.CLAW_GRIP_SOLENOID[1]);
	}

	public void gripClaw() {
		clawPiston.set(Value.kForward);
	}

	public void ungripClaw() {
		clawPiston.set(Value.kReverse);
	}

	public Value getGripState() {
		return clawPiston.get();
	}
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
