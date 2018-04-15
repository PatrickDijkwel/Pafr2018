package nl.hu.v2pafr.controller;

import nl.hu.v2pafr.view.MainWindow;

public class MainApplication {
	private String[] args;
	
	public MainApplication(String args[]) {
		this.args = args;
		startGUI();
	}
	
	private void startGUI() {
		(new MainWindow()).openWindow(this.args);
	}

}
