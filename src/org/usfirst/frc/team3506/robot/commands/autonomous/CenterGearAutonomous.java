package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnPIDCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.ExtendGearDispenserCommand;
import org.usfirst.frc.team3506.robot.commands.gearpicker.RetractGearDispenserCommand;
import org.usfirst.frc.team3506.robot.vision.GearTargetInfo;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class CenterGearAutonomous extends CommandGroup {

    public CenterGearAutonomous() {
    	addSequential(new PointTurnPIDCommand(GearTargetInfo.getAzimuth()));
    	addSequential(new DriveStraightPIDCommand(GearTargetInfo.getDistance()));
    	addSequential(new ExtendGearDispenserCommand());
    	addSequential(new RetractGearDispenserCommand());
    	addSequential(new WaitCommand(2));
    	addSequential(new DriveStraightPIDCommand(-1));
    }
}
