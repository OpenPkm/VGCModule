CREATE TABLE public.type_chart (
	id         uuid    NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	dex_id     uuid    NOT NULL,
	attacking  uuid    NOT NULL,
	defending  uuid    NOT NULL,
	multiplier varchar NOT NULL DEFAULT 1
);