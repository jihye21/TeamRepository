package chattingServer;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class KafkaWebSocketServer extends WebSocketServer{
	List<WebSocket> connections = new ArrayList<WebSocket>();
	public KafkaWebSocketServer(InetSocketAddress address) {
		super(address);
	}
	public static void main(String [] args) {// 172.16.110.46
		InetSocketAddress address = new InetSocketAddress("220.67.114.16", 1234);
		KafkaWebSocketServer server = new KafkaWebSocketServer(address);
		server.start();
		
	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		// TODO Auto-generated method stub
		System.out.println("closed connection: " + conn.getRemoteSocketAddress());
		connections.remove(conn);
	}

	@Override
	public void onError(WebSocket conn, Exception ex) {
		// TODO Auto-generated method stub
		ex.printStackTrace();
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		// TODO Auto-generated method stub
		System.out.println("Message from client: " + message);
		broadcastMessage(conn, message);
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		System.out.println("New Connecton: " + conn.getRemoteSocketAddress());
		conn.send("welcom");
		connections.add(conn);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		System.out.println("WebSocket Server started");
	}
	
	public void broadcastMessage(WebSocket conn, String message) {
		for(WebSocket connection: connections) {
			if(connection != conn) {
				connection.send(conn.getRemoteSocketAddress()+ ": " + message);
			}
			
		}
	}
	
	public void startKafkaConsumer(WebSocket conn, String message) {
		
	}
}
