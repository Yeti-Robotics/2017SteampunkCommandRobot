package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TurretPitchSubsystem extends Subsystem {

	Servo leftServo, rightServo;
	
	public TurretPitchSubsystem() {
		leftServo = new Servo(RobotMap.LEFT_TURRET_SERVO);
		rightServo = new Servo(RobotMap.RIGHT_TURRET_SERVO);
	}
	
	public void setPitch(double pitch) {
		leftServo.set(pitch);
		rightServo.set(1 - pitch);
	}
	
	public void increasePitch() {
		leftServo.set(leftServo.get() + RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE);
		rightServo.set((1 - rightServo.get()) + RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE);
	}
	
	public void decreasePitch() {
		leftServo.set(leftServo.get() - .05);
		rightServo.set((1 - rightServo.get()) - RobotMap.MANUAL_SERVO_ADJUSTMENT_RATE);
	}

    public void initDefaultCommand() {
    	
    }
}

