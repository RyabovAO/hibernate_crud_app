CREATE TABLE IF NOT EXISTS labels (
    id int NOT NULL serial PRIMARY KEY,
    name varchar(255)
);

CREATE TABLE IF NOT EXISTS writers (
    id int NOT NULL serial PRIMARY KEY,
    fist_name varchar(255),
    last_name varchar(255)
);

CREATE TABLE IF NOT EXISTS posts (
    id int NOT NULL serial PRIMARY KEY,
    content varchar(255),
    created varchar(255),
    updated varchar(255),
    writer_id int,
    post_status varchar(255),
    FOREIGN KEY (writer_id) REFERENCES writers(id);
);

CREATE TABLE IF NOT EXISTS post_label (
    post_id int NOT NULL,
    label_id int NOT NULL,
    FOREIGN KEY (post_id) REFERENCES posts(id),
    FOREIGN KEY (label_id) REFERENCES labels(id)
    UNIQUE(post_id, label_id)
);