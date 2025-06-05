# 📦 Controle de Estoque - A3 | PSC

Sistema desenvolvido para a disciplina **Programação de Soluções Computacionais (PSC)** da **Universidade do Sul de Santa Catarina (UNISUL)**, com o objetivo de aplicar práticas de desenvolvimento colaborativo, modelagem de sistemas, manipulação de banco de dados e interface gráfica.

---

## 📝 Descrição do Projeto

Este sistema simula um controle de estoque para uma empresa comercial, permitindo o **gerenciamento de produtos, categorias** e **movimentações de entrada e saída**. A aplicação foi desenvolvida em grupo utilizando **Java com Swing** para interface gráfica, **MySQL** para banco de dados e o padrão de projeto **DAO** para abstração da camada de dados.

---

## 📚 Documentação

* [📄 Enunciado Oficial da A3 - Controle de Estoque](https://mediacdns3.ulife.com.br/PAT/Upload/2855451/A3_UC_PSC_2025A_DIB_MATUTINOControleEstoque_20250408083749.pdf)

---

## 👨‍💻 Alunos

| Nome Completo                         | GitHub                               | RA          |
| ------------------------------------- |--------------------------------------| ----------- |
| Evelyn Yasmin Ferreira Leal           | @EvelynYs2                           | 10725115169 |
| Fabrício Valdemar de Aguiar Filho     | @AguiarFabricio & Fabricio de Aguiar | 10725115451 |
| Gabriel Machado da Fonseca            | @Machadox18                          | 10725115066 |
| Mario Gabriel Imperator dos Santos    | @mariooimp                           | 10725115250 |
| Natan de Camargo Catapan Ghizzo Konig | @NatanKonig & Natan Konig            | 10725110644 |

---

## ✅ Requisitos Funcionais (RF)

* *RF001* – O sistema deve permitir o *cadastro, consulta, edição e exclusão de produtos*, contendo as seguintes informações: nome, preço unitário, unidade de medida, quantidade em estoque, quantidade mínima e máxima permitida e categoria associada.
* *RF002* – O sistema deve possibilitar o *cadastro, consulta, edição e exclusão de categorias*, incluindo as informações de nome, tamanho (Pequeno, Médio, Grande) e tipo de embalagem (Lata, Vidro, Plástico).
* *RF003* – O sistema deve permitir *registrar movimentações de entrada e saída de produtos*, atualizando automaticamente a quantidade em estoque conforme a operação realizada.
* *RF004* – O sistema deve permitir *reajustar os preços de todos os produtos* cadastrados com base em um percentual informado pelo usuário, de forma automática.
* *RF005* – O sistema deve emitir *avisos automáticos* nos seguintes casos:
  
  * Quando uma saída de produto fizer a quantidade em estoque ficar *abaixo da quantidade mínima*.
  * Quando uma entrada de produto fizer a quantidade em estoque *ultrapassar a quantidade máxima*.
* *RF006* – O sistema deve gerar *relatórios gerenciais* com as seguintes funcionalidades:
  
  * *Lista de preços*: produtos ordenados alfabeticamente, com nome, preço unitário, unidade e categoria.
  * *Balanço físico e financeiro*: produtos ordenados alfabeticamente, com quantidade atual, valor total por produto e valor total do estoque.
  * *Produtos fora da faixa de quantidade*: dois relatórios, um para produtos abaixo da quantidade mínima e outro para produtos acima da máxima.
  * *Produtos por categoria*: quantidade de produtos distintos agrupados por categoria.

---

## ❌ Requisitos Não Funcionais (RNF)

* *RNF001* – A interface gráfica do sistema deve ser *intuitiva e de fácil utilização, implementada com **Swing*, permitindo navegação simples entre as funcionalidades principais.
* *RNF002* – O sistema deve adotar o *padrão de projeto DAO (Data Access Object)*, separando a lógica de acesso a dados da lógica de negócio e da interface.
* *RNF003* – Toda a persistência dos dados deve ser garantida por meio de um *banco de dados relacional MySQL*, acessado via JDBC.
* *RNF004* – O código-fonte do sistema deve seguir uma *estrutura modular*, com boas práticas de organização, legibilidade e documentação adequada nas classes e métodos.
* *RNF005* – O projeto deve utilizar *controle de versão com Git, mantendo o repositório no **GitHub*, com contribuições registradas de forma colaborativa por todos os membros da equipe.

---

## 🛠 Tecnologias e Ferramentas Utilizadas

| Ferramenta / Tecnologia           | Finalidade                                  |
|----------------------------------|---------------------------------------------|
| JDK 17                           | Ambiente de desenvolvimento (Java 17)       |
| Swing (faz parte do JDK)         | Criação da interface gráfica (GUI)           |
| MySQL Server 8.0                 | Banco de dados relacional                    |
| JDBC - MySQL Connector 8.3.0     | Comunicação entre Java e MySQL               |
| Apache NetBeans 26               | Ambiente de desenvolvimento (IDE)            |
| Git 2.44.0                      | Controle de versão local                      |
| GitHub (Interface web)           | Repositório remoto e colaboração em equipe   |


---

## 🗃 Banco de Dados

Para executar o sistema corretamente, é necessário criar o banco de dados com base no script fornecido:

1. Localize o arquivo `banco.sql` na raiz do projeto.
2. Execute o script em sua instância local do MySQL.
3. Isso criará o banco de dados `controle_estoque` com todas as tabelas necessárias.

---

## ⚙️ Configuração do Projeto

Antes de executar a aplicação, certifique-se de configurar corretamente o arquivo `config.properties` com suas credenciais locais do banco de dados.

### 📄 Exemplo de `src/main/resources/config.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/controle_estoque
db.username=root
db.password=sua_senha
```

> 🔐 **Importante:** Substitua `sua_senha` pela senha real do seu banco de dados MySQL.

---

## 🎯 Como Executar

1. Clone o repositório:

   ```bash
   git clone https://github.com/NatanKonig/Trabalho-A3-PSC.git
   ```
2. Importe o projeto no NetBeans ou outra IDE Java.
3. Configure o `config.properties` como descrito acima.
4. Execute a classe principal para abrir a interface gráfica do sistema.

---

## 📂 Estrutura do Projeto

```
controle-estoque-a3/
│
├── src/
│   ├── dao/              # Data Access Objects (DAO)
│   ├── model/            # Modelos de entidades
│   ├── view/             # Telas da interface gráfica
│   └── main.java         # Classe principal
│
├── banco.sql             # Script de criação do banco
└── config.properties     # Arquivo de configuração do banco (criar manualmente)
```

---

## 💡 Observações Finais

Este projeto foi desenvolvido com fins educacionais, visando aplicar os conhecimentos adquiridos ao longo da disciplina. Todo o código está disponível publicamente no GitHub e pode ser reaproveitado ou adaptado em outros contextos acadêmicos.
