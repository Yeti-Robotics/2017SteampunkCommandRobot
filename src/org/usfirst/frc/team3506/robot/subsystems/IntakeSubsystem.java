package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {

	private Spark intake;

	public IntakeSubsystem() {
		intake = new Spark(RobotMap.INTAKE_SPARK);
	}

	public void floorIntake() {
		intake.set(RobotMap.INTAKE_SPEED);
	}

	public void floorSpurtOut() {
		intake.set(-RobotMap.INTAKE_SPEED);
	}

	public void initDefaultCommand() {
	}
}
