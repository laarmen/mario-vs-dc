package abstrait;

import java.util.HashSet;
import java.util.Set;

public class ExplosionBrosse implements Evenement {

	private double x ;
	private double y ;
	private double r ;

	public ExplosionBrosse(double x, double y, double r)
	{
		this.x = x ;
		this.y = y ;
		this.r = r ;
	}
	
	public Set<EvenementGraphique> execute(Monde m)
	{
		HashSet<EvenementGraphique> hs = new HashSet<EvenementGraphique>() ;
		hs.add(new ExplosionBrosseGraphique(x,y,r)) ;
		return hs ;
	}
}
