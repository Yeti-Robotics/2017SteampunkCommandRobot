package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnTimeAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightGearCommandGroup extends CommandGroup {

    public RightGearCommandGroup() {
    	addSequential(new DriveStraightTimeAtPowerCommand(.5, .5)); //power, speed
    	addSequential(new PointTurnTimeAtPowerCommand(.25, .25));
    	addSequential(new DriveStraightTimeAtPowerCommand(.5, .5));
    	addSequential(new DriveStraightTimeAtPowerCommand(0, 1));
    }
}
