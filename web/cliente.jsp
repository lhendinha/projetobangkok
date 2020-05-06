<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Cliente</title>
    </head>
    <body>
        <h1>Clientes</h1>
        
        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nome</th>
                <th>Tipo do Cliente</th>
                <th colspan="4">Ações</th>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.codigo}" /></td>
                    <td><c:out value="${cliente.nome}" /></td>
                    <td><c:out value="${cliente.tipo.getTipo()}" /></td>
                    <td><a href="FrontController?action=PrepararAlterarCliente&codigo=<c:out value="${cliente.codigo}" />">Alterar</a></td>
                    <td><a href="FrontController?action=PrepararExcluirCliente&codigo=<c:out value="${cliente.codigo}" />">Excluir</a></td>
                    <td><a href="FrontController?action=ExibirShows&codigo=<c:out value="${cliente.codigo}"/>">Exibir Shows</a></td>
                    <td><a href="FrontController?action=EmitirRelatorio&tipo=Cliente&codigo=<c:out value="${cliente.codigo}" />">Emitir Relatório</a></td>
                </tr>
            </c:forEach>
        </table>
        
        <form action="FrontController?action=PrepararSalvarCliente" method="post">
            <input type="submit" name="btnSalvar" value="Incluir">
        </form>
        
        <br/><br/>
        
        <a href="index.jsp">Página Inicial</a>
    </body>
</html>