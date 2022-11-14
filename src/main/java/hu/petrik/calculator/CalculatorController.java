package hu.petrik.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    public TextField szamEgyLabel;
    @FXML
    public TextField szamKettoLabel;
    @FXML
    public Button buttonHozzaad;
    @FXML
    public Button ButtonKivonas;
    @FXML
    public Button buttonSzorzas;
    @FXML
    public Button buttonMaradek;
    @FXML
    public Label kiirLabel;
    @FXML
    public Button buttonElosztas;

    private boolean beviteliSzamok = false;

    public void HozzaadGomb(ActionEvent actionEvent) {
        String textField1 = szamEgyLabel.getText();
        String textField2 = szamKettoLabel.getText();
        if (beviteliSzamok){
            double elso = Double.parseDouble(szamEgyLabel.getText());
            double masodik = Double.parseDouble(szamKettoLabel.getText());
            kiirLabel.setText(String.valueOf(elso + masodik));

        }
    }

    public void Ellenorzes(String textField1, String textField2){
        kiirLabel.setText(" ");
        beviteliSzamok = false;
        Alert warning = new Alert(Alert.AlertType.WARNING);
        if (szamEgyLabel.getText().isEmpty() && szamKettoLabel.getText().isEmpty()){
            warning.setContentText("Nem adott meg számot!!!");
            warning.show();
        } else if (szamEgyLabel.getText() == null && szamKettoLabel.getText() == null) {
            warning.setContentText("Csak az első mezőt töltötte ki!");
            warning.show();
        }

    }
}