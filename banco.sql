CREATE DATABASE IF NOT EXISTS controle_estoque;

USE controle_estoque;

CREATE TABLE IF NOT EXISTS categoria (
    id_categoria INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tamanho ENUM('PEQUENO', 'MEDIO', 'GRANDE') NOT NULL,
    embalagem ENUM('LATA', 'VIDRO', 'PLASTICO') NOT NULL,
    PRIMARY KEY (id_categoria)
);

CREATE TABLE IF NOT EXISTS produto (
    id_produto INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    unidade VARCHAR(10) NOT NULL,
    qtd_estoque INT NOT NULL,
    qtd_minima INT NOT NULL,
    qtd_maxima INT NOT NULL,
    id_categoria INT,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
);

CREATE TABLE IF NOT EXISTS movimentacao (
    id_movimentacao INT NOT NULL AUTO_INCREMENT,
    quantidade_movimentada INT NOT NULL,
    tipo_movimentacao ENUM('ENTRADA', 'SAIDA') NOT NULL,
    data DATETIME NOT NULL,
    id_produto INT NOT NULL,
    PRIMARY KEY (id_movimentacao),
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);