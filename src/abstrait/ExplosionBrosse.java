package abstrait;

import java.util.HashSet;
import java.util.Set;

public class ExplosionBrosse implements Evenement 
{
	private Brosse b ;
	private double x ;
	private double y ;

	public ExplosionBrosse(Brosse b)
	{
		this.b = b ;
		x = (b.getXmin() + b.getXmax()) / 2 ;
		y = (b.getYmin() + b.getYmax()) / 2 ;
	}
	
	public Set<EvenementGraphique> execute(Monde m)
	{
		HashSet<EvenementGraphique> hs = new HashSet<EvenementGraphique>() ;
		hs.add(new ExplosionBrosseGraphique(x, y, b.getRayon())) ;
		m.removeProjectile(b) ;
		return hs ;
	}
}
