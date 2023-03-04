CREATE TABLE public."type" (
	id uuid NOT NULL,
	"name" varchar NOT NULL,
	background_color varchar NOT NULL,
	foreground_color varchar NOT NULL,
	CONSTRAINT type_pk PRIMARY KEY (id)
);