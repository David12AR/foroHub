# 📚 ForoHub

<div align="center">
  <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/menu_forohub.JPG?raw=true" width="500">
</div>

<div align="center">
  
[![GitHub stars](https://img.shields.io/github/stars/David12AR/foroHub?style=social)](https://github.com/David12AR/foroHub)  
[![GitHub forks](https://img.shields.io/github/forks/David12AR/foroHub?style=social)](https://github.com/David12AR/foroHub)  
[![License](https://img.shields.io/github/license/David12AR/foroHub)](https://github.com/David12AR/foroHub)  
[![Last commit](https://img.shields.io/github/last-commit/David12AR/foroHub)](https://github.com/David12AR/foroHub)  
[![Java](https://img.shields.io/badge/Java-17-orange)](https://www.oracle.com/java/)  
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)  
[![MySQL](https://img.shields.io/badge/MySQL-8.x-blue)](https://www.mysql.com/)  
[![Made with Insomnia](https://img.shields.io/badge/Tested%20with-Insomnia-purple)](https://insomnia.rest/)  

</div>

---

## 📑 Índice
1. [📌 Acerca del proyecto](#-acerca-del-proyecto)  
2. [✨ Funcionalidades](#-funcionalidades)  
3. [🚀 ¿Cómo funciona?](#-cómo-funciona)  
4. [🛠️ Tecnologías utilizadas](#-tecnologías-utilizadas)  
5. [👤 Autor](#-autor)  

---

## 📌 Acerca del proyecto

Este proyecto fue desarrollado en **Java** con **Spring Boot**, conectado a la base de datos **MySQL** y probado con **Insomnia**.  
Permite **crear, listar, detallar, actualizar y eliminar tópicos** dentro de un foro.  

Además, todas las acciones requieren autenticación mediante **usuario y contraseña**, generando un **token JWT** que debe enviarse en cada petición.  

**🏁 Estado:** Proyecto finalizado ✅ con posibilidad de mejoras y contribuciones.

---

## ✨ Funcionalidades

- **Operaciones CRUD** con 5 endpoints principales:
  - ➕ Registrar Tópico  
  - 📋 Listar Tópicos  
  - 🔍 Detallar Tópico  
  - ✏️ Actualizar Tópico  
  - ❌ Eliminar Tópico  

- **Validaciones inteligentes**:
  - 🔐 Solo usuarios autenticados pueden realizar peticiones (token requerido).  
  - 📌 Todos los campos son obligatorios al registrar un tópico.  
  - 🚫 No se permiten títulos ni mensajes duplicados.  
  - ⚠️ Se notifica cuando un **ID es inválido** en las operaciones de detallar, actualizar o eliminar.  
  - ✏️ En la actualización, puedes modificar cualquier campo, siempre que no duplique el título o mensaje de otro tópico.  

---

## 🚀 ¿Cómo funciona?

1. **Inicio de sesión**  
   - Ingresa un usuario registrado en la BD con correo y contraseña.

     <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/inicio_sesion.JPG?raw=true" width="500">

   - Se genera un **token JWT** que debe usarse en todas las peticiones.

     <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/variable_token_request.JPG?raw=true" width="500">

   - En Insomnia se configuró como variable de entorno, para usarlo automáticamente en cada request.
    
     <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/variable_ambiente_token.JPG?raw=true" width="500">


2. **Registro de un tópico**  
   - Campos obligatorios en el JSON:  
     ```json
     {
       "titulo": "Ejemplo",
       "mensaje": "Contenido del mensaje",
       "curso": "Curso X",
       "autor_id": 1
     }
     ```
     <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/registro_topico.JPG?raw=true" width="500">

     <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/registro_topico_validacion_vacio.JPG?raw=true" width="500">

   - No se permite duplicar **título** ni **mensaje**.  
    
     <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/registro_topico_validacion_duplicado.JPG?raw=true" width="500">


3. **Listar tópicos**  
   - Lista todos los tópicos ordenados **ascendentemente por curso**.  
   - La paginación es automática (10 por página).

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/listar_topicos.JPG?raw=true" width="500">

   - Ejemplo: `?page=1` para la segunda página.  

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/listar_topicos_siguiente_pagina.JPG?raw=true" width="500">

4. **Detallar tópico**  
   - Consulta un tópico específico por ID.  

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/detallar_topico.JPG?raw=true" width="500">

   - Si el ID no existe, el sistema lo notificará.  

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/detallar_topico_validacion.JPG?raw=true" width="500">

5. **Actualizar tópico**  
   - Se actualiza indicando el ID en la URL.  

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/actualizar_topico.JPG?raw=true" width="500">


   - Permite modificar cualquier campo, respetando la validación de duplicados.  

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/actualizar_topico_validacion_duplicado.JPG?raw=true" width="500">

   - Si el ID no existe, se devuelve un mensaje de error.  

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/actualizar_topico_validacion_vacio_id.JPG?raw=true" width="500">


6. **Eliminar tópico**  
   - Se elimina indicando el ID en la URL.  
   - El sistema confirmará la eliminación.

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/eliminar_topico.JPG?raw=true" width="500">

   - Si el ID no existe, se notificará al usuario.  

    <img src="https://github.com/David12AR/foroHub/blob/main/imagenes/eliminar_topico_validacio_vacio_id.JPG?raw=true" width="500">


---

## 🛠️ Tecnologías utilizadas

- **Java** → Lógica y ejecución  
- **Spring Boot Initializr** → Estructura y dependencias  
- **Maven** → Gestión de dependencias y compilación  
- **MySQL** → Base de datos relacional  
- **Insomnia** → Pruebas de los endpoints mediante JSON  

---

## 👤 Autor

| [<img src="imagenes/david_linkedin.jpg" width=115><br><sub>David Acosta</sub>](https://github.com/David12AR) |
| :---: |

💻 [GitHub](https://github.com/David12AR) • 🔗 [LinkedIn](https://linkedin.com/in/david-acosta01)

