
package service.medicament;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StylingInterface1 extends Parent{
    
    public StylingInterface1(){
        
    final     ImageView            image    = new ImageView(new Image(getClass().getResourceAsStream("Images/5.jpg")));
    
    image.setOpacity(0.1);
    image.setRotate(30);
    
    getChildren().add(image);
        
    this.setTranslateX(400);
    this.setTranslateY(50);
    }
    
}
