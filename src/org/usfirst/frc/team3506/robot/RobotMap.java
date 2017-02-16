package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RobotMap {

	// Drivetrain
	public static final int FRONT_LEFT_SPARK = 0; //Practice bot
	public static final int BACK_LEFT_SPARK = 3; //Practice bot
	public static final int FRONT_RIGHT_SPARK = 1; //Practice bot
	public static final int BACK_RIGHT_SPARK = 2; //Practice bot
//	public static final int FRONT_LEFT_SPARK = 2; //Final bot
//	public static final int BACK_LEFT_SPARK = 1; //Final bot
//	public static final int FRONT_RIGHT_SPARK = 3; //Final bot
//	public static final int BACK_RIGHT_SPARK = 0; //Final bot

	// Joysticks
	public static final int LFFT_JOYSTICK_PORT = 1;
	public static final int RIGHT_JOYSTICK_PORT = 2;

	// Gear shift
	public static final int[] GEAR_SHIFT_SOLENOID_PORTS = { 0, 1 }; //Practice bot
	public static final Value DRIVETRAIN_SHIFT_UP = Value.kForward;
	public static final Value DRIVETRAIN_SHIFT_DOWN = Value.kReverse;

	// Ball intake
//	public static final int INTAKE_SPARK = 4; //Final bot
	public static final int INTAKE_SPARK = 8; //Practice bot
	public static final double INTAKE_SPEED = 1;
	
	// Turret Control
	public static final int TURRET_ROTATION_SPARK = 7; //Practice bot
	public static final double MANUAL_TURRET_ROTATION_SPEED = .1;
	public static final int IMAGE_CENTER_X = 320;
	public static final int MIN_TARGET_SIZE = 300;
	public static final double NO_TARGET_FOUND_SPEED = 0.1;
	public static final int MAX_ACCEPTABLE_TARGET_X_VALUE = 100;
	public static final int SLOW_TURRET_ADJUSTMENT_RANGE = 100;
	public static final double SLOW_TURRET_ADJUSTMENT_SPEED = 0.05;
	public static final double FAST_TURRET_ADJUSTMENT_SPEED = 0.1;
	
	//Turret flywheel
	public static final int TURRET_FLYWHEEL_SPARK = 4; //Practice bot
	
	//Turret pitch
	public static final int LEFT_TURRET_SERVO = 9; //Practice bot
	public static final int RIGHT_TURRET_SERVO = 5; //Practice bot
	public static final double MANUAL_SERVO_ADJUSTMENT_RATE = .01;
	
	//Gear dispenser
	public static final int[] GEAR_DISPENSER_SOLENOID = { 4, 5 }; //Practice bot
	
	//Tower
	public static final int TOWER_SPARK = 6; //Practice bot
//	public static final int DUMB_WAITER_SPARK = 6; //Final bot
	public static final double TOWER_LIFT_SPEED = 1;
	
	//Climber
	public static final int CLIMBER_SPARK = 18; //Not final
	public static final double CLIMBER_SPEED = 1;

}
