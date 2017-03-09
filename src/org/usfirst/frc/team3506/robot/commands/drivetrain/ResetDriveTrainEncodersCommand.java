package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;

import edu.wpi.first.wpilibj.command.Command;

public class ResetDriveTrainEncodersCommand extends Command {

    public ResetDriveTrainEncodersCommand() {
    	requires(Robot.rightDrivetrainSubsystem);
    	requires(Robot.leftMainDrivetrainSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	DrivetrainSubsystemHandler.resetEncoders();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    	
    }

    protected void interrupted() {
    	
    }
}
