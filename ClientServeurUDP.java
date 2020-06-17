import java.io.*;
import java.net.*;

public class ClientServeurUDP {
  private DatagramSocket socket;
  private InetAddress addresseIPCorrespondant;
  private int port; //devient portDest pour serveur

  public ClientServeurUDP(String adresseDest,int portDest) {
    try{
      this.port = portDest;
      this.addresseIPCorrespondant = InetAddress.getByName(adresseDest);
      this.socket = new DatagramSocket(port, addresseIPCorrespondant);
    } catch(Exception e)  {System.out.println(e);}
  }

  public ClientServeurUDP(int portEcoute) {
    try{
      this.port = portEcoute;
      this.socket = new DatagramSocket(50000);
    } catch(Exception e)  {System.out.println(e);}
  }

  public void envoyerMessage(String mesg) {
    try{
      byte[] buf  = mesg.getBytes();
      DatagramPacket dp = new DatagramPacket(buf, mesg.length(), addresseIPCorrespondant, 50000);
      this.socket.send(dp);
    } catch(Exception e)  {System.out.println(e);}
  }

  public String recevoirMessage() {
    try{
      byte[] buf = new byte[4096];
      System.out.println("1");
      DatagramPacket dp = new DatagramPacket(buf, 4096);
      System.out.println("2");
      this.socket.receive(dp);//blocks until a datagram is received
      System.out.println("3");
      return new String(dp.getData());
    } catch(Exception e)  {return ""+e;}
  }

  public String getAdresseIPCorrespondant() {
    return this.addresseIPCorrespondant.toString();
  }

}
