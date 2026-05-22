package CommandExecutors;

import java.util.List;
import HumanHierarchy.*;
import Logger.Logger;

// A class that represents the executer of the command of showing person list
public class ShowExecutor implements CommandExecutor {
    Logger logger;

    public ShowExecutor(Logger logger)
    {
        this.logger = logger;
    }

    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        if (logger != null)
            logger.log("Show command executed");

        System.out.print("[\n");
        for (int i = 0; i < people.size(); i++)
        {
            System.out.println("Person #" + i + ":");
            System.out.print(people.get(i) + "\n");
        }
        System.out.print("]\n");
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("List show command. Usage: SHOW");
    }
}