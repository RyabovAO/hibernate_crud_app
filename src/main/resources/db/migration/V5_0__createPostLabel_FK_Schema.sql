ALTER TABLE postLabel
ADD CONSTRAINT post_fk
FOREIGN KEY (post_id) REFERENCES post(id);

ALTER TABLE postLabel
ADD CONSTRAINT label_fk
FOREIGN KEY (label_id) REFERENCES label(id);
