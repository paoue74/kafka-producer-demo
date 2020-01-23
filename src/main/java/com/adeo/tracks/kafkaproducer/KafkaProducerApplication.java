package com.adeo.tracks.kafkaproducer;

import com.adeo.tracks.model.Model;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

@Slf4j
@SpringBootApplication
public class KafkaProducerApplication {

  private static final String PROJECTS_TOPIC = "plm_projects";
  private static final String PRODUCTS_TOPIC = "plm_articles";
  private static final String BU_TOPIC = "plm_bu_articles";

  public static void main(String[] args) {
    SpringApplication.run(KafkaProducerApplication.class, args);
  }

  @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
  @Bean
  ApplicationRunner applicationRunner(KafkaTemplate<String, Object> kafkaTemplate) {
    return args -> {
      while (true) {
        Thread.sleep(1000);
        String projectId = "3b5c024c-3372-4fc6-a4f1-049ce36a568a"; // UUID.randomUUID().toString();
        log.info("projectId : {}", projectId);
        kafkaTemplate.send(
            PROJECTS_TOPIC,
            new Model.Project()
                .withProjectId(projectId)
                .withDepartment("WOODS")
                .withProjectName(projectId + " Test")
                .withDepartmentCode("02")
        );
        Thread.sleep(2000);
        String matrixId = "fc6c2a91-66ba-4c64-a871-33facf7cd1be"; //UUID.randomUUID().toString();
        log.info("articles : {}", matrixId);
        kafkaTemplate.send(
            PRODUCTS_TOPIC,
            new Model.ArticleInfos()
                .withProjectId(projectId)
                .withMatrixId(matrixId)
                .withDepartmentCode("02")
        );

        Thread.sleep(2000);
        log.info("articles BU : {}", projectId, matrixId);
        kafkaTemplate.send(
            BU_TOPIC,
            new Model.ArticleBUInfos()
                .withProjectId(projectId)
                .withMatrixId(matrixId)
                .withBuId("2")
                .withAnnualForecastSellout(125)
        );
      }
    };
  }
}
