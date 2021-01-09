create database PiedraPapelTijeraBD;
use PiedraPapelTijeraBD;

SET GLOBAL time_zone = '-5:00';

create table Jugadores(
	idJugador int primary key auto_increment not null,
    nombreJugador varchar(50) not null,
    tipoJugador varchar(20) not null CHECK 
		(tipoJugador IN ('PERSONA', 'BOT'))
);

create table Partidas(
	idPartida int primary key auto_increment not null,
    tipoPartida varchar(10) not null CHECK 
				(tipoPartida IN ('JVJ', 'JVB','BVB')),
	puntosMax int not null,
    idGanadorPartida int 
);

create table Jugadores_Partida(
	idPartida int not null,
    idJugador int not null,
    primary key(idPartida, idJugador)
);

create table Rondas(
	idPartida int not null,
    nroRonda int not null,
    idGanadorRonda int,
    primary key(idPartida,nroRonda)
);

create table Jugadas(
    idPartida int not null,
    nroRonda int not null,
	idJugador int not null,
    opcionJugada varchar(20) not null CHECK 
				(opcionJugada IN ('ROCK',"PIEDRA", 'PAPER', "PAPEL",'SCISSORS', "TIJERAS")),
    primary key(idPartida,nroRonda,idJugador)
);

#CREANDO RELACIONES

ALTER TABLE Partidas ADD CONSTRAINT fk_Ganador_Partida
FOREIGN KEY(idGanadorPartida) REFERENCES Jugadores(idJugador)
ON UPDATE CASCADE ON DELETE CASCADE
;

ALTER TABLE Jugadores_Partida ADD CONSTRAINT fk_Jugadores_Participantes
FOREIGN KEY(idJugador) REFERENCES Jugadores(idJugador)
ON UPDATE CASCADE ON DELETE CASCADE,
ADD CONSTRAINT fk_Partida_Participantes
FOREIGN KEY(idPartida) REFERENCES Partidas(idPartida)
ON UPDATE CASCADE ON DELETE CASCADE
;

ALTER TABLE Rondas ADD CONSTRAINT fk_Partida_Rondas
FOREIGN KEY(idPartida) REFERENCES Partidas(idPartida)
ON UPDATE CASCADE ON DELETE CASCADE,
ADD CONSTRAINT fk_Ganador_Ronda
FOREIGN KEY(idPartida, idGanadorRonda) 
REFERENCES Jugadores_Partida(idPartida, idJugador)
ON UPDATE CASCADE ON DELETE CASCADE
;

ALTER TABLE Jugadas ADD CONSTRAINT fk_Ronda_Jugadas
FOREIGN KEY(idPartida,nroRonda) 
REFERENCES Rondas(idPartida,nroRonda)
ON UPDATE CASCADE ON DELETE CASCADE,
ADD CONSTRAINT fk_Participante_Jugadas
FOREIGN KEY(idPartida, idJugador) 
REFERENCES Jugadores_Partida(idPartida, idJugador)
ON UPDATE CASCADE ON DELETE CASCADE
;

#LLENADOS DE DATOS -------------- 5 INSERTS

insert into Jugadores(nombreJugador,tipoJugador) values
	("Melio Diaz","PERSONA"),
    ("Pablito BOT", "BOT"),
    ("Buenardo BOT", "BOT")
;

insert into Partidas(tipoPartida,puntosMax,idGanadorPartida) values
	("JvB",3,1),
    ("BvB",4,null)
;

insert into Jugadores_Partida values
	(1,1),
    (1,3),
    (2,2),
    (2,3)
;

insert into Rondas values
	(1,1,1),
	(1,2,null),
    (1,3,1),
    (1,4,3),
    (1,5,1),
    (2,1,null),
    (2,2,3),
    (2,3,3)
;

insert into Jugadas values
	(1,1,1,"ROCK"),
    (1,1,3,"SCISSORS"),
    (1,2,1,"ROCK"),
    (1,2,3,"ROCK"),
    (1,3,1,"PAPER"),
    (1,3,3,"ROCK"),
    (1,4,1,"ROCK"),
    (1,4,3,"PAPER"),
    (1,5,1,"SCISSORS"),
	(1,5,3,"PAPER"),
    (2,1,2,"ROCK"),
    (2,1,3,"ROCK"),
    (2,2,2,"ROCK"),
    (2,2,3,"PAPER"),
    (2,3,2,"SCISSORS"),
    (2,3,3,"ROCK")
;

#consultas GENERICAS
select * from Jugadores;
select * from Partidas;

select * from Jugadores_Partida;
select * from Rondas;
select * from Jugadas;

#CONSULTAS -------------------------- 4 CONSULTAS

#PARTICIPANTES DE UNA PARTIDA
select
	Jugadores.nombreJugador
from Jugadores_Partida
inner join Partidas on Jugadores_Partida.idPartida = Partidas.idPartida
inner join Jugadores on Jugadores_Partida.idJugador = Jugadores.idJugador
where Partidas.idPartida=1
;

#HISTORIAL DE UNA PARTIDA
select
	Partidas.idPartida,
    Rondas.nroRonda,
    Jugadores.nombreJugador
from Rondas
inner join Partidas on Rondas.idPartida = Partidas.idPartida
inner join Jugadores on (Rondas.idGanadorRonda <=> Jugadores.idJugador)
where Partidas.idPartida=1
order by Rondas.nroRonda 
;

#JUGADAS DE UNA RONDA
select
	Partidas.idPartida,
    Rondas.nroRonda,
    Jugadores.nombreJugador,
    Jugadas.opcionJugada
from Rondas
inner join Partidas on Rondas.idPartida = Partidas.idPartida
inner join Jugadores_Partida on Rondas.idPartida = Jugadores_Partida.idPartida
inner join Jugadores on Jugadores_Partida.idJugador = Jugadores.idJugador
inner join Jugadas on Partidas.idPartida = Jugadas.idPartida
					and Rondas.nroRonda = Jugadas.nroRonda
                    and Jugadores.idJugador = Jugadas.idJugador
where Partidas.idPartida=1 and Rondas.nroRonda=1 order by Partidas.idPartida
;

#SCORE DE LA PARTIDA---Partido 1, id 1 vs id 3
select
	Partidas.idPartida,
    count(case when Rondas.idGanadorRonda= '1' then 1 end) as marcadorJugador1,
    count(case when Rondas.idGanadorRonda= '3' then 1 end) as marcadorJugador2
from Rondas
inner join Partidas on Rondas.idPartida = Partidas.idPartida
inner join Jugadores on (Rondas.idGanadorRonda = Jugadores.idJugador)
inner join Jugadores_Partida on Rondas.idPartida = Jugadores_Partida.idPartida
							and (Rondas.idGanadorRonda = Jugadores_Partida.idJugador)
where Partidas.idPartida=1 
;

#UPDATES ---------------------------- 3 UPDATES
#cuidao, solo por este caso
SET SQL_SAFE_UPDATES = 0;
#cuidao, solo por este caso

update Jugadas set opcionJugada ="PIEDRA" where opcionJugada="ROCK";
update Jugadas set opcionJugada ="PAPEL" where opcionJugada="PAPER";
update Jugadas set opcionJugada ="TIJERAS" where opcionJugada="SCISSORS";
select * from Jugadas;

update Jugadas set opcionJugada="ROCK" where opcionJugada ="PIEDRA";
update Jugadas set opcionJugada="PAPER" where opcionJugada ="PAPEL";
update Jugadas set opcionJugada="SCISSORS" where opcionJugada ="TIJERAS";
select * from Jugadas;

#NO TE OLVIDES DE HACER ESTO
SET SQL_SAFE_UPDATES = 1;
#NO TE OLVIDES DE HACER ESTO