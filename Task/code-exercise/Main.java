package com.hlag;

import com.hlag.model.City;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  static String defaultString =
      "(Hamburg, Germany, [1,2,3,4]); (Jeddah, Saudi-Arabia, [5,3,7,4]); (Singapore, Singapore, [2,3]); (Los Angeles, USA, [4,3,8,7])";

  public static void main(String[] args) {
    // Read all steps before starting to implement:
    // 1. Please create a command-line application in an IDE of your choice
    // 2. Create a class to store a City, with an id, a name, a country and an ordered collection of
    // Ratings (integers).
    //       The id should be unique for each city. Make sure that the values cannot be changed
    // after creation, only additional ratings may be added.
    // 3. Create Instances of your Class from the String above [defaultSting] (the String format is
    // fixed as is) and store them in a manner that allows access based on the id
    Map<UUID, City> cityMap = parseString();
    // 4. present 2 Ways to output the information of the Object to StdOut
    System.out.println(cityMap);
    for (Entry<UUID, City> entry : cityMap.entrySet()) {
      System.out.println(entry.getValue());
    }
    // 5. Finally, Sort the Cities based on the average rating and Print the Ranking in order
    // starting with the highest average
    cityMap.values().stream()
        .sorted((o1, o2) -> o2.getAverageRating().compareTo(o1.getAverageRating()))
        .forEach(System.out::println);
  }

  private static Map<UUID, City> parseString() {
    Pattern pattern = Pattern.compile("\\((.+)\s(.+)\s\\[(.+)\\]\\)");
    String[] objects = defaultString.split(";");

    Map<UUID, City> cityMap = new HashMap<>();
    for (String object : objects) {
      String objectM = object.trim();
      Matcher m = pattern.matcher(objectM);
      if (m.find()) {
        String name = m.group(1);
        String country = m.group(2);
        City city = new City(name, country);
        Arrays.stream(m.group(3).split(",")).map(Integer::parseInt).forEach(city::addRatings);

        cityMap.put(city.getId(), city);
      }
    }
    return cityMap;
  }
}
