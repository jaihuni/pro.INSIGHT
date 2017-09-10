import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
	public static void main(String[] args) {
		try{
			int portNumber = 7000;
			
			System.out.println("Starting Java Socket Server ...");
			ServerSocket aServerSocket = new ServerSocket(portNumber);
			System.out.println("Listening at port " + portNumber + " ...");
			
			while(true) {
				
				Socket sock = aServerSocket.accept();
				InetAddress clientHost = sock.getLocalAddress();
				int clientPort = sock.getPort();
				System.out.println("A client connected. host : " + clientHost + 
						", port : " + clientPort);
				
				ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
				Object obj = instream.readObject();
				System.out.println("ID : " + obj);
				
				String ID = obj.toString(); 
				
				int abc = Integer.parseInt(ID);
				

				obj = instream.readObject();
				System.out.println("point : " + obj);
				String point = obj.toString();
				
				
				FileWriter reader = new FileWriter("D:\\pro.insight\\total\\" + ID + ".txt");
					
				reader.write(point);
				reader.close();
				
				
				ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
				
				BufferedReader in  = new BufferedReader(new FileReader("D:\\pro.insight\\current\\"+ID+".txt"));
				
				point = in.readLine();
				

				outstream.writeObject(point);
				outstream.flush();

				
				sock.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}