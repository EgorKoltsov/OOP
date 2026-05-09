import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import HumanHierarchy.*;
import CommandExecuters.*;

// Program enter point class
public class Main {
    static List<Human> people = new ArrayList<>();
    public static final Map<String, CommandExecuter> stringToCommandExecuter = new HashMap<>();

    // The command line arguments specify the plug-in plugins in the format:
    // EXECUTER:<Command name>:<Jar file name>
    // or
    // HUMAN:<Class name>:<Jar file name>
    public static void main(String[] args) {
        Gender.prepareMap();

        List<URL> executersUrls = new ArrayList<>();
        List<String> executersCommands = new ArrayList<>();

        List<URL> humanUrls = new ArrayList<>();
        List<String> humanClassesIdentifiers = new ArrayList<>();

        System.out.println(System.getProperty("user.dir"));

        // Parsing string parameters with plugins
        for (String pluginString : args) {
            switch (pluginString.split(":")[0]) {
                case "EXECUTER":
                    try {
                        executersCommands.add(pluginString.split(":")[1]);
                        String executerUrlString = "file:Plugins/CommandExecuters/" + pluginString.split(":")[2];
                        executersUrls.add(new URL(executerUrlString));
                    } catch (MalformedURLException e) {
                        System.out.println("Не удалось загрузить плагин " + pluginString);
                    }
                    break;
                case "HUMAN":
                    try
                    {
                        String humanUrlString = "file:Plugins/Human/" + pluginString.split(":")[2];
                        humanClassesIdentifiers.add(pluginString.split(":")[1]);
                        humanUrls.add(new URL(humanUrlString));
                    } catch (MalformedURLException e) {
                        System.out.println("Не удалось загрузить плагин " + pluginString);
                    }
                    break;
            }
        }

        // Loading CommandExecuter classes
        URLClassLoader classLoader = new URLClassLoader(executersUrls.toArray(new URL[0]));

        List<Class> classesForHelpExecuter = new ArrayList<>();

        for (int i = 0; i < classLoader.getURLs().length; i++)
        {
            try {
                String classPath = "CommandExecuters." + classLoader.getURLs()[i].toString().split("/")[2].split(".jar")[0];
                Class<?> executerClass = classLoader.loadClass(classPath);
                classesForHelpExecuter.add(executerClass);
                stringToCommandExecuter.put(executersCommands.get(i), (CommandExecuter) executerClass.getDeclaredConstructor().newInstance());
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при загрузке " + classLoader.getURLs()[i]);
            }
        }

        // Loading Human classes
        classLoader = new URLClassLoader(humanUrls.toArray(new URL[0]));
        List<Class> classesForAddExecuter = new ArrayList<>();

        for (int i = 0; i < classLoader.getURLs().length; i++)
        {
            try {
                String classPath = "HumanHierarchy." + classLoader.getURLs()[i].toString().split("/")[2].split(".jar")[0];
                Class<?> executerClass = classLoader.loadClass(classPath);
                classesForAddExecuter.add(executerClass);
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при загрузке " + classLoader.getURLs()[i]);
            }
        }

        AddExecuter addExecuter = new AddExecuter();
        addExecuter.addPlugins(classesForAddExecuter, humanClassesIdentifiers);
        HelpExecuter helpExecuter = new HelpExecuter(classesForHelpExecuter, addExecuter);

        stringToCommandExecuter.put("ADD", addExecuter);
        stringToCommandExecuter.put("DELETE", new DeleteExecuter());
        stringToCommandExecuter.put("CHANGE", new ChangeExecuter());
        stringToCommandExecuter.put("SHOW", new ShowExecuter());
        stringToCommandExecuter.put("HELP", helpExecuter);
        stringToCommandExecuter.put("SERIALIZE", new SerializeExecuter());
        stringToCommandExecuter.put("DESERIALIZE", new DeserializeExecuter());

        helpExecuter.printUsageHelp();
        Scanner scanner = new Scanner(System.in);
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