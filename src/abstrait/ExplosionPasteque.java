package abstrait;

import java.util.HashSet;
import java.util.Set;

public class ExplosionPasteque implements Evenement {

	private Pasteque p ;
	private double x ;
	private double y ;

	private static final double reculMax = 3.0 ;
	private static final double reculMin = 1.0 ;
	
	public ExplosionPasteque(Pasteque p)
	{
		this.p = p ;
		x = (p.getXmin() + p.getXmax()) / 2 ;
		y = (p.getYmin() + p.getYmax()) / 2 ;
	}
	
	public Set<EvenementGraphique> execute(Monde m)
	{
		HashSet<EvenementGraphique> hs = new HashSet<EvenementGraphique>() ;
		hs.add(new ExplosionPastequeGraphique(x, y, p.rayonPasteque)) ;
		Mario mario = m.getMario() ;
		double xm = (mario.getXmin() + mario.getXmax())/2.0 ;
		double ym = (mario.getYmin() + mario.getYmax())/2.0 ;
		double d = Math.sqrt(
			Math.pow(x - xm, 2) + 
			Math.pow(y - ym, 2)) ;
		if(d < p.rayonPasteque)
		{
			double recul = reculMax + (reculMin - reculMax) * p.rayonPasteque * d ;
			mario.addSpeed(recul*(x-xm)/d, recul*(y-ym)/d) ;
			mario.decreasePv() ;
			hs.add(new Blessure()) ;
		}
		m.removeProjectile(p) ;
		return hs ;
	}
}
