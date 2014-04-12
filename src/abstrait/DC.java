ggpackage abstrait;

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
	
	protected static final double vitesseChargement = 1.0 ;

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
		puissance = puissance + vitesseChargement ;
	}

	public void feu()
	{
		switch (armeCourante)
		{
			case 0:
				Scene.projList.add(new Pomme(/*TODO*/) ;
				break ;
			case 1:
				Trombone t = new Trombone(/*TODO*/) ;
				Scene.projList.add(t) ;
				activables.add(t) ;
				break;
			case 2:
				Brosse b = new Brosse(/*TODO*/) ;
				Scene.projList.add(b) ;
				activables.add(b) ;
				break;
			default:
				Pasteque p = new Pasteque(/*TODO*/) ;
				Scene.projList.add(p) ;
				activables.add(p) ;
		}
	}
}
