package org.usfirst.frc5858.SteamworksBot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SendVisionHandshake extends Command {

    public SendVisionHandshake() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	// DEMO BOT MODE
    	//requires(Robot.visionCamera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
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
