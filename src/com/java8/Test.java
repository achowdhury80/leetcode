package com.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ayanc on 11/28/17.
 */
public class Test {
  public static void main(String[] args) throws IOException{
    Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");

    Supplier<Stream<String>> supplier = () -> Stream.of("java", "python", "node", null, "ruby", null, "php");

    List<String> result = language.collect(Collectors.toList());

    result.forEach(System.out::println);

  }
}
