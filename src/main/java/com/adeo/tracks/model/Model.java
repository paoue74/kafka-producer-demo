package com.adeo.tracks.model;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Model {

  @Data
  @With
  @NoArgsConstructor
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Project {
    private int ttm;
    private String projectId;
    private String projectName;
    private String department;
    private String departmentCode;
  }

  @Data
  @With
  @NoArgsConstructor
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ArticleInfos {
    private int ttm;
    private String matrixId;
    private String projectId;
    private String department;
    private String departmentCode;
    private String subDepartment;
    private String subDepartmentCode;
  }

  @Data
  @With
  @NoArgsConstructor
  @AllArgsConstructor(access = AccessLevel.PRIVATE)
  public static class ArticleBUInfos {
    private String buId;
    private String projectId;
    private String matrixId;
    private int annualForecastSellout;
  }
}
