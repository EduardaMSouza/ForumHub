package com.forum.forum.dto;

import com.forum.forum.entity.Topic;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TopicDto {

    private Long id;

    private String title;

    private String message;

    private Long authorId;

    private Long courseId;

    private String creationDate;

    private String status;


    public static TopicDto fromEntity(Topic topic) {
        TopicDto dto = new TopicDto();
        dto.setId(topic.getId());
        dto.setTitle(topic.getTitle());
        dto.setMessage(topic.getMessage());
        dto.setCreationDate(topic.getCreationDate());
        dto.setStatus(topic.getStatus());
        dto.setAuthorId(topic.getAuthor().getId());
        dto.setCourseId(topic.getCourse().getId());
        return dto;
    }
}
