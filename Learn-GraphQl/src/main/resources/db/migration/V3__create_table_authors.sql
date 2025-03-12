create table authors (
    id serial primary key not null ,
    name varchar(255) not null ,
    slug varchar(255),
    email varchar(255) UNIQUE NOT NULL,
    gender varchar(50),
    created_at bigint,
    updated_at bigint,
    is_deleted bool default false
);
