package com.hlag.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class City {
  private UUID id;
  private String name;
  private String country;
  private List<Integer> ratings;

  public City(String name, String country) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.country = country;
    this.ratings = new ArrayList<>();
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }

  public List<Integer> getRatings() {
    return new ArrayList<>(ratings);
  }

  public void addRatings(Integer rating) {
    this.ratings.add(rating);
  }

  public BigDecimal getAverageRating() {
    int totalValue = ratings.stream().mapToInt(Integer::intValue).sum();
    return ratings.size() == 0
        ? BigDecimal.ZERO
        : BigDecimal.valueOf(totalValue)
            .divide(BigDecimal.valueOf(ratings.size()), RoundingMode.HALF_UP);
  }

  @Override
  public String toString() {
    return "City{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", country='"
        + country
        + '\''
        + ", ratings="
        + ratings
        + '}';
  }
}
