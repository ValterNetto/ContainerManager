CREATE DATABASE t2s_teste;
USE t2s_teste;
CREATE TABLE container(
id_container int auto_increment,
cliente varchar(60),
num_container varchar(11),
tipo int,
status_container varchar(6),
categoria varchar(20)
);

CREATE TABLE movement(
id_movement int auto_increment,
id_container_movement varchar(11),
tipo_movement varchar(6),
hora_inicio datetime,
hora_inicio datetime,
FOREIGN KEY (id_container_movemente) REFERENCES container (id_container)
);


USE t2s_teste;

SELECT * FROM container;
SELECT * FROM movement;
SELECT * FROM container INNER JOIN movement ON container.id_container = movement.id_container_movement;

INSERT INTO movement (id_container_movement, tipo_mov, hora_inicio, hora_fim) VALUES (53, "Gate In", '2023-09-05 14:41:00', '2023-09-05 14:42:00');