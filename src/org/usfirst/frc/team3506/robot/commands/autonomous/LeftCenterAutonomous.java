package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnDegreesAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class LeftCenterAutonomous extends CommandGroup {

    public LeftCenterAutonomous() {
    	addSequential(new DriveStraightPIDCommand(4.495));
    	addSequential(new PointTurnDegreesAtPowerCommand(60, .25));
    	addSequential(new DriveStraightPIDCommand(7.049));
    	addSequential(new WaitCommand(1));
    }
}
