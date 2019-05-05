package com.java.steve.Command;



import java.beans.Encoder;
import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.nio.charset.Charset;

public class CommandDBStatus extends ACommand{

    private Socket socket;

    public CommandDBStatus(String name) {
        super(name);
    }

    @Override
    public void execute() {

        String outMsg = "status";
        URL url = null;
        try {
            url = new URL("http://localhost:6701/db/serverstate");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            dos.writeBytes(outMsg);

            dos.close();


            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println("Database status is: " + line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }







    }
}



/*
        String outMsg = "status";
        URL url = null;
        try {
            url = new URL("http://localhost:6701/db/serverstate");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);

            DataOutputStream dos = new DataOutputStream(connection.getOutputStream());
            dos.writeBytes(outMsg);

            dos.close();


            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = br.readLine()) != null){
                System.out.println("Database status is: " + line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

 */

       /*
try {
            socket = new Socket(InetAddress.getLocalHost(), 6701);
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            String message = "status";


            bw.write(message);
            bw.flush();
            System.out.println("Message sent to the server : "+ message);

            //Get the return message from the server
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            message = br.readLine();
            System.out.println("Message received from the server : " + message);



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 */


