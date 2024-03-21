import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
  private TextField tfValue = new TextField();
  private TextField tfUnits = new TextField();
  private TextField tfTotal = new TextField();
  private Button btCalculate = new Button("Calculate");
  private float userNum;

  
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Create UI
    GridPane gridPane = new GridPane();
    gridPane.setHgap(5);
    gridPane.setVgap(5);
    gridPane.add(new Label("Enter your numeric value"), 0, 0);
    gridPane.add(tfValue, 1,0);
    gridPane.add(new Label("Enter units: mi, cm, ft, or lbs "), 0, 1);
    gridPane.add(tfUnits, 1, 1);
    gridPane.add(new Label("Loan Amount:"), 0, 2);
    gridPane.add(tfTotal, 1, 2);
    gridPane.add(btCalculate, 1, 3);

    
    gridPane.setAlignment(Pos.CENTER);
    tfValue.setAlignment(Pos.BOTTOM_RIGHT);
    tfUnits.setAlignment(Pos.BOTTOM_RIGHT);
    GridPane.setHalignment(btCalculate, HPos.RIGHT);

    
    btCalculate.setOnAction(e -> convertUnits());

    
    Scene scene = new Scene(gridPane, 400, 250);
    primaryStage.setTitle("Unit Converter: Miles to kilometers, Centimeters to Inches, Feet to Inches, and Pounds to Kilograms"); // Set title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

public void convertUnits() {
  //userNum = Float.parseFloat(tfValue.getText());

  String units = tfUnits.getText();
  try {
    userNum = Float.parseFloat(tfValue.getText());
  } catch (NumberFormatException ex) {
    tfTotal.setText("Invalid numeric input");
    return;
  }
  if (units.equals("mi")) {
      userNum =  (float) (userNum * 1.609344);
      units = "km";
  }else if (units.equals("cm")) {
      userNum =  (float) (userNum * 0.39370);
      units = "in";
  }else if (units.equals("ft")) {
    userNum = (float) (userNum * 12.0);  
    units = "in";
  }else if (units.equals("lbs")) {
      userNum = (float) (userNum * 0.4535923);
      units = "kg";
  }else {
      tfTotal.setText("Invalid units. this program can only handle: mi, cm, ft, or lbs");
      return;}
  tfTotal.setText(String.format("%.2f %s", userNum, units));

}

public static void main(String[] args) {
    launch(args);
}
}