package org.usfirst.frc.team3506.robot.vision;

import java.util.ArrayList;

import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team3506.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearTargetInfo {

	public static final Object imgLock = new Object();
	private static int numTargets = 0;
	private static Rect leftRect, rightRect, gearRect;
	private static double leftTargetCenterX, leftTargetCenterY, leftTargetArea, leftTargetHeight, rightTargetCenterX,
			rightTargetCenterY, rightTargetArea, rightTargetHeight, gearTargetCenterX, gearTargetCenterY,
			gearTargetWidth, gearTargetHeight;

	public static void setTargetContours(ArrayList<MatOfPoint> matOfPoints) {
		synchronized (imgLock) {
			if (matOfPoints.size() >= 2) {
				numTargets = 2;
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
				gearRect = new Rect(leftRect.x, leftRect.y, (rightRect.x + rightRect.width) - leftRect.x,
						(leftRect.height + rightRect.height) / 2);
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
			return ((RobotMap.TARGET_WIDTH_INCH * RobotMap.FOCAL_LENGTH) / gearTargetWidth) / 12;
		} else {
			return 0;
		}
	}

	// D = (W x F) / P
	public static double[] getLeftRightDistance() {
		double[] leftRightDistance = {
			(RobotMap.TARGET_HEIGHT_INCH * RobotMap.FOCAL_LENGTH) / leftTargetHeight,
			(RobotMap.TARGET_HEIGHT_INCH * RobotMap.FOCAL_LENGTH) / rightTargetHeight
		};

		return leftRightDistance;
	}

	public static double getSkew() {
		double azimuth = getAzimuth();
		double a = RobotMap.TARGET_WIDTH_INCH;
		double b = getLeftRightDistance()[0];
		double c = getLeftRightDistance()[1];
		double A = Math.toDegrees(Math.acos(((b * b) + (c * c) - (a * a)) / (2 * b * c)));
		double B = Math.toDegrees(Math.acos(((c * c) + (a * a) - (b * b)) / (2 * c * a)));
		double C = Math.toDegrees(Math.acos(((a * a) + (b * b) - (c * c)) / (2 * a * b)));
		double fovAngle = 68.5;
		double imagePixelWidth = 1280;
		double leftAzimuth = azimuth - ((gearTargetWidth / 2) * (fovAngle / imagePixelWidth));
		double rightAzimuth = azimuth + ((gearTargetWidth / 2) * (fovAngle / imagePixelWidth));
		double skew = ((180 - (180 - leftAzimuth - B)) + (180 - (180 - rightAzimuth - (180 - C)))) / 2;
		return skew;
	}

	private static void setLeftTarget(Rect gearRect1) {
		leftTargetCenterX = gearRect1.x + (gearRect1.width / 2);
		leftTargetCenterY = gearRect1.y + (gearRect1.height / 2);
		leftTargetArea = gearRect1.area();
		leftTargetHeight = gearRect1.height;
	}

	private static void setRightTarget(Rect gearRect2) {
		rightTargetCenterX = gearRect2.x + (gearRect2.width / 2);
		rightTargetCenterY = gearRect2.y + (gearRect2.height / 2);
		rightTargetArea = gearRect2.area();
		rightTargetHeight = gearRect2.height;
	}

	private static void setTargetCenter() {
		// gearTargetWidth = (rightTargetCenterX + (rightTargetWidth / 2)) -
		// (leftTargetCenterX - (leftTargetWidth / 2));
		// gearTargetCenterX = (leftTargetCenterX - (leftTargetWidth / 2)) +
		// (gearTargetWidth / 2);
		// gearTargetCenterY = (leftTargetCenterY + rightTargetCenterY) / 2;
		gearTargetWidth = gearRect.width;
		gearTargetHeight = gearRect.height;
		gearTargetCenterX = gearRect.x + (gearRect.width / 2);
		gearTargetCenterY = gearRect.y - (gearRect.height / 2);
	}

	public static void publishTargetValues() {
		SmartDashboard.putNumber("Number of targets", numTargets);
		SmartDashboard.putNumber("Target width", gearTargetWidth);
		SmartDashboard.putNumber("Target height", gearTargetHeight);
		SmartDashboard.putNumber("Azimuth", getAzimuth());
		SmartDashboard.putNumber("Distance", getDistance());
		SmartDashboard.putString("Left target center", "(" + leftTargetCenterX + ", " + leftTargetCenterY + ")");
		SmartDashboard.putString("Right target center", "(" + rightTargetCenterX + ", " + rightTargetCenterY + ")");
		SmartDashboard.putString("Target center", "(" + gearTargetCenterX + ", " + gearTargetCenterY + ")");
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
