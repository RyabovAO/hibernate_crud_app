ALTER TABLE post
ADD CONSTRAINT post_writer_fk
FOREIGN KEY (writer_id) REFERENCES writer(id);