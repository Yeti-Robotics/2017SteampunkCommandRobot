package org.usfirst.frc.team3506.robot.commands.turretflywheel;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ActivateFlywheelCommand extends Command {

    public ActivateFlywheelCommand() {
    	requires(Robot.turretFlywheelSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.turretFlywheelSubsystem.activateFlywheels();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    	Robot.turretFlywheelSubsystem.deactivateFlywheels();
    }
}
