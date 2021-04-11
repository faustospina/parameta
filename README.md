# parameta
employees files

# JAVA VERSION 1.0.8

#docker y base de datos

Docker Postgres
	docker comandos

	docker version
	docker pull postgres:10.9-alpine
	docker images
	docker run -d --name postgres -e POSTGRES_PASSWORD=qwer12345 -p 5432:5432 postgres:10.9-alpine
	docker ps -a
	docker start (id de la imagen)
	
2 descargar PGadmin 4 https://www.postgresql.org/ftp/pgadmin/pgadmin4/v4.29/windows/
3 configurar las conexiones previamente aclarada en el numeral 1
4 cread la siguiente tabla en el schema public
5 
CREATE TABLE public.employee
(
    id uuid NOT NULL,
    nombres character varying COLLATE pg_catalog."default",
    apellidos character varying COLLATE pg_catalog."default",
    tipo_documento character varying COLLATE pg_catalog."default",
    numero_documento character varying COLLATE pg_catalog."default",
    fecha_nacimiento date,
    fecha_vinculacion date,
    cargo character varying COLLATE pg_catalog."default",
    salario double precision,
    CONSTRAINT employee_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;

6 run GRADLE proyect en intellij

8 dejo la coleccion de postman y el archivo de SOAP para consumir dentro de la carpeta src/integrationTest