package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.geardispenser.ExtendGearPickerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class CenterGearAutonomous extends CommandGroup {

    public CenterGearAutonomous() {
    	addSequential(new DriveStraightPIDCommand(-0.4));
    	addSequential(new WaitCommand(1));
    	addSequential(new ExtendGearPickerCommand());
    	addSequential(new WaitCommand(2));
    	for (int i = 0; i < 5; i++) {
    		addSequential(new DriveStraightPIDCommand(.2));
    		addSequential(new WaitCommand(.5));
    	}
    }
}
