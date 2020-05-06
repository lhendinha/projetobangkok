<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shows</title>
    </head>
    <body>
        <h1>Shows</h1>
        
        <p>${cliente.nome} possui ingresso para os shows: ${shows}</p>
        
        <a href="FrontController?action=LerCliente">Cadastro de Clientes</a>
    </body>
</html>
