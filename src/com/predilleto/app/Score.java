package com.predilleto.app;

public class Score implements Comparable<Score> {

	private Integer score;
	private String genreName;

	public Score(String genre) {
		this.score = 0;
		this.genreName = genre;

	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public void addScore(Integer points) {
		this.score += points;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	@Override
	public String toString() {
		return "Score [score=" + score + ", GenreName=" + genreName + "]";
	}

	@Override
	public int compareTo(Score o) {
		if (this.score < o.getScore()) {
			return 1;
		} else if (this.score > o.getScore()) {
			return -1;
		} else
			return 0;

	}

}
