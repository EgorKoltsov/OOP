package CommandExecuters;

import java.lang.reflect.Method;
import java.util.List;
import HumanHierarchy.*;

// A class that represents the executer of the help command
public class HelpExecuter implements CommandExecuter{
    List<Class> pluginExecuters;
    AddExecuter addExecuter;

    // Class constructor
    public HelpExecuter(List<Class> pluginExecuters, AddExecuter addExecuter)
    {
        this.addExecuter = addExecuter;
        this.pluginExecuters = pluginExecuters;
    }

    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        printUsageHelp();
        addExecuter.printUsageHelp();
        new DeleteExecuter().printUsageHelp();
        new ChangeExecuter().printUsageHelp();
        new ShowExecuter().printUsageHelp();
        new SerializeExecuter().printUsageHelp();
        new DeserializeExecuter().printUsageHelp();

        // Calling plugins help methods
        for (Class executerClass : pluginExecuters)
        {
            try {
                Method usageHelpMethod = executerClass.getMethod("printUsageHelp");
                usageHelpMethod.invoke(executerClass.getDeclaredConstructor().newInstance());
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при выводе подсказки для " + executerClass);
            }
        }
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("Get help command. Usage: HELP");
    }
}
