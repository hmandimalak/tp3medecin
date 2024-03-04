package metier;

import java.util.List;

public class TestMetier {
    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        List<Medecin> meds = metier.getMedecinsParMotCle("selim");
        for (Medecin m : meds) {
            System.out.println(m.getNomMedecin());
        }
    }
}
