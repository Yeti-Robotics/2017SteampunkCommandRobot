package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CenterGearCommandGroup extends CommandGroup {

    public CenterGearCommandGroup() {
    	addSequential(new DriveStraightTimeAtPowerCommand(.5, .5)); //power, speed
    	addSequential(new DriveStraightTimeAtPowerCommand(0, 1));
    }
}
