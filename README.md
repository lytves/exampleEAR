## Java EE 7 Tutorial

A complete example of developing a business application in JavaEE with database access
___
#### - **exampleEAR**

1. Configuring a connection pool and a JNDI resource in WildFly **java:jboss/datasource/Books**. Creating a database, user and tables in MySQL, file **libros.sql**

2. Example is an enterprise web application that is composed of EJBs and Servlets and JSP. Composed by:
   + a project of the type Enterprise Application Project - _**EjemploEAR**_
   + a project where are all the EJBs - _**EjemploEAR_EJB**_
   + a project with interface @Remote of an EJB (ConsultaAutoresRemote) that can be called from another virtual machine - _**EjemploEAR_EJBClient**_
   + two internal dynamic web projects, in this web applications we want to use the previously developed EJBs - _**EjemploEAR_WebApp1**_ and _**EjemploEAR_WebApp2**_
   + another external dynamic web project - _**Ejemplo_WebApp3**_

*dynamic web projects contain the servlets with bean injects and view in jsp files

3. Beans defined within a business project can be accessed from more than one web application belonging to that business project without having to perform any special actions (*ExampleEAR_WebApp1*, *ExampleEAR_WebApp2*, *Ejemplo_WebApp3*)
4. Project _**EjemploEAR_EJB**_:
   + *AuxiliarBean* - acceso mediante interfaz local 
   + *UtilsBean* - acceso a beans de tipo Singleton

5. Project _**Ejemplo_WebApp3**_: shows us access from external web applications to the business project. A bean defined within a business project can be accessed from an external web application to that enterprise project through its JNDI portable name

6. Deploy the project *EjemploEAR* on the application server. Once running the server, we can open the Web browser and put the URLs:
http://localhost:8080/EjemploEAR_WebApp1/ and http://localhost:8080/EjemploEAR_WebApp2/

7. Deploy the project *Ejemplo_WebApp3* on the application server and open URL http://localhost:8080/Ejemplo_WebApp3/
