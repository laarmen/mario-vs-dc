package abstrait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Queue;

public class Monde {
	private Mario mario;
	private Mobile dahut;
	private double dcx, dcy;
	private HashSet<Mobile> projectiles;
	private HashSet<Bloc> blocs;
	private HashSet<Bloc> echelles;
	private HashSet<Mine> mines;
	private Queue<EvenementGraphique> event_queue;
	
	public Monde(String scene_filename) {
		try (BufferedReader fb = new BufferedReader(new FileReader(scene_filename))) {
			String ligne;
			while((ligne = fb.readLine()) != null) {
				String[] mots = ligne.split(" ");
				if (mots.length < 3)
					continue;
				if (mots[0].equals("mario")) {
					double x = Double.parseDouble(mots[1]);
					double y = Double.parseDouble(mots[2]);
					mario = new Mario(x, y);
				} else if (mots[0].equals("dc")) {
					dcx = Double.parseDouble(mots[1]);
					dcy = Double.parseDouble(mots[2]);
				} else if (mots[0].equals("solide")) {
				} else if (mots[0].equals("echelle")) {
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return the mario
	 */
	public Mario getMario() {
		return mario;
	}
	/**
	 * @return the dahut
	 */
	public Mobile getDahut() {
		return dahut;
	}
	/**
	 * @return the projectiles
	 */
	public HashSet<Mobile> getProjectiles() {
		return projectiles;
	}
	
	public void addProjectile(Mobile p)
	{
		projectiles.add(p) ;
	}
	
	public void removeProjectile(Mobile p)
	{
		projectiles.remove(p) ;
	}
	
	public HashSet<Mine> getMine() {
		return mines;
	}
	
	public void addMine(Mine m)
	{
		mines.add(m) ;
	}
	
	public void removeMine(Mine m)
	{
		mines.remove(m) ;
	}
}
