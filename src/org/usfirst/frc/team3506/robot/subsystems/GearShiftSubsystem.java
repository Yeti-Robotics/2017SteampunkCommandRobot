package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearShiftSubsystem extends Subsystem {
	
	private DoubleSolenoid shifter;

	public GearShiftSubsystem() {
		shifter = new DoubleSolenoid(RobotMap.GEAR_SHIFT_SOLENOID_PORTS[0], RobotMap.GEAR_SHIFT_SOLENOID_PORTS[1]);
		shifter.set(RobotMap.DRIVETRAIN_SHIFT_DOWN);
	}

	public void shiftUp() {
		shifter.set(RobotMap.DRIVETRAIN_SHIFT_UP);
	}

	public void shiftDown() {
		shifter.set(RobotMap.DRIVETRAIN_SHIFT_DOWN);
	}

	public Value shiftedState() {
		return shifter.get();
	}

	@Override
	protected void initDefaultCommand() {
	}
}
