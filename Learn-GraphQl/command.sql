delete from books;
delete from authors;

INSERT INTO authors (name, slug, email, gender, created_at, updated_at, is_deleted) VALUES
                                                                                        ('John Doe', 'john-doe', 'johndoe@example.com', 'Male', 1710172800000, 1710172800000, false),
                                                                                        ('Jane Smith', 'jane-smith', 'janesmith@example.com', 'Female', 1710172800000, 1710172800000, false),
                                                                                        ('Alice Brown', 'alice-brown', 'alicebrown@example.com', 'Female', 1710172800000, 1710172800000, false),
                                                                                        ('Bob Johnson', 'bob-johnson', 'bobjohnson@example.com', 'Male', 1710172800000, 1710172800000, false),
                                                                                        ('Charlie White', 'charlie-white', 'charliewhite@example.com', 'Male', 1710172800000, 1710172800000, false);

INSERT INTO books (slug, name, page, created_at, deleted, author_id) VALUES
                                                                         ('mastering-java', 'Mastering Java', 300, 1710172800000, false, 8),
                                                                         ('graphql-guide', 'GraphQL Guide', 250, 1710172800000, false, 9),
                                                                         ('modern-sql', 'Modern SQL', 320, 1710172800000, false, 10),
                                                                         ('docker-for-devs', 'Docker for Developers', 150, 1710172800000, false, 11),
                                                                         ('spring-boot', 'Spring Boot in Action', 500, 1710172800000, false, 12),
                                                                         ('python-essentials', 'Python Essentials', 200, 1710172800000, false, 8),
                                                                         ('data-structures', 'Data Structures and Algorithms', 400, 1710172800000, false, 9),
                                                                         ('clean-architecture', 'Clean Architecture', 350, 1710172800000, false, 10),
                                                                         ('microservices-design', 'Microservices Design Patterns', 280, 1710172800000, false, 11),
                                                                         ('advanced-kubernetes', 'Advanced Kubernetes', 450, 1710172800000, false, 12);


select * from books;
select * from authors;