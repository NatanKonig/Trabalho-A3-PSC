# 📦 Trabalho A3 - PSC

## 📚 Documentação

- [📄 Enunciado A3 - Controle de Estoque](https://mediacdns3.ulife.com.br/PAT/Upload/2855451/A3_UC_PSC_2025A_DIB_MATUTINOControleEstoque_20250408083749.pdf)

---

## 👨‍🏫 Alunos

| Nome Completo                                | Usuário GitHub   | RA           |
|---------------------------------------------|------------------|--------------|
| Gabriel Machado da Fonseca                  | Machadox18       | 10725115066  |
| Evelyn Yasmin Ferreira Leal                 | EvelynYs2        | 10725115169  |
| Natan de Camargo Catapan Ghizzo Konig       | NatanKonig       | 10725110644  |
| Mario Gabriel Imperator dos Santos          | mariooimp        | 10725115250  |
| Fabrício Valdemar de Aguiar Filho           | AguiarFabricio   | 10725115451  |

---

## 🛠 Banco de Dados

1. Localize o arquivo `banco.sql` na raiz do projeto.
2. Execute o script em seu banco MySQL local.
3. Isso criará o banco de dados `controle_estoque` com todas as tabelas necessárias.

---

## ⚙️ Configuração do Projeto

Para que o sistema se conecte ao banco de dados, é necessário criar o arquivo `config.properties` dentro da pasta `src/main/resources`.

### 📄 Exemplo de `config.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/controle_estoque
db.username=root
db.password=sua_senha
```
🔐 Atenção: Substitua `sua_senha` pela senha real do seu banco de dados MySQL local.