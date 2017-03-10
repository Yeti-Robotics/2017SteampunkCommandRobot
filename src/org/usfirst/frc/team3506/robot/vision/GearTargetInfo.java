package org.usfirst.frc.team3506.robot.vision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3506.robot.RobotMap;

public class GearTargetInfo {

	public static final Object imgLock = new Object();
	private static int numTargets = 0;
	private static Rect leftRect, rightRect, gearRect;
	private static double leftTargetCenterX, leftTargetCenterY, leftTargetArea, leftTargetWidth, rightTargetCenterX,
			rightTargetCenterY, rightTargetArea, rightTargetWidth, gearTargetCenterX, gearTargetCenterY,
			gearTargetWidth;

	public static void setTargetContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (imgLock) {
			if (matOfPoints.size() >= 2) {
				numTargets = 2;
				List<Point> targets = Arrays.asList(matOfPoints.get(0).toArray());
				targets.addAll(Arrays.asList(matOfPoints.get(1).toArray()));
				if (Imgproc.boundingRect(matOfPoints.get(0)).x < Imgproc.boundingRect(matOfPoints.get(1)).x) {
					leftRect = Imgproc.boundingRect(matOfPoints.get(0));
					rightRect = Imgproc.boundingRect(matOfPoints.get(1));
					setLeftTarget(leftRect);
					setRightTarget(rightRect);
				} else {
					leftRect = Imgproc.boundingRect(matOfPoints.get(1));
					rightRect = Imgproc.boundingRect(matOfPoints.get(0));
					setLeftTarget(rightRect);
					setRightTarget(leftRect);
				}
				gearRect = Imgproc.boundingRect(new MatOfPoint((Point[]) targets.toArray()));
				setTargetCenter();
			} else if (matOfPoints.size() >= 1) {
				numTargets = 1;
				leftRect = Imgproc.boundingRect(matOfPoints.get(0));
				setLeftTarget(leftRect);
			} else {
				numTargets = 0;
			}
		}
	}

	public static double getAzimuth() {
		if (gearTargetCenterX != 0 && gearTargetCenterY != 0) {
			return ((gearTargetCenterX * RobotMap.HORIZONTAL_FOV) / RobotMap.IMG_WIDTH) - (RobotMap.HORIZONTAL_FOV / 2);
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

	private static void setLeftTarget(Rect gearRect1) {
		leftTargetCenterX = gearRect1.x + (gearRect1.width / 2);
		leftTargetCenterY = gearRect1.y + (gearRect1.height / 2);
		leftTargetArea = gearRect1.area();
		leftTargetWidth = gearRect1.width;
	}

	private static void setRightTarget(Rect gearRect2) {
		rightTargetCenterX = gearRect2.x + (gearRect2.width / 2);
		rightTargetCenterY = gearRect2.y + (gearRect2.height / 2);
		rightTargetArea = gearRect2.area();
		rightTargetWidth = gearRect2.width;
	}

	private static void setTargetCenter() {
//		gearTargetWidth = (rightTargetCenterX + (rightTargetWidth / 2)) - (leftTargetCenterX - (leftTargetWidth / 2));
//		gearTargetCenterX = (leftTargetCenterX - (leftTargetWidth / 2)) + (gearTargetWidth / 2);
//		gearTargetCenterY = (leftTargetCenterY + rightTargetCenterY) / 2;
		gearTargetWidth = gearRect.width;
		gearTargetCenterX = gearRect.x + (gearRect.width / 2);
		gearTargetCenterY = gearRect.y - (gearRect.height / 2);
	}

	public static int getNumTargets() {
		return numTargets;
	}

	public static double getGear1CenterX() {
		return leftTargetCenterX;
	}

	public static double getGear1CenterY() {
		return leftTargetCenterY;
	}

	public static double getGear1Area() {
		return leftTargetArea;
	}

	public static double getGear2CenterX() {
		return rightTargetCenterX;
	}

	public static double getGear2CenterY() {
		return rightTargetCenterY;
	}

	public static double getGear2Area() {
		return rightTargetArea;
	}

	public static double getGearTargetCenterX() {
		return gearTargetCenterX;
	}

	public static double getGearTargetCenterY() {
		return gearTargetCenterY;
	}
}
