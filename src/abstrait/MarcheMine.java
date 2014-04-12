package abstrait;

import java.util.HashSet;
import java.util.Set;

public class MarcheMine implements Evenement {

	private Mine mine ;

	public MarcheMine(Mine mine)
	{
		this.mine = mine ;
	}
	
	public Set<EvenementGraphique> execute(Monde m) {
		HashSet<EvenementGraphique> hs = new HashSet<EvenementGraphique>() ;
		hs.add(new Blessure()) ;
		m.removeMine(mine) ;
		return hs ;
	}
}
