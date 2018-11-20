
package service.medicament.DossierPatient;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class StyleImg extends Parent {
    
    final ImageView    PanoramaSpace        =  new ImageView();
    final String[]     FilmeImageFolder     =  {"Images/13.jpg","Images/7_2.jpg","Images/8_1.jpg","Images/8_2.jpg","Images/9_1.jpg"};
    final Image[]      IconTab              =  new Image[FilmeImageFolder.length];
    public StyleImg(){
     
        for(int i = 0 ; i < FilmeImageFolder.length ;i++){
          Image img  =  IconTab[i]  = new Image(getClass().getResourceAsStream(FilmeImageFolder[i])); 
        }
        PanoramaSpace.setImage(IconTab[1]);
        PanoramaSpace.setFitHeight(300);PanoramaSpace.setPreserveRatio(true);
        PanoramaSpace.setOpacity(0.3);
        PanoramaSpace.setOnMouseEntered(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
            PanoramaSpace.setImage(IconTab[(int) (Math.random() * FilmeImageFolder.length)]);
            }
            
        });
       
        
     getChildren().add(PanoramaSpace);
     this.setTranslateX(750);
     this.setTranslateY(20);
     this.setRotate(20);
    }
}
