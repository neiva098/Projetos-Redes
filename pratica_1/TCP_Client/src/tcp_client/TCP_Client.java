/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcp_client;

import java.io.*;
import java.net.*;

/**
 *
 * @author Cristiano
 */
public class TCP_Client {

    public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream())
        );

        System.out.println("Digite o texto a ser enviado para oservidor:");
        sentence = inFromUser.readLine();

        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();

        System.out.println("FROM SERVER: " + modifiedSentence);

        clientSocket.close();
    }

}
