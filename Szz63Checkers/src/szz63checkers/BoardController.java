/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szz63checkers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Zwei
 */
public class BoardController implements Initializable {
    
    @FXML
    private VBox vBox;
    
    private Stage stage;
    private AnchorPane anchorPane;
    private CheckerBoard board;
    
    private double boardWidth;
    private double boardHeight;
    private int numRows = 8;
    private int numCols = 8;
    private double menuBarHeight;
    
    @FXML
    private MenuBar menuBar;
    private final Color defaultLight = Color.RED;
    private final Color defaultDark = Color.BLACK;
    private final Color blueLight = Color.SKYBLUE;
    private final Color blueDark = Color.DARKBLUE;
    private Color lightColor = defaultLight;
    private Color darkColor = defaultDark;
   
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void ready(Stage stage) {
        this.stage = stage;
        menuBarHeight = menuBar.getHeight();
        render(lightColor, darkColor);
        vBox.widthProperty().addListener(lambdaChangeListener);
        vBox.heightProperty().addListener(lambdaChangeListener);
    }
    
    ChangeListener<Number> lambdaChangeListener = (ObservableValue<? extends Number> observable, Number oldValue, final Number newValue) -> {
        render(lightColor, darkColor);
    };
    
    private void render(Color lightColor, Color darkColor) {
        
        if(board != null) {
           vBox.getChildren().remove(board.getBoard());
        }
        
        boardWidth = vBox.getWidth();
        boardHeight = vBox.getHeight() - menuBarHeight; 
        
        
        board = new CheckerBoard(numRows, numCols, boardWidth, boardHeight, lightColor, darkColor);
        vBox.getChildren().add(board.build());
    }
    
   
    
    @FXML
    private void Grid16(ActionEvent event) {
        numRows = 16;
        numCols = 16;
        render(lightColor, darkColor);
    }
    
    @FXML
    private void Grid10(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        render(lightColor, darkColor);
    }
    
    @FXML
    private void Grid8(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        render(lightColor, darkColor);
    }
    
    @FXML
    private void Grid3(ActionEvent event) {
        numRows = 3;
        numCols = 3;
        render(lightColor, darkColor);
    }
    
    @FXML
    private void Blue(ActionEvent event) {
        vBox.getChildren().remove(board.getBoard());
        lightColor = blueLight;
        darkColor = blueDark;
        render(lightColor, darkColor);
        
    }
    
    @FXML
    private void Default(ActionEvent event) {
        vBox.getChildren().remove(board.getBoard());
        lightColor = defaultLight;
        darkColor = defaultDark;
        render(lightColor, darkColor);
    }

    
}
