package es.ies.puerto.ejercicio5;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class ClienteFile {

    public static void main(String[] args) {

        String host = "localhost";
        int port = 1234;

        Socket socket = null;
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        startClienteFile(socket);
    }

    public static void startClienteFile(Socket socket){

        try {

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InputStream in = socket.getInputStream();

            Random random = new Random();
            int rndNumFile = random.nextInt(2)+1;

            //Escribe un file aleatorio para recibir
            String filename = "file"+rndNumFile+".txt";

            out.println(filename);

            //Imprime que file recibió
            File fileReceived = new File("received_"+filename);

            try (FileOutputStream fileOutputStream = new FileOutputStream(fileReceived)){

                byte [] buffer = new byte[4096];
                int bytesRead;

                //Mientras los bytes leidos sean distintos de -1
                while ((bytesRead = in.read(buffer)) != -1 ){
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.flush();
                fileOutputStream.close();

                System.out.println("File received: " + fileReceived.getName());

                showFileContents(fileReceived);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Function to read the contents of a file
     * @param fileReceived to read
     */
    private static void showFileContents(File fileReceived) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileReceived))){
            String line;
            System.out.println("Content of file: ");
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the file: ");
            throw new RuntimeException(e);
        }
    }
}
