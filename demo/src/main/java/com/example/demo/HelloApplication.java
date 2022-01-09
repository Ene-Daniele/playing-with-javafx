package com.example.demo;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Timer;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {



        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();

        Scene scene = new Scene(root, 500, 400, Color.BLACK);
        Image icon = new Image("file:C:/Users/fired/Desktop/smol.png");

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.setFullScreenExitHint("yourmom");

        Text stuff = new Text("i think nto sure tho not ane xpert");
        stuff.setX(30);
        stuff.setY(200);
        stuff.setFont(Font.font("Verdana", 20));
        root.getChildren().add(stuff);
        stuff.setFill(Color.RED);

        Line myFatF = new Line();
        myFatF.setStartX(30);
        myFatF.setStartY(100);
        myFatF.setEndX(100);
        myFatF.setEndY(150);
        myFatF.setStroke(Color.RED);
        myFatF.setStrokeWidth(10);

        root.getChildren().add(myFatF);

        ImageView asd = new ImageView(icon);
        asd.setX(400);
        asd.setY(400);
        root.getChildren().add(asd);

        Rectangle bouncer = new Rectangle(30, 30, Color.RED);
        bouncer.setX(200);
        bouncer.setY(100);
        root.getChildren().add(bouncer);

        AnimationTimer frames = new AnimationTimer() {

            double gravity = 0.4;
            double vsp = 0;

            @Override
            public void handle(long l) {
                vsp += gravity;
                bouncer.setY(bouncer.getY() + vsp);

                if (bouncer.getY() > scene.getHeight()){
                    vsp = -15;
                }
            }
        };
        frames.start();
        frames.handle(16);

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}