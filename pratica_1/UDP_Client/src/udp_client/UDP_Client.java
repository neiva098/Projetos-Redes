/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udp_client;

import java.io.*;
import java.net.*;

/**
 *
 * @author Cristiano
 */
public class UDP_Client {

    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(
                new InputStreamReader(System.in)
        );
        DatagramSocket clientSocket = new DatagramSocket();

        InetAddress.getByName("192.168.1.100");
        System.out.println("Digite o IP do servidor:");
        InetAddress IPAddress = InetAddress.getByName(
                inFromUser.readLine()
        );

        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        System.out.println("Digite o texto a ser enviado para oservidor:");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();

        DatagramPacket sendPacket = new DatagramPacket(
                sendData,
                sendData.length,
                IPAddress,
                9876
        );
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(
                receiveData,
                receiveData.length
        );
        clientSocket.receive(receivePacket);

        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);

        clientSocket.close();
    }

}
