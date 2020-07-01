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
      this.socket = new DatagramSocket(portEcoute);
    } catch(Exception e)  {System.out.println(e);}
  }

  public void envoyerMessage(String mesg, int portDest) {
    try{
      byte[] buf  = mesg.getBytes();
      DatagramPacket dp = new DatagramPacket(buf, mesg.length(), addresseIPCorrespondant, portDest);
      System.out.println("sending message to "+portDest);
      this.socket.send(dp);
    } catch(Exception e)  {System.out.println(e);}
  }

  public Object[] recevoirMessage() {
    try{
      byte[] buf = new byte[4096];
      DatagramPacket dp = new DatagramPacket(buf, 4096);
      this.socket.receive(dp);//blocks until a datagram is received
      return new Object[] {new String(dp.getData()), dp.getPort()};
    } catch(Exception e)  {return new Object[]  {new String(""+e)};}
  }

  public String getAdresseIPCorrespondant() {
    return this.addresseIPCorrespondant.toString();
  }

}
