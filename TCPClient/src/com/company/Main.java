package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        // Vi skal oprette forbindelse til serveren.
        // Vi  skal kende dens IP adresse, samt port nummer.

        try {


            Socket socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 6780);
            System.out.println("Har oprettet forbindelse til server.");
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("Hello there!"); // Dette sendes til den anden maskine.

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(isr);


            // 1. modtag String fra netværk
            String modtagetString = bufferedReader.readLine();

            //2. lav om til JSON
            JSONParser parser = new JSONParser();
            Object object = parser.parse(modtagetString);
            JSONObject jsonObject = (JSONObject)object;

            //3. Lav om til tekst udfra nøgle
            String besked = (String) jsonObject.get("message");
            String navn = (String) jsonObject.get("name");
            System.out.println("Modtaget med nøgle 'message': " + besked);
            System.out.println("Modtaget med nøgle 'name': " + navn);




        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }


    }
}
