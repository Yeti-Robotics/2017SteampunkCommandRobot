package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ClimberSubsystem extends Subsystem {

	Spark climberSpark;

	public ClimberSubsystem() {
		climberSpark = new Spark(RobotMap.CLIMBER_SPARK);
	}

	public void initDefaultCommand() {

	}

	public void climbUp() {
		climberSpark.set(RobotMap.CLIMBER_SPEED);

	}

	public void climbDown() {
		climberSpark.set(-RobotMap.CLIMBER_SPEED);
	}

	public void stopClimber() {
		climberSpark.set(0);
	}
}
