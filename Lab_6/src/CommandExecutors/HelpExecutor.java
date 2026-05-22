package CommandExecutors;

import java.lang.reflect.Method;
import java.util.List;
import HumanHierarchy.*;
import Logger.Logger;

// A class that represents the executor of the help command
public class HelpExecutor implements CommandExecutor {
    Logger logger;

    List<Class> pluginExecutors;
    AddExecutor addExecutor;

    // Class constructor
    public HelpExecutor(List<Class> pluginExecutors, AddExecutor addExecutor, Logger logger)
    {
        this.addExecutor = addExecutor;
        this.pluginExecutors = pluginExecutors;
        this.logger = logger;
    }

    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        if (logger != null)
            logger.log("Help command executed");

        printUsageHelp();
        addExecutor.printUsageHelp();
        new DeleteExecutor(null).printUsageHelp();
        new ChangeExecutor(null).printUsageHelp();
        new ShowExecutor(null).printUsageHelp();
        new SerializeExecutor(null).printUsageHelp();
        new DeserializeExecuter(null).printUsageHelp();

        // Calling plugins help methods
        for (Class executorClass : pluginExecutors)
        {
            try {
                Method usageHelpMethod = executorClass.getMethod("printUsageHelp");
                usageHelpMethod.invoke(executorClass.getDeclaredConstructor().newInstance());
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при выводе подсказки для " + executorClass);
            }
        }
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("Get help command. Usage: HELP");
    }
}
