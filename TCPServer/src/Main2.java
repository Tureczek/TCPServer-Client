import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        try {


            ServerSocket serverSocket = new ServerSocket(6780);
            // man skal angive et port nummer
            System.out.println("Klar til at modtage klient:");
            Socket socket = serverSocket.accept(); // Står og venter på klient. Det hedder at "Blokere".
            System.out.println("Klient forbindelse oprettet.");


            // Server skal kunne modtage tekst:
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(isr);



boolean abort = true;

            do {

                //Send svar tilbage til klienten
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

                System.out.println("Klienten skriver:");
                System.out.println(bufferedReader.readLine()); // Denne er printWriters modsætning, og komplimentere hinanden.

                String input = scanner.nextLine();
                printWriter.println(input);

                if (socket.getOutputStream().equals("bye!")){
                    abort = false;
                }

            } while (abort);

            socket.close(); //Lukker forbindelsen til klienten.

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
