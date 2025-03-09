CREATE TABLE IF NOT EXISTS postLabel (
    post_id int NOT NULL,
    label_id int NOT NULL,
    primary key(post_id, label_id)
);
