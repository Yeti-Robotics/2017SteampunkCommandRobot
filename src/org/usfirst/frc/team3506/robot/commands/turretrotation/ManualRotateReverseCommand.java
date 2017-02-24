package org.usfirst.frc.team3506.robot.commands.turretrotation;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ManualRotateReverseCommand extends Command {

    public ManualRotateReverseCommand() {
    	requires(Robot.turretRotationSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	System.out.println("1");
    	Robot.turretRotationSubsystem.rotateTurret(-RobotMap.MANUAL_TURRET_ROTATION_SPEED);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	System.out.println("2");
    	Robot.turretRotationSubsystem.rotateTurret(0);
    }
}
