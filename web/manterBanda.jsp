<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Bandas</title>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <h1>${action} Bandas</h1>
        
        <form action="FrontController?action=${action}Banda" method="post">
            Código:&nbsp;<input type="text" name="txtCodigo" value="${banda.codigo}" <c:if test="${action != 'Salvar'}"> readonly</c:if>/><br/>
            Nome:&nbsp;<input type="text" name="txtNome" value="${banda.nome}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Gênero:&nbsp;<input type="text" name="txtGenero" value="${banda.genero}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Avaliacao:&nbsp;<input type="text" name="txtAvaliacao" value="${banda.avaliacao}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            <input type="submit" name="btnConfirmar" value="Confirmar"/>
        </form>
                
    </body>
</html>
