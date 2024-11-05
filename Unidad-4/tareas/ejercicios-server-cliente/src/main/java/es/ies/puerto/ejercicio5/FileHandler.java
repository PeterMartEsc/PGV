package es.ies.puerto.ejercicio5;

import java.io.*;
import java.net.Socket;

public class FileHandler extends Thread {

    private Socket socket;

    public static final String PATH = "src/main/resources/";

    public FileHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try (BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            OutputStream outputStream = socket.getOutputStream();

            String filename = inputReader.readLine();

            System.out.println("Requesting file: " + filename);

            manageFile(outputStream, filename);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void manageFile(OutputStream outputStream, String filename){

        File file = new File(PATH+filename);

        if (!checkFile(file)){
            return;
        }

        try (FileInputStream fileInputStream = new FileInputStream(file)){
            byte [] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            outputStream.close();

            System.out.println("File send: " + filename);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public boolean checkFile (File file){
        return file.exists() && file.isFile();
    }
}
