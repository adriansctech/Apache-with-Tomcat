<%-- 
    Document   : index
    Created on : 15-may-2017, 16:52:57
    Author     : adrian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tomcat-2 AdriSC</title>
    </head>
    <body>
        <h1>Insert new Hotel</h1>
        <form action="InsertHotel" method="POST" name="new_hotel">
            <label for="new_hotel">Insert name of new Hotel:</label>
            <input name="new_hotel">
            <br />
            <label for="new_hotel_provincia">Insert provincia of this hotel:</label>
            <input name="new_hotel_provincia">
            <br />
            <input type="submit" value="send">
        </form>
    </body>
</html>
