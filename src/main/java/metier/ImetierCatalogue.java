package metier;

import java.util.List;



public interface ImetierCatalogue {
	public List<Medecin> getMedecinsParMotCle(String mc);
	public void addMedecin(Medecin M);

}
