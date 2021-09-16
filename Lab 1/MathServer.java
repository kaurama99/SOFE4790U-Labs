/**
 * @author Qusay H. Mahmoud
 */

import java.io.*;
import java.net.*;

public class MathServer {

   ServerSocket hi;
   Socket client;
   DataInputStream br;
   DataOutputStream dos;
 
   public static long binomialCoeff(int k, int n) {
    if (k>n-k)
    k=n-k;

    long result = 1;
    for (int i=1, m=n; i<=k; i++, m--)
    result = result*m/i;
    return result;
   }

   public static void main(String argv[]) throws Exception {
     new MathServer();
   }

   public MathServer() throws Exception {
     hi = new ServerSocket(3500, 5); //added backlog limit to refuse anymore connections
     System.out.println("Server Listening on port 3500....");
     client = hi.accept();
     br = new DataInputStream(client.getInputStream());
     dos = new DataOutputStream(client.getOutputStream());
  
     int x = br.readInt();
     System.out.println("I got: "+x);
     int y = br.readInt();
     System.out.println("I got: "+y);
     long ans = binomialCoeff(x,y);
     System.out.println("I am sending the answer...");
     dos.writeBytes("the binomialCoeff is: "+ans+"\n");     
   }
}
