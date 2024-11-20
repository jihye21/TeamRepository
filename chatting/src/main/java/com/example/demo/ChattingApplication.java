package com.example.demo;

import java.net.InetSocketAddress;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class ChattingApplication extends WebSocketServer{
	
	public ChattingApplication() {}
	public ChattingApplication(InetSocketAddress address) {
		//super soob
		super(address);
	}
	public static void main(String[] args) {
		InetSocketAddress address = new InetSocketAddress("localhost", 8080);
		ChattingApplication server = new ChattingApplication(address);
		server.start();
		
	}
	
	@Override
	public void onStart(){
		System.out.println("WebSocket Server started");
	}
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println("new connection: " + conn.getRemoteSocketAddress());
		conn.send("welcome");
	}
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println("closed connection: " + conn.getRemoteSocketAddress());
		conn.send("welcome");
	}
	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("Message from client: " + message);
		conn.send("welcome");
	}
	@Override
	public void onError(WebSocket conn, Exception ex) {
		ex.printStackTrace();
	}

}
