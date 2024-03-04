package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MetierImpl implements ImetierCatalogue {
@Override
public List<Medecin> getMedecinsParMotCle(String mc) {
	 List<Medecin> meds= new ArrayList<Medecin>();
	 Connection conn=SingletonConnection.getConnection();
	 try {
		PreparedStatement ps= conn.prepareStatement("select * from MEDECIN where NOM_MEDECIN LIKE ?");
		ps.setString(1, "%"+mc+"%");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Medecin m = new Medecin();
			m.setIdMedecin(rs.getLong("ID_MEDECIN"));
			m.setNomMedecin(rs.getString("NOM_MEDECIN"));
			m.setspecialite(rs.getString("SPECIALITE"));
			m.setFaculte(rs.getString("FACULTE"));
			meds.add(m);
		}
	 } catch (SQLException e) {
		 e.printStackTrace();
	 }
	 return meds;
	}
	@Override
	public void addMedecin(Medecin M) {
	// TODO Auto-generated method stub
	}
}

