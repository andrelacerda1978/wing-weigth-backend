# Wing Weight Backend 🐔⚖️

Backend do sistema inteligente de monitoramento e gestão aviária Wing Weight.

---

# 📌 Sobre o projeto

O Wing Weight é uma plataforma desenvolvida para gerenciamento e monitoramento de produção aviária em tempo real.

O sistema permite controlar:

- aviários
- lotes
- balanças inteligentes
- pesagens
- alertas
- usuários
- dashboards operacionais

A aplicação foi construída utilizando arquitetura REST com Spring Boot e PostgreSQL.

---

# 🚀 Tecnologias utilizadas

## Backend
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- Maven

## Banco de dados
- PostgreSQL

## Documentação
- Swagger OpenAPI

## Infraestrutura
- Docker
- Git
- GitHub

---

# 🎯 Funcionalidades

## 🔐 Autenticação
- Login de usuários
- Controle de acesso por perfil
- Controle de sessão
- Usuários ADMIN, TECNICO e USUARIO

## 👥 Usuários
- Cadastro de usuários
- Exclusão de usuários
- Controle de permissões

## 🏠 Aviários
- Cadastro de aviários
- Associação de localização
- Relacionamento com lotes
- Relacionamento com balanças

## 🐔 Lotes
- Cadastro de lotes
- Associação aos aviários
- Controle de quantidade de aves

## ⚖️ Balanças
- Cadastro de balanças/dispositivos
- Associação obrigatória ao aviário
- Controle ativo/inativo
- Exclusão de dispositivos

## 📊 Pesagens
- Registro de pesagens
- Histórico operacional
- Dados simulados em tempo real

## 🚨 Alertas
- Geração automática de alertas
- Monitoramento operacional

## 📈 Dashboard
- Total de aviários
- Total de lotes
- Total de pesagens
- Alertas ativos
- Peso médio

---

# 🗂️ Estrutura do projeto

```bash
src/main/java/br/com/wingweight/
 ├── controller/
 ├── dto/
 ├── entity/
 ├── repository/
 ├── security/
 ├── service/
 └── config/


🔗 Relacionamentos do sistema
Um aviário pode possuir vários lotes
Um aviário pode possuir várias balanças
Uma balança pertence a um aviário
Um lote pertence a um aviário
Um usuário possui perfil de acesso
🐳 PostgreSQL com Docker
Iniciar container
docker start postgres-wingweight
Acessar PostgreSQL
docker exec -it postgres-wingweight psql -U postgres
Selecionar banco
\c meubanco

▶️ Executando o projeto
Rodar aplicação
mvn spring-boot:run

Backend disponível em:

http://localhost:8080

 Swagger

Documentação da API:

http://localhost:8080/swagger-ui/index.html

 Banco de dados

Principais tabelas:

users
aviary
flock
scale_device
weight_record
alert
alert_rule
📌 Endpoints principais
Autenticação
POST /api/auth/login
POST /api/auth/register
Usuários
GET    /api/users
POST   /api/users
DELETE /api/users/{id}
Aviários
GET    /api/aviaries
POST   /api/aviaries
DELETE /api/aviaries/{id}
Lotes
GET    /api/flocks
POST   /api/flocks
DELETE /api/flocks/{id}
Balanças
GET    /api/devices
POST   /api/devices
DELETE /api/devices/{id}

 Melhorias futuras
JWT + Spring Security
Criptografia BCrypt
Logs centralizados
Dashboard avançado
Relatórios PDF
Exportação Excel
WebSocket em tempo real
Integração IoT
Monitoramento online/offline das balanças
Deploy cloud
CI/CD

Autor

Andre Luis Lacerda

GitHub:
https://github.com/andrelacerda1978

Repositório Backend:
https://github.com/andrelacerda1978/wing-weigth-backend
