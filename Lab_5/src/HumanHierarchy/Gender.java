package HumanHierarchy;

import java.util.HashMap;
import java.util.Map;

public enum Gender
{
    MALE, FEMALE;
    public static final Map<String, Gender> stringToGenderMap = new HashMap<>();

    public static void prepareMap()
    {
        stringToGenderMap.put("MALE", MALE);
        stringToGenderMap.put("FEMALE", FEMALE);
    }
}