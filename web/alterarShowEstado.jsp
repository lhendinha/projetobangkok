<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Estado Show</title>
    </head>
    <body>
        <h1>Alterar Estado Show</h1>
        
        <form action="FrontController?action=AlterarShowEstado" method="post">
            Código:&nbsp;<input type="text" name="txtCodigo" value="${show.codigo}" readonly /><br/>
            Descrição:&nbsp;<input type="text" name="txtDescricao" value="${show.descricao}" readonly /><br/>
            <input type="hidden" name="txtCodigo" value="${show.codigo}" />
            <input type="hidden" name="txtDescricao" value="${show.descricao}" />
            <input type="hidden" name="txtDia" value="${show.dia}" />
            <input type="hidden" name="txtHora" value="${show.hora}" />
            <input type="hidden" name="txtBanda" value="${show.banda.codigo}" />
            <input type="hidden" name="txtLugar" value="${show.lugar.codigo}" />
            Estado:&nbsp;
            <select name="cboEstado">
                <option value="ShowEstadoCadastrado" <c:if test="${show.estado.getEstado() == 'Cadastrado'}"> selected</c:if>>Cadastrado</option>
                <option value="ShowEstadoRealizado" <c:if test="${show.estado.getEstado() == 'Realizado'}"> selected</c:if>>Realizado</option>
                <option value="ShowEstadoAdiado" <c:if test="${show.estado.getEstado() == 'Adiado'}"> selected</c:if>>Adiado</option>
                <option value="ShowEstadoCancelado" <c:if test="${show.estado.getEstado() == 'Cancelado'}"> selected</c:if>>Cancelado</option>
            </select>
            <input type="submit" name="btnAlterar" value="Alterar" />
        </form>
    </body>
</html>
