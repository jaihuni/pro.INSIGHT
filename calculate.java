import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class calculate {
	
	public static void main(String[] args){
		while(true){
			try{
				Scanner scan = new Scanner(System.in); 
				System.out.print("아무키나 입력해 주세요");
		        scan.nextLine();  
				
				int portNumber = 7002;
				
				
				
				Socket sock = new Socket("112.165.79.178", portNumber);
				
				
				
		        String userID = "" ;
		        String usePoint = "" ;
		        
		        ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
		         
		        System.out.print("학번을 입력해 주세요 : ");
		        userID = scan.nextLine();  

		        outstream.writeObject(userID);
				outstream.flush();
				
				ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
				String tpo = (String) instream.readObject();
				String cpo = (String) instream.readObject();
				
				int po;
				
				po = Integer.parseInt(tpo) - Integer.parseInt(cpo);
				
				System.out.println("현재 포인트 : " + String.valueOf(po));
		        
		        System.out.print("사용하실 포인트를 입력해 주세요 : ");
		        usePoint = scan.nextLine();  
		        
		        usePoint = String.valueOf(Integer.parseInt(usePoint) + Integer.parseInt(cpo));
		        
		        outstream.writeObject(usePoint);
				outstream.flush();
				
				sock.close();
				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}