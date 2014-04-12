package abstrait;

import java.util.HashSet;

public class Trombone extends Mobile implements Activable
{
	private boolean actif ;

	public Trombone(double xmin, double xmax, double ymin, double ymax,
			double vx, double vy) 
	{
		super(xmin, xmax, ymin, ymax, vx, vy);
		actif = false ;
	}
	
	public boolean getActif()
	{
		return actif ;
	}
	
	public void active()
	{
		actif = true ;
	}
	
	public HashSet<Evenement> update(double dt)
	{
		return update(dt);
	}
}
