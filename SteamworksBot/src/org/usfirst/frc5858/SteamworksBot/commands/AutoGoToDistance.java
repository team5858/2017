package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoGoToDistance extends Command {

	private double distance;
	double startAngle; 
    public AutoGoToDistance(double D) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires (Robot.drivetrain);
    	distance=D;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("DB/String 2", "Going to distance..");
    	startAngle = Robot.drivetrain.GetAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double gyroAngle = Robot.drivetrain.GetAngle();
    	gyroAngle = gyroAngle - startAngle;
    	if (gyroAngle > 180)
    		gyroAngle -= 360;
    	Robot.drivetrain.Drive(0, -0.2, -0.03 * gyroAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double range= Robot.drivetrain.GetRange();
        return (range < distance);
    }
}
