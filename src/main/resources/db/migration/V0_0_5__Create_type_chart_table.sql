CREATE TABLE public.type_chart (
	id uuid NOT NULL,
	dex_id uuid NOT NULL,
	attacking uuid NOT NULL,
	defending uuid NOT NULL,
	multiplier varchar NOT NULL DEFAULT 1,
	CONSTRAINT type_map_pk PRIMARY KEY (id),
	CONSTRAINT type_chart_fk FOREIGN KEY (dex_id) REFERENCES public.dex(id)
);