-- USERS
-- TODO change user to accept hash for password instead of password in clear

INSERT INTO users (id, first_name, last_name, password, email) VALUES (1, 'test', 'test', 'root', 'test.test@test.com');
INSERT INTO users (id, first_name, last_name, password, email) VALUES (2, 'test2', 'test2', 'root', 'test2.test2@test.com');
INSERT INTO users (id, first_name, last_name, password, email) VALUES (3, 'test3', 'test3', 'root', 'test3.test3@test.com');

INSERT INTO quizzes(id, name, created_by) VALUES (1,'quiz1',1);
INSERT INTO quizzes(id, name, created_by) VALUES (2,'quiz2',1);

-- user 1 for quizz 1 and 2 (quiz1: pos 2 score : 120, quizz2: pos 1 score : 120)
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (1,1,1,120);
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (2,2,1,120);

-- user 2 for quizz 1 and 2 (quiz1: pos 1, quizz2: pos 2)
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (3,1,2,300);
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (4,2,2,10);