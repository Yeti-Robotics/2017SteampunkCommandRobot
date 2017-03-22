package org.usfirst.frc.team3506.robot.commands.autonomous;

import org.usfirst.frc.team3506.robot.commands.clawgrip.GripClawCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class CenterGearTimeAutonomous extends CommandGroup {

    public CenterGearTimeAutonomous() {
        addSequential(new DriveStraightTimeAtPowerCommand(0.5, 2.7));
        addSequential(new WaitCommand(.25));
        addSequential(new GripClawCommand());
    }
}
