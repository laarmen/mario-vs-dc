package abstrait ;

public class Mario extends Mobile
{
	private int pv ;
	private boolean saut ;
	private boolean dahutPris ;
	
	protected static final int pvInit = 10 ;
	protected static final double puissanceDeSaut = 2 ;
	protected static final double largeurMario = 1 ;
	protected static final double hauteurMario = 1 ;
	protected static final double accelerationTerrestre = 0.1 ;
	protected static final double accelerationAerienne = 0.1 ;

	public Mario(double x, double y)
	{
		super(x, x + largeurMario, y, y + hauteurMario, 0, 0) ;
		pv = pvInit ;
		saut = true ;
		dahutPris = false ;
	}
	
	public int getPv() {
		return pv;
	}

	public void decreasePv()
	{
		pv-- ;
	}

	public boolean getDahutPris() {
		return dahutPris ;
	}
	
	public void saute()
	{
		if(!saut)
		{
			addSpeed(0.0,puissanceDeSaut) ;
		}
	}
	
	public void update(boolean haut, boolean gauche, boolean droite, double dt)
	{
		if(saut)
		{
			if(gauche)
			{
				addSpeed(- accelerationAerienne, 0.0) ;
			}
			if(droite)
			{
				addSpeed(accelerationAerienne, 0.0) ;
			}
		}
		
		else
		{
			if(gauche)
			{
				addSpeed(-accelerationTerrestre,0.0) ;
			}
			if(droite)
			{
				addSpeed(accelerationTerrestre,0.0) ;
			}
			if(haut)
			{
				saute() ;
			}
		}
		
		xmin = xmin + dt * vx ;
		xmax = xmax + dt * vx ;
		ymin = xmin + dt * vy ;
		ymax = xmax + dt * vy ;
		
		if(saut)
		{
			frottement(frottementAerien, dt) ;
			vy = vy - dt * gravity ;
		}
		
		else
		{
			frottement(frottementTerrestre, dt) ;
			vy = vy - dt * gravity ;
		}
		
		//TODO régler les problèmes de contact
	}
}
