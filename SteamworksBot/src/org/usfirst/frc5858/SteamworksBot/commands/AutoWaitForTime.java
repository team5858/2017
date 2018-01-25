package org.usfirst.frc5858.SteamworksBot.commands;

import edu.wpi.first.wpilibj.command.TimedCommand;

public class AutoWaitForTime extends TimedCommand {

	public AutoWaitForTime(double timeout) {
		super(timeout);
		// Nothing here but a wait
	}
	
	// Called repeatedly when this Command is scheduled to run
    protected void execute() { 
    	// Nothing to do
    }

    // Called once after timeout
    protected void end() {    	
    	// Nothing to do
    }

}
