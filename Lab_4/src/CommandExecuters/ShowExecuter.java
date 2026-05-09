package CommandExecuters;

import java.util.List;
import HumanHierarchy.*;

// A class that represents the executer of the command of showing person list
public class ShowExecuter implements CommandExecuter {
    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
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