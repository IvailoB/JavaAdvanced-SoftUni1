package STREAM;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Course course = new Course();
        course.name = "Java Advanced";
        course.numberOfStudents = 250;
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Resources - STREAMEXE/course.ser"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Resources - STREAMEXE/course.ser"))) {
            oos.writeObject(course);

            Course courseFromFile = (Course) ois.readObject();
            System.out.println(courseFromFile.name);
            System.out.println(courseFromFile.numberOfStudents);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
