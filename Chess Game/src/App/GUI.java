package App;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class GUI extends Application {
public void start(Stage primaryStage) {
	ChessBoard chess = new ChessBoard();
	Scene scene = new Scene(chess, 800, 800);
	primaryStage.setTitle("Chess Game");
	primaryStage.setScene(scene);
	primaryStage.show();
	// prints board
	for(int i = 0; i<8; i++) {
		for(int k = 0; k<8; k++)
			System.out.printf("%4d", chess.board[i][k]);
		System.out.print("\n");
		}
}
public static void main(String[] args) {
	launch(args);
}
}
