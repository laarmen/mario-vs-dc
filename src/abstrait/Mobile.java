package abstrait;

public class Mobile extends Bloc
{
	protected double vx ;
	protected double vy ;

	public static final double gravity = 1 ;
	public static final double frottementTerrestre = 0.1 ;
	public static final double frottementAerien = 0.1 ;

	public Mobile(double xmin, double xmax, double ymin, double ymax, double vx, double vy)
	{
		super(xmin, xmax, ymin, ymax) ;
		this.vx = vx ;
		this.vy = vy ;
	}

	public void addSpeed(double dvx, double dvy)
	{
		vx = vx + dvx ;
		vy = vy + dvy ;
	}

	public void frottement(double f, double dt)
	{
		if(vx > 0)
			vx = Math.max(vx - f * dt, 0.0) ;
		else
			vx = Math.min(vx + f * dt, 0.0) ;
	}
	
	public void update(double dt)
	{
		xmin = xmin + dt * vx ;
		xmax = xmax + dt * vx ;
		ymin = xmin + dt * vy ;
		ymax = xmax + dt * vy ;
		vx = vx - dt * frottementAerien ;
		vy = vy - dt * gravity ;
	}
}
