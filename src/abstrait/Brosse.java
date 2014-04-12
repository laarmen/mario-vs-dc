package abstrait;

import java.util.HashSet;

public class Brosse extends Mobile implements Activable
{
	private boolean actif ;
	private double rayon ;
	
	public Brosse(double xmin, double xmax, double ymin, double ymax,
			double vx, double vy, double rayon)
	{
		super(xmin, xmax, ymin, ymax, vx, vy);
		this.rayon = rayon ;
		this.actif = false ;
	}
	
	public void active()
	{
		actif = true ;
	}
	
	public double getRayon()
	{
		return rayon ;
	}
	
	public HashSet<Evenement> update(double dt)
	{
		HashSet<Evenement> hs = new HashSet<Evenement>() ;
		if(actif)
		{
			hs.add(new ExplosionBrosse(this)) ;
			return hs ;
		}
		else
			return update(dt);
	}
}
