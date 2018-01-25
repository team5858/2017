package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoGoToAngle extends Command {
	private double startAngle;
	private double endAngle;
	private boolean done; 
	
    public AutoGoToAngle(double angle) {
    	requires(Robot.drivetrain);
    	endAngle = angle;
    }
   
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        startAngle = Robot.drivetrain.GetAngle();
    	
        double rotation = 0.0;
       	if (Math.abs(startAngle - endAngle) < 0.5)
    	{
    		done = true;
    	}
    	else
    	{
	    	double dl = startAngle - endAngle;
	    	double dr = endAngle - startAngle;
    	
	    	if (dl<0) dl += 360.0;
	    	if (dr<0)  dr += 360.0;
	    	rotation = (dl<=dr) ? -0.4 : 0.4;
    	}
       	
       	Robot.drivetrain.Drive(0, 0, rotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }
}
