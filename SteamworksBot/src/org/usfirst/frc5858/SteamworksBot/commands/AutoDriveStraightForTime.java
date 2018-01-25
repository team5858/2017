package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoDriveStraightForTime extends TimedCommand {
	double speed;	
	double startAngle;
    public AutoDriveStraightForTime(double timeout, double speed) {
        super(timeout);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires (Robot.drivetrain);
        this.speed = speed;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	SmartDashboard.putString("DB/String 2", "Going foward for time..");
    	startAngle = Robot.drivetrain.GetAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.drivetrain.GetAngle();
    	angle = angle - startAngle; 
    	if (angle > 180)
    		angle = angle - 360;
    	Robot.drivetrain.Drive(0.0, speed, -0.03*angle);
    }

    // Called once after timeout
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
