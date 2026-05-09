import java.util.*;
import HumanHierarchy.*;
import CommandExecuters.*;

// The class of the entry point to the program
public class Main {
    static List<Human> people = new ArrayList<>();
    public static final Map<String, CommandExecuter> stringToCommandExecuter = new HashMap<>();

    public static void main(String[] args) {
        Gender.prepareMap();

        // Adding command executers
        stringToCommandExecuter.put("ADD", new AddExecuter());
        stringToCommandExecuter.put("DELETE", new DeleteExecuter());
        stringToCommandExecuter.put("CHANGE", new ChangeExecuter());
        stringToCommandExecuter.put("SHOW", new ShowExecuter());
        stringToCommandExecuter.put("HELP", new HelpExecuter());
        stringToCommandExecuter.put("SERIALIZE", new SerializeExecuter());
        stringToCommandExecuter.put("DESERIALIZE", new DeserializeExecuter());

        // Printing help command usage help
        new HelpExecuter().printUsageHelp();
        Scanner scanner = new Scanner(System.in);

        // Commands processing cycle
        while (true)
        {
            System.out.print("Command: ");
            String command = scanner.nextLine();

            String[] commandWords = command.split(" ");

            if (commandWords.length >= 1 && stringToCommandExecuter.containsKey(commandWords[0]))
                stringToCommandExecuter.get(commandWords[0]).Execute(people, commandWords.length >= 2 ? commandWords[1] : null);
        }
    }
}