DROP TABLE IF EXISTS "students";

-- DROP SEQUENCE IF EXISTS "students_id_seq";
-- CREATE SEQUENCE students_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "students" (
                            id SERIAL PRIMARY KEY,
                            "name" text,
                            "latitude" decimal,
                            "longitude" decimal,
                            "field" text
);

DROP TABLE IF EXISTS "companies";

-- DROP SEQUENCE IF EXISTS "companies_id_seq";
-- CREATE SEQUENCE companies_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "companies" (
                             id SERIAL PRIMARY KEY,
                             "name" text,
                             "latitude" decimal,
                             "longitude" decimal,
                             "field" text
                         );

