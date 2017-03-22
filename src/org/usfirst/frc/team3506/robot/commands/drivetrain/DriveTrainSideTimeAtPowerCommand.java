package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem;
import org.usfirst.frc.team3506.robot.subsystems.DrivetrainSubsystem.DriveTrainSide;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTrainSideTimeAtPowerCommand extends Command {

	DrivetrainSubsystem.DriveTrainSide side;
	double power, time;
    public DriveTrainSideTimeAtPowerCommand(DrivetrainSubsystem.DriveTrainSide side, double power, double time) {
    	requires(Robot.driveTrainSubsystem);
    	this.power = power;
    	this.time = time;
    	this.side = side;
    }

    protected void initialize() {
    	setTimeout(time);
    }

    protected void execute() {
    	if(side == DriveTrainSide.LEFT) {
    		Robot.driveTrainSubsystem.moveLeftTrain(power);
    	} else {
    		Robot.driveTrainSubsystem.moveRightTrain(-power);
    	}
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    	Robot.driveTrainSubsystem.driveStraight(0);
    }

    protected void interrupted() {
    }
}
