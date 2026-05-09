package CommandExecuters;

import java.util.List;
import HumanHierarchy.*;

// Some command executer interface
public interface CommandExecuter {
    void Execute(List<Human> people, String Param);
    void printUsageHelp();
}