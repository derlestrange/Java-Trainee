import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Communication {

    public Communication() {
        questionFromUser();
    }

    private void questionFromUser() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command." +
                " For example: /home/mercury/Документы/Greenatom/InputOutput/data/file.txt -create");
        String input = scanner.nextLine();
        String[] userCommand = input.split("\\s");

        switch (userCommand[1]) {
            case "-create":
                try {
                    FileUtils.touch(new File(userCommand[0]));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "-write":
                try {
                    FileUtils.writeStringToFile(new File(userCommand[0]), userCommand[2],
                            StandardCharsets.UTF_8);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "-delete":
                FileUtils.deleteQuietly(new File(userCommand[0]));
                break;
            
            case "-read":
                try {
                    String read = FileUtils.readFileToString(new File(userCommand[0]), StandardCharsets.UTF_8);
                    System.out.println(read);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;

            case "exit":
                return;

            default:
                System.out.println("Try again!");
        }
    }
}
