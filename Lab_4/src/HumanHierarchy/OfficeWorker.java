package HumanHierarchy;

// A class representing an office worker
public class OfficeWorker extends Worker {
    int officeID;

    // Constructing object method
    @Override
    public Human constructObject() {
        OfficeWorker result = new OfficeWorker();
        setFields(result, false);

        return result;
    }

    // Setting / changing fields method
    public void setFields(OfficeWorker human, boolean changeFields) {
        new Worker().setFields(human, changeFields);
        human.officeID = getNonNegativeInteger("Enter officeID (Number)", changeFields ? human.officeID : null);
    }

    // Converting instance to string method
    @Override
    public String toString() {
        return super.toString() + "Office ID: " + officeID + "\n";
    }
}
