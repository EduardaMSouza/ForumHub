CREATE TABLE IF NOT EXISTS reply (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       message TEXT NOT NULL,
                       topic_id BIGINT NOT NULL,
                       creation_date TIMESTAMP NOT NULL,
                       author_id BIGINT NOT NULL,
                       solution BOOLEAN NOT NULL,
                       FOREIGN KEY (topic_id) REFERENCES topic(id),
                       FOREIGN KEY (author_id) REFERENCES user(id)
);
