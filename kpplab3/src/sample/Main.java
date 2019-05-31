package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;

import java.util.ArrayList;


public class Main extends Application {

    Stage window;
    Scene sceneLearner, sceneSchool, sceneUniversity, sceneKindergarten;

    @Override

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Kindergarten kindergarten=new Kindergarten();
        School school=new School();
        University university=new University();
        //public ArrayList<SchoolChild> SchoolArrayList = new ArrayList<SchoolChild>();
        ArrayList<Enrollee> EnrolleeArrayList= new ArrayList<>();





        GridPane gridPaneLearner = new GridPane();
        gridPaneLearner.setAlignment(Pos.CENTER);
        gridPaneLearner.setHgap(10);
        gridPaneLearner.setVgap(5);
        gridPaneLearner.setPadding(new Insets(10,10,10,10));

        //gridPaneLearner.setGridLinesVisible(true);


       
        Button SCHOOL = new Button("Школа");
        Button UNIVERSITY = new Button("Университет");
        Button KINDERGARTEN=new Button("Детский сад");

        Label status = new Label("Статус: ");



        gridPaneLearner.add(KINDERGARTEN,0,0);
        gridPaneLearner.add(SCHOOL,0,2);
        gridPaneLearner.add(UNIVERSITY, 0,4);
        gridPaneLearner.add(status,0,6);

////////////////////////////////////////////////////////////////////////////////////////////////


        GridPane gridPaneKindergarten= new GridPane();
        gridPaneKindergarten.setAlignment(Pos.CENTER);
        gridPaneKindergarten.setHgap(10);
        gridPaneKindergarten.setVgap(5);
        gridPaneKindergarten.setPadding(new Insets(10,10,10,10));


        Button enrollKindergartner= new Button("Поступить");
        Button deductKindergartner = new Button("Отчислиться");
        Button Breakfast = new Button("Завтрак");
        Button back2=new Button("Назад");
        Label Growth = new Label(" ");
        Label error3= new Label("");

        gridPaneKindergarten.add(enrollKindergartner, 0,2);
        gridPaneKindergarten.add(Breakfast,0,4);
        gridPaneKindergarten.add(deductKindergartner,0,6);
        gridPaneKindergarten.add(Growth,0,8);
        gridPaneKindergarten.add(error3,0,9);
        gridPaneKindergarten.add(back2,0,10);


////////////////////////////////////////////////////////////////////////////////////////////

        GridPane gridPaneSchool = new GridPane();
        gridPaneSchool.setAlignment(Pos.CENTER);
        gridPaneSchool.setHgap(10);
        gridPaneSchool.setVgap(5);
        gridPaneSchool.setPadding(new Insets(10,10,10,10));

        Button learn = new Button("Провести урок");
        //Button event = new Button("Провести линейку");
        Button deductSchollChild = new Button("Отчислиться");
        Button enrollSchollChild = new Button("Поступить");
        Button Rate=new Button("Выставить оценки");
        Button back = new Button("Назад");
        Label ratings = new Label("Рейтинг: " );
        Label error = new Label();

        gridPaneSchool.add(learn,0,4);
        gridPaneSchool.add(enrollSchollChild, 0,2);
        gridPaneSchool.add(deductSchollChild,0,10);
        gridPaneSchool.add(back,0,12);
        gridPaneSchool.add(error,0,9);
        gridPaneSchool.add(ratings,0,8);
        gridPaneSchool.add(Rate,0,6);



///////////////////////////////////////////////////////////////////////////////////////////////

        GridPane gridPaneUniversity = new GridPane();
        gridPaneUniversity.setAlignment(Pos.CENTER);
        gridPaneUniversity.setHgap(10);
        gridPaneUniversity.setVgap(5);
        gridPaneUniversity.setPadding(new Insets(10,10,10,10));

        //Button enrollStudent= new Button("");
        Button deductStudent=new Button("Отчислиться");
        Button holdLecture=new Button("Провести лекцию");
        Button holdSeminar= new Button("Провести семинар");
        Button holdLaboratoryWork=new Button("Провести лабораторную");
        Button rate=new Button("Выставить оценки");
        Button pass= new Button("Сдать экзамен");
        Button back1=new Button("Назад");
        Label ratings1=new Label(" " );
        Label error2=new Label("");
        Label knowledge= new Label("");

        gridPaneUniversity.add(holdLecture,0,1);
        gridPaneUniversity.add(holdLaboratoryWork,0,2);
        gridPaneUniversity.add(holdSeminar,0,3);
        gridPaneUniversity.add(rate,0,4);
        gridPaneUniversity.add(deductStudent,0,8);
        gridPaneUniversity.add(back1,0,10);
        gridPaneUniversity.add(ratings1,0,5);
        gridPaneUniversity.add(pass,0,0);
        gridPaneUniversity.add(error2,0,6);
        gridPaneUniversity.add(knowledge,0,7);





        KINDERGARTEN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneKindergarten);
            }
        });

        back2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneLearner);
                error3.setText("");
            }
        });

        enrollKindergartner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(university.UniversityArrayList.size()==0 && school.SchoolArrayList.size()==0 &&
                        kindergarten.KindergartenerArrayList.size()==0 && EnrolleeArrayList.size()==0) {
                    kindergarten.EnrollLearner(new Kindergartener(), kindergarten);
                    status.setText("Статус: " + kindergarten.KindergartenerArrayList.get(0).getStatus());
                    error3.setText("");
                }
                else{
                    if(university.UniversityArrayList.size()>0)
                        error3.setText("Вы студент");
                    if(school.SchoolArrayList.size()>0)
                        error3.setText("Вы школьник");
                    if(kindergarten.KindergartenerArrayList.size()>0)
                        error3.setText("Вы уже детсадовец");
                    if(EnrolleeArrayList.size()>0)
                        error3.setText("Вы уже были в детском саду");
                }
            }
        });

        deductKindergartner.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(kindergarten.KindergartenerArrayList.size()==1){
                    if(kindergarten.KindergartenerArrayList.get(0).getGrowth()>4) {
                        EnrolleeArrayList.add(new Enrollee(kindergarten.KindergartenerArrayList.get(0)));
                        kindergarten.DeductLearner(kindergarten.KindergartenerArrayList.get(0), kindergarten);
                        status.setText("Статус: " + EnrolleeArrayList.get(0).getStatus());
                        error3.setText("");
                    }
                    else error3.setText("Вы недостатлчно выросли");
                }
                else
                    error3.setText("Вы не детсадовец");
            }
        });

        Breakfast.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(kindergarten.KindergartenerArrayList.size()==1){
                    kindergarten.breakfast(kindergarten.KindergartenerArrayList.get(0));
                    Growth.setText("Рост: " + kindergarten.KindergartenerArrayList.get(0).getGrowth());
                    error3.setText("");
                }
                else
                    error3.setText("Вы не детсадовец");
            }
        });

        enrollSchollChild.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if(EnrolleeArrayList.get(0).getLevel()==1) {
                        school.EnrollLearner(new SchoolChild(EnrolleeArrayList.get(0)), school);
                        EnrolleeArrayList.remove(0);
                        status.setText("Статус: " + school.SchoolArrayList.get(0).getStatus());
                        error.setText("");
                    }else
                        error.setText("Вы не дошкольник");
                }catch (IndexOutOfBoundsException e){
                    error.setText("Вы не дошкольник");

                }
            }
        });


        learn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(school.SchoolArrayList.size()==1){
                    school.HoldSchoolwork();
                    error.setText("");
                }
                else
                    error.setText("Вы не школьник");
            }
        });

        Rate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(school.SchoolArrayList.size()==1){
                    school.rate(school.SchoolArrayList.get(0));
                    ratings.setText("" + school.SchoolArrayList.get(0).getGrade());
                    error.setText("");
                }
                else
                    error.setText("Вы не школьник");
            }
        });

        deductSchollChild.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (school.SchoolArrayList.get(0).getGrade() > 4) {
                        EnrolleeArrayList.add(new Enrollee(school.SchoolArrayList.get(0)));
                        school.DeductLearner(school.SchoolArrayList.get(0), school);
                        status.setText("Статус: " + EnrolleeArrayList.get(0).getStatus());
                        error.setText("");
                    } else error.setText("Недостаточная оценка");
                }catch (IndexOutOfBoundsException e){
                    error.setText("Вы не школьник");
                }
            }
        });


        pass.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (EnrolleeArrayList.get(0).getLevel() == 2) {
                        EnrolleeArrayList.get(0).PassExam(university);
                        if (EnrolleeArrayList.get(0).getExamResult() > 49) {
                            university.EnrollLearner(new Student(EnrolleeArrayList.get(0)), university);
                            EnrolleeArrayList.remove(0);
                            status.setText("Статус: " + university.UniversityArrayList.get(0).getStatus());
                            error2.setText("");
                        }
                    } else {
                        error2.setText("Вы не абитуриент");
                    }
                }catch (IndexOutOfBoundsException e){
                    error2.setText("Вы не абитуриент");
                }
            }
        });

        holdLecture.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(university.UniversityArrayList.size()>0){
                    university.HoldLecture(university.UniversityArrayList.get(0));
                    knowledge.setText("Знания: " + university.UniversityArrayList.get(0).getKnowledge());
                }else
                    error2.setText("Вы не студент");
            }
        });

        holdLaboratoryWork.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(university.UniversityArrayList.size()>0){
                    university.HoldLaboratoryWork();
                }else
                    error2.setText("Вы не студент");
            }
        });

        holdSeminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(university.UniversityArrayList.size()>0){
                    university.HoldSeminar(university.UniversityArrayList.get(0));
                    knowledge.setText("Знания: " + university.UniversityArrayList.get(0).getKnowledge());
                }else
                    error2.setText("Вы не студент");
            }
        });

        rate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    university.rate(university.UniversityArrayList.get(0));
                    ratings1.setText("Оценки: " + university.UniversityArrayList.get(0).getGrade());
                    error2.setText("");
                }catch (IndexOutOfBoundsException e){
                    error2.setText("Вы не студент");
                }

            }
        });

        deductStudent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                        university.DeductLearner(university.UniversityArrayList.get(0), university);
                        status.setText("Статус: ");
                        error2.setText("");
                }catch (IndexOutOfBoundsException e){
                    error2.setText("Вы не студент");
                }
            }
        });



        SCHOOL.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneSchool);
            }
        });

        back1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneLearner);
            }
        });

        UNIVERSITY.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneUniversity);
            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                window.setScene(sceneLearner);
            }
        });

//////////////////////////////////////////////////////////////////////////////////////////

       





        sceneLearner = new Scene(gridPaneLearner, 300, 300);
        sceneSchool = new Scene(gridPaneSchool, 300, 300);
        sceneUniversity=new Scene(gridPaneUniversity,300,300);
        sceneKindergarten=new Scene(gridPaneKindergarten,300,300);


        window.setScene(sceneLearner);
        window.setTitle("Lab2_17");
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
