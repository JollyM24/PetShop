package com.demo.controller;

import com.demo.PetApp;
import com.demo.StartFX;
import com.demo.bd.Users;
import com.demo.bd.UsersImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BaseController {

    private UsersImpl usersImpl = (UsersImpl) PetApp.ctx.getBean("usersImpl");

    @FXML
    private Pane ak;

    @FXML
    private Pane glav;

    @FXML
    private Pane catal;

    @FXML
    private Pane error404;

    @FXML
    private Pane vyh;

    @FXML
    private Pane vyhda;

    @FXML
    private ScrollPane scrpane;

    @FXML
    private Button glbut;

    @FXML
    private Button catbut;

    @FXML
    private Button accbut;

    @FXML
    private Label ac_log;

    @FXML
    private Label ac_par;

    @FXML
    private Label ac_id;

    private Users users;

    public void initialize()
    {
        setgl();
        users = usersImpl.getuser(StartFX.users_log);
        if(users != null)
        {
            ac_log.setText(users.getUsername());
            ac_par.setText(users.getPassword());
            ac_id.setText(users.getId() + "");
        }else{
            error404.setVisible(true);
        }
    }

    public void exitd()
    {
        vyh.setVisible(true);

    }

    public void vyhida()
    {
        vyh.setVisible(false);
        vyhda.setVisible(true);
    }

    public void vyhino()
    {
        vyh.setVisible(false);
    }

    public void unvisvyhda() throws IOException {
        vyhda.setVisible(false);
        StartFX.close_stage();
        StartFX.reshow_main();
        StartFX.users_log = null;
    }

    public void unvis404() throws IOException {
        error404.setVisible(false);
        StartFX.close_stage();
        StartFX.reshow_main();
    }

    public void setacc()
    {
        glav.setVisible(false);
        ak.setVisible(true);
        catal.setVisible(false);
        accbut.setStyle("-fx-background-color:  rgba(255, 255, 255, 0.5);");
        glbut.setStyle("-fx-background-color: #3b6e2b;");
        catbut.setStyle("-fx-background-color: #3b6e2b;");
        scrpane.setFitToHeight(true);
    }

    public void setgl()
    {
        glav.setVisible(true);
        ak.setVisible(false);
        catal.setVisible(false);
        glbut.setStyle("-fx-background-color:  rgba(255, 255, 255, 0.5);");
        accbut.setStyle("-fx-background-color: #3b6e2b;");
        catbut.setStyle("-fx-background-color: #3b6e2b;");
        scrpane.setFitToHeight(true);
    }

    public void setcat()
    {
        glav.setVisible(false);
        ak.setVisible(false);
        catal.setVisible(true);
        catbut.setStyle("-fx-background-color:  rgba(255, 255, 255, 0.5);");
        glbut.setStyle("-fx-background-color: #3b6e2b;");
        accbut.setStyle("-fx-background-color: #3b6e2b;");
        scrpane.setFitToHeight(false);
    }
}
