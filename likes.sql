CREATE SCHEMA likes;
USE likes;
DROP SCHEMA likes;

CREATE TABLE likes (
	id BIGINT NOT NULL,
    likes BIGINT,
    dislikes BIGINT,
    PRIMARY KEY (id)
);

