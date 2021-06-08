package com.zxin.java.spring.feign.original;

import feign.Headers;
import feign.Param;
import feign.QueryMap;
import feign.RequestLine;
import lombok.Data;

import java.util.List;
import java.util.Map;

public interface GitHub {

  @RequestLine("GET /repos/{owner}/{repo}/contributors")
  List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

  @RequestLine("POST /repos/{owner}/{repo}/issues")
  @Headers("Content-Type: application/json")
  void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);

  @RequestLine("GET /find")
  String find(@QueryMap Map<String, Object> queryMap);

  @Data
  class Contributor {
    String login;
    int contributions;
  }

  @Data
  class Issue {
    String title;
    String body;
    List<String> assignees;
    int milestone;
    List<String> labels;
  }


}