package nl.hu.v2pafr.service.exporter;

import java.io.File;
import java.io.FileWriter;

import nl.hu.v2pafr.model.SentenceStorage;

public class TxtExport implements Export{
	
	//Get the translated sentence form the SentenceStorage instance
	private String txt = SentenceStorage.getInstance().getSentence();
	
	@Override
	public boolean saveExport(File file) {
		if (file != null & txt != null) {
			try {
				writeTXTFile(file);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}
	
	private void writeTXTFile(File file) {
		File output = new File(file.getAbsolutePath() + ".txt");
		FileWriter writer;
		
		try {
			writer = new FileWriter(output, true);
			writer.write(txt + "\n");
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
