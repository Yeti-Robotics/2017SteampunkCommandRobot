package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystemHandler.DrivetrainFeedbackType;
import org.usfirst.frc.team3506.robot.vision.GearTargetInfo;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToPegCommand extends Command {

    public DriveToPegCommand() {
    	requires(Robot.leftMainDrivetrainSubsystem);
    	requires(Robot.rightDrivetrainSubsystem);
    }

    protected void initialize() {
    	DrivetrainSubsystemHandler.setFeedbackType(DrivetrainFeedbackType.DISTANCE);
    	DrivetrainSubsystemHandler.resetEncoders();
    	DrivetrainSubsystemHandler.setSetpoint(GearTargetInfo.getDistance());
    	DrivetrainSubsystemHandler.enable();
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
        return GearTargetInfo.getDistance() <= RobotMap.GEAR_PLACEMENT_DISTANCE;
    }

    protected void end() {
    	DrivetrainSubsystemHandler.disable();
    }

    protected void interrupted() {
    	
    }
}
