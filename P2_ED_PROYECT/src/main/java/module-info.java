module com.mycompany.p2_ed_proyect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.p2_ed_proyect to javafx.fxml;
    exports com.mycompany.p2_ed_proyect;
}
