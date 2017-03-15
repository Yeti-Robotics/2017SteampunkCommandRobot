package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ClawLiftSubsystem extends Subsystem {

	DoubleSolenoid clawPiston;

	public ClawLiftSubsystem() {
		clawPiston = new DoubleSolenoid(RobotMap.CLAW_LIFT_SOLENOID[0], RobotMap.CLAW_LIFT_SOLENOID[1]);
	}

	public void raiseClaw() {
		clawPiston.set(Value.kReverse);
	}

	public void lowerClaw() {
		clawPiston.set(Value.kForward);
	}

	public void initDefaultCommand() {
		
	}
}
