CREATE TABLE public.pokemon (
	id uuid NOT NULL,
	national_dex_no int4 NOT NULL,
	"name" varchar NOT NULL,
	classification varchar NOT NULL,
	weight float8 NOT NULL,
	height float8 NOT NULL,
	female_ratio varchar NULL,
	CONSTRAINT pokemon_pk PRIMARY KEY (id)
);