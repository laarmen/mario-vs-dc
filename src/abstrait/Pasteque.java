package abstrait;

import java.util.HashSet;

public class Pasteque extends Mobile implements Activable
{
	private boolean actif ;
	protected final double rayonPasteque = 1.5 ;
	
	public Pasteque(double xmin, double xmax, double ymin, double ymax,
			double vx, double vy)
	{
		super(xmin, xmax, ymin, ymax, vx, vy);
		actif = false ;
	}
	
	public void active()
	{
		actif = true ;
	}
	
	public HashSet<Evenement> update(double dt)
	{
		HashSet<Evenement> hs = new HashSet<Evenement>() ;
		if(actif)
		{
			hs.add(new ExplosionPasteque(this)) ;
			return hs ;
		}
		else
			return update(dt);
	}
}
