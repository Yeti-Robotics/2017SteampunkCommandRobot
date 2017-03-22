package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.clawgrip.GripClawCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveTrainSideTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem.DriveTrainSide;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class RightGearTimeAutonomous extends CommandGroup {

    public RightGearTimeAutonomous() {
    	addSequential(new DriveStraightTimeAtPowerCommand(0.5, 2.7));
        addSequential(new WaitCommand(.25));
        addSequential(new DriveTrainSideTimeAtPowerCommand(DriveTrainSide.RIGHT, 0.5, 0.5));
        addSequential(new GripClawCommand());
    }
}
