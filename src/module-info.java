module MP3Playa {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;
	requires java.sql;
	
	opens com.predilleto.app to javafx.graphics, javafx.fxml;
}
