module Timer.Clock {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.web;
    requires javafx.media;
    requires java.desktop;
    requires jsyn;

    opens project;
    opens project.views;
    opens project.controller;
    opens project.images;
    opens project.sounds;
}