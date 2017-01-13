package org.usfirst.frc.team3506.robot;

import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI{ 
	public Joystick leftJoystick, rightJoystick;
	
	public OI(){
	leftJoystick = new Joystick(RobotMap.LFFT_JOYSTICK_PORT);
	rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK_PORT); 
}
}

