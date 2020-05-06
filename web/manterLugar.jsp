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
        <h1>${action} Lugar</h1>
        
        <form action="FrontController?action=${action}Lugar" method="post">
            Código:&nbsp;<input type="text" name="txtCodigo" value="${lugar.codigo}" <c:if test="${action != 'Salvar'}"> readonly</c:if>/><br/>
            Nome:&nbsp;<input type="text" name="txtNome" value="${lugar.nome}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Lotação:&nbsp;<input type="text" name="txtLotacao" value="${lugar.lotacao}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Logradouro:&nbsp;<input type="text" name="txtLogradouro" value="${lugar.logradouro}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Número:&nbsp;<input type="text" name="txtNumero" value="${lugar.numero}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Complemento:&nbsp;<input type="text" name="txtComplemento" value="${lugar.complemento}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Bairro:&nbsp;<input type="text" name="txtBairro" value="${lugar.bairro}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Cidade:&nbsp;<input type="text" name="txtCidade" value="${lugar.cidade}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            Estado:&nbsp;
            <select name="cboEstado" <c:if test="${action == 'Excluir'}"> disabled</c:if>>
                <option value="AC" <c:if test="${lugar.estado == \"AC\"}"> selected</c:if>>AC</option>
                <option value="AL" <c:if test="${lugar.estado == \"AL\"}"> selected</c:if>>AL</option>
                <option value="AP" <c:if test="${lugar.estado == \"AP\"}"> selected</c:if>>AP</option>
                <option value="AM" <c:if test="${lugar.estado == \"AM\"}"> selected</c:if>>AM</option>
                <option value="CE" <c:if test="${lugar.estado == \"CE\"}"> selected</c:if>>CE</option>
                <option value="DF" <c:if test="${lugar.estado == \"DF\"}"> selected</c:if>>DF</option>
                <option value="ES" <c:if test="${lugar.estado == \"ES\"}"> selected</c:if>>ES</option>
                <option value="GO" <c:if test="${lugar.estado == \"GO\"}"> selected</c:if>>GO</option>
                <option value="MA" <c:if test="${lugar.estado == \"MA\"}"> selected</c:if>>MA</option>
                <option value="MT" <c:if test="${lugar.estado == \"MT\"}"> selected</c:if>>MT</option>
                <option value="MS" <c:if test="${lugar.estado == \"MS\"}"> selected</c:if>>MS</option>
                <option value="MG" <c:if test="${lugar.estado == \"MG\"}"> selected</c:if>>MG</option>
                <option value="PA" <c:if test="${lugar.estado == \"PA\"}"> selected</c:if>>PA</option>
                <option value="PB" <c:if test="${lugar.estado == \"PB\"}"> selected</c:if>>PB</option>
                <option value="PR" <c:if test="${lugar.estado == \"PR\"}"> selected</c:if>>PR</option>
                <option value="PE" <c:if test="${lugar.estado == \"PE\"}"> selected</c:if>>PE</option>
                <option value="PI" <c:if test="${lugar.estado == \"PI\"}"> selected</c:if>>PI</option>
                <option value="RJ" <c:if test="${lugar.estado == \"RJ\"}"> selected</c:if>>RJ</option>
                <option value="RN" <c:if test="${lugar.estado == \"RN\"}"> selected</c:if>>RN</option>
                <option value="RS" <c:if test="${lugar.estado == \"RS\"}"> selected</c:if>>RS</option>
                <option value="RO" <c:if test="${lugar.estado == \"RO\"}"> selected</c:if>>RO</option>
                <option value="RR" <c:if test="${lugar.estado == \"RR\"}"> selected</c:if>>RR</option>
                <option value="SC" <c:if test="${lugar.estado == \"SC\"}"> selected</c:if>>SC</option>
                <option value="SP" <c:if test="${lugar.estado == \"SP\"}"> selected</c:if>>SP</option>
                <option value="SE" <c:if test="${lugar.estado == \"SE\"}"> selected</c:if>>SE</option>
                <option value="TO" <c:if test="${lugar.estado == \"TO\"}"> selected</c:if>>TO</option>
            </select><br/>
            CEP:&nbsp;<input type="text" name="txtCep" value="${lugar.cep}" <c:if test="${action == 'Excluir'}"> readonly</c:if>/><br/>
            <input type="submit" name="btnConfirmar" value="Confirmar"/>
        </form>
                
    </body>
</html>
