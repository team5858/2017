package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterToggle extends Command {
	private static boolean isOn=false;
	public ShooterToggle() {

	    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

	        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	        requires(Robot.ballShooter);

	        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	    }// Called repeatedly when this Command is scheduled to run
    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }
    protected void execute() {
    	SmartDashboard.putString("DB/String 8", "Init"+isOn);
    	isOn=!isOn;
    	//Robot.ballShooter.enable();
    	//Robot.ballShooter.setSetpoint(1000);
		if (isOn) {
			Robot.ballShooter.setSpeed(1.0);
		}else{
			Robot.ballShooter.setSpeed(0.0);
		}
    }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}
