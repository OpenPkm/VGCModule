CREATE TABLE public.move_dex (
	id uuid NOT NULL,
	move_id uuid NOT NULL,
	dex_id uuid NOT NULL,
	description varchar NOT NULL,
	pp int2 NOT NULL,
	base_power int4 NOT NULL,
	accuracy int4 NOT NULL,
	side_effect varchar NULL,
	base_critical_hit_rate float8 NOT NULL,
	speed_priority int2 NOT NULL DEFAULT 0,
	tm_hm varchar NULL,
	CONSTRAINT move_dex_pk PRIMARY KEY (id),
	CONSTRAINT move_dex_fk FOREIGN KEY (move_id) REFERENCES public."move"(id),
	CONSTRAINT move_dex_fk_1 FOREIGN KEY (dex_id) REFERENCES public.dex(id)
);