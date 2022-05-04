package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RapportFileAttente {

	public RapportFileAttente() {
	}

	public void ecrireRapport(int id, String dateTime) throws IOException {

		String filePath = "fileAttenteLog.txt";
		FileWriter fw = new FileWriter(filePath, true);
		BufferedWriter bw = new BufferedWriter(fw);
		String lineToAppend = String.format("%s  %s\n", id, dateTime);
		bw.write(lineToAppend);
		bw.close();
	}

}
