package abstrait;

import java.util.Set;

public interface Evenement 
{
	Set<EvenementGraphique> execute(Monde m) ;
}
