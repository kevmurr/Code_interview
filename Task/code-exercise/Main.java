package com.company;

import java.util.*;

public class Main {

    static String defaultString = "(Hamburg, Germany, [1,2,3,4]); (Jeddah, Saudi-Arabia, [5,3,7,4]); (Singapore, Singapore, [2,3]); (Los Angeles, USA, [4,3,8,7])";

    // Read all steps before starting to implement:
    // 1. Please create a command-line application in an IDE of your choice
    // 2. Create a class to store a City, with an id, a name, a country and an ordered collection of Ratings (integers).
    //       The id should be unique for each city. Make sure that the values cannot be changed after creation, only additional ratings may be added.
    // 3. Create Instances of your Class from the String above [defaultSting] (the String format is fixed as is) and store them in a manner that allows access based on the id
    // 4. present 2 Ways to output the information of the Object to StdOut
    // 5. Finally, Sort the Cities based on the average rating and Print the Ranking in order starting with the highest average

    public static Map<Long, City> parseCities(String data) {
        Map<Long, City> cities = new HashMap<>();
        String[] cityArray = data.replace("(", "").replace(")", "").split("; ");
        Arrays.stream(cityArray).forEach(city -> {
            City createdCity = parseCity(city);
            cities.put(createdCity.getId(), createdCity);
        });
        return cities;
    }

    public static City parseCity(String data) {
        String[] cityProperties = data.split(", ");
        City c = new City(cityProperties[0], cityProperties[1]);
        String[] ratings = cityProperties[2].replace("[", "").replace("]", "").split(",");
        Arrays.stream(ratings).forEach(rating -> c.addRating(Integer.parseInt(rating)));
        return c;
    }

    public static void main(String[] args) {
        Map<Long, City> cities = parseCities(defaultString);
        System.out.println("-------------------");
        System.out.println(cities);
        System.out.println("-------------------");
        System.out.println(cities.get(1l));
        System.out.println("-------------------");
        cities.values().stream().forEach(System.out::println);

        List<City> citiesToBeOrdered = new ArrayList<>(cities.values());
        Collections.sort(citiesToBeOrdered, new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o2.getAverageRating().compareTo(o1.getAverageRating());
            }
        });

        System.out.println("-----------After sorting-----------");
        citiesToBeOrdered.forEach(System.out::println);

    }
}