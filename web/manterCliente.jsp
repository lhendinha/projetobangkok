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
        <h1>${action} Cliente</h1>
        
        <form action="FrontController?action=${action}Cliente" method="post">
            Código:&nbsp;<input type="text" name="txtCodigo" value="${cliente.codigo}" <c:if test="${action != 'Salvar'}"> readonly</c:if> /><br />
            Nome:&nbsp;<input type="text" name="txtNome" value="${cliente.nome}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Tipo do cliente:&nbsp;
            <select name="cboCliente" <c:if test="${action == 'Excluir'}"> readonly</c:if>>
                <option value="Normal" <c:if test="${cliente.tipo.getTipo() == 'Normal'}"> selected</c:if>>Normal</option>
                <option value="Estudante" <c:if test="${cliente.tipo.getTipo() == 'Estudante'}"> selected</c:if>>Estudante</option>
                <option value="Fidelidade" <c:if test="${cliente.tipo.getTipo() == 'Fidelidade'}"> selected</c:if>>Fidelidade</option>
            </select><br/>
            <input type="submit" name="btnSalvar" value="Confirmar" />
        </form>
    </body>
</html>