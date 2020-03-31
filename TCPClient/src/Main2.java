import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        // Vi skal oprette forbindelse til serveren.
        // Vi  skal kende dens IP adresse, samt port nummer.

        Scanner scanner = new Scanner(System.in);


        try {



            Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 6780);
            System.out.println("Har oprettet forbindelse til server.");
            InputStreamReader isr = new InputStreamReader(socket.getInputStream());

            do {
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                String input = scanner.nextLine();
                printWriter.println(input); // Dette sendes til den anden maskine.

                //modtager svar fra server

                BufferedReader bufferedReader = new BufferedReader(isr);
                System.out.println("Server svare:");
                System.out.println(bufferedReader.readLine());
            }while(!socket.getOutputStream().equals("shit"));


        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
