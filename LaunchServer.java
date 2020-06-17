import java.io.*;
import java.net.*;

public class LaunchServer {
  public static void main(String[] args) {

  ClientServeurUDP serveur = new ClientServeurUDP(50001);

  System.out.println(serveur.recevoirMessage());

  }

}
