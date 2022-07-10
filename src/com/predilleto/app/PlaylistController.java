package com.predilleto.app;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.predilleto.app.connection.DbHandler;

public class PlaylistController {
	private File directory;
	private File[] files;
	private ArrayList<File> songs;
	private Score funkScore, hpScore, sertanejoScore, indieScore, rockScore, popScore;
	private ArrayList<Score> scores;
	private DbHandler dbHandler;

	public PlaylistController() {
		funkScore = new Score("FUNK");
		hpScore = new Score("HIP HOP");
		sertanejoScore = new Score("SERTANEJO");
		indieScore = new Score("INDIE");
		rockScore = new Score("ROCK");
		popScore = new Score("POP");

		scores = new ArrayList<Score>(
				Arrays.asList(funkScore, hpScore, sertanejoScore, indieScore, rockScore, popScore));

	}

	public int getIndexScore(String genre) {
		for (int i = 0; i < scores.size(); i++) {
			if (scores.get(i).getGenreName().equals(genre)) {
				return i;
			}
		}
		return -1;

	}

	public void setScore(String genre, Integer points) {
		scores.get(getIndexScore(genre)).setScore(points);

	}

	public Score getScore(String genre) {
		return scores.get(getIndexScore(genre));

	}

	public ArrayList<File> start() {
		songs = new ArrayList<File>();
		directory = new File("src/com/predilleto/repository/musicUsed");
		files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				songs.add(file);
			}
		}
		return songs;
	}

	public ArrayList<File> scoreShuffle() {

		Collections.sort(scores);
		dbHandler = new DbHandler();
		int j = 0;
		int k = 0;
		int l = 0;
		List<File> goodsongs = new ArrayList<File>();
		List<File> goodsongs1 = new ArrayList<File>();
		List<File> goodsongs2 = new ArrayList<File>();
		List<File> badsongs = new ArrayList<File>();
		Collections.shuffle(songs);
		for (int i = 0; i < songs.size(); i++) {

			File file = songs.get(i);
			if (scores.get(0).getGenreName().equals(dbHandler.getGenre(file.toString())) && j < 5) {
				songs.remove(i);
				goodsongs.add(file);
				j++;
			}
			if (scores.get(1).getGenreName().equals(dbHandler.getGenre(file.toString())) && k < 3) {
				songs.remove(i);
				goodsongs1.add(file);
				k++;
			}

			if (scores.get(2).getGenreName().equals(dbHandler.getGenre(file.toString())) && l < 3) {
				songs.remove(i);
				goodsongs2.add(file);
				l++;
			}
			if (getScore(dbHandler.getGenre(file.toString())).getScore() < -4) {

				badsongs.add(file);

			}

		}
		songs.addAll(0, goodsongs);
		songs.addAll(5, goodsongs1);
		songs.addAll(8, goodsongs2);
		songs.removeAll(badsongs);
		songs.addAll(badsongs);
		return songs;
	}

	public ArrayList<File> shuffle() {
		Collections.shuffle(songs);
		return songs;
	}

	public File getDirectory() {
		return directory;
	}

	public void setDirectory(File directory) {
		this.directory = directory;
	}

	public File[] getFiles() {
		return files;
	}

	public void setFiles(File[] files) {
		this.files = files;
	}

	public ArrayList<File> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<File> songs) {
		this.songs = songs;
	}

}
