package modelo;


public class ShowEstadoAdiado implements ShowEstado {

    @Override
    public String getEstado() {
        return "Adiado";
    }

    @Override
    public String cadastrar(Show show) {
        return "O show não pode ser cadastrado, pois está adiado";
    }

    @Override
    public String adiar(Show show) {
        return "O show não pode ser adiado, pois já está";
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
