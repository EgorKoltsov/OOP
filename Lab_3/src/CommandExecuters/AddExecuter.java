package CommandExecuters;

import HumanHierarchy.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// A class that represents the executer of the command of addition a person to the list
public class AddExecuter implements CommandExecuter {
    public static final Map<String, Human> stringHumanObjects = new HashMap<>();

    // Class constructor
    public AddExecuter()
    {
        // Adding Human objects in a map to call construct methods
        stringHumanObjects.put("HUMAN", new Human());
        stringHumanObjects.put("WORKER", new Worker());
        stringHumanObjects.put("OFFICE_WORKER", new OfficeWorker());
        stringHumanObjects.put("UNEMPLOYED", new Unemployed());
        stringHumanObjects.put("JOB_SEEKING", new JobSeeking());
        stringHumanObjects.put("JOB_NOT_SEEKING", new JobNotSeeking());
    }

    // Execution of the command method
    @Override
    public void Execute(List<Human> people, String Param) {
        if (stringHumanObjects.get(Param) != null)
            people.add(stringHumanObjects.get(Param).constructObject());
    }

    // Printing usage help method
    @Override
    public void printUsageHelp() {
        System.out.print("Person add command. Usage: ADD HUMAN|WORKER|OFFICE_WORKER|UNEMPLOYED|JOB_SEEKING|JOB_NOT_SEEKING");
        System.out.println();
    }
}