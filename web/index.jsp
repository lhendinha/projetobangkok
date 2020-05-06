<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
    </head>
    <body>
        <div>
            <h2>Clique na opção que deseja visitar</h2>
            <ul>
                <li><a href="FrontController?action=LerBanda">Cadastro de Bandas</a></li>
                <li><a href="FrontController?action=LerLugar">Cadastro de Lugares</a></li>
                <li><a href="FrontController?action=LerShow">Cadastro de Shows</a></li>
                <li><a href="FrontController?action=LerCliente">Cadastro de Clientes</a></li>
                <li><a href="FrontController?action=PrepararSalvarIngresso">Emitir Ingresso</a></li>
            </ul>
        </div>
    </body>
</html>
