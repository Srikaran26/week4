package ioStreams;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {

    public static void main(String[] args) {
        try {
            
            PipedInputStream pis = new PipedInputStream();
            PipedOutputStream pos = new PipedOutputStream(pis);

            
            Thread writerThread = new Thread(new DataWriter(pos));
            Thread readerThread = new Thread(new DataReader(pis));

            writerThread.start();
            readerThread.start();

            
            writerThread.join();
            readerThread.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class DataWriter implements Runnable {
        private final PipedOutputStream pos;

        DataWriter(PipedOutputStream pos) {
            this.pos = pos;
        }

        @Override
        public void run() {
            try {
                String[] messages = {"First message", "Second message", "END"};
                for (String msg : messages) {
                    pos.write(msg.getBytes());
                    pos.flush();
                    System.out.println("Sent: " + msg);
                    Thread.sleep(1000); 
                }
                pos.close(); 
            } catch (IOException | InterruptedException e) {
                handleException("Writer error", e);
            }
        }
    }

    static class DataReader implements Runnable {
        private final PipedInputStream pis;

        DataReader(PipedInputStream pis) {
            this.pis = pis;
        }

        @Override
        public void run() {
            try {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = pis.read(buffer)) != -1) {
                    String received = new String(buffer, 0, bytesRead);
                    System.out.println("Received: " + received);
                }
                pis.close();
            } catch (IOException e) {
                handleException("Reader error", e);
            }
        }
    }

    private static void handleException(String context, Exception e) {
        System.err.println(context + ": " + e.getMessage());
        e.printStackTrace();
    }
}

