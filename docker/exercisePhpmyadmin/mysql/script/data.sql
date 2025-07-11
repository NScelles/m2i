USE myapp;

INSERT INTO users (name, email)
VALUES ('Test', 'test@example.com')
ON DUPLICATE KEY UPDATE email = VALUES(email);

INSERT INTO users (name, email)
VALUES ('cool', 'bicule@example.com')
ON DUPLICATE KEY UPDATE email = VALUES(email);

INSERT INTO users (name, email)
VALUES ('testest', 'testest@example.com')
ON DUPLICATE KEY UPDATE email = VALUES(email);