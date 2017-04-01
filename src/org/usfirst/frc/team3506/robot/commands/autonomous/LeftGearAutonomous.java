package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.ExtendGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.RetractGearPickerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LeftGearAutonomous extends CommandGroup {

    public LeftGearAutonomous() {
    	addSequential(new DriveStraightPIDCommand(-SmartDashboard.getNumber("Auto drive distance 1", 7.25)));
    	addSequential(new PointTurnPIDCommand(SmartDashboard.getNumber("Auto rotate distance", 70)));
    	addSequential(new DriveStraightPIDCommand(-SmartDashboard.getNumber("Auto drive distance 2", 3.79)));
    	addSequential(new ExtendGearPickerCommand());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new RetractGearPickerCommand());
    	addSequential(new WaitCommand(0.5));
    	addSequential(new DriveStraightPIDCommand(1));
    }
}
