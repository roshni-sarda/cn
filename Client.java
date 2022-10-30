import java.io.*;
import java.net.*;
import java.util.*;



public class Client {
    public static void main(String[] args) throws Exception{
            Socket s = new Socket("localhost",6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            DataInputStream din = new DataInputStream(s.getInputStream());
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter a number ");
            int x = Integer.parseInt(sc.next());
            dout.writeUTF(""+x);
            dout.flush();
            String y = din.readUTF();
            System.out.println(y);
            dout.close();
            s.close();
            sc.close();
    }
}