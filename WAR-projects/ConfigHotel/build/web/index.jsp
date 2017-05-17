<%-- 
    Document   : index
    Created on : 16-may-2017, 11:15:18
    Author     : adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tomcat-3 AdriSC</title>
    </head>
    <body>        
        <h1>Config hotel information</h1>
        <form action="ConfigHotel" method="POST" name="config_hotel">
            <label for="name_hotel">Insert name of Hotel:</label>
            <input name="name_hotel">
            <br />
            <label for="service_hotel">Insert service:</label>
            <input name="service_hotel">
            <br />
            <label for="discount_hotel">Insert discount:</label>
            <input name="discount_hotel">
            <br />
            <label for="persons_hotel">Insert persons:</label>
            <input name="persons_hotel">
            <br />
            <input name="accion" type="submit" value="send">
        </form>
        <!--
            EL trozo que va a continuación lo he copiado tal cual de los apuntes
        -->
        <form method="get" action="ConfigHotel">
            <input name="accion" value="invalidar" type="hidden">
            <button>Invalidar sesion</button>
        </form>
    </body>
</html>
