package abstrait;

public class Bloc
{
	protected double xmin ;
	protected double xmax ;
	protected double ymin ;
	protected double ymax ;

	public Bloc(double xmin, double xmax, double ymin, double ymax)
	{
		this.xmin = xmin ;
		this.xmax = xmax ;
		this.ymin = ymin ;
		this.ymax = ymax ;
	}
	
	public double getXmin()
	{
		return xmin ;
	}

	public double getXmax()
	{
		return xmax ;
	}

	public double getYmin()
	{
		return ymin ;
	}

	public double getYmax()
	{
		return ymax ;
	}
	
	public boolean contact(Mobile m)
	{
		boolean b0 = Math.min(xmax, m.xmax) > Math.max(xmin, m.xmin) ;
		boolean b1 = Math.min(ymax, m.ymax) > Math.max(ymin, m.ymin) ;
		return b0 && b1 ;
	}
}
