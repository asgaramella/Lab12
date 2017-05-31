package it.polito.tdp.rivers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.rivers.model.Model;
import it.polito.tdp.rivers.model.River;
import it.polito.tdp.rivers.model.Statistiche;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RiversController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<River> boxRiver;

    @FXML
    private TextField txtStartDate;

    @FXML
    private TextField txtEndDate;

    @FXML
    private TextField txtNumMeasurements;

    @FXML
    private TextField txtFMed;

    @FXML
    private TextField txtK;

    @FXML
    private Button btnSimula;

    @FXML
    private TextArea txtResult;

    @FXML
    void doCompila(ActionEvent event) {
    	if(boxRiver.getValue()!=null){
    		float media=model.getMediaFlows(boxRiver.getValue());
    		LocalDate first=boxRiver.getValue().getFlows().get(0).getDay();
    		int tot=boxRiver.getValue().getFlows().size();
    		
    		txtStartDate.appendText(first.toString());
    		txtEndDate.appendText(boxRiver.getValue().getFlows().get(tot-1).getDay().toString());
    		txtNumMeasurements.appendText(Integer.toString(tot));
    		txtFMed.appendText(Float.toString(media));
    	}
    	else
    		txtResult.appendText("Inserire un fiume!");
    }

    @FXML
    void doSimula(ActionEvent event) {
    	if(boxRiver.getValue()!=null){
    		try{
    		int k=Integer.parseInt(txtK.getText());
    		Statistiche st=model.startSimulazione(k, boxRiver.getValue());
    		
    		
    		txtResult.appendText("Il numero di giorni in cui non si è potuta garantire l'erogazione è "+Integer.toString(st.getNrGiorniInsoddisfatti())+"\n");
    		float occMedia= (float) (st.getOccupazioneTot()/st.getTotIngressi());
    		txtResult.appendText("Occupazione media nel corso della simulazione "+Float.toString(occMedia)+"\n");
    		
    		
    		
    		
    		}
    		catch(Exception e){
    			txtResult.appendText("Inserire un numero!\n");
    		}
    	
    	}
    	else{
    		txtResult.appendText("Inserire fiume!\n");
    	}
    }

    @FXML
    void initialize() {
        assert boxRiver != null : "fx:id=\"boxRiver\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtStartDate != null : "fx:id=\"txtStartDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtEndDate != null : "fx:id=\"txtEndDate\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtNumMeasurements != null : "fx:id=\"txtNumMeasurements\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtFMed != null : "fx:id=\"txtFMed\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtK != null : "fx:id=\"txtK\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Rivers.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Rivers.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;
		boxRiver.getItems().addAll(model.getAllRivers());
		
		
	}
}

