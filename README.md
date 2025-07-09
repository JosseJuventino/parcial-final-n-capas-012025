# Sistema de Soporte Técnico

Este proyecto simula un sistema donde los usuarios pueden crear solicitudes de soporte (tickets) y los técnicos pueden gestionarlas. La aplicación está desarrollada con Spring Boot y utiliza PostgreSQL como base de datos.

## Creado por

| Usuario     | Carnet   | 
|-------------|--------|
| José Juventino Castillo Hernández       | 00048322   |
| Germán David Santos Hernández       | 00059122   |

---

## 🐳 Ejecución con Docker y Docker Compose

### 📦 Requisitos

- Docker
- Docker Compose
- Java 21 (para desarrollo local)
- Maven (opcional si usas el wrapper `./mvnw`)

---

## 🚀 Pasos para levantar el entorno

### 1. Clonar el repositorio

```bash
git clone https://github.com/JosseJuventino/parcial-final-n-capas-012025.git
cd parcial-final-n-capas-012025
```

### 2. Generar el `.jar` del proyecto

```bash
./mvnw clean package -DskipTests
```

Esto creará un archivo `.jar` dentro de la carpeta `target/`.

---

### 3. Levantar la aplicación con Docker

```bash
docker compose up --build
```

Esto hará lo siguiente:

- Compilar y construir la imagen de la app con Java 21.
- Levantar una base de datos PostgreSQL con los datos necesarios.
- Iniciar ambos contenedores en red.

---

## ⚙️ Configuración usada

### Base de Datos (PostgreSQL)

- **DB Name**: `supportdb`
- **Usuario**: `postgres`
- **Contraseña**: `root`
- **Puerto expuesto**: `5432`

### Aplicación Spring Boot

- **Puerto expuesto**: `8080`
- **Conexión a DB interna (Usando docker)**: `jdbc:postgresql://db:5432/supportdb`
- **Conexión local**: `jdbc:postgresql://localhost:5432/supportdb`


---

## 🔍 Endpoints y pruebas

Usa la colección de Postman/Insomnia incluida para probar los endpoints de autenticación, creación de tickets y funcionalidades de roles.

---

## 🧯 Para detener los contenedores

```bash
docker compose down
```

Si quieres eliminar también los volúmenes de la base de datos:

```bash
docker compose down -v
```

---

## 📁 Estructura del proyecto relevante

```
.
├── Dockerfile
├── docker-compose.yml
├── src/
├── target/
│   └── parcial-final-n-capas-0.0.1-SNAPSHOT.jar
├── pom.xml
└── README.md
```

---

## 🧪 Usuarios de prueba (ejemplo)

| Usuario     | Rol   | Contraseña |
|-------------|--------|------------|
| user1       | USER   | user123    |
| tech1       | TECH   | tech123    |

---