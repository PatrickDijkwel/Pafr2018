package nl.hu.v2pafr.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import nl.hu.v2pafr.model.SentenceStorage;

public class RepresentationController implements Initializable {

	@FXML private VBox representationController;
    @FXML private Label lblSentence;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	lblSentence.setText(SentenceStorage.getInstance().getSentence());
	}
    
}
