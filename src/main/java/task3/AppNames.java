package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class AppNames {
    public static void main(String[] args) {
        HashMap<String, Integer> namesMap = new HashMap<>();

        AppNames app = new AppNames();
        app.fillInNamesMap(namesMap);

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        while (!command.equals("0")) {
            switch (command) {
                case "1" -> showAllNames(namesMap);
                case "2" -> popularName(namesMap);
                case "3" -> rareName(namesMap);
                default -> System.out.println("""
                        Меню:
                        1 - вывести результаты подсчета
                        2 - вывести популярное имя
                        3 - вывести редкое имя
                        0 - выйти из программы""");
            }
            command = scanner.nextLine();
        }
    }

    /**
     * Вывести результаты подсчета
     */
    private static void showAllNames(HashMap<String, Integer> namesMap) {
        for (HashMap.Entry<String, Integer> entry : namesMap.entrySet())
            System.out.println(entry);
    }

    /**
     * Поиск популярного имени
     */
    private static void popularName(HashMap<String, Integer> namesMap) {
        Integer value = namesMap.values().stream()
                .max(Integer::compare).get();

        findName(namesMap, value);
    }

    /**
     * Поиск редкого имени
     */
    private static void rareName(HashMap<String, Integer> namesMap) {
        Integer value = namesMap.values().stream()
                .min(Integer::compare).get();

        findName(namesMap, value);
    }

    /**
     * Поиск имени по кол-ву повторений
     */
    private static void findName(HashMap<String, Integer> namesMap, Integer value) {
        Set<String> names = namesMap.keySet();

        for (String key : names) {
            if (namesMap.get(key).equals(value))
                System.out.println(key + " - " + value + " повторений");
        }
    }


    /**
     * заполняем names, где key - имя, value - кол-во повторений
     */
    private void fillInNamesMap(HashMap<String, Integer> names) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            URL resource = classLoader.getResource("names.txt");
            Scanner scanner = new Scanner(new File(resource.getFile()));

            while (scanner.hasNextLine()) {
                String scannerName = scanner.nextLine();
                names.put(scannerName, !names.containsKey(scannerName) ? 1 : (names.get(scannerName) + 1));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
