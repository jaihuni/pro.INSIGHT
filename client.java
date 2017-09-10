import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class client {
	
	public static void main(String[] args){
		while(true){
			try{
				int portNumber = 7001;
				
				Socket sock = new Socket("112.165.79.178", portNumber);
				
				ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
				
					
				FileWriter reader = new FileWriter("D:\\pro.insight\\rank.html");
				
				reader.write("<html><head><title>사랑을 담아서~♥ D.Va!</title><style>#aaa{background-image:url(665.jpg);background-repeat : no-repeat;background-position: 50% 50%;background-size: 40% 40%;}</style><style type=\"text/css\">table{width: 85%;height: 85%;margin: auto;text- align: center;}</style><style type=\"text/css\">h5{text-align:center;}</style></head><body id=\"aaa\"><meta http-equiv=\"refresh\" content=\"300\"><h5><font size = 7><font color=#355C00>☆실시간 랭킹☆</font><h5><table border=\"5\"<tr><th><font color=#9905c9><font size = 6>등수</font></th><th><font color=#9905c9><font size = 6>학번</font></th><th><font color=#9905c9><font size = 6>총점</font></th></tr><tr><th><font size = 5>1</th><th><font size = 5>");
	
				String a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr><tr><th><font size = 5>2</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th><th><font size = 5>");
				
				a = (String) instream.readObject();
				
				reader.write(a);
				
				reader.write("</th></tr></table></font></body></html>");
				
				reader.close();
	
				sock.close();
				
				Thread.sleep(300000);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}