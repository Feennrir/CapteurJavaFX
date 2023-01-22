package view;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainWindow {

    @FXML
    public ComboBox<StrategyGenerator> strategyBox;

    @FXML
    public CheckBox isCheck;

    @FXML
    public TreeView<Capteur> capteurTreeView;

    @FXML
    public Button newCapteur;

    @FXML
    public Button slider;

    @FXML
    public Button image;


    private ObservableList<Capteur> capteurs = FXCollections.observableArrayList(
            captor->new ObservableValue[]{
                    captor.getTemperatureProperty()
            }
    );

    private TreeViewCapteur treeBuilder = new TreeViewCapteur();

    private List<Capteur> listCapteur = new ArrayList<Capteur>();
    public ListView<Capteur> listView = new ListView<Capteur>();

    private TreeItem<Capteur> currentCapteur;


    public void initialize(){
        capteurs.addListener((ListChangeListener.Change<? extends Capteur> c) ->{
            while (c.next()){
                if (c.wasUpdated()){
                    listView.refresh();
                }
            }
        });

        strategyBox.getItems().add(new RandomGenerator());
        strategyBox.getItems().add(new RealisticGenerator());

        CompositeCapteur compositeCapteur = new CompositeCapteur(Capteur.currentId + " : " + "Composite");
        CapteurAlone c1 = new CapteurAlone(Capteur.currentId + " : " + " Aléatoire", new RandomGenerator());
        CapteurAlone c2 = new CapteurAlone(Capteur.currentId + " : " + " Réaliste", new RealisticGenerator());
        compositeCapteur.ajouterCapteur(c1);
        compositeCapteur.ajouterCapteur(c2);
        capteurs.add(compositeCapteur);

        TreeItem<Capteur> base = new TreeItem<>();
        base.setExpanded(true);
        for (Capteur cap: capteurs) {
            if (cap != null) {
                lauchThread(cap);
                base.getChildren().add(treeBuilder.CreateTreeItem(cap));
            }
        }
        capteurTreeView.setRoot(base);


    }

    public void IsCapteurComposite(ActionEvent actionEvent) {
        if(isCheck.isSelected()){
            strategyBox.setManaged(false);
            strategyBox.setVisible(false);
        }
        else{
            strategyBox.setManaged(true);
            strategyBox.setVisible(true);
        }
    }

    @FXML
    public void Image(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/ImageWindow.fxml"));
        fxmlLoader.setController(new ImageWindow(currentCapteur.getValue()));
        Parent image = fxmlLoader.load();
        Stage stage = new Stage();
        Scene scene = new Scene(image);
        stage.setScene(scene);
        stage.initOwner(((Button)actionEvent.getSource()).getScene().getWindow());
        stage.show();

    }

    @FXML
    public void Slider(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/FXML/SpinnerWindow.fxml"));
        fxmlLoader.setController(new SpinnerWindow(currentCapteur.getValue()));
        Parent slider = fxmlLoader.load();

        Stage stage = new Stage();
        Scene scene = new Scene(slider);
        stage.setScene(scene);
        stage.initOwner(((Button)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void Add(ActionEvent actionEvent) {
        Capteur capteur = null;

        if(!isCheck.isSelected()){
            if(strategyBox.getSelectionModel().getSelectedItem() != null)
                capteur = new CapteurAlone(Capteur.currentId + " : " + strategyBox.getSelectionModel().getSelectedItem().toString(), strategyBox.getSelectionModel().getSelectedItem());
        }
        else{
            capteur = new CompositeCapteur(Capteur.currentId + " : " + "Composite");
        }

        if(capteur != null)
        {
            lauchThread(capteur);
            if(currentCapteur != null && currentCapteur.getValue() != null && currentCapteur.getValue().getClass() == CompositeCapteur.class){
                ((CompositeCapteur)currentCapteur.getValue()).ajouterCapteur(capteur);
                currentCapteur.getChildren().add(new TreeItem<>(capteur));
            }
            else{
                capteurs.add(capteur);
                capteurTreeView.getTreeItem(0).getChildren().add(new TreeItem<>(capteur));
            }
        }
    }

    @FXML
    public void ClickOnOneCapteur(){
        currentCapteur = capteurTreeView.getSelectionModel().selectedItemProperty().getValue();
        if(currentCapteur == null){
            return;
        }
    }

    public void lauchThread(Capteur cap){
        Thread threadCapteur = new Thread(cap);
        threadCapteur.start();
        if (cap.getClass() == CompositeCapteur.class){
            CompositeCapteur composite = (CompositeCapteur)cap;
            for (Capteur capteur: composite.getListCapteur()) {
                lauchThread(capteur);
            }
        }
    }
}
