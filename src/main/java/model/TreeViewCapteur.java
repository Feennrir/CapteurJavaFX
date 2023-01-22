package model;

import javafx.scene.control.TreeItem;

public class TreeViewCapteur {

    public TreeItem<Capteur> CreateTreeItem(Capteur cap){
        TreeItem<Capteur> beginning = new TreeItem<>(cap);
        beginning.setExpanded(true);

        if (cap.getClass() == CompositeCapteur.class){
            CompositeCapteur composite = (CompositeCapteur)cap;

            for (Capteur capteur: composite.getListCapteur()) {
                if (capteur != null) {
                    beginning.getChildren().add(CreateTreeItem(capteur));
                }
            }
        }
        return beginning;
    }
}
