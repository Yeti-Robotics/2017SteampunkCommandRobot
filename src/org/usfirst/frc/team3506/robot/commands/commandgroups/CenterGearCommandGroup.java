package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightDistanceAtPower;
import org.usfirst.frc.team3506.robot.commands.geardispenser.ExtendGearPickerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class CenterGearCommandGroup extends CommandGroup {

    public CenterGearCommandGroup() {
    	addSequential(new DriveStraightDistanceAtPower(-0.4, 6.08333));
    	addSequential(new WaitCommand(1));
    	addSequential(new ExtendGearPickerCommand());
    	addSequential(new WaitCommand(2));
    	for (int i = 0; i < 5; i++) {
    		addSequential(new DriveStraightDistanceAtPower(.2, .08333));
    		addSequential(new WaitCommand(.5));
    	}
    }
}
