# Apache-with-Tomcat
Este es un proyecto que he presentado para la asignatura de "Despliegue de aplicaciones web" que se cursa en el CGS de DAM, desarrollo de aplicaciones web. Trata de como interactuan máquinas virtuales (Ubuntu server) con apache, con máquinas virtuales que ejecutan un servidor de aplicaciones Tomcat(Ubuntu server).
Dentro de este repositorio se encuentra el pdf que he presentado, los apuntes que me facilitaron para llevarlo a cabo, así como los archivos de configuración de todas las máquinas virtuales utilizadas para el desarrollo del mismo, en este caso eran un total de cinco máquinas virtuales;
1.-Máquina cliente con windows 7 (32, IP:192.168.0.49, DNS: 192.168.0.50),
2.-Máquina servidor con Ubuntu server con los servicios de Apache y DNS (Ubuntu server 32, IP: 192.168.0.50),
3.-Máquina con servidor de aplicaciones Tomcat-7, esta también ejecutaba MYSQL server (Ubuntu server 32), esta ofrecia una lista de hoteles almacenados en una base de datos (IP: 192.168.0.51),
4.-Máquina con servidor de aplicaciones Tomcat-7, esta nos permitía la posibilidad de insertar nuevos hoteles, estos se alamacenaban en la base de datos de la máquina con IP: 192.168.0.51, sólo permitía el acceso a un usuario determinado, esta configuración se realizaba en los ficheros de Tomcat,
5.-Máquina con servidor de aplicacione sTomcat-7, esta permitía crear una configuración de hotel (descuentos, número de personas, etc.), pero controlaba el acceso mediante el uso de las sesiones que ofrece Tomcat.
Dentro de este repositorio se encuantre también el planteamiento del proyecto como todo lo que se pedía para su presentación.
