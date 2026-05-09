package CommandExecuters;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import HumanHierarchy.*;

// A class that represents the executer of the command of deserializing a person list from a file
public class DeserializeExecuter implements CommandExecuter {
    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Param))) {
            List<Human> tempList = (List<Human>) ois.readObject();
            people.clear();
            people.addAll(tempList);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("File deserialization command. Usage: DESERIALIZE <file_name>");
    }
}
