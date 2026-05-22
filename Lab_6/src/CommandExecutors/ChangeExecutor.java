package CommandExecutors;

import java.util.List;
import HumanHierarchy.*;
import Logger.Logger;

// A class that represents the executor of the command of changing a person in the list
public class ChangeExecutor implements CommandExecutor {
    String commandName = "CHANGE";
    Logger logger;

    public ChangeExecutor(Logger logger)
    {
        this.logger = logger;
    }

    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        if (logger != null)
            logger.log("Change command executed");

        try {
            int index = Integer.parseInt(Param);
            people.get(index).setFields(people.get(index), true);
        }
        catch (NumberFormatException | IndexOutOfBoundsException ignore) {};
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("Change command. Usage: CHANGE <person_index>");
    }
}