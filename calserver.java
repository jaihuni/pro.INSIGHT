import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class calserver {
	
	public static void main(String[] args) {
		try{
			int portNumber = 7002;
			
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
				
				ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
				
				BufferedReader in = new BufferedReader(new FileReader("D:\\pro.insight\\total\\"+ID+".txt"));
				
				String point = in.readLine();
				
				outstream.writeObject(point);
				outstream.flush();
				
				in = new BufferedReader(new FileReader("D:\\pro.insight\\current\\"+ID+".txt"));
				
				point = in.readLine();
				
				outstream.writeObject(point);
				outstream.flush();
				
				in.close();

				FileWriter reader = new FileWriter("D:\\pro.insight\\current\\" + ID + ".txt");
				
				obj = instream.readObject();
				System.out.println("point : " + obj);
				
				point = obj.toString(); 
				reader.write(point);
				reader.close();
				
				sock.close();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}