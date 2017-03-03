package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightDistanceAtPower;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnTimeAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RightGearCommandGroup extends CommandGroup {

    public RightGearCommandGroup() {
    	addSequential(new DriveStraightDistanceAtPower(-.25, 4.495));
    	addSequential(new PointTurnDegreesAtPowerCommand(-60, .25));
    	addSequential(new DriveStraightDistanceAtPower(-.25, 7.049));
    	addSequential(new WaitCommand(1));
    }
}
