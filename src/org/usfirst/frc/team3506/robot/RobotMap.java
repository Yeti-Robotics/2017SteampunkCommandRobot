package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RobotMap {
	
	public static final boolean IS_PRACTICE_BOT = false;

	// Drivetrain
	public static final int FRONT_LEFT_SPARK = IS_PRACTICE_BOT ? 0 : 2;
	public static final int BACK_LEFT_SPARK = IS_PRACTICE_BOT ? 3 : 1;
	public static final int FRONT_RIGHT_SPARK = IS_PRACTICE_BOT ? 1 : 3;
	public static final int BACK_RIGHT_SPARK = IS_PRACTICE_BOT ? 2 : 0;
	public static final int[] LEFT_DRIVE_ENCODER = { 6, 7 };
	public static final int[] RIGHT_DRIVE_ENCODER = { 8, 9 };
	public static final double DRIVE_ENCODER_FEET_PER_PULSE = (Math.PI / 3.0) / 128.0;
	public static final double ROBOT_TRACK_WIDTH_FT = 2;
	public static final double LEFT_DRIVETRAIN_TRIM = IS_PRACTICE_BOT ? 1 : .95;
	public static final double RIGHT_DRIVETRAIN_TRIM = IS_PRACTICE_BOT ? .701 : 1;
    
	// Joysticks
	public static final int LFFT_JOYSTICK_PORT = 1;
	public static final int RIGHT_JOYSTICK_PORT = 2;
	public static final int SHOOTER_JOYSTICK_PORT = 0;
	public static final double JOYSTICK_DEADZONE = IS_PRACTICE_BOT ? .2 : .05;

	// Gear shift
	public static final int[] GEAR_SHIFT_SOLENOID_PORTS = { 0, 1 };
	public static final Value DRIVETRAIN_SHIFT_UP = Value.kForward;
	public static final Value DRIVETRAIN_SHIFT_DOWN = Value.kReverse;

	// Ball intake
	public static final int INTAKE_SPARK = IS_PRACTICE_BOT ? 8 : 4;
	public static final double INTAKE_SPEED = 1;
	
	// Turret Control
	public static final int TURRET_ROTATION_SPARK = IS_PRACTICE_BOT ? 4 : 5;
	public static final double MANUAL_TURRET_ROTATION_SPEED = 0.2;
	public static final int IMAGE_CENTER_X = 320;
	public static final int MIN_TARGET_SIZE = 300;
	public static final double NO_TARGET_FOUND_SPEED = 0.1;
	public static final int MAX_ACCEPTABLE_TARGET_X_VALUE = 100;
	public static final int SLOW_TURRET_ADJUSTMENT_RANGE = 200;
	public static final double SLOW_TURRET_ADJUSTMENT_SPEED = 0.18;
	public static final double FAST_TURRET_ADJUSTMENT_SPEED = 0.2;
	
	//Turret flywheel
	public static final int TURRET_FLYWHEEL_SPARK = 7;
	public static final double TURRET_FLYWHEEL_SPEED = .65;
	
	//Turret pitch
	public static final int LEFT_TURRET_SERVO = 19;
	public static final int RIGHT_TURRET_SERVO = 18;
	public static final double MANUAL_SERVO_ADJUSTMENT_RATE = .005;
	public static final double LEFT_SERVO_UPPER_LIMIT = 0.7;
	public static final double LEFT_SERVO_LOWER_LIMIT = 0.2;
	public static final double RIGHT_SERVO_UPPER_LIMIT = 0.8;
	public static final double RIGHT_SERVO_LOWER_LIMIT = 0.3;
	
	//Gear dispenser
	public static final int[] GEAR_DISPENSER_SOLENOID = { 2, 3 };
	
	//Gear Picker
	public static final int[] GEAR_PICKER_SOLENOID = { 4, 5 };
	
	//Tower
	public static final int TOWER_SPARK = 6;
	public static final double TOWER_LIFT_SPEED = 1;
	
	//Climber
	public static final int CLIMBER_SPARK = IS_PRACTICE_BOT ? 9 : 8;
	public static final double CLIMBER_SPEED = 1;
	
	//Vision
	public static final int IMG_WIDTH = 640;
	public static final int IMG_HEIGHT = 480;
	public static final int CAM_EXPOSURE = 0;
	public static final int CAM_BRIGHTNESS = 50;
}
