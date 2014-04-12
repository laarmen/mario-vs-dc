package abstrait;

import java.util.HashSet;

public class Pasteque extends Mobile implements Activable
{
	private boolean actif ;
	
	
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
	
	public HashSet<Evenement> update()
	{
		if(actif)
		{
			HashSet<Evenement> hs = new HashSet<Evenement>() ;
			hs.add(new ExplosionPasteque((xmin + xmax)/2, (ymin + ymax)/2,  ))
			return 
		}
	}
}
