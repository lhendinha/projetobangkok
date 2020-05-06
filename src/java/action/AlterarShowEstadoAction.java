package action;

import controle.Action;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Show;

public class AlterarShowEstadoAction implements Action{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String codigo = request.getParameter("txtCodigo");
        String nomeEstado = request.getParameter("cboEstado");
        
        if(codigo.equals("") || nomeEstado.equals("")){
            response.sendRedirect("index.jsp");
        } else {
            try {
                Show show = Show.obterShow(Integer.parseInt(codigo));
                show.getBanda();
                show.getLugar();
                
                if (nomeEstado.equals("ShowEstadoCadastrado")) {
                    request.setAttribute("mensagem", show.cadastrar());
                } else {
                    if (nomeEstado.equals("ShowEstadoRealizado")){
                        request.setAttribute("mensagem", show.realizar());
                    } else {
                        if (nomeEstado.equals("ShowEstadoAdiado")) {
                            request.setAttribute("mensagem", show.adiar());
                        } else {
                            if (nomeEstado.equals("ShowEstadoCancelado")){
                                request.setAttribute("mensagem", show.cancelar());
                            } else {
                                request.setAttribute("mensagem", "O estado não foi alterado");
                            }
                        }
                    }
                }

                show.alterar();
                RequestDispatcher view = request.getRequestDispatcher("mensagemAlteracaoEstado.jsp");
                view.forward(request, response);
            } catch (ClassNotFoundException e) {
                response.sendRedirect("erro.jsp");
                e.printStackTrace();
            } catch (SQLException e) {
                response.sendRedirect("erro.jsp");
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
    
}
