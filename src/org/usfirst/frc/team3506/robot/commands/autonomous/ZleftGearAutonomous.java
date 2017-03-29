package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.ExtendGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.RetractGearPickerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class ZleftGearAutonomous extends CommandGroup {

    public ZleftGearAutonomous() {
    	addSequential(new DriveStraightPIDCommand(6));
    	addSequential(new PointTurnPIDCommand(60));
    	addSequential(new DriveStraightPIDCommand(3.79));
    	addSequential(new ExtendGearPickerCommand());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new RetractGearPickerCommand());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new DriveStraightPIDCommand(1));
    }
}
