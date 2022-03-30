drop table if exists author;


create table if not exists author
(
    id        integer primary key autoincrement,
    full_name text,
    birthdate text
);

insert into author (full_name, birthdate)
values ('Elmurodov Javohir', '1995-01-23'),
       ('Hakimova Farangiz', '1996-01-01');

