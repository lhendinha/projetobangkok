<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Relatório</title>
    </head>
    <body>
        <h1>${relatorio.cabecalho}</h1>
        
        <c:forEach items="${relatorio.corpo}" var="dado">
            <p>${dado}</p>
        </c:forEach>
            
        <p>${relatorio.rodape}</p>
        
        <a href="index.jsp">Página Inicial</a>
    </body>
</html>
