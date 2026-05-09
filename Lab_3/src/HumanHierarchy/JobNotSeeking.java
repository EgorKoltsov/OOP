package HumanHierarchy;

import java.util.Scanner;

// A class representing an unemployed person who is not looking for a job
public class JobNotSeeking extends Unemployed {
    String reason;

    // Constructing object method
    @Override
    public Human constructObject() {
        JobNotSeeking result = new JobNotSeeking();
        setFields(result, false);
        return result;
    }

    // Setting / changing fields method
    public void setFields(JobNotSeeking human, boolean changeFields)
    {
        new Unemployed().setFields(human, changeFields);
        Scanner scanner = new Scanner(System.in);
        human.reason = scanner.nextLine();
    }

    // Converting instance to string method
    @Override
    public String toString() {
        return super.toString() + "Job not seeking reason: " + reason + "\n";
    }
}