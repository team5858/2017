// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5858.SteamworksBot.subsystems;

import org.usfirst.frc5858.SteamworksBot.RobotMap;
//import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class Climber extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    //private final CANTalon climberMotor1 = RobotMap.climberClimberMotor1;
    //private final CANTalon climberMotor2 = RobotMap.climberClimberMotor2;
    
    private final DigitalInput climbLimiter = RobotMap.climberclimbLimiter;
    
    private final static double POWER = 0.5;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
    	
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void climb() {
    	
    	//set direction and start motor descend
    	//climberMotor1.set(POWER);
    	//climberMotor2.set(POWER);
    	
    }
    
    public void stop() {
    	
    	//set direction and start motor descend
    	//climberMotor1.set(0);
    	//climberMotor2.set(0);
    	
    }
    
    // we need to be able to retract and climb c
    public void descend() {
    	
    	//set direction and start motor descend
    	//climberMotor1.set(-POWER);
    	//climberMotor2.set(-POWER);
    	
    }
}

