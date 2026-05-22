package CommandExecutors;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import HumanHierarchy.*;
import Logger.Logger;

// A class that represents the executer of the command of serializing a person list to a file
public class SerializeExecutor implements CommandExecutor {
    Logger logger;

    public SerializeExecutor(Logger logger)
    {
        this.logger = logger;
    }

    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        if (logger != null)
            logger.log("Serialize command executed");

        if (Param != null)
        {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Param))) {
                oos.writeObject(people);
                oos.flush();
            } catch (IOException e) {
                System.out.print("IOException has occurred");
            }
        }
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("File serialization command. Usage: SERIALIZE <file_name>");
    }
}
