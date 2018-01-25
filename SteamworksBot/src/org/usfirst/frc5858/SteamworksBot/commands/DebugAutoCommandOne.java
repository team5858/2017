package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DebugAutoCommandOne extends Command {

	// we're using 8 so we can use 9 later during a sequential operation!
	public String debug_output = "DB/String 9";
	double start_time;
	double elapsed_time;
	
    public DebugAutoCommandOne() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString(debug_output, "Debug one INIT.");
    	start_time = System.currentTimeMillis();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	elapsed_time = System.currentTimeMillis() - start_time;
    	SmartDashboard.putString(debug_output, "Debug 1 : " + elapsed_time + " ms");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (elapsed_time >= 2500.0)
    		SmartDashboard.putString(debug_output, "Debug one DONE.");
        return elapsed_time >= 2500.0;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putString(debug_output, "Debug one END.");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	SmartDashboard.putString(debug_output, "Debug one INTERRUPTED.");
    }
}
