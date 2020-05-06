<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Lugares</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>

    <h1>Lugares</h1>
    
    <table border="1">
        <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>Lotação</th>
            <th>Logradouro</th>
            <th>Número</th>
            <th>Complemento</th>
            <th>Bairro</th>
            <th>Cidade</th>
            <th>Estado</th>
            <th>CEP</th>
            <th colspan="2">Ações</th>
        </tr>
        <c:forEach items="${lugares}" var="lugar">
            <tr>
                <td><c:out value="${lugar.codigo}"/></td>
                <td><c:out value="${lugar.nome}"/></td>
                <td><c:out value="${lugar.lotacao}"/></td>
                <td><c:out value="${lugar.logradouro}"/></td>
                <td><c:out value="${lugar.numero}"/></td>
                <td><c:out value="${lugar.complemento}"/></td>
                <td><c:out value="${lugar.bairro}"/></td>
                <td><c:out value="${lugar.cidade}"/></td>
                <td><c:out value="${lugar.estado}"/></td>
                <td><c:out value="${lugar.cep}"/></td>
                <td><a href="FrontController?action=PrepararAlterarLugar&codigo=<c:out value="${lugar.codigo}"/>">Editar</a></td>
                <td><a href="FrontController?action=PrepararExcluirLugar&codigo=<c:out value="${lugar.codigo}"/>">Apagar</a></td>
            </tr>
        </c:forEach>
    </table>
    
    <form action="FrontController?action=PrepararSalvarLugar" method="post">
        <input type="submit" name="btnIncluir" value="Incluir">
    </form>
    
    <br/><br/>
    
    <a href="index.jsp">Página Inicial</a>
    
    </body>
</html>