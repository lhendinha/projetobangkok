package modelo;

import java.sql.SQLException;
import java.util.List;
import persistencia.BandaDAO;


public class Banda {

    private int codigo;
    private String nome;
    private String genero;
    private float avaliacao;

    /*Métodos construtores*/
    
    public Banda() { }
    
    public Banda(int codigo, String nome, String genero, float avaliacao) {
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.avaliacao = avaliacao;
    }
    
    //Métodos GET e SET dos atributos*/

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
   

    public String getAvaliacao() {
        if (this.avaliacao >= 0 && this.avaliacao < 10) {
            return "Péssimo";
        } else if (this.avaliacao >= 10 && this.avaliacao < 20) {
            return "Ruim";
        } else if (this.avaliacao >= 20 && this.avaliacao < 30) {
            return "Médio";
        } else if (this.avaliacao >= 30 && this.avaliacao < 40) {
            return "Regular";
        } else if (this.avaliacao >= 50 && this.avaliacao < 60) {
            return "Bom";
        } else if (this.avaliacao >= 60 && this.avaliacao < 70) {
            return "Muito bom";
        } else if (this.avaliacao >= 70 && this.avaliacao < 80) {
            return "Ótimo";
        } else if (this.avaliacao >= 80 && this.avaliacao < 90) {
            return "Muito Ótimo";
        } else if (this.avaliacao >= 90 && this.avaliacao <= 100) {
            return "Perfeito";
        } else {
            return "Não foi possível definir";
        }
    }

    public void setAvaliacao(float avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    /*Métodos CRUD*/

   public void salvar() throws SQLException, ClassNotFoundException{
        BandaDAO.getInstancia().salvar(this);
    }
    
    public void alterar() throws SQLException, ClassNotFoundException{
        BandaDAO.getInstancia().alterar(this);
    }
    
    public void excluir() throws SQLException, ClassNotFoundException{
        BandaDAO.getInstancia().excluir(this);
    }
    
    public static Banda obterBanda(int codigoBanda) throws ClassNotFoundException{
        return BandaDAO.getInstancia().obterBanda(codigoBanda);
    }
    
    public static List<Banda> obterBandas() throws ClassNotFoundException{
        return BandaDAO.getInstancia().obterBandas();
    }
}