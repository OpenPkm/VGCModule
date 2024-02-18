CREATE TABLE public."type_chart_generation" (
	id           uuid        NOT NULL DEFAULT gen_random_uuid() PRIMARY KEY,
	"generation" VARCHAR(20) NOT NULL
);