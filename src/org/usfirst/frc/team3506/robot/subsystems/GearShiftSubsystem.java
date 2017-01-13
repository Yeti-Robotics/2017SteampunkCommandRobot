package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearShiftSubsystem extends Subsystem {
	private DoubleSolenoid shifter;
	public GearShiftSubsystem(){
		shifter = new DoubleSolenoid(RobotMap.SOLENOID_PORTS[0], RobotMap.SOLENOID_PORTS[2]);
		shifter.set(Value.kOff);
		
	}
    
	public void shiftUp(){
		System.out.println("up");
		shifter.set(RobotMap.DRIVETRAIN_SHIFT_UP);
	}
	public void shiftDown(){
			System.out.println("down");
			shifter.set(RobotMap.DRIVETRAIN_SHIFT_DOWN);
}
	public Value shiftedState(){
		return shifter.get();
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
    
}

