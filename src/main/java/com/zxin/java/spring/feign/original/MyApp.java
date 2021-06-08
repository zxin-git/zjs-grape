package com.zxin.java.spring.feign.original;

import feign.Feign;
import feign.Logger;
import feign.jackson.JacksonDecoder;

import java.util.List;


public class MyApp {
  public static void main(String... args) {
    GitHub github = Feign.builder()
            .logLevel(Logger.Level.FULL)
            .logger(new FeignSlf4jLogger())
            .decoder(new JacksonDecoder())
            .target(GitHub.class, "https://api.github.com");

    // Fetch and print a list of the contributors to this library.
    List<GitHub.Contributor> contributors = github.contributors("OpenFeign", "feign");
    for (GitHub.Contributor contributor : contributors) {
      System.out.println(contributor.login + " (" + contributor.contributions + ")");
    }
  }

}