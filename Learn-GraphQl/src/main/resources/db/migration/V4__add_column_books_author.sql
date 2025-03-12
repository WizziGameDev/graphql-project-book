alter table books add column author_id bigint;

alter table books add constraint fk_books_author foreign key (author_id) references authors(id) on delete cascade;