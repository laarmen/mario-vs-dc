package abstrait;

public class Mobile
{
	public double xmin ;
	public double xmax ;
	public double ymin ;
	public double ymax ;
	public double vx ;
	public double vy ;

	public Mobile(double xmin, double xmax, double ymin, double ymax, double vx, double vy)
	{
		this.xmin = xmin ;
		this.xmax = xmax ;
		this.ymin = ymin ;
		this.ymax = ymax ;
		this.vx = vx ;
		this.vy = vy ;
	}
	
	public double getx()
	{
		return (xmin + xmax) / 2 ;
	}

	public double gety()
	{
		return (ymin + ymax) / 2 ;
	}

	public void addSpeed(double dvx, double dvy)
	{
		vx = vx + dvx ;
		vy = vy + dvy ;
	}
	
	public void update()
	{
		xmin = xmin + Config.dt * vx ;
		xmax = xmax + Config.dt * vx ;
		ymin = xmin + Config.dt * vy ;
		ymax = xmax + Config.dt * vy ;
		vx = vx - Config.dt * Config.frottementAerien ;
		vy = vy - Config.dt * Config.gravity ;
	}

	public boolean contact(Mobile m)
	{
		boolean b0 = Math.min(xmax, m.xmax) > Math.max(xmin, m.xmin) ;
		boolean b1 = Math.min(ymax, m.ymax) > Math.max(ymin, m.ymin) ;
		return b0 && b1 ;
	}
}
