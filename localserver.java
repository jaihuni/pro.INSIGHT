import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class localserver {
	
	public static void main(String[] args) {
		try{
			int portNumber = 7001;
			
			System.out.println("Starting Java Socket Server ...");
			ServerSocket aServerSocket = new ServerSocket(portNumber);
			System.out.println("Listening at port " + portNumber + " ...");
			
			while(true) {
				
				Socket sock = aServerSocket.accept();
				InetAddress clientHost = sock.getLocalAddress();
				int clientPort = sock.getPort();
				System.out.println("A client connected. host : " + clientHost + 
						", port : " + clientPort);
				
				ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
				
				BufferedReader in  = new BufferedReader(new FileReader("D:\\pro.insight\\total\\rank.txt"));
				for(int i = 0; i < 20; i++) {
					String point = in.readLine();
					
	
					outstream.writeObject(point);
					outstream.flush();

				}

				
				sock.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}