package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppAge {
    public static void main(String[] args) {
        List<Person> personList = parseFile("NameAndAge.txt");
        AgeGroup[] ageGroupsList = AgeGroup.values();

        for (AgeGroup ageGroup : ageGroupsList) {
            long countGroup = personList.stream().filter(person -> person.getAge() >= ageGroup.getLowerLimit() &&
                    person.getAge() <= ageGroup.getUpperLimit()).count();

            System.out.println(ageGroup + " - " + countGroup + " человек");
        }
    }

    private static List<Person> parseFile(String pathFile) {
        List<Person> personList = new ArrayList<>();

        try {
            ClassLoader classLoader = AppAge.class.getClassLoader();
            URL resource = classLoader.getResource(pathFile);
            Scanner scanner = new Scanner(new File(resource.getFile()));

            while (scanner.hasNextLine()) {
                String[] element = scanner.nextLine().split(",");
                personList.add(new Person(element[0], Integer.parseInt(element[1])));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return personList;
    }
}
