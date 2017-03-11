package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearPickerSubsystem extends Subsystem {

	DoubleSolenoid gearPiston;
	
	public GearPickerSubsystem() {
		gearPiston = new DoubleSolenoid(RobotMap.GEAR_PICKER_SOLENOID[0],RobotMap.GEAR_PICKER_SOLENOID[1]);
	}
	
	public void retractPicker() {
		gearPiston.set(Value.kForward);
	}
	
	public void extendPicker() {
		gearPiston.set(Value.kReverse);
	}

    public void initDefaultCommand() {
    	
    }
}

