package modelo;

import java.sql.SQLException;
import java.util.List;
import persistencia.LugarDAO;


public class Lugar {

    private int codigo;
    private String nome;
    private int lotacao;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    /*Métodos construtores*/

    public Lugar(int codigo, String nome, int lotacao, String logradouro, String numero, String complemento, String bairro, String cidade, String estado, String cep) {
        this.codigo = codigo;
        this.nome = nome;
        this.lotacao = lotacao;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    /*Métodos GET e SET dos atributos*/

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

    public int getLotacao() {
        return lotacao;
    }

    public void setLotacao(int lotacao) {
        this.lotacao = lotacao;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
    
    /*Métodos CRUD*/

   public void salvar() throws SQLException, ClassNotFoundException{
        LugarDAO.getInstancia().salvar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        LugarDAO.getInstancia().alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        LugarDAO.getInstancia().excluir(this);
    }
    
    public static Lugar obterLugar(int codigoLugar) throws ClassNotFoundException{
        return LugarDAO.getInstancia().obterLugar(codigoLugar);
    }
    
    public static List<Lugar> obterLugares() throws ClassNotFoundException{
        return LugarDAO.getInstancia().obterLugares();
    }
    
}