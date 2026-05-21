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
