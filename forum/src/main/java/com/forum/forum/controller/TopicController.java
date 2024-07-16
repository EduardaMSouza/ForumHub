package com.forum.forum.controller;

import com.forum.forum.dto.TopicDto;
import com.forum.forum.entity.Topic;
import com.forum.forum.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
@Validated
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    public ResponseEntity<Topic> cadastrarTopico(@RequestBody TopicDto topicDTO) {
        Topic topic = topicService.cadastrarTopico(topicDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(topic);
    }

    @GetMapping
    public ResponseEntity<List<TopicDto>> listTopics(Pageable pageable) {
        List<TopicDto> topics = topicService.listAllTopics(pageable);
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDto> getTopicById(@PathVariable Long id) {
        TopicDto topicDTO = topicService.getTopicById(id);
        if (topicDTO != null) {
            return ResponseEntity.ok(topicDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicDto> updateTopic(
            @PathVariable Long id,
            @RequestBody TopicDto topicDTO) {

        TopicDto updatedTopicDTO = topicService.updateTopic(id, topicDTO);

        if (updatedTopicDTO != null) {
            return ResponseEntity.ok(updatedTopicDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        boolean deleted = topicService.deleteTopic(id);

        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
