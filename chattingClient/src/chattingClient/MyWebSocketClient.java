package chattingClient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;


public class MyWebSocketClient extends WebSocketClient{

	public MyWebSocketClient(URI serverUri) {
		super(serverUri);
	}

	public static void main(String[] args) {
		URI uri;
		try {
			uri = new URI("ws://localhost:1234");
			MyWebSocketClient clinet = new MyWebSocketClient(uri);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Exception ex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String message) {
		System.out.println("Received message: " + message);
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		System.out.println("Connected to server");
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();
		send(message);
	}
	

}
