package arvores.uteis;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lpoliveira
 */
public class Uteis {

    public static List<Integer> explode(String lista) {
        List<Integer> listaRetorno = new ArrayList<Integer>();
        String[] explodeLista = lista.split(",");
        for(String itemLista : explodeLista){
            try {
                listaRetorno.add(Integer.valueOf(itemLista));
            } catch( Exception e ) {
                System.out.println("Não foi possível adicionar o objeto "+itemLista+" na lista. (Não é numérico)");
            }
        }
        return listaRetorno;
    }
    
}
