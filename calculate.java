import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class calculate {
	
	public static void main(String[] args){
		while(true){
			try{
				Scanner scan = new Scanner(System.in); 
				System.out.print("�ƹ�Ű�� �Է��� �ּ���");
		        scan.nextLine();  
				
				int portNumber = 7002;
				
				
				
				Socket sock = new Socket("112.165.79.178", portNumber);
				
				
				
		        String userID = "" ;
		        String usePoint = "" ;
		        
		        ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
		         
		        System.out.print("�й��� �Է��� �ּ��� : ");
		        userID = scan.nextLine();  

		        outstream.writeObject(userID);
				outstream.flush();
				
				ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
				String tpo = (String) instream.readObject();
				String cpo = (String) instream.readObject();
				
				int po;
				
				po = Integer.parseInt(tpo) - Integer.parseInt(cpo);
				
				System.out.println("���� ����Ʈ : " + String.valueOf(po));
		        
		        System.out.print("����Ͻ� ����Ʈ�� �Է��� �ּ��� : ");
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