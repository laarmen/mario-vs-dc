package abstrait;

import java.util.HashSet;
import java.util.Set;

public class ExplosionPasteque implements Evenement {

	private double x ;
	private double y ;
	private double r ;

	private static final double reculMax = 3.0 ;
	private static final double reculMin = 1.0 ;
	
	public ExplosionPasteque(double x, double y, double r)
	{
		this.x = x ;
		this.y = y ;
		this.r = r ;
	}
	
	public Set<EvenementGraphique> execute(Monde m)
	{
		HashSet<EvenementGraphique> hs = new HashSet<EvenementGraphique>() ;
		hs.add(new ExplosionPastequeGraphique(x,y,r)) ;
		Mario mario = m.getMario() ;
		double xm = (mario.getXmin() + mario.getXmax())/2.0 ;
		double ym = (mario.getYmin() + mario.getYmax())/2.0 ;
		double d = Math.sqrt(
			Math.pow(x - xm, 2) + 
			Math.pow(y - ym, 2)) ;
		if(d<r)
		{
			double recul = reculMax + (reculMin - reculMax) * r * d ;
			mario.addSpeed(recul*(x-xm)/d, recul*(y-ym)/d) ;
			mario.decreasePv() ;
			hs.add(new Blessure()) ;
		}
		return hs ;
	}
}
