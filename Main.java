package betterFormArch;

import com.example.javafxproject.notCard;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.util.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.lang.Math;


public class Main extends Application {


    private Canvas canvas;
    private Image cardImages;

    public static void main (String [] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        canvas = new Canvas();
        int row, col;
        Button button = new Button("redraw");
        VBox v = new VBox(button);
        v.setAlignment(Pos.CENTER);

        HBox inhand = new HBox();
        inhand.setAlignment(Pos.CENTER);
        ImageView view1,view2,view3;

        row = randomRow();
        col = randomCol();
        Image im1 = new Image(getName(row,col));
        view1 = new ImageView(im1);
        view1.setImage(im1);


        row = randomRow();
        col = randomCol();
        Image im2 = new Image(getName(row,col));
        view2 = new ImageView(im2);
        view2.setImage(im2);

        row = randomRow();
        col = randomCol();
        Image im3 = new Image(getName(row,col));
        view3 = new ImageView(im3);
        view3.setImage(im3);

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                view1.setImage(new Image(getName(randomRow(), randomCol())));
                view2.setImage(new Image(getName(randomRow(), randomCol())));
                view3.setImage(new Image(getName(randomRow(), randomCol())));
            }
        });

        inhand.getChildren().add(view1);
        inhand.getChildren().add(view2);
        inhand.getChildren().add(view3);

        inhand.setSpacing(10);
        v.getChildren().add(inhand);

        Scene scene = new Scene(v);
        stage.setScene( scene );
        stage.setTitle("Random Cards");
        stage.show();

    }


    private int randomRow() {

        int random = (int)(Math.random()*3);
        return random;
    }
    private int randomCol() {

        int random = (int)(Math.random()*12);
        return random;
    }

    public String getName(int row, int col){
        String cardName [] = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        String [] Suit = {"diamonds", "clubs", "hearts", "spades"};

        String s = cardName[col] + "_of_" + Suit[row] + ".png";
        System.out.println(s);

        return s;
    }

    }


