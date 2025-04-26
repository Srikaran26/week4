package ioStreams;
import java.io.*;

public class StudentDataStreamDemo {
    private static final String FILE_NAME = "students.dat";

    public static void main(String[] args) {
        writeStudentData();

        readStudentData();
    }

    private static void writeStudentData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            // Write student 1
            dos.writeInt(101);           
            dos.writeUTF("Alice");         
            dos.writeDouble(8.5);        

            // Write student 2
            dos.writeInt(102);
            dos.writeUTF("Bob");
            dos.writeDouble(7.8);

            // Write student 3
            dos.writeInt(103);
            dos.writeUTF("Charlie");
            dos.writeDouble(9.1);

            System.out.println("Student data has been written to " + FILE_NAME);

        } catch (IOException e) {
            System.err.println("Writing error: " + e.getMessage());
        }
    }

    private static void readStudentData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_NAME))) {
            System.out.println("\nReading student data from file:");

            while (dis.available() > 0) { 
                int rollNo = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();

                System.out.println("Roll No: " + rollNo + ", Name: " + name + ", GPA: " + gpa);
            }

        } catch (IOException e) {
            System.err.println("Reading error: " + e.getMessage());
        }
    }
}
