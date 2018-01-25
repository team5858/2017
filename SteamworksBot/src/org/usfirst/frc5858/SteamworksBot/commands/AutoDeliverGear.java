package org.usfirst.frc5858.SteamworksBot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDeliverGear extends CommandGroup {
	private static final double TEMPLOWPOWER = -0.8;
	private static final double SCOOTSPEED = -0.3;

    public AutoDeliverGear(double pauseFirst, double driveTime) {
    	addSequential(new CloseGearbasket());
    	
    	// Let other teams get out of the way (DB/Slider 1)
    	addSequential(new AutoWaitForTime(pauseFirst));
    	
    	// Drive up to peg (DB/Slider 2)
    	addSequential(new AutoDriveStraightForTime(driveTime, TEMPLOWPOWER));
    	
    	// Open gear basket
    	addSequential(new OpenGearbasket());
    	
    	// Hang on a second
    	addSequential(new AutoWaitForTime(1.0));
    	
    	// Scoot a bit to shake the gear
    	addSequential(new AutoDriveStraightForTime(0.2, SCOOTSPEED));
    	
    	// Back away
    	addSequential(new AutoDriveStraightForTime(0.5, -TEMPLOWPOWER));  
    	
    	// close gear basket for teleop
    	addSequential(new CloseGearbasket());
    }
}
