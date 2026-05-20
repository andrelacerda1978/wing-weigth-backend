# Wing Weight Backend - Java Spring Boot

Backend criado para atender o Capítulo 7 do PIM: evidências de implementação do Back-End, testes e implantação.

## Funcionalidades
- Cadastro de usuários
- Cadastro de aviários
- Cadastro de lotes de aves
- Cadastro de balanças/dispositivos
- Registro de pesagens com temperatura e umidade
- Regras de alerta por peso mínimo/máximo
- Geração automática de alerta quando uma pesagem fica fora do limite
- Dashboard com total de aviários, lotes, registros, peso médio e alertas abertos
- API documentada com Swagger
- Banco H2 local

## Como rodar
```bash
mvn spring-boot:run
```

Swagger:
http://localhost:8080/swagger-ui.html

Banco H2:
http://localhost:8080/h2-console

JDBC URL:
jdbc:h2:file:./data/wingweightdb

## Endpoints principais
- `/api/users`
- `/api/aviaries`
- `/api/flocks`
- `/api/devices`
- `/api/weights`
- `/api/alert-rules`
- `/api/alerts`
- `/api/dashboard`

## Exemplo de JSON para cadastrar aviário
```json
{
  "name": "Aviário 01",
  "location": "Setor A",
  "capacity": 5000,
  "active": true
}
```

## Exemplo de JSON para registrar pesagem
```json
{
  "weightKg": 1.85,
  "temperature": 28.5,
  "humidity": 65.0,
  "flock": { "id": 1 },
  "device": { "id": 1 }
}
```
