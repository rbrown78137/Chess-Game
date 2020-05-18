package App;
import javafx.scene.layout.StackPane;
class BoardStackPane extends StackPane {
	int row;
	int column;
	BoardStackPane(int row, int column){
		this.row = row;
		this.column = column;
		/*setOnMouseClicked(e->{
			System.out.println("Clicked " + row + " "+ column);
			
		});*/
	}
}