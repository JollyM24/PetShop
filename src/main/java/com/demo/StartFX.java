package com.demo;

import com.demo.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class StartFX extends Application {

    private static Pane root;

    private static Map<String, Object> roots;

    private static Scene scene;

    private static Stage primStage;

    private static FXMLLoader loader;

    public static String users_log;

    @Override
    public void start(Stage primaryStage) throws IOException {
        primStage = primaryStage;
        primStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/logo_mini.png")));
        primStage.setTitle("Lapy&Hwost");
        primStage.setResizable(false);
        show_main();
    }

    public void show_main() throws IOException {
        loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("/fxml/main.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();
        scene = new Scene(root,1280,720);
        primStage.setScene(scene);
        primStage.show();
        roots = loader.getNamespace();
        for(Node n : root.getChildrenUnmodifiable())
            n.requestFocus();
        start_spring();
    }

    public static void reshow_main() throws IOException {
        loader = new FXMLLoader();
        URL xmlUrl = StartFX.class.getResource("/fxml/main.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();
        scene = new Scene(root,1280,720);
        primStage.setScene(scene);
        primStage.show();
        roots = loader.getNamespace();
        for(Node n : root.getChildrenUnmodifiable())
            n.requestFocus();
        starts();
    }

    public void start_spring()
    {
        new SpringThread(new SetCtx()).start();
    }

    public static void starts()
    {
        ((MainController)loader.getController()).ini();
    }

    public static void close_stage()
    {
        primStage.close();
    }

    public static void show_base() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = StartFX.class.getResource("/fxml/base.fxml");
        loader.setLocation(xmlUrl);
        root = loader.load();
        scene = new Scene(root,1280,720);
        primStage.setScene(scene);
        primStage.show();
        roots = loader.getNamespace();
        for(Node n : root.getChildrenUnmodifiable())
            n.requestFocus();
    }
}
