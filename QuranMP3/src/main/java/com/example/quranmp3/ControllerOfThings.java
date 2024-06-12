package com.example.quranmp3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.io.File;

public class ControllerOfThings {

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnSelect;

    @FXML
    private Button btnStop;
    @FXML
    Slider slider;

    @FXML
    private MediaView mediaView;
    private Media media;
    private MediaPlayer mediaPlayer;
    Boolean isPlayied = false;

    @FXML
    void playYouKnow(ActionEvent event) {
        if(!isPlayied){
            btnPlay.setText("Pause");
            mediaPlayer.play();
            isPlayied = true;
        }
        else{
            btnPlay.setText("play");
            mediaPlayer.pause();
            isPlayied = false;

        }

    }

    @FXML
    void selectMedia(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Quran Holy");
        File file = fileChooser.showOpenDialog(null);
        if(file!=null){
            String url = file.toURI().toString();
            media = new Media(url);
            mediaPlayer = new MediaPlayer(media);

            mediaPlayer.currentTimeProperty().addListener((observableValue, oldValue, newValue) ->{
                slider.setValue(newValue.toSeconds());
            });

            mediaPlayer.setOnReady(()->{
                Duration duration = media.getDuration();
                slider.setValue(duration.toSeconds());
            });
            Scene Myscene = mediaView.getScene();
            mediaView.fitWidthProperty().bind(Myscene.widthProperty());
            mediaView.fitHeightProperty().bind(Myscene.heightProperty());

            mediaView.setMediaPlayer(mediaPlayer);

        }
    }

    @FXML
    void stopYouKnow(ActionEvent event) {

        mediaPlayer.stop();

    }
    @FXML
    void sliderDo(MouseEvent event){
        mediaPlayer.seek(Duration.seconds(slider.getValue()));
    }

}
