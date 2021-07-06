## SISTEMA DE OFERTAS DE PEDIDOS

### Sistema de Ofertas de Pedidos usando <b>Spring MVC, Spring Security, Thymeleaf, Bootstrap e VueJS</b>

#### Objetivo:
- Logar com usuário e senha, visualizar seus pedidos, cadastrar novos pedidos e enviar ofertas para pedidos de outros usuários

Caracterísitcas:
- Padrão MVC
- Autenticação
- Paginação e Cache
- Interceptadores
- Monitoramento de tempo de execução das requisições
- Envio de Dados em formato JSON.
- Validações de Formulários

Tecnologias:
- Spring Data JPA
- Spring Security
- Spring Boot
- Spring MVC
- Thymeleaf
- Bootstrap
- VueJS
- Banco de Dados MySQL
- Bean Validation

Exemplo de teste de URLs:
- localhost:8080/api/pedidos -> Expõe dados dos pedidos do usuário em JSON.
- /api/acessos -> Expõe os dados do tempo de acesso das requisições.
- /home -> Pedidos de todos os usuários com status Entregue.
- /login -> Página de Login.
- /oferta -> Enviar ofertas para os pedidos cadastrados.
- /pedido -> Cadastro de pedidos.
- /usuario/pedidos -> Listagem de todos os pedidos do usuário logado.

Logins cadastrados:
- Login: jose | Senha: alexandre

