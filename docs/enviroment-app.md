
## Esquema de enviroment pero usando .yml en vez de .properties

### Enviroment properties
 - application.properties
 - application-dev.properties
 - application-prod.properties
 - .env-dev.properties

### Enviroment yml
application.yml
application-dev.yml
application-prod.yml


### Application.yml - Configuración común para todos los entornos.

    spring:
        application:
            name: fedcoop
    jpa:
        open-in-view: false
    app:
        storage-dir: ./storage


### application-dev.yml

    spring:
        datasource:
            url: jdbc:h2:file:./data/fedcoop
            username: sa
            password: ""
    
        h2:
            console:
                enabled: true
    
        jpa:
            hibernate:
                ddl-auto: update

    app:
        jwt-secret: dev-secret-123456789

### application-prod.yml

    spring:
        datasource:
            url: ${DB_URL}
            username: ${DB_USER}
            password: ${DB_PASSWORD}
    
        jpa:
            hibernate:
                ddl-auto: validate
    
    app:
        jwt-secret: ${JWT_SECRET}
        storage-dir: ${STORAGE_DIR}

### Configurar en Intellij
Run
→ Edit Configurations
    Environment variables:
        SPRING_PROFILES_ACTIVE=dev

### Configurar en producion - Render
    SPRING_PROFILES_ACTIVE=prod

## Comparando dos files .yml ya terminados con difierentes formatos
### Forma 1:

spring:
    datasource: { url: "jdbc:h2:file:./data/fedcoop;AUTO_SERVER=TRUE", username: sa, password: "" }
    jpa: { hibernate: { ddl-auto: update }, open-in-view: false }
    h2: { console: { enabled: true }, path: /h2-console }
    servlet: { multipart: { max-file-size: 25MB, max-request-size: 25MB } }
app:
    jwt-secret: cambia-esta-clave-secreta-de-al-menos-32-caracteres!!
    storage-dir: ./storage

### Forma 2: # Recomendable usar esta forma
spring:
    datasource:
        url: "jdbc:h2:file:./data/fedcoop;AUTO_SERVER=TRUE"
        username: sa
        password: ""

    jpa:
        hibernate:
            ddl-auto: update
        open-in-view: false
    
    h2:
        console:
            enabled: true
            path: /h2-console
    
    servlet:
        multipart:
            max-file-size: 25MB
            max-request-size: 25MB
app:
    jwt-secret: cambia-esta-clave-secreta-de-al-menos-32-caracteres!!
    storage-dir: ./storage
