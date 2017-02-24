package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurretRotationSubsystem extends Subsystem {
	
	private Talon rotateSpark;
	
	public TurretRotationSubsystem() {
		rotateSpark = new Talon(RobotMap.TURRET_ROTATION_SPARK);
		rotateSpark.setInverted(true);
	}
	
	public double getDesiredRotationSpeed(double area, double targetCenterX) {
		SmartDashboard.putNumber("Contour Area", area);
		SmartDashboard.putNumber("Contour center x", targetCenterX);
		double deltaPixels =  targetCenterX - RobotMap.IMAGE_CENTER_X;
		System.out.println("Delta = " + deltaPixels);
		// This will run if there is no target in sight
		if (area < RobotMap.MIN_TARGET_SIZE || targetCenterX == 0) {
			System.out.println("No Target");
			return RobotMap.NO_TARGET_FOUND_SPEED;
		}
		//This will run if there is a target, and determine the speed and direction to go at
		else if (Math.abs(deltaPixels) < RobotMap.MAX_ACCEPTABLE_TARGET_X_VALUE) {
			System.out.println("In Range");
			return 0.0;
		} else if (Math.abs(deltaPixels) < RobotMap.SLOW_TURRET_ADJUSTMENT_RANGE) {
			System.out.println("Gotta go slow");
			return Math.signum(deltaPixels) * RobotMap.SLOW_TURRET_ADJUSTMENT_SPEED;
		} else {
			System.out.println("Gotta go fast" + Math.signum(deltaPixels) * RobotMap.FAST_TURRET_ADJUSTMENT_SPEED);
			return Math.signum(deltaPixels) * RobotMap.FAST_TURRET_ADJUSTMENT_SPEED;
		}
	}
	
	public void rotateTurret(double speed) {
		System.out.println("Rotating at" + speed);
		rotateSpark.set(speed);
	}
	
    public void initDefaultCommand() {
    	
    }
}

