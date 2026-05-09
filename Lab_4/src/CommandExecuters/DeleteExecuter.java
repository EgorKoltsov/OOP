package CommandExecuters;

import java.util.List;
import HumanHierarchy.*;

// A class that represents the executer of the command of deleting a person from the list
public class DeleteExecuter implements CommandExecuter {
    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
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