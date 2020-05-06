<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Shows</title>
    </head>
    <body>

    <h1>Shows</h1>
    
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Descrição</th>
            <th>Dia</th>
            <th>Hora</th>
            <th>Estado</th>
            <th>Banda</th>
            <th>Lugar</th>
            <th colspan="3">Ações</th>
        </tr>
        <c:forEach items="${shows}" var="show">
            <tr>
                <td><c:out value="${show.codigo}"/></td>
                <td><c:out value="${show.descricao}"/></td>
                <td><c:out value="${show.dia}"/></td>
                <td><c:out value="${show.hora}"/></td>
                <td><c:out value="${show.estado.getEstado()}"/></td>
                <td><c:out value="${show.banda.nome}"/></td>
                <td><c:out value="${show.lugar.nome}"/></td>
                <td><a href="FrontController?action=PrepararAlterarShow&codigo=<c:out value="${show.codigo}"/>">Alterar</a></td>
                <td><a href="FrontController?action=PrepararExcluirShow&codigo=<c:out value="${show.codigo}"/>">Excluir</a></td>
                <td><a href="FrontController?action=PrepararAlterarShowEstado&codigo=<c:out value="${show.codigo}"/>">Alterar Estado</a></td>
            </tr>
        </c:forEach>
    </table>
    
    <form action="FrontController?action=PrepararSalvarShow" method="post">
        <input type="submit" name="btnIncluir" value="Incluir">
    </form>
    
    <br/><br/>
    
    <a href="index.jsp">Página Inicial</a>
    
    </body>
</html>