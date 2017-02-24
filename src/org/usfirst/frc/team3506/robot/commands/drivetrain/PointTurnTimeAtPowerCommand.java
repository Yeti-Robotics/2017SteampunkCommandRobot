package org.usfirst.frc.team3506.robot.commands.drivetrain;

import org.usfirst.frc.team3506.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PointTurnTimeAtPowerCommand extends Command {

private double time, power;
	
    public PointTurnTimeAtPowerCommand(double time, double power) {
    	this.time = time;
    	this.power = power;
    	requires(Robot.driveTrainSubsystem);
    }

    protected void initialize() {
    	setTimeout(this.time);
    }

    protected void execute() {
    	if(power > 0){
    		Robot.driveTrainSubsystem.moveLeftTrain(power);
    		Robot.driveTrainSubsystem.moveRightTrain(-power);
    	} else if(power < 0){
    		Robot.driveTrainSubsystem.moveLeftTrain(-power);
    		Robot.driveTrainSubsystem.moveRightTrain(power);
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