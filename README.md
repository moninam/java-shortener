# Java Challenge Shortener

Este programa es realizado para el Java Challenge de NearSoft, se trata de una API que genera un acortador de URLs.

#Requisitos
Debes tener instalado una instancia de Maven en tu equipo y agregar las variables de entorno MAVEN_HOME y JAVA_HOME para su ejecución en la consola de comandos.
Puedes obtener más información en el siguiente link: https://maven.apache.org/install.html

## Instalación

Lo unico que debes hacer es clonar el repositorio en una carpeta en tu equipo.

## Ejecución
Debes construir el proyecto maven clonado en tu equipo, desde el directorio raíz del proyecto , realizandolo con el siguiente comando

```bash
mvn clean install
```
Después debes ejecutar la aplicación con el siguiente comando:

```bash
mvn spring-boot:run
```
De igual forma puede ejecutarse y construirse el proyecto desde el IDE de tu preferencia, para realizarlo favor de checar las especificaciones necesarias para cada IDE.

## Funcionalidad

El proyecto consta de dos endpoints:

### GET
Este verbo realiza la obtención del URL asociado a un alias
La url de acceso para este endpoint es la siguiente:
```bash
URL_SERVIDOR/{alias}
```
La respuesta de dicho endpoint debe redirigir a la pagina asociada a un alias, si dicha pagina no llegará a existir, debe enviar un mensaje como el siguiente:

```bash
{
    "code": "404 NOT_FOUND",
    "error": "No se encontró el sitio para el alias dado"
}
```
#### Ejemplo
Request:
```bash
http://localhost:8080/fcbkcm
```
Response: 
** Debe redirigirte al sitio correspondiente, en este caso a facebook.com

###POST
Este verbo realiza el almacenamiento de un URL y le asigna un alias generado por un par de reglas.

La url de acceso para este endpoint es la siguiente:
```bash
URL_SERVIDOR/
```
Se debe enviar junto con el request un cuerpo en formato JSON con la siguiente estructura:
```bash
{
    "url":"facebook.com"
}
```
Mediante funciones el sistema genera el alias para el URL, siguiendo las siguientes reglas:

1. Si el URL contiene "google" se generara un String de caracteres de una longitud de 5.
2. Si el URL contiene "yahoo" se generara un String alfanúmerico de una longitud de 7 caracteres.
3. Si el URL no cumple con las condiciones anteriores se generará un String apartir de la URL omitiendo los caracteres especiales, vocales y números.

Si el almacenamiento fue correcto, la respuesta a desplegarse debe ser la siguiente:
```bash
{
    "code": "200 OK",
    "alias": "fcbkcm"
}
```
En caso contrario debe mostrar un mensaje como el siguiente:
```bash
{
    "code": "404 NOT_FOUND",
    "error": "El URL no puede estar vacio"
}
```
#### Ejemplo
Request:
```bash
{
    "url":"facebook.com"
}
```
Response:
```bash
{
    "code": "200 OK",
    "alias": "fcbkcm"
}
```
El proyecto puede ser probado a través de una aplicación para la realización de peticiones web como Postman , o desde la consola de comandos, esto depende de tu sistema operativo.

## Diseño
El diseño de la aplicación se realizo pensando en una arquitectura cliente servidor, donde el servidor responde a dos endpoints mencionados previamente.

De igual forma se utilizo la herramienta Spring Boot para la realización de la API, cuya arquitectura puedes ver en la siguiente imagen:
![alt text](https://static.javatpoint.com/springboot/images/spring-boot-architecture2.png)

La estructura del proyecto es la siguiente:
![alt text](https://drive.google.com/file/d/1H8Tm9PAFevqF1fEytKxTfuRGkh4R7oqE/view?usp=sharing)
