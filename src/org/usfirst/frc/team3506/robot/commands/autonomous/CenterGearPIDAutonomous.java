package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.ExtendGearPickerCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.RetractGearPickerCommand;
import org.usfirst.frc.team3506.robot.vision.GearTargetInfo;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CenterGearPIDAutonomous extends CommandGroup {

    public CenterGearPIDAutonomous() {
    	addSequential(new DriveStraightPIDCommand(-RobotMap.CENTER_DRIVE_DISTANCE));
    	addSequential(new ExtendGearPickerCommand());
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveStraightPIDCommand(2));
    	addSequential(new RetractGearPickerCommand());
    	addSequential(new WaitCommand(0.75));
    }
}
