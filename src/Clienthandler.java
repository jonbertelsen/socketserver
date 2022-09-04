import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientHandler extends Thread
{
    DateFormat dateTemplate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat timeTemplate = new SimpleDateFormat("hh:mm:ss");
    final DataInputStream dataInputStream;
    final DataOutputStream dataOutputStream;
    final Socket socket;
    final Quote quotes = new Quote();

    public ClientHandler(Socket socket, DataInputStream dataInputStream, DataOutputStream dataOutputStream)
    {
        this.socket = socket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;
    }

    @Override
    public void run()
    {
        String receivedString;
        String stringToReturn;

        while (true)
        {
            try
            {
                dataOutputStream.writeUTF("Choose: [Date | Time | Quote ]..\n" + "Or Exit");

                // getting answers from client
                receivedString = dataInputStream.readUTF();

                if (receivedString.equals("Exit"))
                {
                    System.out.println("Client " + this.socket + " sends exit...");
                    System.out.println("Connection closing...");
                    this.socket.close();
                    System.out.println("Closed");
                    break;
                }

                // creating Date object
                Date myNewDate = new Date();
                stringToReturn = "Invalid input";

                switch (receivedString)
                {
                    case "Date":
                        stringToReturn = dateTemplate.format(myNewDate);
                        break;
                    case "Time":
                        stringToReturn = timeTemplate.format(myNewDate);
                        break;
                    case "Quote":
                        stringToReturn = quotes.getQuote();
                        break;
                    default:
                        break;
                }

                dataOutputStream.writeUTF(stringToReturn);

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            // closing resources
            this.dataInputStream.close();
            this.dataOutputStream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}