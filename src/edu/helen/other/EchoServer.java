package edu.helen.other;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public EchoServer() {
	}

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		DataInputStream is = null;
		PrintStream os = null;
		String line = null;
		try {
			serverSocket = new ServerSocket(9000);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			clientSocket = serverSocket.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			while(true){
				line = is.readUTF();
				os.print(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
