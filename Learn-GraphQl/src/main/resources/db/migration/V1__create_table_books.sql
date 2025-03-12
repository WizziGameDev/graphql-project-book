create table books (
    id serial primary key ,
    slug varchar(25) not null,
    page int not null,
    created_at bigint not null,
    deleted boolean
)