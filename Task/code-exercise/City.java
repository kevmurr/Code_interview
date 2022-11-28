package com.company;

// 2. Create a class to store a City, with an id, a name, a country and an ordered collection of Ratings (integers).
//       The id should be unique for each city. Make sure that the values cannot be changed after creation, only additional ratings may be added.

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class City {
    private static Long SEQUENCE_CITY = 0l;

    private final Long id;
    private final String name;
    private final String country;
    private final List<Integer> ratings;

    public City(String name, String country) {
        this.name = name;
        this.country = country;
        this.id = SEQUENCE_CITY++;
        this.ratings = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void addRating(Integer rating) {
        this.ratings.add(rating);
        //Collections.sort(this.ratings, Comparator.reverseOrder());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", avgRating='" + getAverageRating() + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", ratings=" + ratings +
                '}';
    }

    public BigDecimal getAverageRating() {
        if (this.ratings.size() > 0) {
            BigDecimal sum = new BigDecimal(this.ratings.stream().mapToInt(i -> i).sum());
            return sum.divide(new BigDecimal(this.ratings.size()));
        }
        return BigDecimal.ZERO;
    }
}

