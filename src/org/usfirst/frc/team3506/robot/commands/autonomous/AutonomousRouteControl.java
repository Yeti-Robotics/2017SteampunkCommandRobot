package org.usfirst.frc.team3506.robot.commands.autonomous;

import java.util.ArrayList;
import java.util.List;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousRouteControl extends CommandGroup {

	private List<Boolean> moveStepEnable;
	private List<Integer> moveType;
	private List<Double> moveSpeed;
	private List<Double> moveAngle;
	private List<Double> moveDistance;
	int numSteps;
	
	public static class MoveTypes {
		public static final int DRIVE = 1;
		public static final int ROTATE = 2;
		public static final int WAIT = 3;
	}

	public AutonomousRouteControl() {
		moveStepEnable = new ArrayList<Boolean>();
		moveType = new ArrayList<Integer>();
		moveSpeed = new ArrayList<Double>();
		moveAngle = new ArrayList<Double>();
		moveDistance = new ArrayList<Double>();
		numSteps = moveStepEnable.size();
		
		SmartDashboard.putNumber("Step number", 1);
		SmartDashboard.putBoolean("Enable step", false);
		SmartDashboard.putNumber("Move type", 1);
		SmartDashboard.putNumber("Move speed", 0);
		SmartDashboard.putNumber("Move angle", 0);
		SmartDashboard.putNumber("Move distance", 0);
	}
	
	public void addStep() {
		moveStepEnable.add(SmartDashboard.getBoolean("Enable step", false));
		moveType.add((int) SmartDashboard.getNumber("Move type", 1));
		moveSpeed.add(SmartDashboard.getNumber("Move speed", 0));
		moveAngle.add(SmartDashboard.getNumber("Move angle", 0));
		moveDistance.add(SmartDashboard.getNumber("Move distance", 0));
		
		numSteps = moveStepEnable.size();
		
		SmartDashboard.putNumber("Step number", numSteps);
		loadStep();
	}
	
	public void saveStep() {
		int stepNum = (int) SmartDashboard.getNumber("Step number", 0) - 1;
		
		if (stepNum >= 0 && stepNum <= numSteps - 1) {
			moveStepEnable.set(stepNum, SmartDashboard.getBoolean("Enable step", false));
			moveType.set(stepNum, (int) SmartDashboard.getNumber("Move type", 1));
			moveSpeed.set(stepNum, SmartDashboard.getNumber("Move speed", 0));
			moveAngle.set(stepNum, SmartDashboard.getNumber("Move angle", 0));
			moveDistance.set(stepNum, SmartDashboard.getNumber("Move distance", 0));
		}
	}
	
	public void loadStep() {
		int stepNum = (int) SmartDashboard.getNumber("Step number", 0) - 1;
		
		if (stepNum >= 0 && stepNum <= numSteps - 1) {
			SmartDashboard.putBoolean("Enable step", moveStepEnable.get(stepNum));
			SmartDashboard.putNumber("Move type", moveType.get(stepNum));
			SmartDashboard.putNumber("Move speed", moveSpeed.get(stepNum));
			SmartDashboard.putNumber("Move angle", moveAngle.get(stepNum));
			SmartDashboard.putNumber("Move distance", moveDistance.get(stepNum));
		}
	}

	// Autonomous Sequencer: This for loop will cycle through each
	// Autonomous step as indicated by the stepIndex;AKA the array element.
	// As each step completes, it increments through all the steps. If the
	// step is not enabled, it skips the case statement.
	public void runSequencer() {
		for (int i = 0; i < numSteps; i++) {
			if (moveStepEnable.get(i)) {
				switch (moveType.get(i)) {
					case MoveTypes.DRIVE:
						addSequential(new DriveStraightPIDCommand(moveDistance.get(i)));
						break;
					case MoveTypes.ROTATE:
						addSequential(new PointTurnPIDCommand(moveAngle.get(i)));
						break;
					case MoveTypes.WAIT:
						break;
				}
				System.out.println("Step " + i + " completed.");
			} else {
				System.out.println("Step " + i + " is not enabled.");
			}
		}
	}
}
