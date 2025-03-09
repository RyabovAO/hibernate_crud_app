CREATE TABLE IF NOT EXISTS post (
    id int NOT NULL PRIMARY KEY,
    content varchar(255),
    created varchar(255),
    updated varchar(255),
    writer_id int,
    post_status varchar(255)
);