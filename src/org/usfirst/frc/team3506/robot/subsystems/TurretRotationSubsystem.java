package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.turretrotation.ManualRotateCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurretRotationSubsystem extends Subsystem {
	
	private Talon rotateSpark;
	private NetworkTable visionTable;
	private double[] defaultArr = {0};
	
	public TurretRotationSubsystem() {
		rotateSpark = new Talon(RobotMap.TURRET_ROTATION_SPARK);
		visionTable = NetworkTable.getTable("GRIP/ContoursDetected");	
		rotateSpark.setInverted(true);
	}
	
	public double[] getAreas() {
		if (visionTable.getNumberArray("area", defaultArr).length != 0) {
			return visionTable.getNumberArray("area", defaultArr);
		} else {
			return defaultArr;
		}
	}
	
	public double[] getCenterX() {
		if (visionTable.getNumberArray("centerX", defaultArr).length != 0) {
			return visionTable.getNumberArray("centerX", defaultArr);
		} else {
			return defaultArr;
		}
	}
	
	public double getDesiredRotationSpeed(double area, double targetCenterX) {
		SmartDashboard.putNumber("Area", area);
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

