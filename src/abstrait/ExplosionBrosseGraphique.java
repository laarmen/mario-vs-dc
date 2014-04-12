package abstrait;

public class ExplosionBrosseGraphique implements EvenementGraphique
{
	private double x ;
	private double y ;
	private double r ;

	public ExplosionBrosseGraphique(double x, double y, double r)
	{
		this.x = x ;
		this.y = y ;
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
