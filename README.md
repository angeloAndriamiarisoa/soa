# MICROSERVICE

## 📦 Prérequis

- Docker
- Docker Compose
- JDK 21+

## ⚙️ Etapes pour le lancement

### Étape 1 : Packager les services

```bash
./apigateway/mvnw clean package -DskipTests -f "./apigateway/pom.xml"

```

```bash
./employeefileservice/mvnw clean package -DskipTests -f "./employeefileservice/pom.xml"

```

```bash
./employeeservice/mvnw clean package -DskipTests -f "./employeeservice/pom.xml"

```

```bash
./eureka/mvnw clean package -DskipTests -f "./eureka/pom.xml"
```

```bash
./hrservice/mvnw clean package -DskipTests -f "./hrservice/pom.xml"
```

```bash
./insurancecompany/mvnw clean package -DskipTests -f "./insurancecompany/pom.xml"
```

### Étape 2 : Lancer les services avec docker-compose

```bash
docker-compose up -d --build

```









