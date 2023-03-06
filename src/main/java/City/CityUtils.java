package City;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CityUtils {
    /**
     * Загрузка данных о городах в массив
     *
     * @return массив объектов с данными о городах
     */
    public static List<City> parser() {
        List<City> cityArrayList = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("src/main/resources/city_ru.csv"), "UTF-8");

            while (input.hasNextLine()) {
                cityArrayList.add(parser(input.nextLine()));
            }

            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return cityArrayList;
    }

    /**
     * Разбор строки с данными о городе
     *
     * @param line строка с данными о городе
     * @return {@link City}
     */
    private static City parser(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");
        scanner.skip("\\d*");

        String name = scanner.next();
        String region = scanner.next();
        String distinct = scanner.next();
        int population = scanner.nextInt();
        String foundation = null;

        if (scanner.hasNext()) {
            foundation = scanner.next();
        }

        return new City(name, region, distinct, population, foundation);
    }
}
