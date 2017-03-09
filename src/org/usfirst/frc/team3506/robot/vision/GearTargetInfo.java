package org.usfirst.frc.team3506.robot.vision;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3506.robot.RobotMap;

public class GearTargetInfo {

	public static final Object imgLock = new Object();
	private static int numTargets = 0;
	private static Rect gearRect1, gearRect2;
	private static double gear1CenterX, gear1CenterY, gear1Area, gear1Width, gear2CenterX, gear2CenterY, gear2Area,
			gear2Width, gearTargetCenterX, gearTargetCenterY, gearTargetWidth;

	public static void setTargetContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (imgLock) {
			if (matOfPoints.size() >= 2) {
				numTargets = 2;
				gearRect1 = Imgproc.boundingRect(matOfPoints.get(0));
				gearRect2 = Imgproc.boundingRect(matOfPoints.get(1));
				setTarget1(gearRect1);
				setTarget2(gearRect2);
				setTargetCenter();
			} else if (matOfPoints.size() >= 1) {
				numTargets = 1;
				gearRect1 = Imgproc.boundingRect(matOfPoints.get(0));
				setTarget1(gearRect1);
			} else {
				numTargets = 0;
			}
		}
	}

	public static double getAzimuth() {
		if (gearTargetCenterX != 0 && gearTargetCenterY != 0) {
			return ((gearTargetCenterX * RobotMap.HORIZONTAL_FOV) / RobotMap.IMG_WIDTH)
					- (RobotMap.HORIZONTAL_FOV / 2);
		} else {
			return 0;
		}
	}

	public static double getDistance() {
		if (gearTargetCenterX != 0 && gearTargetCenterY != 0) {
			return (RobotMap.TARGET_WIDTH_INCH * RobotMap.FOCAL_LENGTH) / gearTargetWidth;
		} else {
			return 0;
		}
	}

	private static void setTarget1(Rect gearRect1) {
		gear1CenterX = gearRect1.x + (gearRect1.width / 2);
		gear1CenterY = gearRect1.y + (gearRect1.height / 2);
		gear1Area = gearRect1.area();
		gear1Width = gearRect1.width;
	}

	private static void setTarget2(Rect gearRect2) {
		gear1CenterX = gearRect2.x + (gearRect2.width / 2);
		gear1CenterY = gearRect2.y + (gearRect2.height / 2);
		gear1Area = gearRect2.area();
		gear2Width = gearRect2.width;
	}

	private static void setTargetCenter() {
		gearTargetCenterX = (gear1CenterX + gear2CenterX) / 2;
		gearTargetCenterY = (gear1CenterY + gear2CenterY) / 2;
		gearTargetWidth = gear1Width + gear2Width;
	}

	public static int getNumTargets() {
		return numTargets;
	}

	public static double getGear1CenterX() {
		return gear1CenterX;
	}

	public static double getGear1CenterY() {
		return gear1CenterY;
	}

	public static double getGear1Area() {
		return gear1Area;
	}

	public static double getGear2CenterX() {
		return gear2CenterX;
	}

	public static double getGear2CenterY() {
		return gear2CenterY;
	}

	public static double getGear2Area() {
		return gear2Area;
	}

	public static double getGearTargetCenterX() {
		return gearTargetCenterX;
	}

	public static double getGearTargetCenterY() {
		return gearTargetCenterY;
	}
}
