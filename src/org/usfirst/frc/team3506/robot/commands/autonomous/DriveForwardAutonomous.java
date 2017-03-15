package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightPIDCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveForwardAutonomous extends CommandGroup {

    public DriveForwardAutonomous() {
    	addSequential(new DriveStraightPIDCommand(9));
    }
}
