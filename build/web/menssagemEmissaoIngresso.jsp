<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emitir o ingresso</title>
    </head>
    <body>
        <h1>Suceso ao emitir o ingresso</h1>
        <p>${cliente.nome} é um cliente ${cliente.tipo.getTipo()}, por isso o ingresso teve ${cliente.tipo.getDesconto()}% de desconto.</p>
        <br/>
        <a href="index.jsp">Página Inicial</a>
    </body>
</html>
