DROP  TABLE IF EXISTS "fields" CASCADE ;

CREATE TABLE "fields" (
                          id BIGSERIAL PRIMARY KEY,
                          "name" text
);


DROP TABLE IF EXISTS "students";

CREATE TABLE "students" (
                            id SERIAL PRIMARY KEY,
                            "name" text,
                            "latitude" decimal,
                            "longitude" decimal,
                            "field_id" BIGINT,
                            FOREIGN KEY (field_id) REFERENCES fields(id)
);

DROP TABLE IF EXISTS "companies" CASCADE ;

CREATE TABLE "companies" (
                             id SERIAL PRIMARY KEY,
                             "name" text,
                             "latitude" decimal,
                             "longitude" decimal
                         );

DROP TABLE IF EXISTS "field_company" CASCADE ;
CREATE TABLE field_company (
                               field_id BIGINT,
                               company_id BIGINT,
                               FOREIGN KEY (field_id) REFERENCES fields(id),
                               FOREIGN KEY (company_id) REFERENCES companies(id),
                               PRIMARY KEY (field_id, company_id)
);


DROP TABLE IF EXISTS "users";

CREATE TABLE "users" (
                         id SERIAL PRIMARY KEY,
                         "username" text,
                         "password" text,
                         "role" text
                     );

