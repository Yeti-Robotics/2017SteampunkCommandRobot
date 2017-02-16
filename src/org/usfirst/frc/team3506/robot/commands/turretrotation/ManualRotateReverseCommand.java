package org.usfirst.frc.team3506.robot.commands.turretrotation;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualRotateReverseCommand extends Command {

    public ManualRotateReverseCommand() {
    	requires(Robot.turretRotationSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.turretRotationSubsystem.rotateTurret(-RobotMap.MANUAL_TURRET_ROTATION_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.turretRotationSubsystem.rotateTurret(0);
    }
}
