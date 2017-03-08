package org.usfirst.frc.team3506.robot.subsystems;

import java.util.Collections;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3506.robot.Robot;
import org.usfirst.frc.team3506.robot.RobotMap;
import org.usfirst.frc.team3506.robot.vision.RedContourVisionPipeline;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.vision.VisionThread;

/**
 *
 */
public class VisionDrivePIDSubsystem extends PIDSubsystem {

	//Motor variables
	Spark frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark;
	private RobotDrive drive;
	private Encoder leftEnc, rightEnc;
	
	//Vision variables
	private VisionThread visionThread;
	private final Object imgLock = new Object();
	private double visionCenterX;
	private double visionArea;
	
    public VisionDrivePIDSubsystem() {
    	//PID settings
		super("VisionDrive", RobotMap.P, RobotMap.I, RobotMap.D);
		setInputRange(RobotMap.MIN_TURN_SPEED, RobotMap.MAX_TURN_SPEED);
		setSetpoint(0);
		
		//Instantiating motor objects
    	frontLeftSpark = new Spark(RobotMap.FRONT_LEFT_SPARK);
		backLeftSpark = new Spark(RobotMap.BACK_LEFT_SPARK);
		frontRightSpark = new Spark(RobotMap.FRONT_RIGHT_SPARK);
		backRightSpark = new Spark(RobotMap.BACK_RIGHT_SPARK);

		frontLeftSpark.setInverted(true);
		backLeftSpark.setInverted(true);
		drive = new RobotDrive(frontLeftSpark, backLeftSpark, frontRightSpark, backRightSpark);
		
		leftEnc = new Encoder(RobotMap.LEFT_DRIVE_ENCODER[0], RobotMap.LEFT_DRIVE_ENCODER[1], false, EncodingType.k4X);
		rightEnc = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER[0], RobotMap.RIGHT_DRIVE_ENCODER[1], true, EncodingType.k4X);
		leftEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
		rightEnc.setDistancePerPulse(RobotMap.DRIVE_ENCODER_FEET_PER_PULSE);
		
		//Creating vision thread
		visionThread = new VisionThread(Robot.camera, new RedContourVisionPipeline(), pipeline -> {
			if (!pipeline.findContoursOutput().isEmpty()) {
				Collections.sort(pipeline.convexHullsOutput(), (first, second) -> {
					if (first.size().area() > second.size().area()) {
						return -1;
					} else if (first.size().area() == second.size().area()) {
						return 0;
					} else {
						return 1;
					}
				});
				Rect rectangle = Imgproc.boundingRect(pipeline.convexHullsOutput().get(0));
				synchronized (imgLock) {
					visionCenterX = rectangle.x + (rectangle.width / 2);
					visionArea = rectangle.area();
				}
			}
		});
    }

    public void initDefaultCommand() {
    	
    }

    protected double returnPIDInput() {
    	//Getting variables from vision thread
    	double visionCenterX, visionArea;
    	synchronized (imgLock) {
			visionCenterX = this.visionCenterX;
			visionArea = this.visionArea;
		}
    	
    	//Returning azimuth of picture or 0 if nothing detected
    	if (visionArea < RobotMap.MIN_TARGET_SIZE || visionCenterX == 0) {
			System.out.println("No Target");
			return 0;
		} else {
			return visionCenterX - RobotMap.IMAGE_CENTER_X;
		}
    }

    protected void usePIDOutput(double output) {
    	//Driving forward at constant speed and turning based on PID loop output
    	//or stops driving if encoders say we're at the peg
        if (getAvgEncoderDistance() <= RobotMap.MAX_DRIVE_DISTANCE) {
			drive.arcadeDrive(RobotMap.MAX_TURN_SPEED, output);
		} else {
			drive.arcadeDrive(0, 0);
		}
    }
	
	public void startVisionThread() {
		visionThread.start();
		enable();
	}
	
	public void stopVisionThread() {
		visionThread.stop();
		disable();
	}

	private double getLeftEncoderDistance() {
		return leftEnc.getDistance();
	}

	private double getRightEncoderDistance() {
		return rightEnc.getDistance();
	}
	
	private double getAvgEncoderDistance() {
		return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2;
	}
}
