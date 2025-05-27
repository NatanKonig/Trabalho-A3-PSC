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

CREATE TABLE movimentacao (
    id_movimentacao INT NOT NULL AUTO_INCREMENT,
    id_produto INT,
    tipo ENUM('Entrada', 'Saida') NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_movimentacao),
    data DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_produto) REFERENCES produto(id_produto)
);
