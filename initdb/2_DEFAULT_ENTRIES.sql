-- USERS
-- TODO change user to accept hash for password instead of password in clear

INSERT INTO users (id, first_name, last_name, password, email) VALUES (1, 'test', 'test', 'root', 'test.test@test.com');
/*INSERT INTO users (id, first_name, last_name, password, email) VALUES (2, 'test2', 'test2', 'root', 'test2.test2@test.com');
INSERT INTO users (id, first_name, last_name, password, email) VALUES (3, 'test3', 'test3', 'root', 'test3.test3@test.com');

INSERT INTO quizzes(id, name, created_by) VALUES (1,'quiz1',1);
INSERT INTO quizzes(id, name, created_by) VALUES (2,'quiz2',1);

-- user 1 for quizz 1 and 2 (quiz1: pos 2 score : 120, quizz2: pos 1 score : 120)
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (1,1,1,120);
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (2,2,1,120);

-- user 2 for quizz 1 and 2 (quiz1: pos 1, quizz2: pos 2)
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (3,1,2,300);
INSERT INTO quiz_users(id, quiz_id, user_id, score) VALUES (4,2,2,10);

--questions qcm 1 a 2
INSERT INTO quiz_questions(id, question, quiz_id, question_type, question_value) VALUES (1,'quelle est la capitale de la France?', 1,1,50);
INSERT INTO quiz_questions(id, question, quiz_id, question_type, question_value) VALUES (2,'quelle est la capitale de l Espagne?', 1,1,50);

--questions single 3
INSERT INTO quiz_questions(id, question, quiz_id, question_type, question_value) VALUES (3,'quelle est la capitale de l Allemagne?', 1,0,50);

--questions writen 4 et 5
INSERT INTO quiz_questions(id, question, quiz_id, question_type, question_value) VALUES (4,'quelle est la capitale de la France?', 1,2,50);
INSERT INTO quiz_questions(id, question, quiz_id, question_type, question_value) VALUES (5,'sport tres populaire dans le monde',1,2,50);

--question1
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (1,1,'PARIS',true);
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (2,1,'LYON',false);
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (3,1,'MARSEILLES',false);

--question2
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (4,2,'BARCELONA',false);
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (5,2,'MADRID',true);
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (6,2,'VALENCE',false);

--question3
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (7,3,'DUBLIN',false);
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (8,3,'BERLIN',true);
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (9,3,'MUNICH',false);

--question4
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (10,4,'PARIS',true);
INSERT INTO quiz_answers(id, quiz_question_id, answer, is_true) VALUES (11,5,'FOOTBALL',true);*/