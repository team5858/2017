package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class AutoDriveForTime extends TimedCommand {
	private double x;
	private double y;
	private double rotation;
	
    public AutoDriveForTime(double timeout, double x, double y, double rotation) {
        super(timeout);
        this.x = x;
        this.y = y;
        this.rotation = rotation;
        requires(Robot.drivetrain);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.Drive(x, y, rotation);
    }

    // Called once after timeout
    protected void end() {
    	Robot.drivetrain.Stop();
    }
}
