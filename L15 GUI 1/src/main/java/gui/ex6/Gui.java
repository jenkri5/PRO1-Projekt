package gui.ex6;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Exercise 6");
        stage.setResizable(false);
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField(), txfAge = new TextField();
    private final TextArea txaStudent = new TextArea();
    private final CheckBox cbActive = new CheckBox();
    private final Button btnInc = new Button("Inc"), btnReset = new Button("Reset"), btnCreate = new Button("Create"),
            btnUpdate = new Button("Update"), btnDelete = new Button("Delete");
    private Student student;

    private void initContent(GridPane pane) {

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblStudentInfo = new Label("Student Info:");
        pane.add(lblStudentInfo, 0, 0);
        txaStudent.setPrefWidth(300);
        txaStudent.setEditable(false);
        pane.add(txaStudent,0,1);

        HBox hBoxName = new HBox();
        hBoxName.setSpacing(10);
        hBoxName.setAlignment(Pos.CENTER_LEFT);
        Label lblName = new Label("Name:");
        lblName.setPrefWidth(50);
        hBoxName.getChildren().add(lblName);
        hBoxName.getChildren().add(txfName);
        pane.add(hBoxName,0,2);

        HBox hBoxAge = new HBox();
        hBoxAge.setSpacing(10);
        hBoxAge.setAlignment(Pos.CENTER_LEFT);
        Label lblAge = new Label("Age:");
        lblAge.setPrefWidth(50);
        txfAge.setPrefWidth(75);
        btnInc.setOnAction(event -> incrementAction());
        btnInc.setDisable(true);
        btnReset.setOnAction(event -> resetAction());
        btnReset.setDisable(true);
        hBoxAge.getChildren().add(lblAge);
        hBoxAge.getChildren().add(txfAge);
        hBoxAge.getChildren().add(btnInc);
        hBoxAge.getChildren().add(btnReset);
        pane.add(hBoxAge,0,3);

        HBox hBoxActive = new HBox();
        hBoxActive.setSpacing(10);
        hBoxActive.setAlignment(Pos.CENTER_LEFT);
        Label lblActive = new Label("Active:");
        lblActive.setPrefWidth(50);
        hBoxActive.getChildren().add(lblActive);
        hBoxActive.getChildren().add(cbActive);
        pane.add(hBoxActive, 0, 4);

        HBox hBoxButtons = new HBox();
        hBoxButtons.setSpacing(10);
        hBoxButtons.setAlignment(Pos.CENTER);
        btnCreate.setOnAction(event -> createAction());
        btnUpdate.setOnAction(event -> updateAction());
        btnUpdate.setDisable(true);
        btnDelete.setOnAction(event -> deleteAction());
        btnDelete.setDisable(true);
        hBoxButtons.getChildren().add(btnCreate);
        hBoxButtons.getChildren().add(btnUpdate);
        hBoxButtons.getChildren().add(btnDelete);
        pane.add(hBoxButtons, 0, 5);
    }

    // -------------------------------------------------------------------------

    private void incrementAction() {
        String name = student.getName();
        student.setAge(student.getAge() + 1);
        int age = student.getAge();
        boolean active = student.isActive();
        if (active)
            txaStudent.setText("Name: " + name + "\n" + "Age: " + age + "\n" + "Active: Yes");
        else
            txaStudent.setText("Name: " + name + "\n" + "Age: " + age + "\n" + "Active: No");
        txfAge.setText(String.valueOf(student.getAge()));
    }

    private void resetAction() {
        txfName.setText(student.getName());
        txfAge.setText(String.valueOf(student.getAge()));
        cbActive.setSelected(student.isActive());
    }

    private void createAction() {
        String name = txfName.getText();
        int age = Integer.parseInt(txfAge.getText());
        boolean active = cbActive.isSelected();
        student = new Student(name, age, active);
        if (active)
            txaStudent.setText("Name: " + name + "\n" + "Age: " + age + "\n" + "Active: Yes");
        else
            txaStudent.setText("Name: " + name + "\n" + "Age: " + age + "\n" + "Active: No");
        btnCreate.setDisable(true);
        btnUpdate.setDisable(false);
        btnDelete.setDisable(false);
        btnInc.setDisable(false);
        btnReset.setDisable(false);
    }

    private void updateAction() {
        String name = txfName.getText();
        int age = Integer.parseInt(txfAge.getText());
        boolean active = cbActive.isSelected();
        student.setName(name);
        student.setAge(age);
        student.setActive(active);
        if (active)
            txaStudent.setText("Name: " + name + "\n" + "Age: " + age + "\n" + "Active: Yes");
        else
            txaStudent.setText("Name: " + name + "\n" + "Age: " + age + "\n" + "Active: No");
    }

    private void deleteAction() {
        student = null;
        txaStudent.setText("");
        txfName.setText("");
        txfAge.setText("");
        cbActive.setSelected(false);
        btnCreate.setDisable(false);
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        btnInc.setDisable(true);
        btnReset.setDisable(true);
    }

}
