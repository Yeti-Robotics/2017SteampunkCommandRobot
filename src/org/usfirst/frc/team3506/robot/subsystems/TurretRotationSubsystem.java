package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class TurretRotationSubsystem extends Subsystem {
	
	private Spark rotateSpark;
	private NetworkTable visionTable;
	private double[] defaultArr = {0};
	
	public TurretRotationSubsystem() {
		rotateSpark = new Spark(RobotMap.TURRET_ROTATION_SPARK);
		visionTable = NetworkTable.getTable("GRIP/myContoursReport");		
	}
	
	public double[] getAreas() {
		return visionTable.getNumberArray("area", defaultArr);
	}
	
	public double[] getCenterX() {
		return visionTable.getNumberArray("centerX", defaultArr);
	}
	
	public double getDesiredRotationSpeed(double area, double centerX) {
		double deltaPixels =  centerX - RobotMap.X_CENTER;
		
		// This will run if there is no target in sight
		if (area < RobotMap.MIN_TARGET_SIZE || centerX == 0) {
			return RobotMap.NO_TARGET_FOUND_SPEED;
		}
		//This will run if there is a target, and determine the speed and direction to go at
		else if (Math.abs(deltaPixels) < RobotMap.MAX_ACCEPTABLE_TARGET_X_VALUE) {
			return 0.0;
		} else if (Math.abs(deltaPixels) < RobotMap.SLOW_TURRET_ADJUSTMENT_RANGE) {
			return Math.signum(deltaPixels) * RobotMap.SLOW_TURRET_ADJUSTMENT_SPEED;
		} else if (Math.abs(deltaPixels) < RobotMap.SLOW_TURRET_ADJUSTMENT_RANGE) {
			return Math.signum(deltaPixels) * RobotMap.SLOW_TURRET_ADJUSTMENT_SPEED;
		}
		return 0.0;
	}
	
	public void rotateTurret(double speed) {
		rotateSpark.set(speed);
	}
	
    public void initDefaultCommand() {
    	
    }
}

