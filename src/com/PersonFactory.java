package com;

/**
 * Created by ayanc on 6/3/17.
 */
public interface PersonFactory<P extends Person> {
  P create(String firstName, String lastName);
}
