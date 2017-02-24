package org.usfirst.frc.team3506.robot.subsystems;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.intake.IntakeDefaultCommand;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private Spark intake;
	public IntakeState intakeState;
	public static enum IntakeState {
		OUT, IN, OFF
	}
	
	public IntakeSubsystem() {
		intake = new Spark(RobotMap.INTAKE_SPARK);
		intakeState = IntakeState.OFF;
		intake.setInverted(true);
	}

	public void runIntake() {
		intake.set(RobotMap.INTAKE_SPEED);
	}

	public void runOutput() {
		intake.set(-RobotMap.INTAKE_SPEED);
	}
	
	public void stopIntake() {
		intake.set(0);
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new IntakeDefaultCommand());
	}
}
