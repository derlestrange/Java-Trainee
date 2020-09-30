import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) {
        String filename = "Serialization/file.txt";
        Human human = new Human("Maxim", 22, "");

        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(human);

            out.close();
            file.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            human = (Human) in.readObject();

            in.close();
            file.close();

            if (human.age >= 0 && human.age <= 3) {
                human.activity = "дома";
            } else if (human.age > 3 && human.age <= 7) {
                human.activity = "детский сад";
            } else if (human.age > 7 && human.age <= 18) {
                human.activity = "школа";
            } else if (human.age > 17 && human.age <= 23) {
                human.activity = "институт";
            } else if (human.age > 24 && human.age <= 65) {
                human.activity = "работа";
            } else if (human.age > 65) {
                human.activity = "пенсия";
            }

            System.out.println("activity = " + human.activity);
            System.out.println("name = " + human.name);
            System.out.println("age = " + human.age);

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

    }
}

