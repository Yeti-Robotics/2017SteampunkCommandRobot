package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TowerSubsystem extends Subsystem {

	Spark towerSpark;
	
	public TowerSubsystem() {
		towerSpark = new Spark(RobotMap.TOWER_SPARK);
	}
	
	public void raiseTower() {
		towerSpark.set(RobotMap.TOWER_LIFT_SPEED);
	}
	
	public void stopTower() {
		towerSpark.set(0);
	}
	
	public void lowerTower() {
		towerSpark.set(-RobotMap.TOWER_LIFT_SPEED);
	}
	
    public void initDefaultCommand() {
    	
    }
}

