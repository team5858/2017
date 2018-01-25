package org.usfirst.frc5858.SteamworksBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNearGear extends CommandGroup {
	
	private static final double TEMPLOWPOWER = -0.8;
	//private static final double SCOOTSPEED = 0.1;

    public AutoNearGear(double pauseFirst, double driveTime) {
    	addSequential(new CloseGearbasket());
    	
    	// Let other teams get out of the way (DB/Slider 1)
    	addSequential(new AutoWaitForTime(pauseFirst));
    	
    	// Drive up to peg (DB/Slider 2)
    	addSequential(new AutoDriveStraightForTime(driveTime, TEMPLOWPOWER));
    	
    	// Drop the gear
    	//addSequential(new OpenGearbasket());
    	//addSequential(new AutoDriveForTime(Robot.Constants.scootTime,     0, -SCOOTSPEED, 0));
    	//addSequential(new AutoDriveForTime(Robot.Constants.scootTime * 2, 0,  SCOOTSPEED, 0));    	
    }
    
}
