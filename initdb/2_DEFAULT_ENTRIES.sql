-- USERS
-- TODO change user to accept hash for password instead of password in clear
INSERT INTO users (id, first_name, last_name, password, email) VALUES (1, 'test', 'test', 'root', 'test.test@test.com');
INSERT INTO users (id, first_name, last_name, password, email) VALUES (2, 'test2', 'test2', 'root', 'test2.test2@test.com');
INSERT INTO users (id, first_name, last_name, password, email) VALUES (3, 'test3', 'test3', 'root', 'test3.test3@test.com');

INSERT INTO quizzes(id, name, create_by) VALUES (1,'test',1);

INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (1,1,1,0);
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (2,1,2,120);
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (3,1,3,100);
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (4,1,1,2);
