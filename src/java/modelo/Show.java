package modelo;

import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import persistencia.BandaDAO;
import persistencia.LugarDAO;
import persistencia.ShowDAO;


public class Show extends Observable{

    private int codigo;
    private String descricao;
    private String dia;
    private String hora;
    private ShowEstado estado;
    private Banda banda;
    private Lugar lugar; 
    
    private int codigoBanda;
    private int codigoLugar;
    
    /*Métodos construtores*/

    public Show(int codigo, String descricao, String dia, String hora, Banda banda, Lugar lugar) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.dia = dia;
        this.hora = hora;
        this.estado = new ShowEstadoCadastrado();
        this.banda = banda;
        this.lugar = lugar;
    }
    
    /*Métodos GET e SET dos atributos*/

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public ShowEstado getEstado() {
        return estado;
    }

    public void setEstado(ShowEstado estado) {
        this.estado = estado;
    }

    public Banda getBanda() {
        if((this.codigoLugar != 0) && (this.banda == null)){
            try {
                this.banda = BandaDAO.getInstancia().obterBanda(codigoBanda);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        return this.banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

    public Lugar getLugar() {
        if((this.codigoLugar != 0) && (this.lugar == null)){
            try {
                this.lugar = LugarDAO.getInstancia().obterLugar(codigoLugar);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        
        return this.lugar;
    }

    public void setLugar(Lugar lugar) {
        this.lugar = lugar;
    }

    public int getCodigoBanda() {
        return codigoBanda;
    }

    public void setCodigoBanda(int codigoBanda) {
        this.codigoBanda = codigoBanda;
    }

    public int getCodigoLugar() {
        return codigoLugar;
    }

    public void setCodigoLugar(int codigoLugar) {
        this.codigoLugar = codigoLugar;
    }

    /*Métodos para alterar o estado do show*/
    
    public String cadastrar() throws ClassNotFoundException{
        obterClientesShow();
        String resposta = estado.cadastrar(this);
        setChanged();
        notifyObservers();
        return resposta;
    }
    
    public String realizar() throws ClassNotFoundException{
        obterClientesShow();
        String resposta = estado.realizar(this);
        setChanged();
        notifyObservers();
        return resposta;
    }
    
    public String adiar() throws ClassNotFoundException{
        obterClientesShow();
        String resposta = estado.adiar(this);
        setChanged();
        notifyObservers();
        return resposta;
    }
    
    public String cancelar() throws ClassNotFoundException{
        obterClientesShow();
        String resposta = estado.cancelar(this);
        setChanged();
        notifyObservers();
        return resposta;
    }

    /*Métodos CRUD*/

   public void salvar() throws SQLException, ClassNotFoundException{
        ShowDAO.getInstancia().salvar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        ShowDAO.getInstancia().alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        ShowDAO.getInstancia().excluir(this);
    }
    
    public static Show obterShow(int codigoShow) throws ClassNotFoundException{
        return ShowDAO.getInstancia().obterShow(codigoShow);
    }
    
    public static List<Show> obterShows() throws ClassNotFoundException{
        return ShowDAO.getInstancia().obterShows();
    }
    
    public void obterClientesShow() throws ClassNotFoundException{
        ShowDAO.getInstancia().obterClientesShow(this);
    }
    
}