package controle;

public class ActionFactory {

    public static Action create(String action){
        Action actionObject = null;
        String nomeClasse = "action." + action + "Action";
        Class classe = null;
        Object objeto = null;
        
        try {
            classe = Class.forName(nomeClasse);
            objeto = classe.newInstance();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        
        if(!(objeto instanceof Action)) return null;
        
        actionObject = (Action) objeto;
        
        return actionObject;
    }
    
}
