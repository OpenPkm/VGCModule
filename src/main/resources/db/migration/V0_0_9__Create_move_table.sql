CREATE TABLE public."move" (
	id uuid NOT NULL,
	move_category_id uuid NOT NULL,
	type_id uuid NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT move_pk PRIMARY KEY (id),
	CONSTRAINT move__move_category__fk FOREIGN KEY (move_category_id) REFERENCES public.move_category(id),
	CONSTRAINT move__type___fk FOREIGN KEY (type_id) REFERENCES public."type"(id)
);