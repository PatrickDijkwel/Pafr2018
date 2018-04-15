package nl.hu.v2pafr.controller;

import java.io.IOException;
import java.lang.String;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.hu.v2pafr.antlr.SentenceParser;
import nl.hu.v2pafr.model.SentenceStorage;
import nl.hu.v2pafr.service.InputService;
import nl.hu.v2pafr.service.TranslatorService;

public class MainMenuController implements Initializable{

    @FXML private String Deutsch;
    @FXML private Button exportButton;
    @FXML private ComboBox<String> cbLanguage;
    @FXML private String English;
    @FXML private TextField tfinput;
    @FXML private Button translateButton;
    @FXML private TextField tfOutput;
    @FXML private Button grammarButton;
    @FXML private ComboBox<String> cbInputType;
    @FXML private VBox mainContainer;
    
    private Parent root;
    private Stage windowStage;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	cbLanguage.setItems(FXCollections.observableArrayList(TranslatorService.getLanguages()));
    	cbInputType.setItems(FXCollections.observableArrayList(InputService.getInputTypes()));
    }
    
    @FXML
    private void onClickGrammar(ActionEvent event) throws IOException {
    	loadFXMLFile("addGrammarScene.fxml");
    }

    @FXML
    private void onClickExport(ActionEvent event) {
    	loadFXMLFile("exporterScene.fxml");
    }

    @FXML
    private void onClickTranslate(ActionEvent event) {
    	if (cbLanguage.getSelectionModel().getSelectedItem() == null) {
    		return;
    	}
    	
    	try {
    		String translation = TranslatorService.getTranslatorForLanguage(cbLanguage.getSelectionModel().getSelectedItem()).translate(this.tfinput.getText());
    		tfOutput.setText(translation);
    	} catch(Exception e) {
    		e.printStackTrace();
    		return;
    	}

    	SentenceParser.parseSentence(tfinput.getText());
    	
    	SentenceStorage.getInstance().setSentence(tfOutput.getText());
    	
    	loadFXMLFile("representationScene.fxml");
    }
    
    private void loadFXMLFile(String fileName) {
    	try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
    	windowStage = new Stage();
    	windowStage.setTitle("vertaler");
    	windowStage.setScene(new Scene(root));
    	windowStage.show();
    }

}
