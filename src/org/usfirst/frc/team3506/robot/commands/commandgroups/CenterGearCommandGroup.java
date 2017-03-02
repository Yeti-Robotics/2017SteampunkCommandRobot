package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightDistanceAtPower;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class CenterGearCommandGroup extends CommandGroup {

    public CenterGearCommandGroup() {
    	addSequential(new DriveStraightDistanceAtPower(-0.5, 6.08333));
    	addSequential(new WaitCommand(1));
    }
}
