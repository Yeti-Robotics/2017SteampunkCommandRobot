package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightDistanceAtPower;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TestEncodersCommandGroup extends CommandGroup {

    public TestEncodersCommandGroup() {
    	addSequential(new DriveStraightDistanceAtPower(0.5, 5));
    	addSequential(new PointTurnDegreesAtPowerCommand(180, 0.5));
    	addSequential(new DriveStraightDistanceAtPower(0.5, 5));
    }
}
