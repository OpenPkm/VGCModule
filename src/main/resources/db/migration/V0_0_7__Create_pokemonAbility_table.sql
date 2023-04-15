CREATE TABLE public."pokemon_ability" (
	id           uuid    NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	"pokemon_id" uuid    NOT NULL,
	ability_id   uuid    NOT NULL,
	hidden       boolean NOT NULL DEFAULT FALSE,
	CONSTRAINT ability_id_fk FOREIGN KEY (ability_id) REFERENCES public.ability(id)
);