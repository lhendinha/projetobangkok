<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Ingresso</title>
    </head>
    <body>
        <h1>${action} Ingresso</h1>
        
        <form action="FrontController?action=${action}Ingresso" method="post">
            Clientes:&nbsp;
            <select name="cboCliente">
                <c:forEach items="${clientes}" var="cliente">
                    <option value="${cliente.codigo}">${cliente.nome}</option>
                </c:forEach>
            </select><br />
            Shows:&nbsp;
            <select name="cboShow">
                <c:forEach items="${shows}" var="show">
                    <option value="${show.codigo}">${show.descricao}</option>
                </c:forEach>
            </select><br />
            <input type="submit" name="btnEmitir" value="Emitir" />            
        </form>
    </body>
</html>
