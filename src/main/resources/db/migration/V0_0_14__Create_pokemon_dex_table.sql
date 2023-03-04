CREATE TABLE public.pokemon_dex (
	id uuid NOT NULL,
	pokemon_id uuid NOT NULL,
	dex_id uuid NOT NULL,
	"no" int4 NOT NULL,
	description varchar NOT NULL,
	hidden_ability_id uuid NULL,
	CONSTRAINT pokemon_dex_pk PRIMARY KEY (id),
	CONSTRAINT pokemon_dex__pokemon__fk FOREIGN KEY (pokemon_id) REFERENCES public.pokemon(id) DEFERRABLE,
	CONSTRAINT pokemon_dex_fk FOREIGN KEY (hidden_ability_id) REFERENCES public.ability_dex(id)
);