CREATE TABLE IF NOT EXISTS topic (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       message TEXT NOT NULL,
                       creation_date TIMESTAMP NOT NULL,
                       status VARCHAR(50) NOT NULL,
                       author_id BIGINT NOT NULL,
                       course_id BIGINT NOT NULL,
                       FOREIGN KEY (author_id) REFERENCES user(id),
                       FOREIGN KEY (course_id) REFERENCES course(id)
);
