package nl.hu.v2pafr.service;

import java.util.ArrayList;

import nl.hu.v2pafr.service.exporter.Export;
import nl.hu.v2pafr.service.exporter.TxtExport;
import nl.hu.v2pafr.service.exporter.XmlExport;

public class ExporterService {
	private final static String TXT = "TXT";
	private final static String XML = "XML";
	
	public static ArrayList<String> getExportTypes() {
		ArrayList<String> exportTypes = new ArrayList<>();
		
		exportTypes.add(TXT);
		exportTypes.add(XML);
		
		return exportTypes;
	}
	
	public static Export getExporterForType(String type) {
		if (type.equals(TXT)) {
			return new TxtExport();
		}
		if (type.equals(XML)) {
			return new XmlExport();
		}
		return null;
	}

}
