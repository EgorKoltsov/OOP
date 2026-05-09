package CommandExecuters;

import java.util.List;
import HumanHierarchy.*;

// A class that represents the executer of the help command
public class HelpExecuter implements CommandExecuter{
    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        printUsageHelp();
        new AddExecuter();
        new DeleteExecuter().printUsageHelp();
        new ChangeExecuter().printUsageHelp();
        new ShowExecuter().printUsageHelp();
        new SerializeExecuter().printUsageHelp();
        new DeserializeExecuter().printUsageHelp();
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.println("Get help command. Usage: HELP");
    }
}
