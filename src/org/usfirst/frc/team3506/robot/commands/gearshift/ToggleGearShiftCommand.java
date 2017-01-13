package org.usfirst.frc.team3506.robot.commands.gearshift;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleGearShiftCommand extends Command {

    public ToggleGearShiftCommand() {
    	requires(Robot.gearshiftsubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	if (Robot.gearshiftsubsystem.shiftedState() == RobotMap.DRIVETRAIN_SHIFT_UP) {
    		Robot.gearshiftsubsystem.shiftDown();
    	} else {
    		Robot.gearshiftsubsystem.shiftUp();
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
