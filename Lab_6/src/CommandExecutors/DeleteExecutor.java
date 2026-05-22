package CommandExecutors;

import java.util.List;
import HumanHierarchy.*;
import Logger.Logger;

// A class that represents the executer of the command of deleting a person from the list
public class DeleteExecutor implements CommandExecutor {
    Logger logger;

    public DeleteExecutor(Logger logger)
    {
        this.logger = logger;
    }

    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        if (logger != null)
            logger.log("Delete command executed");

        try {
            int index = Integer.parseInt(Param);
            people.remove(index);
        }
        catch (NumberFormatException | IndexOutOfBoundsException ignore) {};
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("Person delete command. Usage: DELETE <person_index>");
    }
}