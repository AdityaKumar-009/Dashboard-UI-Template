module com.template.dashboardui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.template.dashboardui to javafx.fxml;
    exports com.template.dashboardui;
}