DROP TABLE IF EXISTS student CASCADE;

CREATE TABLE student
(
    id            bigint auto_increment primary key,
    first_name    varchar(255) not null,
    last_name     varchar(255) not null,
    date_of_birth date         not null,
    gender        varchar(1)   not null,
    address       varchar(255) not null
);