<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Show</title>
    </head>
    <body>
        <h1>${action} Show</h1>
        
        <form action="FrontController?action=${action}Show" method="post">
            Código:&nbsp;<input type="text" name="txtCodigo" value="${show.codigo}" <c:if test="${action != 'Salvar'}"> readonly</c:if>/><br/>
            Descrição:&nbsp;<input type="text" name="txtDescricao" value="${show.descricao}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Dia:&nbsp;<input type="text" name="txtDia" value="${show.dia}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Hora:&nbsp;<input type="text" name="txtHora" value="${show.hora}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Bandas:&nbsp;
            <select name="cboBandas" <c:if test="${action == 'Excluir'}"> readonly</c:if>>
                <c:forEach items="${bandas}" var="banda">
                    <option value="${banda.codigo}" <c:if test="${show.banda.codigo == banda.codigo}"> selected</c:if>>${banda.nome}</option>
                </c:forEach>
            </select><br/>
            Lugar:&nbsp;
            <select name="cboLugares" <c:if test="${action == 'Excluir'}"> readonly</c:if>>
                <option value="0" <c:if test="${show.lugar.codigo == null}"> selected</c:if>></option>
                <c:forEach items="${lugares}" var="lugar">
                    <option value="${lugar.codigo}" <c:if test="${show.lugar.codigo == lugar.codigo}"> selected</c:if>>${lugar.nome}</option>
                </c:forEach>
            </select><br/>
            <input type="submit" name="btnConfirmar" value="Confirmar"/>
        </form>
                
    </body>
</html>
