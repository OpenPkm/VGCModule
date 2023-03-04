CREATE TABLE public.stats_pokemon_dex (
	id uuid NOT NULL,
	stats_id uuid NOT NULL,
	value int2 NOT NULL,
	pokemon_dex_id uuid NOT NULL,
	CONSTRAINT stats_pokemon_dex_pk PRIMARY KEY (id),
	CONSTRAINT stats_pokemon_dex_fk FOREIGN KEY (stats_id) REFERENCES public.stats(id),
	CONSTRAINT stats_pokemon_dex_fk2 FOREIGN KEY (pokemon_dex_id) REFERENCES public.pokemon_dex(id)
);