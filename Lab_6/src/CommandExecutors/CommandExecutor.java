package CommandExecutors;

import java.util.List;
import HumanHierarchy.*;

// Some command executor interface
public interface CommandExecutor {
    void Execute(List<Human> people, String Param);
    void printUsageHelp();
}