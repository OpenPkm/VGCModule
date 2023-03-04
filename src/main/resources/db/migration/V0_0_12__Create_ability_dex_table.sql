CREATE TABLE public.ability_dex (
	id uuid NOT NULL,
	ability_id uuid NOT NULL,
	dex_id uuid NOT NULL,
	description varchar NOT NULL,
	CONSTRAINT ability_dex_pk PRIMARY KEY (id),
	CONSTRAINT ability_dex_fk FOREIGN KEY (dex_id) REFERENCES public.dex(id),
	CONSTRAINT ability_dex_fk1 FOREIGN KEY (ability_id) REFERENCES public.ability(id)
);