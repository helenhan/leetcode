package com.helen.other;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SMTPClient {

	public SMTPClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String hostName = "localhost";
		int portNumber = 9000;
		Socket clientSocket = null;
		DataInputStream is = null;
		DataOutputStream os = null;
		try {
			clientSocket = new Socket(hostName, portNumber);
			is = new DataInputStream(clientSocket.getInputStream());
			os = new DataOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (clientSocket != null && is != null && os != null) {
			try {
				os.writeBytes("");
				String responseLine;
				while((responseLine=is.readUTF())!=null){
					if(responseLine.indexOf("quit")!=-1){
						break;
					}
				}
				os.close();
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
