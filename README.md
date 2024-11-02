# Dna Mutante API

Este proyecto es una API REST desarrollada en **Java** con **Spring Boot** que permite analizar secuencias de ADN para identificar si pertenecen a mutantes. La aplicación almacena el ADN analizado y genera estadísticas sobre los resultados obtenidos. Está desplegada en [Render](https://render.com) y utiliza una base de datos **H2** embebida para almacenamiento.

## Tabla de Contenidos

La Dna Mutante API es un proyecto backend diseñado para analizar secuencias de ADN y determinar si pertenecen a un mutante o a un humano. Basado en patrones genéticos específicos, este sistema identifica características únicas en las cadenas de ADN que pueden clasificar una secuencia como mutante. La API no solo permite realizar estos análisis, sino que también almacena los resultados en una base de datos para consultas y estadísticas posteriores.

Entre las funcionalidades clave de la API se incluyen la verificación de secuencias de ADN, el almacenamiento de resultados de los análisis, la consulta de estadísticas de ADN (como el número de secuencias mutantes y humanas analizadas) y la posibilidad de gestionar los registros almacenados. Además, está implementada en Java con Spring Boot y ha sido desplegada en la nube a través de Render, lo que permite su acceso remoto.
- [Ejecución del Proyecto](#ejecución-del-proyecto)
Método HTTP	Ruta	Descripción
POST	https://parcialbackend-2024-ds.onrender.com/mutantes	Determina si una secuencia de ADN corresponde a un mutante o a un humano.
GET	https://parcialbackend-2024-ds.onrender.com/dnaEstadisticas/stats	Devuelve estadísticas de ADN mutante y humano, incluyendo el ratio.
DELETE	https://parcialbackend-2024-ds.onrender.com/mutantes/delete/{id}	Elimina una secuencia de ADN almacenada mediante su ID.
DELETE	https://parcialbackend-2024-ds.onrender.com/mutantes/deleteAll	Elimina todas las secuencias de ADN almacenadas en la base de datos.

## Descripción

La **Dna Mutante API** permite identificar si una secuencia de ADN pertenece a un mutante y guarda los resultados en una base de datos. También permite consultar estadísticas sobre el número de secuencias de ADN mutantes y humanas.

## Características

- Verificación de secuencias de ADN para identificar mutantes.
- Almacenamiento de secuencias de ADN y resultados de análisis.
- Estadísticas en tiempo real sobre las secuencias analizadas.
- API desplegada en la nube para acceso remoto.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **H2 Database** (modo embebido)
- **Render** (para despliegue)

## Requisitos

- **Java 17** o superior
- **Gradle**
## Dependencias
- Spring Boot Starter Data JPA: Proporciona funcionalidades para trabajar con bases de datos a través de JPA (Java Persistence API), simplificando el acceso y manipulación de datos.
- Spring Boot Starter Data REST: Permite crear servicios RESTful de manera sencilla y rápida, facilitando la exposición de entidades JPA como recursos REST.
- Spring Boot Starter Web: Proporciona las funcionalidades necesarias para desarrollar aplicaciones web, incluyendo soporte para RESTful APIs.
- Lombok: Reduce la verbosidad del código Java generando automáticamente métodos como getters, setters y constructores a través de anotaciones.
- Spring Boot DevTools: Mejora la experiencia de desarrollo proporcionando reinicios automáticos y capacidades de monitoreo.
- H2 Database: Base de datos en memoria utilizada para pruebas y desarrollo, que permite un manejo ligero de datos.
- MySQL Connector: Permite la conexión y comunicación con bases de datos MySQL.(Por si se quiere probar de manera local con MySQL).
- PostgreSQL: Controlador JDBC para conectarse a bases de datos PostgreSQL, lo que permite trabajar con esta base de datos.(Por si se quiere probar de manera local con PostgreSQL)
- Spring Boot Starter Test: Proporciona herramientas para realizar pruebas unitarias y de integración en la aplicación.
- Spring REST Docs: Ayuda a documentar las APIs REST de la aplicación mediante pruebas automatizadas.
## Instalación

1. Clona el repositorio en tu máquina local:
   ```bash
   git clone https://github.com/SebaPineda23/ParcialBackEnd-2024-DS
   cd dna-mutante-api
