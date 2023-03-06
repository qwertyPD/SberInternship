import City.City;

import java.text.MessageFormat;
import java.util.*;

import static City.CityUtils.*;

public class Main {
    public static void main(String[] args) {
        List<City> cities = parser();
        countOfCityInRegionV2(cities);
    }

    /**
     * Сортировка списка городов по наименованию в алфавитном порядке
     * по убыванию без учета регистра, используя lambda-выражения
     *
     * @param cities список городов
     * @return отсортированный список городов
     */
    private static List<City> sortByNameV1(List<City> cities) {
        Collections.sort(cities, (City o1, City o2) ->
                o1.getName().compareToIgnoreCase(o2.getName().toLowerCase())
        );
        return cities;
    }

    /**
     * Сортировка списка городов по наименованию в алфавитном порядке
     * по убыванию без учета регистра, используя {@link java.util.Comparator}
     *
     * @param cities список городов
     * @return отсортированный список городов
     */
    private static List<City> sortByNameV2(List<City> cities) {
        cities.sort(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        return cities;
    }

    /**
     * Сортировка списка городов по федеральному округу и наименованию города
     * внутри каждого федерального округа в алфавитном порядке по убыванию
     * с учетом регистра
     *
     * @param cities список городов
     * @return отсортированный список городов
     */
    private static List<City> sortByDistinctAndName(List<City> cities) {
        cities.sort(Comparator.comparing(City::getDistinct).thenComparing(City::getName));
        return cities;
    }

    /**
     * Вывод в консоль списка городов
     *
     * @param cities список городов
     */
    private static void print(List<City> cities) {
        cities.forEach(System.out::println);
    }

    /**
     * Находит город с максимальным числом жителей, и его индекс в массиве
     *
     * @param cities массив городов
     * @return массив, содержащий индекс элемента и максимальное значение
     */
    private static void findMaxBySimpleBruteForce(List<City> cities) {
        City[] citiesArray = new City[cities.size()];
        cities.toArray(citiesArray);

        int[] maxResult = new int[2];
        maxResult[0] = 0;
        maxResult[1] = citiesArray[0].getPopulation();
        for (int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i].getPopulation() > maxResult[1]) {
                maxResult[0] = i;
                maxResult[1] = citiesArray[i].getPopulation();
            }
        }
        System.out.println("[" + maxResult[0] + "]" + " = " + maxResult[1]);
    }

    /**
     * Поиск города с наибольшим количеством жителей
     *
     * @param cities массив городов
     */
    private static void findMax(List<City> cities) {
        System.out.println(cities.stream().max(Comparator.comparing(City::getPopulation)));
    }

    /**
     * Подсчет количества городов в регионе
     *
     * @param cities массив городов
     */
    private static void countOfCityInRegion(List<City> cities) {
        cities.sort(Comparator.comparing(City::getRegion));
        City[] citiesArray = new City[cities.size()];
        cities.toArray(citiesArray);

        int count = 1;
        List<String> result = new ArrayList<>();
        for (int i = 1; i < citiesArray.length; i++) {
            if (citiesArray[i].getRegion().equals(citiesArray[i - 1].getRegion())) {
                count++;
            } else {
                result.add(citiesArray[i - 1].getRegion() + " - " + count);
                count = 1;
            }
        }
        for (String i: result) {
            System.out.println(i);
        }
    }

    /**
     * Подсчет количества городов в регионе, используя lambda-выражения
     *
     * @param cities массив городов
     */
    private static void countOfCityInRegionV2(List<City> cities) {
        Map<String, Integer> regions = new HashMap<>();
        cities.forEach(city -> regions.merge(city.getRegion(), 1, Integer::sum));
        regions.forEach((k, v) -> System.out.println(MessageFormat.format(" {0} - {1}", k, v)));
    }
}
