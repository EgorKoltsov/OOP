package HumanHierarchy;

// A class representing a working person
public class Worker extends Human {
    int experienceMonths;
    int salary;

    // Constructing object method
    @Override
    public Human constructObject() {
        Worker result = new Worker();
        setFields(result, false);
        return result;
    }

    // Setting / changing fields method
    public void setFields(Worker human, boolean changeFields)
    {
        new Human().setFields(human, changeFields);
        human.experienceMonths = getNonNegativeInteger("Enter work experience in months (Not negative Number)", changeFields ? human.experienceMonths : null);
        human.salary = getNonNegativeInteger("Enter salary (Not negative Number)", changeFields ? human.salary : null);
    }

    // Converting instance to string method
    @Override
    public String toString() {
        return super.toString() + "Experience in months: " + experienceMonths + "\n";
    }
}