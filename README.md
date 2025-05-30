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

| Nome Completo                         | GitHub          | RA          |
| ------------------------------------- | --------------- | ----------- |
| Evelyn Yasmin Ferreira Leal           | @EvelynYs2      | 10725115169 |
| Fabrício Valdemar de Aguiar Filho     | @AguiarFabricio | 10725115451 |
| Gabriel Machado da Fonseca            | @Machadox18     | 10725115066 |
| Mario Gabriel Imperator dos Santos    | @mariooimp      | 10725115250 |
| Natan de Camargo Catapan Ghizzo Konig | @NatanKonig     | 10725110644 |

---

## ✅ Funcionalidades (Requisitos Funcionais)

* Cadastro, consulta, edição e exclusão de **produtos**
* Cadastro, consulta, edição e exclusão de **categorias**
* **Movimentações** de entrada e saída de produtos
* **Reajuste de preços** em massa com percentual informado
* Avisos para **estoque abaixo da quantidade mínima** ou **acima da máxima**
* **Relatórios gerenciais**:

    * Lista de preços
    * Balanço físico e financeiro
    * Produtos fora da faixa de quantidade (mínima/máxima)
    * Quantidade de produtos por categoria

---

## ❌ Funcionalidades Não Funcionais

* Interface gráfica intuitiva e de fácil uso (Swing)
* Padrão de projeto DAO para separação da lógica de acesso a dados
* Persistência garantida com banco de dados relacional (MySQL)
* Estrutura de código limpa, modular e documentada
* Controle de versão utilizando Git/GitHub de forma colaborativa

---

## 🛠 Tecnologias e Ferramentas Utilizadas

| Ferramenta / Tecnologia      | Finalidade                                 |
|------------------------------| ------------------------------------------ |
| JDK 17                       | Ambiente de desenvolvimento (Java 17)      |
| Swing                        | Criação da interface gráfica (GUI)         |
| MySQL Server 8.0             | Banco de dados relacional                  |
| JDBC - MySQL Connector 8.3.0 | Comunicação entre Java e MySQL             |
| Apache NetBeans 26           | Ambiente de desenvolvimento (IDE)          |
| Git                          | Controle de versão local                   |
| GitHub                       | Repositório remoto e colaboração em equipe |

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
   git clone https://github.com/NatanKoni/Trabalho-A3-PSC.git
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
