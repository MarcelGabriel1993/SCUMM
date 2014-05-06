import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Server {

	private ServerSocket serverSocket;
	private Socket client;
	private Socket client_thread[];
	private PrintWriter out;
	private Scanner in;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	
	public void create_socket_to_client(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	}

	public void create_timeout(int zahl) throws SocketException {
		serverSocket.setSoTimeout(zahl);
	}

	public void write(Socket client,Message m) throws IOException{
		oos = new ObjectOutputStream(client.getOutputStream());
		oos.writeObject(m);
	}
	
	public Message read(Socket client) throws IOException{
		Message mes;
		ois= new ObjectInputStream(client.getInputStream());
		try {
			mes = (Message)ois.readObject();
			return mes;
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public Server() throws IOException {
		create_socket_to_client(1235);// Socket erstellen
		create_timeout(30000);// Sockettimeout festlegen
		
		System.out.println("Server gestartet");
		
		while (true) {
			
			try {
				client = serverSocket.accept();
				write(client,new Message(1,"Chtefaaan"));	
				Message mes=read(client);
				System.out.println(mes.getMessage());	
				
				
			} catch (InterruptedIOException e) {
				serverSocket.close();
				System.err.println("Timeout nach einer Minute!");
			}finally {
		        if ( client != null )
		            try { client.close(); } catch ( IOException e ) { }
		        }

		}
	}

}
