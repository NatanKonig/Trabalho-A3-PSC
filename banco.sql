CREATE TABLE categoria (
    id_categoria INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    tamanho ENUM('Pequeno', 'Médio', 'Grande') NOT NULL,
    embalagem ENUM('Lata', 'Vidro', 'Plástico') NOT NULL,
    PRIMARY KEY (id_categoria)
);

CREATE TABLE produto (
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