# Trabalho-A3-PSC
https://mediacdns3.ulife.com.br/PAT/Upload/2855451/A3_UC_PSC_2025A_DIB_MATUTINOControleEstoque_20250408083749.pdf

https://mediacdns3.ulife.com.br/PAT/Upload/2855451/14_A3_Desenvolvimento_ControleEstoque_2025_1_20250527075904.pdf

## Alunos: 
Gabriel Machado da Fonseca - Machadox18 - 10725115066\
Evelyn Yasmin Ferreira Leal - EvelynYs2 - 10725115169\
Natan de Camargo Catapan Ghizzo Konig - NatanKonig - 10725110644\
Mario Gabriel Imperator dos Santos - mariooimp - 10725115250\
Fabrício Valdemar de Aguiar filho - AguiarFabricio 10725115451

## Banco de Dados
Execute o arquivo `banco.sql` para criar o banco de dados e suas tabelas.

## Arquivo config.properties
Para estabelecer a conexão com o banco de dados, é necessário adicionar o arquivo config.properties na pasta resources (src/main/resources). Esse arquivo deve conter as credenciais e configurações necessárias para se conectar ao banco de dados local.

Antes de utilizar o banco, certifique-se de executar o script banco.sql, localizado na raiz do projeto. Ele criará o schema controle_estoque e suas respectivas tabelas.

### Exemplo de config.properties
properties
db.url=jdbc:mysql://localhost:3306/controle_estoque
db.username=root
db.password=sua_senha
