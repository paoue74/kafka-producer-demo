package com.adeo.tracks.kafkaproducer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.With;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
//@Component
public class ProducerService {

//  private final KafkaTemplate<String, Project> kafkaTemplate;

//  public void send(Project payload) {
//    kafkaTemplate.send(PROJECTS_TOPIC, payload);
//  }
//
//
}
