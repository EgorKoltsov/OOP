package HumanHierarchy;

import java.io.Serializable;
import java.util.Scanner;

// A class that represents a Human
public class Human implements Serializable {
    Gender gender;
    int age;

    // Constructing object method
    public Human constructObject() {
        Human result = new Human();
        setFields(result, false);
        return result;
    }

    // Setting / changing fields method
    public void setFields(Human human, boolean changeFields) {
        Scanner scanner = new Scanner(System.in);

        Gender temp;
        do {
            System.out.print("Enter gender (MALE/FEMALE) " + (changeFields ? "[" + human.gender.toString() + "]" : "") + ": ");
            String line = scanner.nextLine();

            if (line.isEmpty())
                break;

            temp = Gender.stringToGenderMap.get(line);
            human.gender = temp == null ? human.gender : temp;
        } while (temp == null);

        human.age = getNonNegativeInteger("Enter age (Not negative Number) ", changeFields ? human.age : null);
    }

    // Getting a non-negative integer value from a user
    public int getNonNegativeInteger(String enterMessage, Integer defaultValue)
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.print(enterMessage + (defaultValue != null ? "[" + defaultValue + "]" : "") + " : ");
            String numberStr = scanner.nextLine();

            if (defaultValue != null && numberStr.isEmpty())
                break;

            try
            {
                int tempInt = Integer.parseInt(numberStr);
                if (tempInt >= 0)
                    return tempInt;
            }
            catch (NumberFormatException ignore) {}
        }

        return defaultValue;
    }

    // Converting instance to string method
    @Override
    public String toString() {
        return "Gender: " + gender + "\n" + "Age: " + age + "\n";
    }
}
