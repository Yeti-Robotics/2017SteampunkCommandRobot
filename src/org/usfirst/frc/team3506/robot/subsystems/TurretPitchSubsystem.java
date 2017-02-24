package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.turretpitch.DefaultPitchCommand;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TurretPitchSubsystem extends Subsystem {

	public Servo leftServo, rightServo;
	public double leftServoDesired, rightServoDesired;
	
	public TurretPitchSubsystem() {
		leftServo = new Servo(RobotMap.LEFT_TURRET_SERVO);
		rightServo = new Servo(RobotMap.RIGHT_TURRET_SERVO);
		
		leftServoDesired = 0.5;
		rightServoDesired = 0.5;
	}
	
	public void setLeftPitch() {
		System.out.println("Left servo: " + leftServoDesired);
		leftServo.set(leftServoDesired);
	}
	
	public void setRightPitch() {
		System.out.println("Right servo: " + rightServoDesired);
		rightServo.set(rightServoDesired);
	}
	
	public void increasePitch() {
		if ((rightServoDesired > RobotMap.RIGHT_SERVO_LOWER_LIMIT) && (leftServoDesired < RobotMap.LEFT_SERVO_UPPER_LIMIT)) {
			leftServoDesired += RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE;
			rightServoDesired -= RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE;
		}
	}
	
	public void decreasePitch() {
		if ((rightServoDesired < RobotMap.RIGHT_SERVO_UPPER_LIMIT) && (leftServoDesired > RobotMap.LEFT_SERVO_LOWER_LIMIT)) {
			leftServoDesired -= RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE;
			rightServoDesired += RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE;
		}
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new DefaultPitchCommand());
    }
}

