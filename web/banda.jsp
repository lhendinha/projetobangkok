<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Bandas</title>
    </head>
    <body>

    <h1>Bandas</h1>
    
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Gênero</th>
            <th colspan="3">Ações</th>
        </tr>
        <c:forEach items="${bandas}" var="banda">
            <tr>
                <td><c:out value="${banda.codigo}"/></td>
                <td><c:out value="${banda.nome}"/></td>
                <td><c:out value="${banda.genero}"/></td>
                <td><c:out value="${banda.avaliacao}"/></td>
                <td><a href="FrontController?action=PrepararAlterarBanda&codigo=<c:out value="${banda.codigo}"/>">Editar</a></td>
                <td><a href="FrontController?action=PrepararExcluirBanda&codigo=<c:out value="${banda.codigo}"/>">Apagar</a></td>
                <td><a href="FrontController?action=EmitirRelatorio&tipo=Banda&codigo=<c:out value="${banda.codigo}"/>">Emitir Relatório</a></td>
            </tr>
        </c:forEach>
    </table>
    
    <form action="FrontController?action=PrepararSalvarBanda" method="post">
        <input type="submit" name="btnIncluir" value="Incluir">
    </form>
    
    <br/><br/>
    
    <a href="index.jsp">Página Inicial</a>
    
    </body>
</html>