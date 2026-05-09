package HumanHierarchy;

// A class representing an unemployed person who is looking for a job
public class JobSeeking extends Unemployed {
    int numOfApplications;

    // Constructing object method
    @Override
    public Human constructObject() {
        JobSeeking result = new JobSeeking();
        setFields(result, false);
        return result;
    }

    // Setting / changing fields method
    public void setFields(JobSeeking human, boolean changeFields)
    {
        new Unemployed().setFields(human, changeFields);
        human.numOfApplications = getNonNegativeInteger("Enter number of sent applications (Not negative Number)", changeFields ? human.numOfApplications : null);
    }

    // Converting instance to string method
    @Override
    public String toString() {
        return super.toString() + "Number Of Applications: " + numOfApplications + "\n";
    }
}
