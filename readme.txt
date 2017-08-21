#SpringBoot-FileUpload

This is a spring-boot application with Restful API to upload a file either to store it in local folder or into database.

## Getting Started

* You must have eclipse or other IDE that could run spring boot application. 
* You must already installed JDK1.8. 
* This application connect to Oracle database, if you use other database, please modify properties file to fit your database.

### Installing and Running

* download and import project into your IDE
* update all dependency of needed
* change your username and password for database in application.properties file
* run as spring boot app

### Testing

You could use Postman to test it.

for upload to your local folder, use URL with POST method and parameter with file(.file) and name(String)

```
http://localhost:9090/upload
```

the file will store in root path of this application with folder name "~" and also store metadata in database
**note** : parameter "file" and "name" should present

## Author

Rachel Zheng @ 2017