package com.forum.forum.service;

import com.forum.forum.dto.TopicDto;
import com.forum.forum.entity.Course;
import com.forum.forum.entity.Topic;
import com.forum.forum.entity.User;
import com.forum.forum.repository.TopicRepository;
import com.forum.forum.repository.UserRepository;
import com.forum.forum.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Topic cadastrarTopico(TopicDto topicDTO) {

        User author = userRepository.findById(topicDTO.getAuthorId())
                .orElseThrow(() -> new IllegalArgumentException("Autor não encontrado"));

        Course course = courseRepository.findById(topicDTO.getCourseId())
                .orElseThrow(() -> new IllegalArgumentException("Curso não encontrado"));

        if (topicRepository.findByTitleAndMessage(topicDTO.getTitle(), topicDTO.getMessage()).isPresent()) {
            throw new IllegalArgumentException("Já existe um tópico com este título e mensagem.");
        }

        Topic topic = new Topic();
        topic.setTitle(topicDTO.getTitle());
        topic.setMessage(topicDTO.getMessage());
        topic.setCreationDate(LocalDateTime.now().toString());
        topic.setStatus("OPEN");
        topic.setAuthor(author);
        topic.setCourse(course);
        Topic topic1 = topicRepository.save(topic);
        topic.setId(topic1.getId());
        return topic;
    }


    public List<TopicDto> listAllTopics(Pageable pageable) {
        Page<Topic> topicsPage = topicRepository.findAll(pageable);
        return topicsPage.getContent().stream()
                .map(TopicDto::fromEntity)
                .collect(Collectors.toList());
    }

    public TopicDto getTopicById(Long id) {
        Topic topic = topicRepository.findById(id).orElse(null);
        if (topic != null) {
            return TopicDto.fromEntity(topic);
        } else {
            return null;
        }
    }

    public TopicDto updateTopic(Long id, TopicDto topicDTO) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            Topic topic = optionalTopic.get();
            topic.setTitle(topicDTO.getTitle());
            topic.setMessage(topicDTO.getMessage());

            topic = topicRepository.save(topic);

            return TopicDto.fromEntity(topic);
        } else {
            return null;
        }
    }

    public boolean deleteTopic(Long id) {
        Optional<Topic> optionalTopic = topicRepository.findById(id);

        if (optionalTopic.isPresent()) {
            topicRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
