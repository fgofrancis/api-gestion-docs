
## application.properties and application.yml
application.yml y application.properties hacen exactamente lo mismo. 
Son dos formas distintas de configurar Spring Boot.

¿Qué es YAML?
YAML utiliza indentación para representar jerarquías.

### Por ejemplo 1:
**YAML**
    app:
        jwt-secret: clave
        storage-dir: ./storage

**.properties**
app.jwt-secret=clave
app.storage-dir=./storage


### Por ejemplo 2:
**YAML**
    spring:
        datasource:
            url: "jdbc:h2:file:./data/fedcoop;AUTO_SERVER=TRUE"
            username: sa
            password: ""

**.properties**
spring.datasource.url=jdbc:h2:file:./data/fedcoop
spring.datasource.username=sa
spring.datasource.password=""

Nota: Personalmente, cuando las configuraciones empiezan a crecer,
prefiero application.yml porque es más legible.

### Ejemplo 3:
YAML
    url: "jdbc:h2:file:./data/fedcoop;AUTO_SERVER=TRUE"

Significa:

jdbc
↓
H2
↓
Base en archivo
↓
./data/fedcoop

La base se guarda físicamente en:
backend/
└─ data/
└─ fedcoop.mv.db
Por eso cuando reinicias la aplicación no pierdes los datos.

#### AUTO_SERVER=TRUE
Permite que más de una conexión pueda acceder al mismo archivo H2.
Muy útil durante desarrollo.

#### Ejemplo 4:
YAML
    jpa:
        hibernate:
        ddl-auto: update
        open-in-view: false
expicacion:
    ddl-auto: update

Uno de los parámetros más importantes de Spring Boot.
Significa:
Hibernate compara las entidades Java con la BD y
actualiza la estructura automáticamente.Cambia la estructura segun 
la clase de spring.

    Ejemplo:
    Clase spring es esta:
    class AppUser {
    String email;
    }
Mañana agrega esto:
String phone;

Al arrancar:
Shell
mvn spring-boot:run
Hibernate hará algo parecido a:
    ALTER TABLE app_user
    ADD COLUMN phone VARCHAR(255);
automáticamente

ddl-auto: create --> Borra todo y crea nuevamente. Muy peligroso
ddl-auto: update --> Actualiza sin borrar datos. Muy usado en desarrollo.
ddl-auto: validate --> Solo verifica. No modifica nada. Muy usado en producción.

open-in-view: false --> ¡Aquí está uno de los temas más interesantes!
Por defecto Spring Boot suele trabajar con:
    open-in-view: true
    Esto mantiene abierta la sesión de Hibernate durante toda la petición web.

Cuando Claude puso:open-in-view: false --> está obligándote a trabajar correctamente.
¿Recuerdas este error? --> LazyInitializationException
Pues precisamente estuvo relacionado con esto
Con: open-in-view: false --> la sesión se cierra antes.Por eso Hibernate no pudo cargar
    Organization$HibernateProxy
    cuando hacías: d.getOrg().getName()

Te obligó a corregir: getReferenceById() por findById() que es una solución mejor.



