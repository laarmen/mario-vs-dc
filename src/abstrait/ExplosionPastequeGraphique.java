package abstrait;

public class ExplosionPastequeGraphique implements EvenementGraphique {

	private double x ;
	private double y ;
	private double r ;

	public ExplosionPastequeGraphique(double x, double y, double r)
	{
		this.x = x ;
		this.y = y ;
		this.r = r ;
	}
	
	public double getX()
	{
		return x ;
	}
	
	public double getY()
	{
		return y ;
	}
	
	public double getR()
	{
		return r ;
	}
}
