package abstrait;

public class Mario extends Mobile
{
	public int pv ;
	public boolean saut ;
	public boolean dahutPris ;

	public Mario(double x, double y)
	{
		super(x - Config.largeurMario/2, 
			x + Config.largeurMario/2, 
			y - Config.hauteurMario/2, 
			y + Config.hauteurMario/2,
			0,0) ;
		pv = Config.pvInit ;
		saut = true ;
		dahutPris = false ;
	}
	
	public void decreasePv()
	{
		pv-- ;
	}

	public void saute()
	{
		if(!saut)
		{
			addSpeed(0.0,Config.puissanceDeSaut) ;
		}
	}

	public void frottement(double f)
	{
		if(vx > 0)
			vx = Math.max(vx - f * Config.dt, 0.0) ;
		else
			vx = Math.min(vx + f * Config.dt, 0.0) ;
	}
	
	public void update(boolean haut, boolean gauche, boolean droite)
	{
		if(saut)
		{
			if(gauche)
			{
				addSpeed(- Config.accelerationAerienne, 0.0) ;
			}
			if(droite)
			{
				addSpeed(Config.accelerationAerienne, 0.0) ;
			}
		}
		
		else
		{
			if(gauche)
			{
				addSpeed(- Config.accelerationTerrestre,0.0) ;
			}
			if(droite)
			{
				addSpeed(Config.accelerationTerrestre,0.0) ;
			}
			if(haut)
			{
				saute() ;
			}
		}
		
		xmin = xmin + Config.dt * vx ;
		xmax = xmax + Config.dt * vx ;
		ymin = xmin + Config.dt * vy ;
		ymax = xmax + Config.dt * vy ;
		
		if(saut)
		{
			frottement(Config.frottementAerien) ;
			vy = vy - Config.dt * Config.gravity ;
		}
		
		else
		{
			frottement(Config.frottementTerrestre) ;
		}
		
		//TODO régler les problèmes de contact
	}
}
