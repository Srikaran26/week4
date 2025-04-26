package ioStreams;
import java.io.*;

public class BufferedStreams {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFile = "Sample.txt";
        String destFileUnbuffered = "dest_unbuffered.txt";
        String destFileBuffered = "dest_buffered.txt";
        long startUnbuffered = System.nanoTime();
        copyFileUnbuffered(sourceFile, destFileUnbuffered);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered copy time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");

        long startBuffered = System.nanoTime();
        copyFileBuffered(sourceFile, destFileBuffered);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered copy time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");
    }

    private static void copyFileUnbuffered(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileBuffered(String sourcePath, String destPath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
        	e.printStackTrace();
        }
    }
}
