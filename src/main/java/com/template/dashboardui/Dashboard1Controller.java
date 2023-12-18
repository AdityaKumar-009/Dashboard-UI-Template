package com.template.dashboardui;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Dashboard1Controller implements Initializable {

    @FXML
    private LineChart<String, Number> combinedChart;

    @FXML
    private ChoiceBox<String> frequencyChoiceBox;

    @FXML
    private AreaChart<String, Number> parameter1_AreaChart;

    @FXML
    private CheckBox parameter1_CheckBox;

    @FXML
    private Label parameter1_Label;

    @FXML
    private AnchorPane parameter1_Pane;

    @FXML
    private AreaChart<String, Number> parameter2_AreaChart;

    @FXML
    private CheckBox parameter2_CheckBox;

    @FXML
    private Label parameter2_Label;

    @FXML
    private AnchorPane parameter2_Pane;

    @FXML
    private AreaChart<String, Number> parameter3_AreaChart;

    @FXML
    private CheckBox parameter3_CheckBox;

    @FXML
    private Label parameter3_Label;

    @FXML
    private AnchorPane parameter3_Pane;

    @FXML
    private AreaChart<String, Number> parameter4_AreaChart;

    @FXML
    private CheckBox parameter4_CheckBox;

    @FXML
    private Label parameter4_Label;

    @FXML
    private AnchorPane parameter4_Pane;

    @FXML
    private AreaChart<String, Number> parameter5_AreaChart;

    @FXML
    private CheckBox parameter5_CheckBox;

    @FXML
    private Label parameter5_Label;

    @FXML
    private AnchorPane parameter5_Pane;

    @FXML
    private AreaChart<String, Number> parameter6_AreaChart;

    @FXML
    private CheckBox parameter6_CheckBox;

    @FXML
    private Label parameter6_Label;

    @FXML
    private AnchorPane parameter6_Pane;

    @FXML
    private CheckBox symbols_CheckBox;

    @FXML
    void showHideParameter1() {
        // IF CheckBox selected
        if (parameter1_CheckBox.isSelected()) {

            // LOGIC for adding removing series: only work if we disable animation of lineChart
            if (!combinedChart.getData().contains(series1_copy)) {
                combinedChart.getData().add(0, series1_copy);
            }

        } else { // If not selected, remove the series
            combinedChart.getData().remove(series1_copy);
        }
    }

    @FXML
    void showHideParameter2() {
        // IF CheckBox selected
        if (parameter2_CheckBox.isSelected()) {

            // LOGIC for adding removing series: only work if we disable animation of lineChart
            if (!combinedChart.getData().contains(series2_copy)) {
                combinedChart.getData().add(0, series2_copy);
            }

        } else { // If not selected, remove the series
            combinedChart.getData().remove(series2_copy);
        }
    }

    @FXML
    void showHideParameter3() {
        // IF CheckBox selected
        if (parameter3_CheckBox.isSelected()) {

            // LOGIC for adding removing series: only work if we disable animation of lineChart
            if (!combinedChart.getData().contains(series3_copy)) {
                combinedChart.getData().add(0, series3_copy);
            }

        } else { // If not selected, remove the series
            combinedChart.getData().remove(series3_copy);
        }
    }

    @FXML
    void showHideParameter4() {
        // IF CheckBox selected
        if (parameter4_CheckBox.isSelected()) {

            // LOGIC for adding removing series: only work if we disable animation of lineChart
            if (!combinedChart.getData().contains(series4_copy)) {
                combinedChart.getData().add(0, series4_copy);
            }

        } else { // If not selected, remove the series
            combinedChart.getData().remove(series4_copy);
        }
    }

    @FXML
    void showHideParameter5() {
        // IF CheckBox selected
        if (parameter5_CheckBox.isSelected()) {

            // LOGIC for adding removing series: only work if we disable animation of lineChart
            if (!combinedChart.getData().contains(series5_copy)) {
                combinedChart.getData().add(0, series5_copy);
            }

        } else { // If not selected, remove the series
            combinedChart.getData().remove(series5_copy);
        }
    }

    @FXML
    void showHideParameter6() {
        // IF CheckBox selected
        if (parameter6_CheckBox.isSelected()) {

            // LOGIC for adding removing series: only work if we disable animation of lineChart
            if (!combinedChart.getData().contains(series6_copy)) {
                combinedChart.getData().add(0, series6_copy);
            }

        } else { // If not selected, remove the series
            combinedChart.getData().remove(series6_copy);
        }
    }

    @FXML
    void showHideSymbols() {
        combinedChart.setCreateSymbols(symbols_CheckBox.isSelected());
    }

    public static ScheduledExecutorService executor1 = Executors.newSingleThreadScheduledExecutor();
    public static ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(1);

    private ScheduledFuture<?> chartPlottingTask;

    XYChart.Series<String, Number> series1 = new XYChart.Series<>();
    XYChart.Series<String, Number> series2 = new XYChart.Series<>();
    XYChart.Series<String, Number> series3 = new XYChart.Series<>();
    XYChart.Series<String, Number> series4 = new XYChart.Series<>();
    XYChart.Series<String, Number> series5 = new XYChart.Series<>();
    XYChart.Series<String, Number> series6 = new XYChart.Series<>();

    XYChart.Series<String, Number> series1_copy = new XYChart.Series<>();
    XYChart.Series<String, Number> series2_copy = new XYChart.Series<>();
    XYChart.Series<String, Number> series3_copy = new XYChart.Series<>();
    XYChart.Series<String, Number> series4_copy = new XYChart.Series<>();
    XYChart.Series<String, Number> series5_copy = new XYChart.Series<>();
    XYChart.Series<String, Number> series6_copy = new XYChart.Series<>();

    private double parameter1, parameter2, parameter3, parameter4, parameter5, parameter6;

    // this is used to display time in HH:mm:ss format
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    public int frequency = 1;

    // for the X-AXIS Limit to show until 20 data only otherwise graph will become cluttered after some time
    final int MAX_DATA_POINTS = 20;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Curve Edges towards down of the AreaChart
        roundingAreaChart();

        // Adding line data (called series.) to the AreaChart [ that are INDIVIDUAL SYSTEM MEMORY CHARTs ]
        areaChartConfiguration();

        // Adding lines data to the LineChart [ that shows COMBINED VIEW OF SYSTEM MEMORY IN SINGLE CHART ]
        combinedChartConfiguration();

        // Show usages based on frequency
        usageBasedOnFrequency();

        // Start plotting
        plotInfoOnChart();

    }

    private void combinedChartConfiguration() {

        // Set Series name that will be shown below the combined chart
        series1_copy.setName("SERIES 1");
        series2_copy.setName("SERIES 2");
        series3_copy.setName("SERIES 3");
        series4_copy.setName("SERIES 4");
        series5_copy.setName("SERIES 5");
        series6_copy.setName("SERIES 6");

        combinedChart.getXAxis().setLabel("Time");
        combinedChart.getYAxis().setLabel("Value");

        // add series to chart
        combinedChart.getData().add(series1_copy);
        combinedChart.getData().add(series2_copy);

    }

    private void roundingAreaChart() {

        Rectangle clipRectangle = new Rectangle(200, 190);
        clipRectangle.setArcWidth(35);
        clipRectangle.setArcHeight(35);
        parameter1_Pane.setClip(clipRectangle);

        Rectangle clipRectangle2 = new Rectangle(200, 190);
        clipRectangle2.setArcWidth(35);
        clipRectangle2.setArcHeight(35);
        parameter2_Pane.setClip(clipRectangle2);

        Rectangle clipRectangle3 = new Rectangle(200, 190);
        clipRectangle3.setArcWidth(35);
        clipRectangle3.setArcHeight(35);
        parameter3_Pane.setClip(clipRectangle3);

        Rectangle clipRectangle4 = new Rectangle(200, 190);
        clipRectangle4.setArcWidth(35);
        clipRectangle4.setArcHeight(35);
        parameter4_Pane.setClip(clipRectangle4);

        Rectangle clipRectangle5 = new Rectangle(200, 190);
        clipRectangle5.setArcWidth(35);
        clipRectangle5.setArcHeight(35);
        parameter5_Pane.setClip(clipRectangle5);

        Rectangle clipRectangle6 = new Rectangle(200, 190);
        clipRectangle6.setArcWidth(35);
        clipRectangle6.setArcHeight(35);
        parameter6_Pane.setClip(clipRectangle6);

    }

    private void areaChartConfiguration() {

        // Hiding components of all the AreaCharts to make it clean and then adding series
        parameter1_AreaChart.getData().add(series1);
        parameter1_AreaChart.getXAxis().setTickLabelsVisible(false);
        parameter1_AreaChart.getYAxis().setTickLabelsVisible(false);
        parameter1_AreaChart.getYAxis().setOpacity(0);
        parameter1_AreaChart.getXAxis().setOpacity(0);

        parameter2_AreaChart.getData().add(series2);
        parameter2_AreaChart.getXAxis().setTickLabelsVisible(false);
        parameter2_AreaChart.getYAxis().setTickLabelsVisible(false);
        parameter2_AreaChart.getYAxis().setOpacity(0);
        parameter2_AreaChart.getXAxis().setOpacity(0);

        parameter3_AreaChart.getData().add(series3);
        parameter3_AreaChart.getXAxis().setTickLabelsVisible(false);
        parameter3_AreaChart.getYAxis().setTickLabelsVisible(false);
        parameter3_AreaChart.getYAxis().setOpacity(0);
        parameter3_AreaChart.getXAxis().setOpacity(0);

        parameter4_AreaChart.getData().add(series4);
        parameter4_AreaChart.getXAxis().setTickLabelsVisible(false);
        parameter4_AreaChart.getYAxis().setTickLabelsVisible(false);
        parameter4_AreaChart.getYAxis().setOpacity(0);
        parameter4_AreaChart.getXAxis().setOpacity(0);

        parameter5_AreaChart.getData().add(series5);
        parameter5_AreaChart.getXAxis().setTickLabelsVisible(false);
        parameter5_AreaChart.getYAxis().setTickLabelsVisible(false);
        parameter5_AreaChart.getYAxis().setOpacity(0);
        parameter5_AreaChart.getXAxis().setOpacity(0);

        parameter6_AreaChart.getData().add(series6);
        parameter6_AreaChart.getXAxis().setTickLabelsVisible(false);
        parameter6_AreaChart.getYAxis().setTickLabelsVisible(false);
        parameter6_AreaChart.getYAxis().setOpacity(0);
        parameter6_AreaChart.getXAxis().setOpacity(0);
    }

    private void usageBasedOnFrequency() {
        frequencyChoiceBox.setValue("1s");
        frequencyChoiceBox.getItems().addAll("1s", "10s", "30s", "1 min", "5 min", "10 min");

        // For setting frequency for the graph update [ when user changes the value of choiceBox ]
        frequencyChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            System.out.println("Selected frequency: " + newValue);
            frequencyChoiceBox.setValue(newValue);

            switch (frequencyChoiceBox.getValue()) {
                case "1s" -> {
                    frequency = 1;

                    // Cancel the ongoing frequency wait
                    if (chartPlottingTask != null) {
                        chartPlottingTask.cancel(true);

                        plotInfoOnChart();

                    }

                }
                case "10s" -> {
                    frequency = 10;
                    if (chartPlottingTask != null) {
                        chartPlottingTask.cancel(true);

                        plotInfoOnChart();

                    }
                }
                case "30s" -> {
                    frequency = 30;
                    if (chartPlottingTask != null) {
                        chartPlottingTask.cancel(true);

                        plotInfoOnChart();

                    }
                }
                case "1 min" -> {
                    frequency = 60;
                    if (chartPlottingTask != null) {
                        chartPlottingTask.cancel(true);

                        plotInfoOnChart();

                    }
                }
                case "5 min" -> {
                    frequency = 300;
                    if (chartPlottingTask != null) {
                        chartPlottingTask.cancel(true);

                        plotInfoOnChart();

                    }
                }
                case "10 min" -> {
                    frequency = 600;
                    if (chartPlottingTask != null) {
                        chartPlottingTask.cancel(true);

                        plotInfoOnChart();

                    }
                }
            }
        });
    }

    // Realtime Chart Logic
    private void plotInfoOnChart() {

        Runnable plotSystemMemory = () -> {

            // get current time
            Date now = new Date();
            String time = simpleDateFormat.format(now);

            fetchYData();

            // Update the chart in the UI
            Platform.runLater(() -> {

                // Updating Text Labels on the UI
                parameter1_Label.setText(String.valueOf(parameter1).substring(0,5));
                parameter2_Label.setText(String.valueOf(parameter2).substring(0,5));
                parameter3_Label.setText(String.valueOf(parameter3).substring(0,5));
                parameter4_Label.setText(String.valueOf(parameter4).substring(0,5));
                parameter5_Label.setText(String.valueOf(parameter5).substring(0,5));
                parameter6_Label.setText(String.valueOf(parameter6).substring(0,5));

                series1.getData().add(new XYChart.Data<>(time, parameter1));
                series2.getData().add(new XYChart.Data<>(time, parameter2));
                series3.getData().add(new XYChart.Data<>(time, parameter3));
                series4.getData().add(new XYChart.Data<>(time, parameter4));
                series5.getData().add(new XYChart.Data<>(time, parameter5));
                series6.getData().add(new XYChart.Data<>(time, parameter6));

                series1_copy.getData().add(new XYChart.Data<>(time, parameter1));
                series2_copy.getData().add(new XYChart.Data<>(time, parameter2));
                series3_copy.getData().add(new XYChart.Data<>(time, parameter3));
                series4_copy.getData().add(new XYChart.Data<>(time, parameter4));
                series5_copy.getData().add(new XYChart.Data<>(time, parameter5));
                series6_copy.getData().add(new XYChart.Data<>(time, parameter6));

                // To remove first Element
                if (series1.getData().size() > MAX_DATA_POINTS) {
                    series1.getData().remove(0);
                    series1_copy.getData().remove(0);
                }
                if (series2.getData().size() > MAX_DATA_POINTS) {
                    series2.getData().remove(0);
                    series2_copy.getData().remove(0);
                }
                if (series3.getData().size() > MAX_DATA_POINTS) {
                    series3.getData().remove(0);
                    series3_copy.getData().remove(0);
                }
                if (series4.getData().size() > MAX_DATA_POINTS) {
                    series4.getData().remove(0);
                    series4_copy.getData().remove(0);
                }
                if (series5.getData().size() > MAX_DATA_POINTS) {
                    series5.getData().remove(0);
                    series5_copy.getData().remove(0);
                }
                if (series6.getData().size() > MAX_DATA_POINTS) {
                    series6.getData().remove(0);
                    series6_copy.getData().remove(0);
                }
            });
        };

        chartPlottingTask = executor1.scheduleAtFixedRate(plotSystemMemory, 0, frequency, TimeUnit.SECONDS);

    }

    // Logic for fetching for Y-Axis Data
    private void fetchYData() {

        parameter1 = Math.random() / Math.random();
        parameter2 = Math.random();
        parameter3 = Math.random() / Math.random();
        parameter4 = Math.random() / Math.random();
        parameter5 = Math.random();
        parameter6 = Math.random();

    }

}
