# proyecto-final-springjs
Este proyecto se basa en una aplicación donde se usan los servicios API REST que pueden ser creados por medio del framework de Spring. Un framework basado en Java.

Este proyecto tiene en cuenta las siguientes dependencias.
* Spring Boot Devtools
* Spring Web
* Lombok
* Spring Data JPA
* JDBC Driver
* MySQL Driver

# Descripción del proyecto
El proyecto se basa en una plataforma de asesoriamiento financiero. Según la descripción del proyecto, esta herramienta debe de dar una orientación financiera personalizada a los usuarios. Esto se va a basar en el ofrecimiento de herramientas, seguimiento de gastos, planificación de inversiones y gestión de deudas.

## Herramientas Utilizadas
Las herramientas que han sido utilizadas en la realización del proyecto son las siguientes:
* Spring Framework: Framework basado en Java para la creación de API Rest.
* Javascript: Lenguaje de programación utilizado para mostrar datos en un sitio web.
* IntelliJ IDEA: IDE usado para el proyecto de Spring.
* Postman: Aplicación usada para testear los endpoints.
* MySQL Workbench: Herramienta visual para visualizar y manejar datos del SGBD MySQL.

## Requerimientos Funcionales
* Realizar un CRUD de las personas junto con una contraseña para permitir subir la información.
* Crear una sección que permita a partir de los ingresos y egresos poner comentarios dentro de cada mes para definir por qué aumentó o disminuyeron los ingresos.
* Mantener un saldo actualizado en la base de datos donde se tengan los ahorros.


## Base de datos
La base de datos va a estar formada a partir de 4 entidades. Estas entidades son las siguientes:

* Personas: 
    * **Descripción:** Tabla usada para guardar la información básica de la persona. Esta información contiene los siguientes atributos:

        * ***Document_Type:*** [VARCHAR(8)]: Tipo de identificación de la persona.
        * ***Identificación*** [PK; Integer]: Identificación de la persona.
        * ***Nombres***: [VARCHAR(100)]: Nombres de la persona.
        * ***Apellidos***: [VARCHAR(100)]: Apellidos de la persona.
        * ***Cargos***: [VARCHAR(100)]: Tipo de cargo o empleo que tiene la persona.
        * ***Fecha de Nacimiento***: [DATE]: Fecha de nacimiento de la persona.
        * ***email:*** Correo electrónico de la persona registrada.
        * ***saves_percent:*** Porcentaje que la persona debe de tener para ahorros.

* Contraseña:
    * **Descripción:** Tabla que va a guardar la información de las contraseñas de las personas. Contiene los siguientes atributos:
        * ***user_id:*** [PK, Integer, Auto-increment] Identificación del usuario.
        * ***Identificación:*** [FK, Integer]: Identificación de la persona.
        * ***Contraseña:*** [TEXT]: Contraseña de la persona. Esta contraseña va a estar encriptada bajo el estándar de encriptación SHA.

* Cambios Mensuales:
    * **Descripción:** Esta tabla se va a encargar de guardar un historial de los ingresos y egresos que la persona ha tenido por mes. Los atributos son los que se presentan a continuación.

        * ***change_id:*** [PK, Integer, autoincrement] Identificación del cambio mensual.
        * ***Identificación:*** [FK, Integer] Identificación de la persona a la que pertenece este registro.
        * ***ingresos:*** [Double] Ingresos mensuales de la persona.
        * ***egresos:*** [Double] Egresos mensuales de la persona.
        * ***created_at***: Fecha de creación del registro. Permite saber en que mes ha sido agregado el registro.

* Comentarios:

    * **Descripción**: Tabla que permite agregar comentarios por cada registro de cambios de ingresos por persona. Esta tabla mantiene todos los comentarios que se tengan sobre el por qué tiene ingresos más altos por ejemplo o gastos más elevados. Los atributos en esta tabla son los siguientes:

        * ***comment_id:*** [PK, Integer, Autoincrement] Identificación del comentario creado.

        * ***register_id:*** [FK, Integer] Identificación del registro de la persona.

        * ***created_at:*** [DATE] Fecha donde se crea el comentario.

* Estadísticas.
    * **Descripción:** Esta tabla guarda la utilidad y el dinero que se tiene libre mes tras mes en formato de saldo. Contiene los siguientes atributos:

        * ***id_statistics:*** [PK, Integer, Autoincrement]Identificación de las estadísticas.
        * ***person_id:*** [FK, Integer] Identificación de la persona que tiene los ingresos.
        * ***utilities:*** [Double]
        Utilidades que tienen las personas en formato numérico ($).
        * ***saves:*** [Double] Ahorros que la persona debería de tener en el mes.
        * ***month:*** [Date] Mes en el que se realiza el ahorro.

### MER
El diagrama Entidad Relación de la base de datos es la siguiente.
![Diagrama Entidad Relación](./database/mer.png)

## Endpoints
El proyecto está configurado para que la ruta principal sea
 ```http://localhost:9090/api```
