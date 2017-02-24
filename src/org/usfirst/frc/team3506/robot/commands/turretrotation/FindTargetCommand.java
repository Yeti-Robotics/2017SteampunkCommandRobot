package org.usfirst.frc.team3506.robot.commands.turretrotation;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class FindTargetCommand extends Command {

    public FindTargetCommand() {
        requires(Robot.turretRotationSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	System.out.println("ExecutingCommand");
    	Robot.turretRotationSubsystem.rotateTurret(Robot.turretRotationSubsystem.getDesiredRotationSpeed(Robot.visionArea, Robot.visionCenterX));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
