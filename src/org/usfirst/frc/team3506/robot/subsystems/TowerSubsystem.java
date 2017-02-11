package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TowerSubsystem extends Subsystem {

	Spark dumbWaiterSpark;
	
	public TowerSubsystem() {
		dumbWaiterSpark = new Spark(RobotMap.DUMB_WAITER_SPARK);
	}
	
	public void liftDumbWaiter() {
		dumbWaiterSpark.set(RobotMap.DUMB_WAITER_LIFT_SPEED);
	}
	
	public void stopDumbWaiter() {
		dumbWaiterSpark.set(0);
	}
	
	public void lowerDumbWaiter() {
		dumbWaiterSpark.set(-RobotMap.DUMB_WAITER_LIFT_SPEED);
	}
	
    public void initDefaultCommand() {
    	
    }
}

