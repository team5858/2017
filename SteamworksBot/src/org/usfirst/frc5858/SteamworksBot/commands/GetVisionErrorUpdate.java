package org.usfirst.frc5858.SteamworksBot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GetVisionErrorUpdate extends Command {

    public GetVisionErrorUpdate() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	// DEMO BOT MODE
    	// requires(Robot.visionCamera);
    	this.setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	// DEMO BOT MODE
    	//Robot.visionCamera.DisplayUpdate();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
