package abstrait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;
import java.util.Vector;

public class Monde {
	private Mario mario;
	private Mobile dahut;
	private double dcx, dcy;
	private Vector<Mobile> projectiles;
	private Vector<Bloc> blocs;
	private Vector<Echelle> echelles;
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
	public Vector<Mobile> getProjectiles() {
		return projectiles;
	}

}
