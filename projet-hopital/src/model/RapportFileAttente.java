package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RapportFileAttente {

	public RapportFileAttente() {
	}

	public void ecrireRapport(int id, String dateTime) throws IOException {

		String filePath = "fileAttenteLog.txt";
		File file = new File(filePath);
		FileWriter fw;
		BufferedWriter bw;

		if (!file.isFile()) {
			file.createNewFile();
			fw = new FileWriter(filePath);
			bw = new BufferedWriter(fw);
			String head = " id patient |     date     |   heure\n---------------------------------------\n";
			bw.write(head);
			bw.close();
		}

		fw = new FileWriter(filePath, true);
		bw = new BufferedWriter(fw);
		String[] tableDateTime = dateTime.split(" ");
		String lineToAppend = String.format("% 7d     |  %s  |  %s\n", id, tableDateTime[0], tableDateTime[1]);
		bw.write(lineToAppend);
		bw.close();
	}

}
