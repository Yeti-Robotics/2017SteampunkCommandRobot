package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.vision.GearTargetInfo;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CorrectSkewCommand extends CommandGroup {

	public CorrectSkewCommand() {
		double perpendicularDistance = GearTargetInfo.getDistance() / Math.tan(GearTargetInfo.getSkew());
		
		addSequential(new PointTurnPIDCommand(-90));
		addSequential(new DriveStraightPIDCommand(perpendicularDistance));
		addSequential(new PointTurnPIDCommand(90 - GearTargetInfo.getSkew()));
	}
}
