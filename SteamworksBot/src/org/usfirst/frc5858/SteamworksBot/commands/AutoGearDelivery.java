package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearDelivery extends CommandGroup {

    public AutoGearDelivery() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	addSequential(new AutoGoToDistance(Robot.Constants.distanceToPeg));
    	//addSequential(new AutoPutGearOnPeg());
    	addSequential(new OpenGearbasket());
    	double scootSpeed = 0.1;
    	addSequential(new AutoDriveForTime(Robot.Constants.scootTime, 0, -scootSpeed, 0));
    	addSequential(new AutoDriveForTime(Robot.Constants.scootTime * 2, 0, scootSpeed, 0));
    	//addSequential(new CloseGearbasket());
    	
    }
}
