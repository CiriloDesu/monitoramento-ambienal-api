CREATE TABLE tbl_alertas(
    id_alerta BIGINT(20) NOT NULL AUTO_INCREMENT,
    numero_alerta BIGINT(20) NOT NULL,
    local_alerta" VARCHAR(100) NULL,
    status_alerta VARCHAR(20) NOT NULL,
    data_alerta DATE NULL,
    PRIMARY KEY (numero_alerta)
);