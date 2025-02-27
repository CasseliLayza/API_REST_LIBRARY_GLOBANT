![logo](src/main/resources/asset/img/top.png)
# 📚 Biblioteca - Spring Boot

## 📝 Descripción
Este es un proyecto de gestión de 📖 desarrollado con Spring Boot. Permite la administración de 📚, ✍️ y 🏢, proporcionando una API REST para su manipulación.

## 🏗️ Estructura del Proyecto

El proyecto sigue la arquitectura MVC y está organizado en los siguientes directorios:

- **controller/**: Contiene los controladores para gestionar las solicitudes HTTP.
- **entity/**: Define las entidades de la 🗄️ (📚, ✍️, 🏢).
- **repository/**: Contiene los repositorios JPA para el acceso a la 🗄️.
- **service/**: Implementa la lógica de negocio del sistema.
- **exception/**: Manejo de errores personalizados.

## 🛠️ Tecnologías Utilizadas
- ☕ Java 17
- 🚀 Spring Boot
- 🗃️ Spring Data JPA
- 🏗️ MYSQL Database (persistencia de datos)
- 🎨 Thymeleaf (para vistas)
- 📦 Maven

## 📥 Instalación y Ejecución
### 🔧 Requisitos previos
- Tener instalado JDK 17 o superior
- Tener configurado Maven

### 📂 Clonar el repositorio
```sh
git clone https://github.com/CasseliLayza/API_REST_LIBRARY_GLOBANT
```

### ⚙️ Compilar el proyecto
```sh
mvn clean package
```

### ▶️ Ejecutar la aplicación
```sh
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8080`

## 🌐 Endpoints principales

| 🔹 Método | 📍 Endpoint        | 📖 Descripción                |
|---------|---------------------|------------------------------|
| GET     | `/autores`          | Listar ✍️                  |
| POST    | `/autores`          | Crear un ✍️            |
| GET     | `/libros`           | Listar 📚                   |
| POST    | `/libros`           | Agregar un 📖          |
| GET     | `/editoriales`      | Listar 🏢              |
| POST    | `/editoriales`      | Crear una 🏢       |

## ⚙️ Configuración de Base de Datos

Por defecto, la aplicación usa 🏗️ H2 en memoria. Para cambiar a 🐬 MySQL, modificar `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
```

## 🤝 Contribuir

1. Haz un fork del repositorio.
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva característica'`).
4. Haz push a tu rama (`git push origin feature/nueva-caracteristica`).
5. Abre un pull request.

## 📜 Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

## 📝 Créditos

- Desarrollado como parte del desafío de especialización **Java Backend Developer**.
- 📧 **Correo:** [Casseli Layza](casseli.layzal@dominio.com).

_**¡Gracias por revisar este proyecto!... Powered by Globant 🌟📚🚀...!!**_

## Derechos Reservados

```markdown
© 2025 Casse. Todos los derechos reservados.
```

