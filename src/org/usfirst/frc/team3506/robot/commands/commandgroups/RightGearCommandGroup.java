package org.usfirst.frc.team3506.robot.commands.commandgroups;

import org.usfirst.frc.team3506.robot.commands.drivetrain.DriveStraightTimeAtPowerCommand;
import org.usfirst.frc.team3506.robot.commands.drivetrain.PointTurnTimeAtPowerCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightGearCommandGroup extends CommandGroup {

    public RightGearCommandGroup() {
    	addSequential(new DriveStraightTimeAtPowerCommand(.5, .5)); //power, speed
    	addSequential(new PointTurnTimeAtPowerCommand(.25, .25));
    	addSequential(new DriveStraightTimeAtPowerCommand(.5, .5));
    	addSequential(new DriveStraightTimeAtPowerCommand(0, 1));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
