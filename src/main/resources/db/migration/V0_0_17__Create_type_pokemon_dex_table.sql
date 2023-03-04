CREATE TABLE public.type_pokemon_dex (
	id uuid NOT NULL,
	pokemon_dex_id uuid NOT NULL,
	main_type_id uuid NOT NULL,
	secondary_type_id uuid NULL,
	CONSTRAINT type_pokemon_dex_pk PRIMARY KEY (id),
	CONSTRAINT type_pokemon_dex_fk FOREIGN KEY (pokemon_dex_id) REFERENCES public.pokemon_dex(id),
	CONSTRAINT type_pokemon_dex_fk_1 FOREIGN KEY (main_type_id) REFERENCES public."type"(id),
	CONSTRAINT type_pokemon_dex_fk_2 FOREIGN KEY (secondary_type_id) REFERENCES public."type"(id)
);