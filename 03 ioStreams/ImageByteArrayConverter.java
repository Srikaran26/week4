package ioStreams;

import java.io.*;

public class ImageByteArrayConverter {
    public static void main(String[] args) {
        String originalPath = "original.png";
        String newPath = "copy.png";
        try {
            byte[] imageBytes = readImageToByteArray(originalPath);
            writeByteArrayToImage(imageBytes, newPath);
            System.out.println("Image has been copied Successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readImageToByteArray(String originalPath) throws IOException { // Add throws IOException
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(originalPath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, String filePath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(filePath)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
