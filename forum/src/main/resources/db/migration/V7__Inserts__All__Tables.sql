INSERT INTO course (name, category) VALUES
                                        ('Music'),
                                        ('Sports');

INSERT INTO profile (name) VALUES
                               ('pro_02'),
                               ('pro_837284'),
                               ('Pro_din');

INSERT INTO user (name, email, password) VALUES
                                             ('João Silva', 'joao.silva@example.com', '$2a$12$y07IGC2NsnCvPIJ2DGV1Zuxg/YbCHzsAy5G6GCasrxdMiI72eT3WO'),
                                             ('Maria Souza', 'maria.souza@example.com', '$2a$12$btyuBw1EwG8wXCDXBcUff.e0ydQxuFsTrST9CGKmuNxgqHKhYLJem'),
                                             ('Carlos Oliveira', 'carlos.oliveira@example.com', '$2a$12$qvVVFgodZ50Ufnt4xi8Qz.TKEgWyS.LafiHP3C8R9JHvq5XkiSGb.'),
                                             ('Ana Santos', 'ana.santos@example.com', '$2a$12$xtCXzRVdslrNlX30HIE6z.hkGXumXfAC2u47.csx22KwDqhgM9uPi');
/*senha123, senha456, senha789, senha987*/

INSERT INTO user_profile (user_id, profile_id) VALUES
                                                   (1, 1),
                                                   (2, 2),
                                                   (3, 3),
                                                   (4, 3);

INSERT INTO topic (title, message, creation_date, status, author_id, course_id) VALUES
                                                                                    ('Music', NOW(), 'OPEN', 1, 1),
                                                                                    ('Sports', 'Could someone help me with Hibernate configuration?', NOW(), 'OPEN', 2, 2);

INSERT INTO reply (message, topic_id, creation_date, author_id, solution) VALUES
                                                                              ('Reply', 1, NOW(), 3, false),
                                                                              ('Reply 2', 1, NOW(), 4, true),
                                                                              ('Reply 3', 2, NOW(), 3, true);
