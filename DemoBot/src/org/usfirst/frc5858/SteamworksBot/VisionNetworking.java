package org.usfirst.frc5858.SteamworksBot;

import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import org.apache.commons.lang.SerializationUtils;

public class VisionNetworking {
	
	static final int DeadBand = 10;
	static final int DeadBandO2 = DeadBand/2;

	//#ifdef USE_PWM
	static final int EL_SERVO_MAX=600;
	static final int EL_SERVO_MIN=300;
	static final int AZ_SERVO_MAX=600;
	static final int AZ_SERVO_MIN=300;
	//#endif

	/*
	static final int ELEV_PIN = GPIO3;
	static final int AZ_PIN = GPIO5;
	static final int RING_LIGHT_PIN = GPIO7;
	static final int GO_LEFT_PIN = GPIO6;
	static final int GO_RIGHT_PIN = GPIO9;
	static final int CENTERED_PIN = GPIO10;
	*/

	static final int LEFT_DEADBAND_STATE=1;
	static final int RIGHT_DEADBAND_STATE=2;
	static final int CENTERED_DEADBAND_STATE=3;

	//#ifdef USE_PWM
	static final int ELEV_SERVO_ZERO_DEG = 180;   // 0  degrees
	static final int ELEV_SERVO_NINETY_DEG = 375; // 90 degrees
	static final int AZ_SERVO_ZERO_DEG = 180;   // 0  degrees
	static final int AZ_SERVO_NINETY_DEG = 375; // 180 degrees
	//#endif

	static final int ACADIA_PORT = 5800; // use 5800-5810
	static final String ACADIA_IP = "10.58.58.255";

	// define header values
	static final int ERROR_HEADER=1;
	static final int ERROR_REQUEST_HEADER=2;
	static final int IMAGE_HEADER=3;
	static final int IMAGE_REQUEST_HEADER=4;
	static final int GIMBAL_REQUEST_HEADER=5;
	static final int TARGET_MODE_HEADER=6;
	static final int INITIALIZATION_HEADER=7;

	static final int HSV_TYPE=0;
	static final int RAW_TYPE=1;
	static final int BINARY_TYPE=2;

	static final int CROPPED=1;
	static final int NON_CROPPED=0;

	static final int HIGH_FUEL_TARGET=1;
	static final int LOW_FUEL_TARGET=2;
	static final int FUEL_ON_GROUND_TARGET=3;
	static final int HOPPER_TARGET=4;
	static final int ROPE_TARGET=5;
	static final int GEAR_PIN_TARGET=6;
	static final int FEEDER_TARGET=7;
	static final int TOTAL_TARGETS=FEEDER_TARGET;

	static final double logTimeInterval=1.0; // sec

//	#ifdef USE_PWM
	static final int ELEVATION_GIMBAL_COMMAND = 1;
	static final int AZIMUTH_GIMBAL_COMMAND = 2;
//	#endif

	static final int screen_width=640; // pixels
	static final int screen_widthO2=screen_width/2; // pixels
	static final int screen_height=480; // pixels
	static final int screen_heightO2=screen_width/2; // pixels

	static final int RED=1;
	static final int BLUE=2;
	static final String colors[] = {"", "Red", "Blue" };

	// Target Mode message from Laptop
	class TargetModeMessage implements Serializable {
		byte header;
		byte mode; // see static final targets including HIGH_FUEL_TARGET
		byte hopper_side; // 0-left, 1-right
		
		TargetModeMessage()
		{
			header = TARGET_MODE_HEADER;
		}
	};

	// broadcast from Acadia
	class ErrorMessage implements Serializable {
		byte header;
		byte range; // truncated inches
		byte confidence; // seconds past 1970
		byte target_mode; // ???? new
		short horizontal_error; // pixels
		
		ErrorMessage()
		{
			header = ERROR_HEADER;
		}
	};

	// broadcast from the Driver Station Laptop
	class InitializationMessage implements Serializable {
		byte header;
		byte alliance_color;
		byte match_time; // int seconds
		
		InitializationMessage()
		{
			header = INITIALIZATION_HEADER; 
		}
	};

	// broadcast from Driver Station Laptop
	class ErrorRequestMessage implements Serializable {
		byte header;
		byte mode; // 0 once, 1-as faster as possible, 2-stop sending
		
		ErrorRequestMessage()
		{
			header = ERROR_REQUEST_HEADER;
		}
	};

	// broadcast from Acadia
	class ImageMessage implements Serializable  {
		byte header;
		byte framesPerSecond; // whole number 0-30
		byte alliance_color;
		short cg_x; // pixels from the center of the screen of where I am assuming center of track
		short cg_y;
		short length; // pixels
		byte buffer[] = new byte[1400];
		//unsigned int *ptr; // faster than the memcpy
		
		public ImageMessage()
		{
			header = IMAGE_HEADER;
		}
	};

	// broadcast from Laptop
	class ImageRequestMessage implements Serializable {
		byte header;
		byte mode; // 0-binary, 1-HSV, 2-RGB, 3-Grey Image
		byte cropped; // 0-no cropped image
		byte freq; // seconds between messages
		
		public ImageRequestMessage()
		{
			header = IMAGE_REQUEST_HEADER;
		}
	};

	/* for Robot Code
	// broadcast from RoboRIO
	class FuelResevoirMessage {
		byte header;
		byte level;
	};
	*/

	// broadcast from Laptop
	class GimbalRequestMessage implements Serializable {
		byte header;
		byte mode; // 1-elevation, 2-azimuth
		short angle; // angle in truncated degrees
		
		public GimbalRequestMessage()
		{
			header = GIMBAL_REQUEST_HEADER;
		}
	};
	
	
	InetAddress acadia_ip;
	DatagramSocket socket;
	DatagramPacket packet;
	byte[] data = new byte[1500];
	
	public void handshake() throws IOException
	{
		InitializationMessage message = new InitializationMessage();
		message.alliance_color = RED;
		message.match_time = (byte) 135;
		
		//byte[] bytes = SerializationUtils.serialize(message);
		//packet = new DatagramPacket(bytes, bytes.length, acadia_ip, ACADIA_PORT);
		//socket.send(packet);
	}
	
	public VisionNetworking() throws IOException
	{
		socket = new DatagramSocket(ACADIA_PORT);
		handshake();
	}
	
	
}
