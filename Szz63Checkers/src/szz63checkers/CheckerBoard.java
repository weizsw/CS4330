/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szz63checkers;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Zwei
 */
public class CheckerBoard {
    @FXML
    private AnchorPane anchorPane;
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor;
    private Color darkColor;
    private double rectangleWidth;
    private double rectangleHeight;
    
     
    public AnchorPane getBoard()
    {
        return anchorPane != null ? anchorPane : null;
    }
    
    public int getNumRows()
    {
        return this.numRows;
    }
    
    public int getNumCols()
    {
        return this.numCols;
    }
    
    public double getWidth()
    {
        return this.boardWidth;
    }
    
    public double getHeight()
    {
        return this.boardHeight;
    }
    
    public Color getLightColor()
    {
        return this.lightColor;
    }
    
    public Color getDarkColor()
    {
        return this.darkColor;
    }
    
    public double getRectangleWidth()
    {
        return this.rectangleWidth;
    }
    
    public double getRectangleHeight()
    {
        return this.rectangleHeight;
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight)
    {
        this(numRows, numCols, boardWidth, boardHeight, Color.RED, Color.BLACK);
    }
    
    public CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor)
    {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build()
    {
        
        this.anchorPane = new AnchorPane();
        this.rectangleWidth = Math.ceil(boardWidth / numCols);
        this.rectangleHeight = Math.ceil(boardHeight / numRows);
        
        for (int r = 0; r < this.numRows; r++)
        {
            for (int c = 0; c < this.numCols; ++c)
            {
                
                Color col = ((r + c) % 2 == 0) ? lightColor : darkColor;
                
                Rectangle rect = new Rectangle(rectangleWidth, rectangleHeight, col);
                anchorPane.getChildren().add(rect);
                AnchorPane.setTopAnchor(rect, rectangleHeight * r);
                AnchorPane.setLeftAnchor(rect, rectangleWidth * c);
                
            }
        }
        
        return anchorPane;
    }
}
