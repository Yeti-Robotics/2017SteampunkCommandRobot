package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RobotMap {
	
	public static final boolean IS_PRACTICE_BOT = true;

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
	public static final double MAX_DRIVE_RATE = 11.5;
	public static final double MIN_DRIVETRAIN_OUTPUT = -1;
	public static final double MAX_DRIVETRAIN_OUTPUT = 1;
	public static final double LEFT_DISTANCE_P = 1.0/(69.0/12.0);
	public static final double LEFT_DISTANCE_I = 0;
	public static final double LEFT_DISTANCE_D = 0;
	public static final double RIGHT_DISTANCE_P = 1.0/(69.0/12.0);
	public static final double RIGHT_DISTANCE_I = 0;
	public static final double RIGHT_DISTANCE_D = 0;
	public static final double LEFT_RATE_P = 0.8;
	public static final double LEFT_RATE_I = 0.3;
	public static final double LEFT_RATE_D = 0;
	public static final double RIGHT_RATE_P = 0.8;
	public static final double RIGHT_RATE_I = 0.3;
	public static final double RIGHT_RATE_D = 0;
	public static final double MAX_TURN_SPEED = .4;
	public static final double MIN_TURN_SPEED = 0;
	public static final double GEAR_PLACEMENT_DISTANCE = .5;
    
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
	
	//Camera
	public static final int IMG_WIDTH = 640;
	public static final int IMG_HEIGHT = 480;
	public static final int CAM_EXPOSURE_VISION = 0;
	public static final int CAM_BRIGHTNESS_VISION = 50;
	public static final int CAM_EXPOSURE_DRIVING = 50;
	public static final int CAM_BRIGHTNESS_DRIVING = 100;
	public static final double HORIZONTAL_FOV = 66 * Math.cos(Math.atan(9.0 / 16.0));
	public static final double VERTICAL_FOV = 66 * Math.sin(Math.atan(9.0 / 16.0));
	public static final double FOCAL_LENGTH = 543.45;
	public static final double TARGET_WIDTH_INCH = /*10.25*/9.5;
	public static final double TARGET_HEIGHT_INCH = /*5*/4.75;
}
