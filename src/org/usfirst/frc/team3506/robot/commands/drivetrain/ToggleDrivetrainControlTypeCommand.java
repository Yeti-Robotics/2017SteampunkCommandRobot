package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem.ControlType;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleDrivetrainControlTypeCommand extends Command {

    public ToggleDrivetrainControlTypeCommand() {
    	requires(Robot.driveTrainSubsystem);
    }

    protected void initialize() {
    	if (Robot.driveTrainSubsystem.getControlType() == ControlType.TANK) {
    		Robot.driveTrainSubsystem.setControlType(ControlType.ARCADE);
    	} else {
    		Robot.driveTrainSubsystem.setControlType(ControlType.TANK);
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
