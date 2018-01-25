package org.usfirst.frc5858.SteamworksBot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Communication with the NeoPixel LED board (Oreo Board)
 */
public class LEDDriver extends Subsystem {
	
	/**
	 * These are all the things the LED board can do
	 */
	public enum Commands {
		OFF,              // All LEDs OFF
		Test,             // Test sequence for all LEDs
		//
		ModeAutonomousRed,  // Entering autonomous mode on RED team
		ModeAutonomousBlue, // Entering autonomous mode on BLUE team
		ModeTeleop,         // Entering teleop mode
		//
		GearBasketOpen,   // Open the gear basket
		GearBasketClose,  // Close the gear basket
		//
		StopClimb,        // Climber stop
		ClimbUp,          // Climb up
		ClimbDown,        // Climb down
		//
		BallShooterOn,
		BallShooterOff,
		FloorConOn,
		FloorConOff,
		StartAuto,
		StartTeleop,
		SpinLeft,
		SpinRight,
		FowardSlow,
		ForwardMedium,
		ForwardFast,
		BackwardSlow,
		BackwardMedium,
		BackwardFast,
	}
	
	// Connecting to the non-RS232-voltage port on
	// the MXP port.
	// MXP-UART-RX   pin 10
	// MXP_UART_DGND pin 12
	// MXP-UART-TX   pin 14
	private SerialPort port = new SerialPort(115_200,SerialPort.Port.kMXP);
	
	@Override
	protected void initDefaultCommand() {
		// Nothing to do
	}
	
	/**
	 * Send the desired LED command to the Oreo Board
	 * @param command what the LEDs do
	 */
	public void sendCommand(Commands command) {
		// The OREO board uses carriage returns to separate commands
		port.writeString("["+command.toString()+"]\r");
	}
			

	/**
	 * Shortcut for the "Test" command
	 */
	public void test() {
		sendCommand(Commands.Test);
	}
	
	
	public void openGearBasket() {
		sendCommand(Commands.GearBasketOpen);
	}
	public void closeGearBasket() {
		sendCommand(Commands.GearBasketClose);
	}
	
	public void modeAutonomousRed() {
		sendCommand(Commands.ModeAutonomousRed);
	}
	public void modeAutonomousBlue() {
		sendCommand(Commands.ModeAutonomousBlue);
	}
	public void modeTeleop() {
		sendCommand(Commands.ModeTeleop);
	}
	
	public void stopClimb() {
		sendCommand(Commands.StopClimb);
	}
	public void climbUp() {
		sendCommand(Commands.ClimbUp);
	}
	public void climbDown() {
		sendCommand(Commands.ClimbDown);
	}	
	public void ballShooterOn() {
		sendCommand(Commands.BallShooterOn);
	}
	public void ballShooterOff() {
		sendCommand(Commands.BallShooterOff);
	}
	public void FloorConOn() {
		sendCommand(Commands.FloorConOn);
	}
	public void FloorConOff() {
		sendCommand(Commands.FloorConOff);
	}
	public void StartAuto() {
		sendCommand(Commands.StartAuto);
	}
	public void StartTeleop() {
		sendCommand(Commands.StartTeleop);
	}
	public void SpinLeft() {
		sendCommand(Commands.SpinLeft);
	}
	public void SpinRight() {
		sendCommand(Commands.SpinRight);
	}
	public void FowardSlow() {
		sendCommand(Commands.FowardSlow);
	}
	public void ForwardMedium() {
		sendCommand(Commands.ForwardMedium);
	}
	public void ForwardFast() {
		sendCommand(Commands.ForwardFast);
	}
	public void BackwardSlow() {
		sendCommand(Commands.BackwardSlow);
	}
	public void BackwardMedium() {
		sendCommand(Commands.BackwardMedium);
	}
	public void BackwardFast() {
		sendCommand(Commands.BackwardFast);
	}
	
	/**
	 * Shortcut for the "OFF" command
	 */
	public void allOff() {
		sendCommand(Commands.OFF);
	}

}
