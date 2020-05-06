package modelo;


public class ShowEstadoCadastrado implements ShowEstado{

    @Override
    public String getEstado() {
        return "Cadastrado";
    }

    @Override
    public String cadastrar(Show show) {
        return "O show não pode ser cadastrado, pois já está";
    }

    @Override
    public String adiar(Show show) {
        show.setEstado(new ShowEstadoAdiado());
        return "O show pode ser adiado";
    }

    @Override
    public String realizar(Show show) {
        show.setEstado(new ShowEstadoRealizado());
        return "O show pode ser realizado";
    }

    @Override
    public String cancelar(Show show) {
        show.setEstado(new ShowEstadoCancelado());
        return "O show pode ser cancelado";
    }
    
}
