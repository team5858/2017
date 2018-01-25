package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends Command {	
	public Drive() {
        requires(Robot.drivetrain);
    }
	
	private int c = 0;
	private Joystick j = new Joystick(0);
	
	protected void execute() {
    	double x = j.getX();
    	if (Math.abs(x) < 0.05)
    		x = 0.0;
    	
    	double y = j.getY();
    	if (Math.abs(y) < 0.05)
			y = 0.0;

        double rotation = j.getTwist();
        if (Math.abs(rotation) < 0.1)
        	rotation = 0.0;
        	
        c++;
    	SmartDashboard.putString("DB/String 1", "Drive Cnt: " + c);
    	//Robot.drivetrain.GetRange();
    	//Robot.drivetrain.FieldCentricDrive(x, y, rotation, angle);
    	Robot.drivetrain.Drive(x, y, rotation);
    }
	
	protected boolean isFinished() {
		return false;
	}
}
