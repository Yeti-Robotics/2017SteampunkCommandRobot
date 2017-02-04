package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RobotMap {

	// Drivetrain
	public static final int FRONT_LEFT_SPARK = 0;
	public static final int BACK_LEFT_SPARK = 3;
	public static final int FRONT_RIGHT_SPARK = 1;
	public static final int BACK_RIGHT_SPARK = 2;

	// Joysticks
	public static final int LFFT_JOYSTICK_PORT = 1;
	public static final int RIGHT_JOYSTICK_PORT = 2;

	// GearShift
	public static final int[] SOLENOID_PORTS = { 0, 1 };
	public static final Value DRIVETRAIN_SHIFT_UP = Value.kForward;
	public static final Value DRIVETRAIN_SHIFT_DOWN = Value.kReverse;

	// Ball intake
	public static final int INTAKE_SPARK = 8;
	public static final double INTAKE_SPEED = 1;
	
	//Tower
	public static final int DUMB_WAITER_SPARK = 6;
	public static final double DUMB_WAITER_LIFT_SPEED = 0.5;
	
	//Climber
	public static final int CLIMBER_SPARK = 7;
	public static final double CLIMBER_SPEED = .5;
	
}
