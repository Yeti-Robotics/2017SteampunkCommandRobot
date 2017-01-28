package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class RobotMap {

	// Drivetrain
	public static final int FRONT_LEFT_SPARK = 1;
	public static final int BACK_LEFT_SPARK = 4;
	public static final int FRONT_RIGHT_SPARK = 2;
	public static final int BACK_RIGHT_SPARK = 3;

	// Joysticks
	public static final int LFFT_JOYSTICK_PORT = 1;
	public static final int RIGHT_JOYSTICK_PORT = 2;

	// GearShift
	public static final int[] SOLENOID_PORTS = { 0, 1 };
	public static final Value DRIVETRAIN_SHIFT_UP = Value.kForward;
	public static final Value DRIVETRAIN_SHIFT_DOWN = Value.kReverse;

	// Ball intake
	public static final int INTAKE_SPARK = 5;
	public static final double INTAKE_SPEED = 0.4;
	
	// Turret Control
	public static final int TURRET_ROTATION_SPARK = 6;
	public static final double X_CENTER = 340;
	public static final double MIN_TARGET_SIZE = 300;
	public static final double NO_TARGET_FOUND_SPEED = 0.2;
	public static final double MAX_ACCEPTABLE_TARGET_X_VALUE = 30;
	public static final double SLOW_TURRET_ADJUSTMENT_RANGE = 100;
	public static final double SLOW_TURRET_ADJUSTMENT_SPEED = 0.2;
	
}
