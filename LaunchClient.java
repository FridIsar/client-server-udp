import java.io.*;
import java.net.*;

public class LaunchClient {
  public static void main(String[] args) {
  ClientServeurUDP client = new ClientServeurUDP("localhost", 50001);

  client.envoyerMessage("test");
  //System.out.println(client.recevoirMessage());
  }

}
