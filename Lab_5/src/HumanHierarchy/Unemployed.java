package HumanHierarchy;

// A class representing an unemployed person
public class Unemployed extends Human {
    int monthsUnemployed;

    // Constructing object method
    @Override
    public Human constructObject() {
        Unemployed result = new Unemployed();
        setFields(result, false);
        return result;
    }

    // Setting / changing fields method
    public void setFields(Unemployed human, boolean changeFields)
    {
        new Human().setFields(human, changeFields);
        human.monthsUnemployed = getNonNegativeInteger("Enter unemployment months period (Not negative Number)", changeFields ? human.monthsUnemployed : null);
    }

    // Converting instance to string method
    @Override
    public String toString() {
        return super.toString() + "Months unemployed: " + monthsUnemployed + "\n";
    }
}
