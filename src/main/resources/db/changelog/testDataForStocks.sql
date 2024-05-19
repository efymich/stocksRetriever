--liquibase formatted sql

--changeset user:testData_001 runOnChange:true splitStatements:false
INSERT INTO public.stocks (ticker) VALUES ('AAPL');
INSERT INTO public.stocks (ticker) VALUES ('GOOGL');
INSERT INTO public.stocks (ticker) VALUES ('AMZN');
INSERT INTO public.stocks (ticker) VALUES ('GOOG');
INSERT INTO public.stocks (ticker) VALUES ('FB');
INSERT INTO public.stocks (ticker) VALUES ('MSFT');
INSERT INTO public.stocks (ticker) VALUES ('TSLA');
INSERT INTO public.stocks (ticker) VALUES ('NFLX');
INSERT INTO public.stocks (ticker) VALUES ('NVDA');
INSERT INTO public.stocks (ticker) VALUES ('BABA');
INSERT INTO public.stocks (ticker) VALUES ('JPM');
INSERT INTO public.stocks (ticker) VALUES ('V');
INSERT INTO public.stocks (ticker) VALUES ('WMT');
INSERT INTO public.stocks (ticker) VALUES ('DIS');
INSERT INTO public.stocks (ticker) VALUES ('PFE');
INSERT INTO public.stocks (ticker) VALUES ('KO');
INSERT INTO public.stocks (ticker) VALUES ('MCD');
INSERT INTO public.stocks (ticker) VALUES ('NKE');
INSERT INTO public.stocks (ticker) VALUES ('INTC');
INSERT INTO public.stocks (ticker) VALUES ('CSCO');
