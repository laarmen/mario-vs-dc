package abstrait;

import java.util.PriorityQueue;

public class DC
{
	private double x ;
	private double y ;
	private int armeCourante ; // 0 pomme ; 1 trombone ; 2 brosse ; 3 pastèque
	private boolean chargement; 
	private double tempsPomme ;
	private double tempsTrombone ;
	private double tempsBrosse ;
	private double tempsPasteque ;
	private double puissance ;
	private PriorityQueue<Activable> activables ;
	
	private final double vitesseChargement = 1.0 ;
	private final double tailleProjectile = 0.3 ;
	private final double vmax = 20 ;
	private final double facteurCraie = 1 ;

	public DC(double x, double y)
	{
		this.x = x ;
		this.y = y ;
		armeCourante = 1 ; 
		tempsPomme = 0.0 ;
		tempsTrombone = 0.0 ;
		tempsBrosse = 0.0 ;
		tempsPasteque = 0.0 ;
		puissance = 0.0 ;
		activables = new PriorityQueue<Activable>() ;
	}
	
	public double getX()
	{
		return x ;
	}
	
	public double getY()
	{
		return y ;
	}
	
	public int getArmeCourante()
	{
		return armeCourante ;
	}
	
	public void setArmeCourante(int i)
	{
		armeCourante = i ;
	}
	
	public boolean getChargement()
	{
		return chargement ;
	}
	
	public double getTempsPomme()
	{
		return tempsPomme ;
	}
	
	public double getTempsTrombone()
	{
		return tempsTrombone ;
	}
	
	public double getTempsBrosse()
	{
		return tempsBrosse ;
	}
	
	public double getTempsPasteque()
	{
		return tempsPasteque ;
	}
	
	public double getPuissance()
	{
		return puissance ;
	}

	public void charge()
	{
		puissance = puissance + 1 ;
	}
	
	public void activation()
	{
		Activable a = activables.poll() ;
		if(a != null)
		{
			a.active() ;
			activables.remove(a) ;
		}
	}

	public void feu(Monde m, double xVise, double yVise)
	{
		double xmin = x - tailleProjectile/2 ;
		double xmax = x + tailleProjectile/2 ;
		double ymin = y - tailleProjectile/2 ;
		double ymax = y + tailleProjectile/2 ;
		
		double vx = xVise - x ;
		double vy = yVise - y ;
		double d = Math.sqrt(vx*vx + vy*vy) ;
		double a = (4/Math.PI) * vmax * Math.atan(puissance * vitesseChargement) ;
		vx = vx * a / d ;
		vy = vy * a / d ;
		
		switch (armeCourante)
		{
			case 0:
				m.addProjectile(new Pomme(xmin,xmax,ymin,ymax,vx,vy)) ;
				break ;
			case 1:
				Trombone t = new Trombone(xmin,xmax,ymin,ymax,vx,vy) ;
				m.addProjectile(t) ;
				activables.add(t) ;
				break;
			case 2:
				Brosse b = new Brosse(xmin,xmax,ymin,ymax,vx,vy,facteurCraie*a) ;
				m.addProjectile(b) ;
				activables.add(b) ;
				break;
			default:
				Pasteque p = new Pasteque(xmin,xmax,ymin,ymax,vx,vy) ;
				m.addProjectile(p) ;
				activables.add(p) ;
		}
	}
}
