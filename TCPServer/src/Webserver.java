import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Webserver {

    static int count = 0;

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(6780);
            // man skal angive et port nummer


                System.out.println("Klar til at modtage klient:");
                Socket socket = serverSocket.accept(); // Står og venter på klient. Det hedder at "Blokere".

                System.out.println("Klient forbindelse oprettet.");
                // Server skal kunne modtage tekst:
            while (count<3) {
                //Send svar tilbage til klienten
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("Ahhh... general Kenobi!");
                printWriter.println("Sheit" + count);
                count++;

                //Kan køre på en localhost side på netet.

                //If not working
                //printWriter.println("HTTP/1.0 200 OK");
                //printWriter.println("Content-Type: text/html; charset=utf-8);
                //printWriter.println(""); <- tom linje

            }
                socket.close(); //Lukker forbindelsen til klienten.

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}

