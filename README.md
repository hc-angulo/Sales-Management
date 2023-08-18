# Sales Management

Este proyecto es una API REST, desarrollada en Java usando **Spring Boot**, que busca automatizar el proceso estándar en una transacción comercial de productos como lo es registrar las ventas y manejar el _stock_ de estos.

## Índice
- [1. Descripción](#item1)
- [2. Requerimientos](#item2)
- [3. D-E-R](#item3)
- [4. Herramientas de desarrollo](#item4)

<a name="item1"></a>
### Descripción
Ese proyecto se basará en la arquitectura MVC (Modelo-Vista-Controlador) para separar la lógica de negocio, la presentación y la interacción con el usuario.

Para el modelado de la base de datos se considerán las entidades: Cliente, Factura, Detalle de Factura y Producto. En donde cada factura posee uno y solo un cliente asociado, cada detalle de factura puede tener más de una factura y más de un producto 
asociado. 

A continuación, decribiremos cada entidad, y su clase relacionada desde "models".

1.	**Cliente:** Representará a las personas que realizan compras de los productos ofertados. Cada cliente tendría atributos como: nombre, dni, email, etc. Su clase representativa es **Customer**, la cual tendrá una relación _*@OneToMany*_ con la clase _*Invoice*_.
2.	**Factura:** La entidad contendrá la información relacionada con cada transacción de venta. Tendrá atributos como fecha de emisión, número de factura, total de la factura, etc. Cada factura estaría asociada a un cliente y contendría varios "Detalles de Factura" relacionados. Modelando esto desde el código, representaremos esta entidad en la clase **Invoice** desde la capa "models", la cual tendrá una relación _*ManyToOne*_ con la clase _*Customer*_ y una relación _*OneToMany*_ con la clase _*Invoice_Product*_.
3.	**Detalle_de_Factura:** La entidad Detalle_de_Factura registrará los productos específicos vendidos en cada factura. Contiene atributos como cantidad, precio por cantidad de producto, etc. Cada "Detalle de Factura" estará relacionado con un producto y con una factura. Desde nuestra arquitectura de código, en "models", esta entidad está representada con la clase **Invoice_Product**, la cual tedrá una relación _*ManyToOne*_ con la clase _*Invoice*_ y _*ManyToOne*_ con la clase _*Product*_.
4.	**Producto:** Esta entidad representa los artículos disponibles para la venta. Tiene como atributos: nombre, cantidad disponible, precio. Su clase representativa es **Product**, la cual tendrá una relación _*@OneToMany*_ con la clase _*Invoice_Product*_.

La arquitectura de capas en las que se desarrolla el proyecto es:
1. **Models:** Alojamos las clases que representan las entidades en la base de datos: _*Customer*_, _*Invoice*_, _Invoice_Product_, y _*Product*_.
2. **Repotitories:** Se almacenan interfaces que extiendan _JpaRepository_ para cada clase en _*models*_, las cuales proporcionan métodos predefinidos para realizar operaciones de base de datos como guardar, recuperar y eliminar registros.
3. **Services:** En esta capa, a través de clases e interfaces, se implementan servicios para cada entidad. Estos servicios contienen la "lógica de negocio" los cuales se encargan de gestionar la interacción entre las clases de la capa _controllers_ y _repositories_.
4. **Controllers:** Desde esta capa almacenamos las diferentes clases "controllers" utilizando las anotaciones de Spring MVC. Estas clases manejan las solicitudes _*HTTP*_.
5. **Validators:** En esta capa realizamos las pruebas unitarias y de integración para asegurarnos de que todos los componentes funciones correctamente.

<a name="item2"></a>
### Requerimientos
A continuación, listamos algunos de los requerimientos que desarrollamos en la API:

1. CRUD completo de cada entidad.
2. Automatizar la actualización del _*Stock*_ de un producto cuyo "id" está referenciado como _*id_product*_ desde la instancia de un objeto de la clase _Invoice_Product_. Esta actualización dependerá del valor del atributo _quantity_.
3. Controlar si se cuenta con la cantidad de producto a vender.
4. Automatizar la actualización del _Monto a pagar por factura_ cada vez que se seleccione un producto para la venta en dicha factura.

<a name="item3"></a>
### D-E-R
![D-E-R  Gestión de ventas](https://github.com/hc-angulo/Sales-Management/assets/14808063/0ba7fa4d-ec95-4357-b1f9-d067ed76a448)

<a name="item4"></a>
### Herramientas

<p align="left> 
   <a href="" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original-wordmark.svg" alt="Spring Boot" width="100" height="100"/>
  <a href="" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" alt="Java" width="100" height="100"/>
    <a href="https://www.mysql.com/" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/mysql/mysql-original-wordmark.svg" alt="mysql" width="100" height="100"/>
 
</p>
