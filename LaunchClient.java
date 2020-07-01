import java.io.*;
import java.net.*;

public class LaunchClient {
  public static void main(String[] args) {
  ClientServeurUDP client = new ClientServeurUDP("localhost",50001);

  client.envoyerMessage("6",50000);

  int number;
  System.out.println("Waiting for answer...");
  try{
    number = Integer.parseInt(((String) client.recevoirMessage()[0]).trim());
  } catch(Exception e)  {number = 0;}
  System.out.println("Answer is "+number);
  }

}
