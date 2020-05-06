package modelo;

public class RelatorioFactory {
    
    public static Relatorio create(String tipo){
        Relatorio RelatorioEstadoFactory = null;
        String nomeRelatorio = "modelo.Relatorio" + tipo;
        Class classe = null;
        Object objeto = null;
        
        try {
            classe = Class.forName(nomeRelatorio);
            objeto = classe.newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        
        if(!(objeto instanceof Relatorio)) return  null;
        
        RelatorioEstadoFactory = (Relatorio) objeto;
        
        return RelatorioEstadoFactory;
    }
    
}