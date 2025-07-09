Este repositorio contiene un proyecto para evaluar y practicar los conceptos de seguridad en aplicaciones Spring Boot usando JWT, roles y Docker.

### Estudiantes
- **Nombre del estudiante**: José Juventino Castillo Hernández - 00048322
- **Nombre del estudiante 2**: German David Santos Hernández - 00059122
- Sección:  2
---

## Sistema de Soporte Técnico

### Descripción
Simula un sistema donde los usuarios pueden crear solicitudes de soporte (tickets) y los técnicos pueden gestionarlas. Actualmente **no tiene seguridad implementada**.

Su tarea es **agregar autenticación y autorización** utilizando **Spring Security + JWT**, y contenerizar la aplicación con Docker.

### Requisitos generales

- Proyecto funcional al ser clonado y ejecutado con Docker.
- Uso de PostgreSQL (ya incluido en docker-compose).
- Seguridad implementada con JWT.
- Roles `USER` y `TECH`.
- Acceso restringido según el rol del usuario.
- Evidencia de funcionamiento (colección de Postman/Insomnia/Bruno o capturas de pantalla).

**Nota: El proyecto ya tiene una estructura básica de Spring Boot con endpoints funcionales para manejar tickets. No es necesario modificar la lógica de negocio, solo agregar seguridad. Ademas se inclye un postman collection para probar los endpoints. **

_Si van a crear mas endpoints como el login o registrarse recuerden actualizar postman/insomnia/bruno collection_

### Partes de desarrollo

#### Parte 1: Implementar login con JWT
- [✅] Crear endpoint `/auth/login`.
- [✅] Validar usuario y contraseña (puede estar en memoria o en BD).
- [✅] Retornar JWT firmado.

#### Parte 2: Configurar filtros y validación del token
- [✅] Crear filtro para validar el token en cada solicitud.
- [✅] Extraer usuario desde el JWT.
- [✅] Añadir a contexto de seguridad de Spring.

#### Parte 3: Proteger endpoints con Spring Security
- [✅] Permitir solo el acceso al login sin token.
- [✅] Proteger todos los demás endpoints.
- [✅] Manejar errores de autorización adecuadamente.

#### Parte 4: Aplicar roles a los endpoints

| Rol   | Acceso permitido                                 |
|--------|--------------------------------------------------|
| USER  | Crear tickets, ver solo sus tickets              |
| TECH  | Ver todos los tickets, actualizar estado         |

- [ ] Usar `@PreAuthorize` o reglas en el `SecurityFilterChain`.
- [ ] Validar que un USER solo vea sus tickets.
- [ ] Validar que solo un TECH pueda modificar tickets.

#### Parte 5: Agregar Docker
- [✅] `Dockerfile` funcional para la aplicación.
- [✅] `docker-compose.yml` que levante la app y la base de datos.
- [✅] Documentar cómo levantar el entorno (`docker compose up`).

#### Parte 6: Evidencia de pruebas
- [✅] Probar todos los flujos con Postman/Insomnia/Bruno.
- [✅] Mostrar que los roles se comportan correctamente.
- [✅] Incluir usuarios de prueba (`user`, `tech`) y contraseñas.

## Capturas y aclaraciones
### Funcionó correctamente, pero al final detectamos que habíamos subido un commit desde otra computadora donde se agregó un archivo duplicado. El archivo SecurityBean estaba repetido, y al eliminarlo, la aplicación comenzó a ejecutarse sin problemas.
![Imagen de WhatsApp 2025-07-08 a las 20 45 18_8450c21c](https://github.com/user-attachments/assets/d81c7871-c0d1-4393-b7f3-96dc71dcf52d)
![Imagen de WhatsApp 2025-07-08 a las 20 46 30_49531ccf](https://github.com/user-attachments/assets/f4cf93fe-484b-487c-b5be-5a9f4ced2d39)
![Imagen de WhatsApp 2025-07-08 a las 20 47 38_e6fc5581](https://github.com/user-attachments/assets/533d0c31-3ef4-4351-9986-a62c2db9c7f4)

