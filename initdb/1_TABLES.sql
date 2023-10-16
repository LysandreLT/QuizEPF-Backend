create table users
(
    id SERIAL PRIMARY KEY,
    first_name TEXT not null,
    last_name TEXT not null,
    password TEXT not null,
    email TEXT not null
);

create table quizzes
(
    id SERIAL PRIMARY KEY,
    name TEXT not null,
    create_by int not null
);

create table quiz_users
(
    id SERIAL PRIMARY KEY,
    quiz_id int not null,
    user_id int not null,
    score int not null
);

create table quiz_questions
(
    id SERIAL PRIMARY KEY,
    question TEXT not null,
    quiz_id int not null,
    question_type int not null,
    question_value int not null
);

create table quiz_answers
(
    id SERIAL PRIMARY KEY,
    quiz_question_id int not null,
    answer TEXT not null
);



