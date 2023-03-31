CREATE TABLE public."ability" (
	id            uuid    NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	"name"        varchar NOT NULL,
	"description" varchar NOT NULL
);