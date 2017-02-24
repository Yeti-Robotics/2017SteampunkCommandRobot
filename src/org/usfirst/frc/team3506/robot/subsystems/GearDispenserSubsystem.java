package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearDispenserSubsystem extends Subsystem {

	DoubleSolenoid gearPiston;
	
	public GearDispenserSubsystem() {
		gearPiston = new DoubleSolenoid(RobotMap.GEAR_DISPENSER_SOLENOID[0], RobotMap.GEAR_DISPENSER_SOLENOID[1]);
	}
	
	public void extendDispenser() {
		gearPiston.set(Value.kForward);
	}
	
	public void retractDispenser() {
		gearPiston.set(Value.kReverse);
	}

    public void initDefaultCommand() {
    	
    }
}

