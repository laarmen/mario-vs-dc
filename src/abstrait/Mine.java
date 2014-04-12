package abstrait;

import java.util.HashSet;

public class Mine {
	private double x ;
	private double y ;
	private final double porteeMines = 0.3 ;
	
	public double getX()
	{
		return x ;
	}
	
	public double getY()
	{
		return y ;
	}
	
	public HashSet<Evenement> update(Mario mario)
	{
		HashSet<Evenement> hs = new HashSet<Evenement>() ;
		if(mario.getSaut() && 
			(Math.abs((mario.getXmin() + mario.getXmax())/2 - x) < porteeMines) &&
			(Math.abs(mario.getYmin() - y) < 0.1))
		{
			hs.add(new MarcheMine(this)) ;
		}
		return hs ;
	}
}