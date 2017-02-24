package org.usfirst.frc.team3506.robot.commands.turretflywheel;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DeactivateFlywheelCommand extends Command {

    public DeactivateFlywheelCommand() {
    	requires(Robot.turretFlywheelSubsystem);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.turretFlywheelSubsystem.deactivateFlywheels();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
