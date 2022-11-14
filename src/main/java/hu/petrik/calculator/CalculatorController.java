package hu.petrik.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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

    @FXML
    public void HozzaadGomb(ActionEvent actionEvent) {
        String textField1 = szamEgyLabel.getText();
        String textField2 = szamKettoLabel.getText();
        Ellenorzes(textField1, textField2);
        if (beviteliSzamok) {
            double elso = Double.parseDouble(szamEgyLabel.getText());
            double masodik = Double.parseDouble(szamKettoLabel.getText());
            kiirLabel.setText(String.valueOf(elso + masodik));
        }
    }

    @FXML
    public void Ellenorzes(String textField1, String textField2) {
        kiirLabel.setText(" ");
        beviteliSzamok = false;
        Alert warning = new Alert(Alert.AlertType.WARNING);
        if (szamEgyLabel.getText().isEmpty() && szamKettoLabel.getText().isEmpty()) {
            warning.setContentText("Nem adott meg számot!!!");
            warning.show();
        } else if (szamEgyLabel.getText() == null && szamKettoLabel.getText() == null) {
            warning.setContentText("Minden mező kitöltése kötelező vagy ellenőrizze számot adott e meg");
            warning.show();
        } else {
            //szam-e?
            Boolean szamEElso = true;
            Boolean szamEMasodik = true;
            try {
                Double elsoSzam = Double.parseDouble(textField1);
            } catch (NumberFormatException e) {
                szamEElso = false;

            }
            try {
                Double masodikSzam = Double.parseDouble(textField2);
            } catch (NumberFormatException e) {
                szamEMasodik = false;
            }

            if (!szamEElso && !szamEMasodik) {
                warning.setContentText("Minden mező kitöltése kötelező vagy ellenőrizze számot adott e meg!!");
                warning.show();
            } else {
                beviteliSzamok = true;
            }
        }


    }


    @FXML
    public void KivonasGomb(ActionEvent actionEvent) {
        String textField1 = szamEgyLabel.getText();
        String textField2 = szamKettoLabel.getText();
        Ellenorzes(textField1, textField2);
        if (beviteliSzamok) {
            double elso = Double.parseDouble(szamEgyLabel.getText());
            double masodik = Double.parseDouble(szamKettoLabel.getText());
            kiirLabel.setText(String.valueOf(elso - masodik));
        }
    }

    @FXML
    public void SzorzasGomb(ActionEvent actionEvent) {
        String textField1 = szamEgyLabel.getText();
        String textField2 = szamKettoLabel.getText();
        Ellenorzes(textField1, textField2);
        if (beviteliSzamok) {
            double elso = Double.parseDouble(szamEgyLabel.getText());
            double masodik = Double.parseDouble(szamKettoLabel.getText());
            kiirLabel.setText(String.valueOf(elso * masodik));
        }
    }

    @FXML
    public void ElosztasGomb(ActionEvent actionEvent) {
        String textField1 = szamEgyLabel.getText();
        String textField2 = szamKettoLabel.getText();
        Ellenorzes(textField1, textField2);
        if (beviteliSzamok) {
            double elso = Double.parseDouble(szamEgyLabel.getText());
            double masodik = Double.parseDouble(szamKettoLabel.getText());
            kiirLabel.setText(String.valueOf(elso / masodik));
        }
    }

    @FXML
    public void MaradekGomb(ActionEvent actionEvent) {
        String textField1 = szamEgyLabel.getText();
        String textField2 = szamKettoLabel.getText();
        Ellenorzes(textField1, textField2);
        if (beviteliSzamok) {
            double elso = Double.parseDouble(szamEgyLabel.getText());
            double masodik = Double.parseDouble(szamKettoLabel.getText());
            double maradek = elso % masodik;
            double matek = Math.round(maradek*100)/100;
            kiirLabel.setText(String.valueOf(matek));
        }

    }
}