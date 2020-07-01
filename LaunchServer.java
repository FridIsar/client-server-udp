import java.io.*;
import java.net.*;

public class LaunchServer {
  public static void main(String[] args) {

  ClientServeurUDP serveur = new ClientServeurUDP("localhost",50000);

  boolean running = true;
  System.out.println("Starting server...");
  while(running) {
    int number;
    System.out.println("Waiting for answer...");
    Object[] answer = serveur.recevoirMessage();
    try{
      number = Integer.parseInt(((String) answer[0]).trim());
    } catch(Exception e)  {number = 0;}
  Integer result = number * number;
  System.out.println("Answer is "+result);
  serveur.envoyerMessage(result.toString(), (int) answer[1]);
  }
  }

}
