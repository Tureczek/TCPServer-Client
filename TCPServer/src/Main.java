import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(6780);
            // man skal angive et port nummer
            System.out.println("Klar til at modtage klient:");
            Socket socket = serverSocket.accept(); // Står og venter på klient. Det hedder at "Blokere".

            System.out.println("Klient forbindelse oprettet.");
            // Server skal kunne modtage tekst:
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(isr);
            System.out.println("modtaget fra klient: ");
            System.out.println(bufferedReader.readLine()); // Denne er printWriters modsætning, og komplimentere hinanden.

            //Send svar tilbage til klienten
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);


            // 1. skaf noget tekst
            String message = "Ahh... General Kenobi!"; // kan også komme fra bruger input
            String name = "John Doe";

            // 2. lav om til JSON
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("message", message);
            jsonObject.put("name", name);

            // 3. lav om til String
            printWriter.println(jsonObject.toJSONString()); // sender dette til klient


            socket.close(); //Lukker forbindelsen til klienten.

        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
