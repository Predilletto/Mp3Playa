package com.predilleto.app;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.predilleto.app.connection.DbHandler;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MainController implements Initializable {

	@FXML
	private Pane mainPane;
	@FXML
	private Label titleLabel, artistLabel, genreLabel;
	@FXML
	private ImageView playPauseView, nextView, previousView, shuffleView, volumeView, heartView;
	@FXML
	private Slider volumeSlider;
	@FXML
	private ProgressBar progressSong;
	@FXML
	private CheckBox shuffleCheck;

	private boolean paused = true;
	private boolean isMuted = false;
	private boolean checked = false;
	private boolean shuffled = false;

	private ArrayList<File> songs;

	private int songNumber=0;

	private Timer songext;
	private TimerTask task;

	private Media media;
	private MediaPlayer mediaPlayer;

	DbHandler dbHandler = new DbHandler();
	PlaylistController pHandler = new PlaylistController();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		songs = pHandler.start();
		String filepath = songs.get(songNumber).toString();
		media = new Media(songs.get(songNumber).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		titleLabel.setText(dbHandler.getTitle(filepath));
		artistLabel.setText(dbHandler.getArtist(filepath));
		genreLabel.setText(dbHandler.getGenre(filepath));

		volumeSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);

			}
		});

	}

	public void checkShuffle() {
		if (checked == false) {
			checked = true;
		} else {
			checked = false;
		}
	}

	public void hearted() {
		pHandler.getScore(genreLabel.getText()).addScore(5);
		Image img = new Image(getClass().getResourceAsStream("icons/like.png"));
		heartView.setImage(img);

	}

	public void onDragPlay() {

		if (paused == true) {
			Image img = new Image(getClass().getResourceAsStream("icons/playondrag.png"));
			playPauseView.setImage(img);
		} else {
			Image img = new Image(getClass().getResourceAsStream("icons/pausedrag.png"));
			playPauseView.setImage(img);

		}

	}

	public void mouseOutPlay() {
		if (paused == true) {
			Image img = new Image(getClass().getResourceAsStream("icons/play-button.png"));
			playPauseView.setImage(img);
		} else {
			Image img = new Image(getClass().getResourceAsStream("icons/pause.png"));
			playPauseView.setImage(img);
		}
	}

	public void playMedia() {
		if (this.paused == true) {

			beginSongext();
			mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			this.paused = false;
			mediaPlayer.play();

			Image img = new Image(getClass().getResourceAsStream("icons/pauseDrag.png"));
			playPauseView.setImage(img);

		} else {
			endTimer();
			this.paused = true;
			mediaPlayer.pause();
			mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			Image img = new Image(getClass().getResourceAsStream("icons/playondrag.png"));
			playPauseView.setImage(img);
		}

	}

	public void mouseOnNext() {
		Image img = new Image(getClass().getResourceAsStream("icons/nextON.png"));
		nextView.setImage(img);

	}

	public void mouseOutNext() {
		Image img = new Image(getClass().getResourceAsStream("icons/next.png"));
		nextView.setImage(img);

	}

	public void nextMedia() {
		Image img = new Image(getClass().getResourceAsStream("icons/nextON.png"));
		nextView.setImage(img);
		Image img2 = new Image(getClass().getResourceAsStream("icons/heart.png"));
		heartView.setImage(img2);

		if (songNumber < songs.size() - 1) {
			songNumber++;
			if (checked == false) {
				heartbytime();
			}
			endTimer();
			mediaPlayer.stop();
			String filepath = songs.get(songNumber).toString();
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			titleLabel.setText(dbHandler.getTitle(filepath));
			artistLabel.setText(dbHandler.getArtist(filepath));
			genreLabel.setText(dbHandler.getGenre(filepath));
			mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			mediaPlayer.play();
			beginSongext();

		} else {
			songNumber = 0;
			if (checked == false) {
				heartbytime();
			}
			endTimer();
			mediaPlayer.stop();
			String filepath = songs.get(songNumber).toString();
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			titleLabel.setText(dbHandler.getTitle(filepath));
			artistLabel.setText(dbHandler.getArtist(filepath));
			genreLabel.setText(dbHandler.getGenre(filepath));
			mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			mediaPlayer.play();
			beginSongext();
		}

	}

	public void mouseOnPrevious() {
		Image img = new Image(getClass().getResourceAsStream("icons/previousON.png"));
		previousView.setImage(img);

	}

	public void mouseOutPrevious() {
		Image img = new Image(getClass().getResourceAsStream("icons/previous.png"));
		previousView.setImage(img);

	}

	public void heartbytime() {
		double ext = progressSong.getProgress();
		if (ext > 0.6 && ext < 0.9) {
			pHandler.getScore(genreLabel.getText()).addScore(3);

		} else if (ext > 0.3 && ext < 0.6) {
			pHandler.getScore(genreLabel.getText()).addScore(1);
		} else if (ext > 0.9) {
			pHandler.getScore(genreLabel.getText()).addScore(5);
		}

		else if (ext < 0.2) {
			pHandler.getScore(genreLabel.getText()).addScore(-2);
		}
	}

	public void previousMedia() {
		Image img = new Image(getClass().getResourceAsStream("icons/previousON.png"));
		previousView.setImage(img);
		Image img2 = new Image(getClass().getResourceAsStream("icons/heart.png"));
		heartView.setImage(img2);

		if (songNumber > 0) {
			songNumber--;
			if (checked == false) {
				heartbytime();
			}
			endTimer();
			mediaPlayer.stop();
			String filepath = songs.get(songNumber).toString();
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			titleLabel.setText(dbHandler.getTitle(filepath));
			artistLabel.setText(dbHandler.getArtist(filepath));
			genreLabel.setText(dbHandler.getGenre(filepath));
			mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			mediaPlayer.play();
			beginSongext();

		} else {
			songNumber = songs.size() - 1;
			if (checked == false) {
				heartbytime();
			}
			endTimer();
			mediaPlayer.stop();
			String filepath = songs.get(songNumber).toString();
			media = new Media(songs.get(songNumber).toURI().toString());
			mediaPlayer = new MediaPlayer(media);
			titleLabel.setText(dbHandler.getTitle(filepath));
			artistLabel.setText(dbHandler.getArtist(filepath));
			genreLabel.setText(dbHandler.getGenre(filepath));
			mediaPlayer.setVolume(volumeSlider.getValue() * 0.01);
			mediaPlayer.play();
			beginSongext();

		}

	}

	public void mouseOnVolume() {
		if (isMuted == false) {
			Image img = new Image(getClass().getResourceAsStream("icons/no-soundOn.png"));
			volumeView.setImage(img);
		} else {
			Image img = new Image(getClass().getResourceAsStream("icons/volume-upON.png"));
			volumeView.setImage(img);

		}

	}

	public void volume() {
		if (isMuted == false) {

			Image img = new Image(getClass().getResourceAsStream("icons/no-soundOn.png"));
			volumeView.setImage(img);
			volumeSlider.setValue(0.0);
			isMuted = true;

		} else {
			Image img = new Image(getClass().getResourceAsStream("icons/volume-upON.png"));
			volumeView.setImage(img);
			volumeSlider.setValue(100.0);
			isMuted = false;
		}
	}

	public void mouseOutVolume() {
		if (isMuted == false) {
			Image img = new Image(getClass().getResourceAsStream("icons/volume-up.png"));
			volumeView.setImage(img);
		} else {
			Image img = new Image(getClass().getResourceAsStream("icons/no-sound.png"));
			volumeView.setImage(img);

		}

	}

	public void mouseOnShuffle() {
		if (shuffled) {
			Image img = new Image(getClass().getResourceAsStream("icons/shuffle.png"));
			shuffleView.setImage(img);

		} else {
			Image img = new Image(getClass().getResourceAsStream("icons/shuffle-arrows.png"));
			shuffleView.setImage(img);
		}
	}

	public void mouseOutShuffle() {
		if (!shuffled) {
			Image img = new Image(getClass().getResourceAsStream("icons/shuffle.png"));
			shuffleView.setImage(img);
		} else {
			Image img = new Image(getClass().getResourceAsStream("icons/shuffle-arrows.png"));
			shuffleView.setImage(img);
		}
	}

	public void shuffle() {
		if (shuffled == true) {
			shuffled = false;
			songNumber = -1;
			songs = pHandler.start();
			Image img = new Image(getClass().getResourceAsStream("icons/shuffle.png"));
			shuffleView.setImage(img);
		} else if (shuffled == false && checked == false) {
			shuffled = true;
			songNumber = -1;
			songs = pHandler.shuffle();
			Image img = new Image(getClass().getResourceAsStream("icons/shuffle-arrows.png"));
			shuffleView.setImage(img);

		}

		else if (shuffled == false && checked == true) {
			shuffled = true;
			songNumber = -1;
			songs = pHandler.scoreShuffle();
			Image img = new Image(getClass().getResourceAsStream("icons/shuffle-arrows.png"));
			shuffleView.setImage(img);
		}

	}

	public void beginSongext() {
		songext = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				double current = mediaPlayer.getCurrentTime().toSeconds();
				double end = media.getDuration().toSeconds();
				double ext = current / end;
				progressSong.setProgress(ext);

				if (ext == 1) {

					endTimer();
				}
				progressSong.setStyle("-fx-accent: violet");
			}
		};
		songext.scheduleAtFixedRate(task, 0, 1000);
	}

	public void endTimer() {

		songext.cancel();
	}

}
