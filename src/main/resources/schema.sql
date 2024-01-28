DROP  TABLE IF EXISTS "fields" CASCADE ;

DROP TABLE IF EXISTS "students";

DROP TABLE IF EXISTS "companies" CASCADE ;

DROP TABLE IF EXISTS "field_company" CASCADE ;

DROP TABLE IF EXISTS "users";

CREATE TABLE fields (
                        id BIGSERIAL PRIMARY KEY,
                        name TEXT
);

CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          name TEXT,
                          latitude DOUBLE PRECISION,
                          longitude DOUBLE PRECISION,
                          field_id BIGINT,
                          FOREIGN KEY (field_id) REFERENCES fields(id)
);

CREATE TABLE companies (
                           id SERIAL PRIMARY KEY,
                           name TEXT,
                           latitude DOUBLE PRECISION,
                           longitude DOUBLE PRECISION
);

CREATE TABLE field_company (
                               company_id BIGINT,
                               field_id BIGINT,

                               FOREIGN KEY (company_id) REFERENCES companies(id),
                               FOREIGN KEY (field_id) REFERENCES fields(id),
                               PRIMARY KEY (company_id, field_id)
);


CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username TEXT,
                       password TEXT,
                       role TEXT
);