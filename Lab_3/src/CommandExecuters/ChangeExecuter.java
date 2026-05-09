package CommandExecuters;

import java.util.List;
import HumanHierarchy.*;

// A class that represents the executer of the command of changing a person in the list
public class ChangeExecuter implements CommandExecuter {
    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
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