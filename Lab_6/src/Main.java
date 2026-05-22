import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import HumanHierarchy.*;
import CommandExecutors.*;
import Logger.Logger;

public class Main {
    static List<Human> people = new ArrayList<>();
    public static final Map<String, CommandExecutor> stringToCommandExecuter = new HashMap<>();

    // The command line arguments specify the plug-in plugins in the format:
    // EXECUTER:<Command name>:<Jar file name>
    // or
    // HUMAN:<Class name>:<Jar file name>
    public static void main(String[] args) {
        Gender.prepareMap();

        List<URL> executorsUrls = new ArrayList<>();
        List<String> executorsCommands = new ArrayList<>();

        List<URL> humanUrls = new ArrayList<>();
        List<String> humanClassesIdentifiers = new ArrayList<>();

        List<URL> loggerUrls = new ArrayList<>();
        List<String> loggerClassesIdentifiers = new ArrayList<>();

        System.out.println(System.getProperty("user.dir"));

        // Parsing string parameters with plugins
        for (String pluginString : args) {
            switch (pluginString.split(":")[0]) {
                case "EXECUTOR":
                    try {
                        executorsCommands.add(pluginString.split(":")[1]);
                        String executerUrlString = "file:Plugins/CommandExecutors/" + pluginString.split(":")[2];
                        executorsUrls.add(new URL(executerUrlString));
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
                case "LOGGER":
                    try
                    {
                        String loggerUrlString = "file:Plugins/Logger/" + pluginString.split(":")[2];
                        loggerClassesIdentifiers.add(pluginString.split(":")[1]);
                        loggerUrls.add(new URL(loggerUrlString));
                    } catch (MalformedURLException e) {
                        System.out.println("Не удалось загрузить плагин " + pluginString);
                    }
            }
        }

        // Loading CommandExecuter classes
        URLClassLoader classLoader = new URLClassLoader(executorsUrls.toArray(new URL[0]));

        List<Class> classesForHelpExecuter = new ArrayList<>();

        for (int i = 0; i < classLoader.getURLs().length; i++)
        {
            try {
                String classPath = "CommandExecuters." + classLoader.getURLs()[i].toString().split("/")[2].split(".jar")[0];
                Class<?> executorClass = classLoader.loadClass(classPath);
                classesForHelpExecuter.add(executorClass);
                stringToCommandExecuter.put(executorsCommands.get(i), (CommandExecutor) executorClass.getDeclaredConstructor().newInstance());
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при загрузке " + classLoader.getURLs()[i]);
            }
        }

        // Loading Human classes
        classLoader = new URLClassLoader(humanUrls.toArray(new URL[0]));
        List<Class> classesForAddExecutor = new ArrayList<>();

        for (int i = 0; i < classLoader.getURLs().length; i++)
        {
            try {
                String classPath = "HumanHierarchy." + classLoader.getURLs()[i].toString().split("/")[2].split(".jar")[0];
                Class<?> executerClass = classLoader.loadClass(classPath);
                classesForAddExecutor.add(executerClass);
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при загрузке " + classLoader.getURLs()[i]);
            }
        }

        classLoader = new URLClassLoader(loggerUrls.toArray(new URL[0]));

        Logger logger = null;
        for (int i = 0; i < classLoader.getURLs().length; i++)
        {
            try {
                String classPath = "Logger." + classLoader.getURLs()[i].toString().split("/")[2].split(".jar")[0];
                Class<?> loggerClass = classLoader.loadClass(classPath);
                logger = (Logger) loggerClass.getMethod("getInstance", String.class, String.class).invoke(null, "file", "log.txt");
            }
            catch (Exception e)
            {
                System.out.println("Ошибка при загрузке " + classLoader.getURLs()[i]);
            }
        }

        AddExecutor addExecutor = new AddExecutor(logger);
        addExecutor.addPlugins(classesForAddExecutor, humanClassesIdentifiers);
        HelpExecutor helpExecutor = new HelpExecutor(classesForHelpExecuter, addExecutor, logger);

        stringToCommandExecuter.put("ADD", addExecutor);
        stringToCommandExecuter.put("DELETE", new DeleteExecutor(logger));
        stringToCommandExecuter.put("CHANGE", new ChangeExecutor(logger));
        stringToCommandExecuter.put("SHOW", new ShowExecutor(logger));
        stringToCommandExecuter.put("HELP", helpExecutor);
        stringToCommandExecuter.put("SERIALIZE", new SerializeExecutor(logger));
        stringToCommandExecuter.put("DESERIALIZE", new DeserializeExecuter(logger));

        helpExecutor.printUsageHelp();
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