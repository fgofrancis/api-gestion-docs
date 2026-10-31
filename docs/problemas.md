
## Tres niveles distintos de validación:
mvn clean compile
↓
mvn spring-boot:run
↓
IntelliJ Run

### Nota: Cada uno comprueba más cosas que el anterior.


mvn clean compile: 
 - Este comando responde a una sola pregunta:
   - ¿Mi código Java compila?
   - Hace:
     ✅ Borra target/
     ✅ Descarga dependencias si faltan
     ✅ Compila el código fuente
     ✅ Ejecuta procesadores de anotaciones
     ✅ Genera los .class
   
   - No Hace:
     ❌ No arranca Spring
     ❌ No crea beans
     ❌ No levanta Tomcat
     ❌ No conecta a la BD
     ❌ No ejecuta endpoints

mvn spring-boot:run
- Este comando responde a una sola pregunta:
  ¿Mi aplicación Spring Boot puede arrancar?
    - Hace todo lo anterior y además:
      ✅ Compila
      ✅ Arranca Spring
      ✅ Escanea componentes
      ✅ Crea beans
      ✅ Registra repositorios
      ✅ Configura Security
      ✅ Configura Hibernate
      ✅ Levanta Tomcat
      ✅ Lee application.properties
      ✅ Crea el ApplicationContext

IntelliJ Run
- Este comando responde a una sola pregunta:
  ¿Mi IDE puede compilar y arrancar la aplicación?
  Cuando haces:
  ▶ Run App
  ¿Mi entorno de desarrollo está bien configurado?
  si entonces:
  ✅ Compilar
  ✅ Ejecutar
  ✅ Adjuntar debugger
  ✅ Gestionar dependencias
  ✅ Gestionar plugins
  ✅ Resolver anotaciones
  ✅ Usar el SDK configurado

## Spring Security proteje de:
 - CSRF Cross Site Request Forgery o Falsificación de Peticiones entre Sitios

 - Clickjacking : mostrar esta página dentro de un frame.
 - 
Para ver /h2-console debemos desabilitar esta optcion, pero solo en desarrollo,
de esta manera en el SecurityFilterChain()
 @Bean SecurityFilterChain chain(HttpSecurity http, JwtService jwt) throws Exception {
     http
     .csrf(csrf -> csrf
     .ignoringRequestMatchers("/h2-console/**"))
     .headers(headers ->
     headers.frameOptions(frame -> frame.disable())
     )
     .sessionManagement(........