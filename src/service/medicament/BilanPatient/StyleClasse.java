
package service.medicament.BilanPatient;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StyleClasse extends Parent{
 
     public StyleClasse(){
        final ImageView ecran     = new ImageView(new Image(getClass().getResourceAsStream("Images/6.jpeg")));
        ecran.setOpacity(0.6);
        ecran.setRotate(20);
        
        
        getChildren().add(ecran);
        this.setTranslateX(700);
        this.setTranslateY(50);
        
        
     }
}
