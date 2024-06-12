module com.example.quranmp3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.example.quranmp3 to javafx.fxml;
    exports com.example.quranmp3;
}