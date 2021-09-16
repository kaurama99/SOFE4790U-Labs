/**
 * @author Qusay H. Mahmoud
 */

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class MathClient {
   public static void main(String argv[]) throws Exception {
     Socket echo;
     DataInputStream br;
     DataOutputStream dos;

     echo = new Socket("localhost", 3500);
     br = new DataInputStream(echo.getInputStream());
     dos = new DataOutputStream(echo.getOutputStream());
     Scanner keyboard = new Scanner(System.in);
     System.out.println("enter a value for k");
     int x = keyboard.nextInt();
     System.out.println("enter a value for n");
     int y = keyboard.nextInt();
     dos.writeInt(x);
     dos.flush();
     dos.writeInt(y);
     dos.flush();
     String str = br.readLine();
     System.out.println("I got: "+str);
   }
}
