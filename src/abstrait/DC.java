package abstrait;

import java.util.PriorityQueue;

public class DC
{
	public double x ;
	public double y ;
	public int armeCourante ; // 0 pomme ; 1 trombone ; 2 brosse ; 3 pastèque
	public double tempsRecharge ;
	public double puissance ;
	public int état ; // 0 repos ; 1 chargement ; 2 tir en cours
	public PriorityQueue<Activable> activables ;
	

	public DC(double x, double y)
	{
		this.x = x ;
		this.y = y ;
		armeCourante = 1 ; 
		tempsRecharge = 0.0 ;
		puissance = 0.0 ;
		activables = new PriorityQueue<Activable>() ;
	}

	public void changeArme(int i)
	{
		armeCourante = i ;
	}
	
	public void charge()
	{
		puissance = puissance + Config.vitesseChargement ;
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
