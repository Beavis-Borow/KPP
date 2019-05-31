package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

import sample.Thread.СonvolutionThread;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(true);
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 300, 300);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);
        for (int i = 0; i < 4; i++) {
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(100 / 4.0);
            gridpane.getColumnConstraints().add(column);
        }

        TextField ArrTextField = new TextField();
        ArrTextField.setMinWidth(100);
        ArrTextField.setMaxWidth(100);
        gridpane.add(ArrTextField, 1, 1);


        TextField Arr2TextField = new TextField();
        Arr2TextField.setMinWidth(100);
        Arr2TextField.setMaxWidth(100);
        gridpane.add(Arr2TextField, 1, 2);

        Label Signal1 = new Label("Сигнал 1 ");
        gridpane.add(Signal1, 0, 1);

        Label Signal2 = new Label(" Сигнал 2 ");
        gridpane.add(Signal2, 0, 2);

        Button calculateButton = new Button("Calculate");
        gridpane.add(calculateButton, 1, 4, 3, 1);

        TextArea answer = new TextArea(" ");
        gridpane.add(answer, 0, 5, 4, 3);

        calculateButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String  lines = null;
                String lines2=null;
                List<Integer> list = new ArrayList<Integer>();
                List<Integer> list2 = new ArrayList<Integer>();
                lines=ArrTextField.getText();
                lines2=Arr2TextField.getText();
                str(lines,list);
                str(lines2,list2);
                for (int k = 0; k < list.size(); k++) {
                    String result = calculate(list, list2, k);
                    answer.appendText(result);
                    answer.appendText("\n");
                }
            }
        });

        root.setCenter(gridpane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }




    private String calculate(List<Integer> list,List<Integer> list2,  Integer k){
        Exchanger<String> exchanger = new Exchanger<>();
        СonvolutionThread calculator = new СonvolutionThread(list, list2, k, exchanger);
        calculator.start();
        String result;
        try {
            result = exchanger.exchange("");
        } catch (Exception ex) {
            return "e r r o r";
        }
        return result;
    }

    public void str(String lines,List<Integer> list){
        Scanner in = new Scanner(lines).useDelimiter("[,\\s+]");
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                list.add(in.nextInt());
            }
            else
                in.next();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}