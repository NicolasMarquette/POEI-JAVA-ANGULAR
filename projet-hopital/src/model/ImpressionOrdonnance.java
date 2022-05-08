package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import view.AffichageOrdonnance;

public class ImpressionOrdonnance {

	public void imprimerOrdonnance(Ordonnance ordonnance) throws IOException {

		String nomPatient = ordonnance.getPatient();
		String[] dateOrdonnance = ordonnance.getDateVisite().split(" ");

		String filePath = "ordonnance_" + nomPatient + "_" + dateOrdonnance[0] + ".txt";

		FileWriter fw = new FileWriter(filePath);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(new AffichageOrdonnance().afficherOrdonnance(ordonnance));
		bw.close();
	}

}
