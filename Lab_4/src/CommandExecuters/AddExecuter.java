package CommandExecuters;

import HumanHierarchy.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// A class that represents the executer of the command of addition a person to the list
public class AddExecuter implements CommandExecuter {
    public static final Map<String, Human> stringHumanObjects = new HashMap<>();
    List<String> humanClassesIdentifiers;

    // Adding human plugins to an executer
    public void addPlugins(List<Class> humanPlugins,  List<String> humanClassesIdentifiers)
    {
        this.humanClassesIdentifiers = humanClassesIdentifiers;

        for (int i = 0; i < humanPlugins.size(); i++) {
            try {
                stringHumanObjects.put(humanClassesIdentifiers.get(i), (Human) humanPlugins.get(i).getDeclaredConstructor().newInstance());
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при выводе подсказки для " + humanPlugins.get(i));
            }
        }
    }

    // Adding Human objects in a map to call construct methods
    public AddExecuter()
    {
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
        if (humanClassesIdentifiers != null)
            for (String temp : humanClassesIdentifiers)
                System.out.print("|" + temp);
        System.out.println();
    }
}