package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.LeftDrivetrainSubsystem.ControlType;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleDrivetrainControlTypeCommand extends Command {

    public ToggleDrivetrainControlTypeCommand() {
    	requires(Robot.rightDrivetrainSubsystem);
    }

    protected void initialize() {
    	if (Robot.leftMainDrivetrainSubsystem.getControlType() == ControlType.TANK) {
    		Robot.leftMainDrivetrainSubsystem.setControlType(ControlType.ARCADE);
    	} else {
    		Robot.leftMainDrivetrainSubsystem.setControlType(ControlType.TANK);
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
