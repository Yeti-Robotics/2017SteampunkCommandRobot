package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.ExtendGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.RetractGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearshift.ShiftDownCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RightGearAutonomous extends CommandGroup {

    public RightGearAutonomous() {
    	addSequential(new ShiftDownCommand());
    	if (RobotMap.USE_SMART_DASHBOARD) {
			addSequential(new DriveStraightPIDCommand(
					-SmartDashboard.getNumber("Auto drive distance 1", RobotMap.RL_DRIVE_DISTANCE_1)));
			addSequential(new PointTurnPIDCommand(
					-SmartDashboard.getNumber("Auto rotate distance", RobotMap.RL_ROTATE_DISTANCE)));
			addSequential(new DriveStraightPIDCommand(
					-SmartDashboard.getNumber("Auto drive distance 2", RobotMap.RL_DRIVE_DISTANCE_2)));
		} else {
	    	addSequential(new DriveStraightPIDCommand(-RobotMap.RL_DRIVE_DISTANCE_1));
	    	addSequential(new PointTurnPIDCommand(-RobotMap.RL_ROTATE_DISTANCE));
	    	addSequential(new DriveStraightPIDCommand(-RobotMap.RL_DRIVE_DISTANCE_2));
		}
    	addSequential(new ExtendGearPickerCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveStraightPIDCommand(2));
    	addSequential(new RetractGearPickerCommand());
    	addSequential(new WaitCommand(0.75));
    }
}
