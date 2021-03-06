// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc5858.SteamworksBot;

//import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.VictorSP;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	// slightly loved on by Chris
	
	// CAN ID's:
    public static int frontLeft_CAN_id = 1;
    public static int frontRight_CAN_id = 2;
    public static int backLeft_CAN_id = 3;
    public static int backRight_CAN_id = 4;
    public static int ballShooter_CAN_id = 5;
    public static int climberMotor1_CAN_id = 6;
    public static int climberMotor2_CAN_id = 7;
    
    // PWM ID's:
    public static int gearBox_left_servo_id = 1;
    public static int gearBox_right_servo_id = 2;
    public static int visionCamera_servoX_id = 3;
    public static int visionCamera_servoY_id = 4;
    public static int hopper_conveyer_motor_id = 5;
    public static int floor_conveyer_motor_id = 6;
    
    // Digital IDs:
    public static int climberLimitSwitch_DIO_id = 1;
    public static int ultrasonic_left_trigger_id = 2;
    public static int ultrasonic_rightt_trigger_id = 3;
    public static int ultrasonic_left_response_id = 4;
    public static int ultrasonic_right_response_id = 5;
    public static int driveTrainEncoder_A_id = 6;
    public static int driveTrainEncoder_B_id = 7;
    public static int ballShooterEncoder_A_id = 8;
    public static int ballShooterEncoder_B_id = 9;
    
	// Drive train:
//    public static CANTalon drivetrainfrontLeft;
//    public static CANTalon drivetrainfrontRIght;
//    public static CANTalon drivetrainbackLeft;
//    public static CANTalon drivetrainbackRight;
    
    //public static RobotDrive drivetrainRobotDrive;
    // the robotdrive class lets us just..  drive the robot
    // without having to set each motor individually
    
    
    // loanermech tech 
    public static Talon loanerfrontLeft;
    public static Talon loanerfrontRight;
    public static Talon LoanerbackLeft;
    public static Talon loanerbackRight;
    
    public static RobotDrive loanerRobotDrive;
    
    
    
    // we will come back and add the ultrasonics here later
    Ultrasonic ultrasonic_Left;
    Ultrasonic ultrasonic_Right;
    
    
    public static ADXRS450_Gyro drivetrainrobotGyro;
    public static Encoder drivetraindriveEncoder;
    // ^ this encoder may go away since it may get plugged direct into
    //   TalonSRX (it can handle encoders itself and you just tell it
    //   what rate to go to...)
    
    
    // Gear box:
    public static Servo gearBasketleftServo;
    public static Servo gearBasketrightServo;
       
    
    // Camera:
    public static Servo visionCameracameraServoX;
    public static Servo visionCameracameraServoY;

    
    // Shooter:
    //public static CANTalon ballShooterwheelMotor;
    public static Encoder ballShooterwheelMonitor;
    
    // Hopper and floor conveyer:
    public static VictorSP hopperConveyorconveyerMotor;
    public static VictorSP floorConveyorfloorConveyerMotor;
    
    // Climber:
    //public static CANTalon climberClimberMotor1;
    //public static CANTalon climberClimberMotor2;
    public static DigitalInput climberclimbLimiter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
//        drivetrainfrontLeft = new CANTalon(frontLeft_CAN_id);
//        LiveWindow.addActuator("Drivetrain", "frontLeft", (CANTalon) drivetrainfrontLeft);
//        
//        drivetrainfrontRIght = new CANTalon(frontRight_CAN_id);
//        LiveWindow.addActuator("Drivetrain", "frontRIght", (CANTalon) drivetrainfrontRIght);
//        
//        drivetrainbackLeft = new CANTalon(backLeft_CAN_id);
//        LiveWindow.addActuator("Drivetrain", "backLeft", (CANTalon) drivetrainbackLeft);
//        
//        drivetrainbackRight = new CANTalon(backRight_CAN_id);
//        LiveWindow.addActuator("Drivetrain", "backRight", (CANTalon) drivetrainbackRight);
//        
//        drivetrainRobotDrive = new RobotDrive(drivetrainfrontLeft, drivetrainbackLeft,
//              drivetrainfrontRIght, drivetrainbackRight);
//        
//        drivetrainRobotDrive.setSafetyEnabled(true);
//        drivetrainRobotDrive.setExpiration(0.1);
//        drivetrainRobotDrive.setSensitivity(0.5);
//        drivetrainRobotDrive.setMaxOutput(1.0);
        
        
        // loanerdrivetrain section
        
        loanerfrontLeft = new Talon(8);
        loanerfrontLeft.setInverted(true);
        
        loanerfrontRight = new Talon(6);
        
        LoanerbackLeft = new Talon(7);
        LoanerbackLeft.setInverted(true);
        
        loanerbackRight = new Talon(5);
        
        
        loanerRobotDrive = new RobotDrive(loanerfrontLeft, LoanerbackLeft,
        		loanerfrontRight, loanerbackRight);
        
        loanerRobotDrive.setSafetyEnabled(true);
        loanerRobotDrive.setExpiration(0.1);
        loanerRobotDrive.setSensitivity(0.5);
        //loanerRobotDrive.setMaxOutput(0.3);
        
       // end of the loanerdrivetrain section 
        
        

        drivetrainrobotGyro = new ADXRS450_Gyro();
        LiveWindow.addSensor("Drivetrain", "robotGyro", drivetrainrobotGyro);
        //drivetrainrobotGyro.setSensitivity(0.007);
        
        drivetraindriveEncoder = new Encoder(driveTrainEncoder_A_id, driveTrainEncoder_B_id, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "driveEncoder", drivetraindriveEncoder);
        drivetraindriveEncoder.setDistancePerPulse(1.0);
        
        drivetraindriveEncoder.setPIDSourceType(PIDSourceType.kRate);
        gearBasketleftServo = new Servo(gearBox_left_servo_id);
        LiveWindow.addActuator("GearBasket", "leftServo", gearBasketleftServo);
        
        gearBasketrightServo = new Servo(gearBox_right_servo_id);
        LiveWindow.addActuator("GearBasket", "rightServo", gearBasketrightServo);
        
        visionCameracameraServoX = new Servo(visionCamera_servoX_id);
        LiveWindow.addActuator("VisionCamera", "cameraServoX", visionCameracameraServoX);
        
        visionCameracameraServoY = new Servo(visionCamera_servoY_id);
        LiveWindow.addActuator("VisionCamera", "cameraServoY", visionCameracameraServoY);
        
        //ballShooterwheelMotor = new CANTalon(ballShooter_CAN_id);
        //LiveWindow.addActuator("BallShooter", "wheelMotor", (CANTalon) ballShooterwheelMotor);
        
        ballShooterwheelMonitor = new Encoder(ballShooterEncoder_A_id, ballShooterEncoder_B_id, false, EncodingType.k4X);
        LiveWindow.addSensor("BallShooter", "wheelMonitor", ballShooterwheelMonitor);
        ballShooterwheelMonitor.setDistancePerPulse(1.0);
        ballShooterwheelMonitor.setPIDSourceType(PIDSourceType.kRate);
        //hopperConveyorconveyerMotor = new VictorSP(hopper_conveyer_motor_id);
        
       // LiveWindow.addActuator("HopperConveyor", "conveyorMotor", (VictorSP) hopperConveyorconveyerMotor);
        
      //  floorConveyorfloorConveyerMotor = new VictorSP(floor_conveyer_motor_id);
      //  LiveWindow.addActuator("FloorConveyor", "floorConveyorMotor", (VictorSP) floorConveyorfloorConveyerMotor);
        
        //climberClimberMotor1 = new CANTalon(climberMotor1_CAN_id);
        //LiveWindow.addActuator("Climber", "climberMotor1", (CANTalon) climberClimberMotor1);

        //climberClimberMotor2 = new CANTalon(climberMotor2_CAN_id);
        //LiveWindow.addActuator("Climber", "climberMotor2", (CANTalon) climberClimberMotor2);
        
        //climberclimbLimiter = new DigitalInput(climberLimitSwitch_DIO_id);
        //LiveWindow.addSensor("Climber", "climbLimiter", climberclimbLimiter);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
