INSERT INTO fields (id, name) VALUES
                                  (0, 'Cyber'),
                                  (1, 'Cooking');

INSERT INTO students (name, latitude, longitude, field_id) VALUES
                                                               ('Test', 42.392574068021005, -87.97722454804106, 1),
                                                               ('Billy', 42.38083525124947, -87.98666242954418,  1);

INSERT INTO schools (name, latitude, longitude) VALUES
                                                               ('Warren', 42.392574068021005, -87.97722454804106),
                                                               ('Highland Park', 42.38083525124947, -87.98666242954418);


INSERT INTO companies (name, latitude, longitude) VALUES
                                                            ('Apple', 42.38083525124947, -87.95866242954418),
                                                            ('Apple', 42.38083525124947, -87.95866242954418);

INSERT INTO field_company (company_id, field_id) VALUES
    (1, 1);

INSERT INTO companies (name, latitude, longitude) VALUES
                                                            ('Apple', 42.38083525124947, -87.95866242954418),
                                                            ('Apple', 42.38083525124947, -87.95866242954418);

INSERT INTO field_company (company_id, field_id) VALUES
    (1, 1);

-- INSERT INTO users (username, password, role) VALUES
--     ('admin', 'password', 'ADMIN');
--
