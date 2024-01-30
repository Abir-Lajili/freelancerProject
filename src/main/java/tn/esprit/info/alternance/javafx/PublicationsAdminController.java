package tn.esprit.info.alternance.javafx;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import khadamni.modeles.Publication;
import khadamni.utiles.Connection;

public class PublicationsAdminController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView table;

    @FXML
    private Button btnEnregistrer;

    @FXML
    private Button btnModifier;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnSupprimerTous;

    @FXML
    private TableColumn<Publication, String> contenuPub;


    @FXML
    private TableColumn<Publication, String> datePub;

    @FXML
    private TableColumn<Publication, Integer> idPub;

    @FXML
    private TableColumn<Publication, String> statusPub;

    @FXML
    private TextField tfContenu;

    @FXML
    private TextField tfDate;

    @FXML
    private TextField tfStatus;

    @FXML
    private TextField tfTitre;

    @FXML
    private TableColumn<Publication, String> titrePub;


    public ObservableList<Publication> getPublications() {
        ObservableList<Publication> publications = FXCollections.observableArrayList();
        Connection myConnection = new Connection();
        java.sql.Connection jdbcConnection = myConnection.getConnection();
        String query = "SELECT * FROM publications"; // Corrected SQL query

        try {
            PreparedStatement st = jdbcConnection.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Publication pub = new Publication();
                pub.setPublicationId(rs.getInt("PublicationId"));
                pub.setTitle(rs.getString("Title"));
                pub.setContent(rs.getString("Content"));
                pub.setDate(rs.getDate("Date"));
                pub.setStatus((rs.getString("Status")));
                publications.add(pub);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return publications;
    }

    public void showPublications(){
        ObservableList<Publication> listPublications = getPublications();
        table.setItems(listPublications);
        idPub.setCellFactory(column -> {
            return new TableCell<Publication, Integer>() {
                @Override
                protected void updateItem(Integer item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(String.valueOf(item));
                    }
                }
            };
        });




    }


    @FXML
    void onEnregisterPublication(ActionEvent event) {

    }

    @FXML
    void onModifierPublication(ActionEvent event) {

    }

    @FXML
    void onSupprimerPublication(ActionEvent event) {

    }

    @FXML
    void onSupprimerTous(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnEnregistrer != null : "fx:id=\"btnEnregistrer\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert btnModifier != null : "fx:id=\"btnModifier\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert btnSupprimer != null : "fx:id=\"btnSupprimer\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert btnSupprimerTous != null : "fx:id=\"btnSupprimerTous\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert contenuPub != null : "fx:id=\"contenuPub\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert datePub != null : "fx:id=\"datePub\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert idPub != null : "fx:id=\"idPub\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert statusPub != null : "fx:id=\"statusPub\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert tfContenu != null : "fx:id=\"tfContenu\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert tfDate != null : "fx:id=\"tfDate\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert tfStatus != null : "fx:id=\"tfStatus\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert tfTitre != null : "fx:id=\"tfTitre\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";
        assert titrePub != null : "fx:id=\"titrePub\" was not injected: check your FXML file 'publicationsAdmin.fxml'.";

    }

}
