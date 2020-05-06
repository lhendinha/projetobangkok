package modelo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import persistencia.ClienteDAO;

public class Cliente implements Observer{

    private int codigo;
    private String nome;
    private ClienteTipo tipo;
    private List<Observable> shows = null;
    
    /*Métodos construrores*/
    
    public Cliente(int codigo, String nome, String tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipo = ClienteTipoFactory.create(tipo);
    }

    /*Métodos GET e SET*/
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ClienteTipo getTipo() {
        return tipo;
    }

    public void setTipo(ClienteTipo tipo) {
        this.tipo = tipo;
    }
    
    public List<Observable> getShows() {
        return shows;
    }

    public void setShows(List<Observable> shows) {
        this.shows = shows;
    }
        
    /*Métodos do observer*/
    
    public void adicionarShow (Show show) throws SQLException, ClassNotFoundException{
        if(shows ==  null){
            shows = new ArrayList<>();
        }
        this.shows.add(show);
        show.addObserver(this);
        ClienteDAO.getInstancia().adicionarShow(this, show);
    }
    
    public void adicionarShowBusca (Show show) throws SQLException, ClassNotFoundException{
        show.addObserver(this);
    }
    
    @Override
    public void update(Observable showSubject, Object arg) {
        if (showSubject instanceof Show){
            Show show = (Show) showSubject;
            System.out.println(getNome() + " o estado do " + show.getDescricao() + " foi alterado para " + show.getEstado().getEstado() + ".");
        }
    }
    
    /*Métodos CRUD*/
    
    public void salvar() throws SQLException, ClassNotFoundException{
        ClienteDAO.getInstancia().salvar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        ClienteDAO.getInstancia().alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        ClienteDAO.getInstancia().excluir(this);
    }
    
    public static Cliente obterCliente(int codigoCliente) throws ClassNotFoundException{
        return ClienteDAO.getInstancia().obterCliente(codigoCliente);
    }
    
    public static List<Cliente> obterClientes() throws ClassNotFoundException{
        return ClienteDAO.getInstancia().obterClientes();
    }
            
}