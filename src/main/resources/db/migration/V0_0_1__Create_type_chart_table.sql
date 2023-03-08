CREATE TABLE public.type_chart (
	id         uuid  NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	gen_id     uuid  NOT NULL,
	attacking  uuid  NOT NULL,
	defending  uuid  NOT NULL,
	multiplier float NOT NULL DEFAULT 1
);