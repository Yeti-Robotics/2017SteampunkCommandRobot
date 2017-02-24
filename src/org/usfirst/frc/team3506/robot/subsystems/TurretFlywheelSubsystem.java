package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TurretFlywheelSubsystem extends Subsystem {

	Spark flywheel;

	public TurretFlywheelSubsystem() {
		flywheel = new Spark(RobotMap.TURRET_FLYWHEEL_SPARK);
	}

	public void activateFlywheels() {
		flywheel.set(RobotMap.TURRET_FLYWHEEL_SPEED);
	}

	public void deactivateFlywheels() {
		flywheel.set(0);
	}

	public void initDefaultCommand() {

	}
}
