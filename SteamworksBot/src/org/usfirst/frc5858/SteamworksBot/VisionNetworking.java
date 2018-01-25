package org.usfirst.frc5858.SteamworksBot;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionNetworking {

	private static final int ACADIA_PORT = 5800; // use 5800-5810

	// define header values
	private static final int ERROR_HEADER=1;
	//private static final int ERROR_REQUEST_HEADER=2;
	private static final int TARGET_MODE_HEADER=6;
	private static final int INITIALIZATION_HEADER=7;

	private static final int RED=1;
	private static final int BLUE=2;

	static final int LEFT = 0;
	static final int RIGHT = 1;
	
	static final int ONE_TIME = 0;
	static final int CONTINUOUS = 1;
	static final int STOP_SENDING = 2;
	
	private static final long maxSize = 1500;

	private static int last_range; 
	private static int last_confidence;
	//private static int last_targetmode;
	private static int last_horizontal_error;
	
	private Object update_mutex = new Object();
	private Object socket_mutex = new Object();
	
	InetAddress acadia_ip = InetAddress.getByName("10.58.58.255");
	DatagramSocket socket;
	DatagramPacket packet;
	byte[] data = new byte[1500];
	
	// broadcast from Acadia
	class ErrorMessage {
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
	
	class ErrorRequestMessage {
		byte header;
		byte mode; // 0 once, 1-as faster as possible, 2-stop sending
	};
	
	class TargetModeMessage {
		byte header;
		byte mode; // see const targets including HIGH_FUEL_TARGET
		byte hopper_side; // 0-left, 1-right
	}
	
	public VisionNetworking() throws IOException
	{
		socket = new DatagramSocket(ACADIA_PORT);
		Handshake();
	}

	public void Handshake() throws IOException
	{
		byte[] bytes = new byte[3];
		bytes[0] = INITIALIZATION_HEADER;
		DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
		bytes[1] = (byte)(color == DriverStation.Alliance.Red ? RED : BLUE);
		bytes[2] = (byte) 135;
	}
	
	
	private synchronized boolean Receive()
	{
		byte[] bytes = new byte[(int) maxSize];
		DatagramPacket receivePacket = new DatagramPacket(bytes, bytes.length);
		
		synchronized (socket_mutex)
		{
			try {
				socket.receive(receivePacket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (receivePacket.getLength() == 0)
			return false;
		
	    // get the entire content
	    byte data[] = receivePacket.getData();
	    
	    // and slice it up:
	    int header = data[0];
	    if (header != ERROR_HEADER)
	    {
	    	return false;
	    }
	    
	    synchronized (update_mutex)
	    {
			last_range = data[1];
			last_confidence = data[2];
			//last_targetmode = data[3];
			byte error_high = data[4];
			byte error_low = data[5];
			last_horizontal_error = (short) ( ((error_high & 0xFF)<<8) | (error_low & 0xFF) );
	    }
	    
	    return true;
	}
	
	private void Send(byte[] bytes)
	{
		synchronized (socket_mutex)
		{
			DatagramPacket packet = new DatagramPacket(bytes, bytes.length, acadia_ip, ACADIA_PORT);
			try {
				socket.send(packet);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void StartUpdating()
	{
        Thread t = new Thread(() -> {        	
            while (!Thread.interrupted()) {
            	
            	Receive();

        		try {
					Thread.sleep(10);
				} catch (InterruptedException e1) { }
            }
        });
        t.start();
	}
	
	public synchronized void DisplayUpdate()
	{
		
    	double r;
    	double c;
    	double e;
    	
    	synchronized (update_mutex) {
    		r = last_range;
    		c = last_confidence;
    		e = last_horizontal_error;
    	}

		SmartDashboard.putString("DB/String 5", "Last Range: " + r );
		SmartDashboard.putString("DB/String 6", "Last Confidence: " + c );
		SmartDashboard.putString("DB/String 7", "Last Error: " + e );
    	
	}
	
	public int getError()
	{
		synchronized(update_mutex)
		{
			return last_horizontal_error;
		}
	}
	
	public int getConfidence()
	{
		synchronized(update_mutex)
		{
			return last_confidence;
		}
	}
	
	public int getRange()
	{
		synchronized(update_mutex)
		{
			return last_range;
		}
	}

	public void setTarget(int targetMode) 
	{
		byte[] bytes = new byte[3];
		bytes[0] = TARGET_MODE_HEADER;
		//DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
		bytes[1] = (byte)targetMode;
		bytes[2] = (byte)((DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) ? RIGHT : LEFT);

		Send(bytes);
	}

	/*
	private void pauseReceiving() 
	{
		byte[] bytes = new byte[2];
		bytes[0] = ERROR_REQUEST_HEADER;
		bytes[1] = STOP_SENDING;
		
		Send(bytes);
	}

	private void resumeReceiving()
	{
		byte[] bytes = new byte[2];
		bytes[0] = ERROR_REQUEST_HEADER;
		bytes[1] = CONTINUOUS;
		
		Send(bytes);
	}
	*/
}
