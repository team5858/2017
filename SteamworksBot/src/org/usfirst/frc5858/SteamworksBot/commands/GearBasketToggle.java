package org.usfirst.frc5858.SteamworksBot.commands;

import org.usfirst.frc5858.SteamworksBot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearBasketToggle extends Command {
	private static boolean isOn=false;
	public GearBasketToggle() {

	    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

	        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
	        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	        requires(Robot.gearBasket);

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
			Robot.gearBasket.open();
			Robot.oreo.openGearBasket();
		}else{
			Robot.gearBasket.close();
			Robot.oreo.closeGearBasket();
		}
    }
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

}