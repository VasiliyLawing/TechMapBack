INSERT INTO students (name, latitude, longitude, field_id) VALUES
                                                            ('Test', 42.392574068021005, -87.97722454804106, 0),
                                                            ('Billy', 42.38083525124947, -87.98666242954418,  1);



INSERT INTO companies (name, latitude, longitude) VALUES
                                                            ('Apple', 42.38083525124947, -87.95866242954418),
                                                            ('Apple', 42.38083525124947, -87.95866242954418);

 INSERT INTO field_company (company_id, field_id) VALUES
                                                      (1, 0);

INSERT INTO users (username, password, role) VALUES
                                       ('admin', 'password', 'ADMIN');


--     ('NAme', 42.38083525124947, -87.98866242954418,  'Medical'),
--     ('Apple', 42.38083525124947, -87.95866242954418,  'Cyber'),
--     new Student("NAme", 42.38083525124947, -87.98866242954418,  "CyberSecurity")
INSERT INTO fields (id, name) VALUES
                                  (0, 'Cyber'),
                                  (1, 'Cooking');