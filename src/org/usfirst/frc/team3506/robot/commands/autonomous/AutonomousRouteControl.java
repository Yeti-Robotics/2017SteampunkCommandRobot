package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousRouteControl extends CommandGroup {

	boolean moveStepEnable[];
	double moveType[];
	double moveSpeed[];
	double moveAngle[];
	double moveDistance[];
	int numSteps;
	NetworkTable table;
	String tableName = "prefs";

	public AutonomousRouteControl() {
		table = NetworkTable.getTable(tableName);
		
		moveStepEnable = table.getBooleanArray("moveStepEnable", new boolean[] {});
		moveType = table.getNumberArray("moveType", new double[] {});
		moveSpeed = table.getNumberArray("moveSpeed", new double[] {});
		moveAngle = table.getNumberArray("moveAngle", new double[] {});
		moveDistance = table.getNumberArray("moveDistance", new double[] {});
		numSteps = moveStepEnable.length;
	}

	// Autonomous Sequencer: This for loop will cycle through each
	// Autonomous step as indicated by the stepIndex;AKA the array element.
	// As each step completes, it increments through all the steps. If the
	// step is not enabled, it skips the case statement.
	public void runSequencer() {
		for (int i = 0; i < numSteps; i++) {
			if (moveStepEnable[i]) {
				switch ((int) moveType[i]) {
					case 1:
						addSequential(new DriveStraightPIDCommand(moveDistance[i]));
					case 2:
						addSequential(new PointTurnPIDCommand(moveAngle[i]));
				}
				System.out.println("Step " + i + " completed.");
			} else {
				System.out.println("Step " + i + " is not enabled.");
			}
		}
	}
}
