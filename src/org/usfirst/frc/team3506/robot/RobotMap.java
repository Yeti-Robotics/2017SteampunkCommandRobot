package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	  public static final int FRONT_LEFT_SPARK = 1;
	    public static final int BACK_LEFT_SPARK = 7;
	    public static final int FRONT_RIGHT_SPARK = 4;
	    public static final int BACK_RIGHT_SPARK = 3;
	    
	    //Joysticks
	    
	    public static final int LFFT_JOYSTICK_PORT =1;
	    public static final int RIGHT_JOYSTICK_PORT =2;
	    
	    //gearshift 
	    
		//GearShift
		public static final int[] SOLENOID_PORTS = {0,1};
		public static final Value DRIVETRAIN_SHIFT_UP = Value.kForward;
		public static final Value DRIVETRAIN_SHIFT_DOWN = Value.kReverse;
	    
}
