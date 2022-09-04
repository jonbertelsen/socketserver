import java.io.*;
import java.net.*;
public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket = new ServerSocket(5056);
        // getting client request
        while (true)
        {
            Socket newSocket = null;
            try
            {
                // newSocket object to receive incoming client requests (gets a unique port number)
                newSocket = serverSocket.accept();

                System.out.println("A new connection identified : " + newSocket);

                DataInputStream dataInputStream = new DataInputStream(newSocket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(newSocket.getOutputStream());

                System.out.println("Thread assigned");

                Thread thread = new ClientHandler(newSocket, dataInputStream, dataOutputStream);
                thread.start();

            }
            catch (Exception e){
                newSocket.close();
                e.printStackTrace();
            }
        }
    }
}
