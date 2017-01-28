package org.usfirst.frc.team3506.robot.commands.turretrotation;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FindTargetCommand extends Command {

    public FindTargetCommand() {
        requires(Robot.turretRotationSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.turretRotationSubsystem.rotateTurret(Robot.turretRotationSubsystem.getDesiredRotationSpeed(Robot.turretRotationSubsystem.getAreas()[0], Robot.turretRotationSubsystem.getCenterX()[0]));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
