-- Создание Пользователя для БД
CREATE ROLE asm WITH
	LOGIN
	SUPERUSER
	CREATEDB
	CREATEROLE
	INHERIT
	REPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'passwod';
-- Создание БД
CREATE DATABASE asm
    WITH 
    OWNER = asm
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
--!!!Выполнять запросы из созданной БД!!!
-- Создание Таблицы professions
CREATE TABLE public.professions
(
    id bigserial NOT NULL,
    profession_name character varying NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.professions
    OWNER to asm;
-- Создание Таблицы experience
CREATE TABLE public.experience
(
    id bigserial NOT NULL,
    profession_time smallint NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.experience
    OWNER to asm;
-- Создание Таблицы applicant
CREATE TABLE public.applicant
(
    id bigserial NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    middle_name character varying,
    age smallint NOT NULL,
    gender smallint NOT NULL,
    profession_id bigint NOT NULL,
    experience_id bigint NOT NULL,
    PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.applicant
    OWNER to asm;
--Создание связей
ALTER TABLE public.applicant
    ADD FOREIGN KEY (profession_id)
    REFERENCES public.professions (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;

ALTER TABLE public.applicant
    ADD FOREIGN KEY (experience_id)
    REFERENCES public.experience (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION;
-- Создание Таблицы emails
CREATE TABLE public.emails
(
    id bigserial NOT NULL,
    applicant_id bigint NOT NULL,
    email character varying NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (applicant_id)
        REFERENCES public.applicant (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.emails
    OWNER to asm;
-- Создание Таблицы phones
CREATE TABLE public.phones
(
    id bigserial NOT NULL,
    applicant_id bigint NOT NULL,
    "number" character varying NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (applicant_id)
        REFERENCES public.applicant (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
);

ALTER TABLE public.phones
    OWNER to asm;
-- Удаление БД
DROP DATABASE asm;
-- Удаление пользователя
DROP ROLE asm;