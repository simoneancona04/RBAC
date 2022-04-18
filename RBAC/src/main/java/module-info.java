module com.rbac {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.rbac to javafx.fxml;
    exports com.rbac;
}
