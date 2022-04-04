package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.YatzyDice;

import java.util.Arrays;
import java.util.Objects;

public class YatzyGui extends Application {

    private final YatzyDice dice = new YatzyDice();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Yatzy");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final Image diceImageOne = new Image(Objects.requireNonNull(YatzyGui.class.getResourceAsStream("dice/1.png")));
    private final Image diceImageTwo = new Image(Objects.requireNonNull(YatzyGui.class.getResourceAsStream("dice/2.png")));
    private final Image diceImageThree = new Image(Objects.requireNonNull(YatzyGui.class.getResourceAsStream("dice/3.png")));
    private final Image diceImageFour = new Image(Objects.requireNonNull(YatzyGui.class.getResourceAsStream("dice/4.png")));
    private final Image diceImageFive = new Image(Objects.requireNonNull(YatzyGui.class.getResourceAsStream("dice/5.png")));
    private final Image diceImageSix = new Image(Objects.requireNonNull(YatzyGui.class.getResourceAsStream("dice/6.png")));
    private final Image[] diceImages = {diceImageOne, diceImageTwo, diceImageThree, diceImageFour, diceImageFive, diceImageSix};

    private final ImageView dice0 = new ImageView(diceImageOne),
            dice1 = new ImageView(diceImageTwo),
            dice2 = new ImageView(diceImageThree),
            dice3 = new ImageView(diceImageFour),
            dice4 = new ImageView(diceImageFive);
    private final ImageView[] diceImageViews = {dice0, dice1, dice2, dice3, dice4};


    // Shows the obtained results.
    // For results not set yet, the possible result of 
    // the actual face values of the 5 dice are shown.
    private final TextField scoreOnes = new TextField("0"), scoreTwos = new TextField("0"), scoreThrees = new TextField("0"),
            scoreFours = new TextField("0"), scoreFives = new TextField("0"), scoreSixes = new TextField("0"), scorePair = new TextField("0"),
            scoreTwoPairs = new TextField("0"), scoreThreeKind = new TextField("0"), scoreFourKind = new TextField("0"),
            scoreLowStraight = new TextField("0"), scoreHighStraight = new TextField("0"), scoreFullHouse = new TextField("0"),
            scoreChance = new TextField("0"), scoreYatzy = new TextField("0");
    private final TextField[] txfResults = {scoreOnes, scoreTwos, scoreThrees, scoreFours, scoreFives, scoreSixes, scorePair, scoreTwoPairs, scoreThreeKind, scoreFourKind, scoreLowStraight, scoreHighStraight, scoreFullHouse, scoreChance, scoreYatzy};
    // Shows points in sums, bonus and total.
    private final TextField txfSumSame = new TextField("0"), txfBonus = new TextField("0"),
            txfSumOther = new TextField("0"), txfTotal = new TextField("0");
    // Labels
    private final Label lblOnes = new Label("Ones"), lblTwos = new Label("Twos"), lblThrees = new Label("Threes"),
            lblFours = new Label("Fours"), lblFives = new Label("Fives"), lblSixes = new Label("Sixes"),
            lblPair = new Label("One Pair"), lblTwoPairs = new Label("Two Pairs"), lblThreeSame = new Label("Three same"),
            lblFourSame = new Label("Four same"), lblFullHouse = new Label("Full house"), lblSmallStr = new Label("Small str."),
            lblLargeStr = new Label("Large str."), lblChance = new Label("Chance"), lblYatzy = new Label("Yatzy");
    private final Label[] lblResults = {lblOnes, lblTwos, lblThrees, lblFours, lblFives, lblSixes, lblPair, lblTwoPairs, lblThreeSame, lblFourSame, lblFullHouse, lblSmallStr, lblLargeStr, lblChance, lblYatzy};
    private final Label lblSumSame = new Label("Sum"), lblBonus = new Label("Bonus"),
            lblSumOther = new Label("Sum"), lblTotal = new Label("TOTAL");

    private final Label lblRolled = new Label("0/3");
    private final Button btnRoll = new Button(" Roll ");

    private final boolean[] holdStatus = new boolean[5], isSubmitted = new boolean[15];

    private final int[] sum = new int[15];

    private void initContent(GridPane pane) {
        // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        // ---------------------------------------------------------------------

        HBox diceHBox = new HBox();
        diceHBox.setSpacing(10);
        diceHBox.setAlignment(Pos.CENTER);

        for (int i = 0; i < diceImageViews.length; i++) {
            diceImageViews[i].setFitHeight(40.0);
            diceImageViews[i].setFitWidth(40.0);
            int finalI = i;
            diceImageViews[i].setOnMouseClicked(event -> lockDice(finalI));
            diceHBox.getChildren().add(diceImageViews[i]);
        }

        HBox rollHBox = new HBox();
        rollHBox.setAlignment(Pos.CENTER);
        rollHBox.setSpacing(10);
        rollHBox.getChildren().addAll(lblRolled, btnRoll);

        btnRoll.setOnAction(event -> rollDice());

        VBox diceVBox = new VBox();
        pane.add(diceVBox, 0, 0);
        diceVBox.setSpacing(10);
        diceVBox.setPadding(new Insets(10.0));
        diceVBox.setStyle("-fx-border-color: black");
        diceVBox.getChildren().addAll(diceHBox, rollHBox);

        // ---------------------------------------------------------------------

        GridPane scorePane = new GridPane();
        pane.add(scorePane, 0, 1);
        // scorePane.setGridLinesVisible(true);
        scorePane.setPadding(new Insets(10));
        scorePane.setVgap(5);
        scorePane.setHgap(10);
        scorePane.setStyle("-fx-border-color: black");
        int w = 50; // width of the text fields

        for (int i = 0; i < 6; i++) {
            scorePane.add(lblResults[i], 0, i);
        }

        for (int i = 0; i < 6; i++) {
            scorePane.add(txfResults[i], 1, i);
            int finalI = i;
            txfResults[i].setOnMouseClicked(event -> submit(finalI));
            txfResults[i].setEditable(false);
            txfResults[i].setPrefWidth(w);
        }

        for (int i = 6; i < lblResults.length; i++) {
            scorePane.add(lblResults[i], 0, i + 1);
        }

        for (int i = 6; i < txfResults.length; i++) {
            scorePane.add(txfResults[i], 1, i + 1);
            int finalI = i;
            txfResults[i].setOnMouseClicked(event -> submit(finalI));
            txfResults[i].setEditable(false);
            txfResults[i].setPrefWidth(w);
        }

        scorePane.add(lblSumSame, 2, 5);
        scorePane.add(txfSumSame, 3, 5);
        txfSumSame.setEditable(false);
        txfSumSame.setPrefWidth(w);
        scorePane.add(lblBonus, 2, 6);
        scorePane.add(txfBonus, 3, 6);
        txfBonus.setEditable(false);
        txfBonus.setPrefWidth(w);
        scorePane.add(lblSumOther, 2, 15);
        scorePane.add(txfSumOther, 3, 15);
        txfSumOther.setEditable(false);
        txfSumOther.setPrefWidth(w);
        scorePane.add(lblTotal, 2, 16);
        scorePane.add(txfTotal, 3, 16);
        txfTotal.setEditable(false);
        txfTotal.setPrefWidth(w);

    }

    // -------------------------------------------------------------------------

    public void rollDice() {
        dice.throwDice(holdStatus);
        updateImage();
        updateText();
        if (dice.getThrowCount() >= 3) {
            btnRoll.setDisable(true);
        }
    }

    public void lockDice(int i) {
        if (dice.getThrowCount() > 0) {
            holdStatus[i] = true;
            ColorAdjust colorAdjust = new ColorAdjust();
            colorAdjust.setContrast(-0.5);
            diceImageViews[i].setEffect(colorAdjust);
        }
    }

    public void unlockDice() {
        Arrays.fill(holdStatus, false);
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setContrast(0.0);
        for (ImageView imageView : diceImageViews) {
            imageView.setEffect(colorAdjust);
        }
    }

    public void submit(int i) {
        if (dice.getThrowCount() > 0 && !isSubmitted[i]) {
            sum[i] = Integer.parseInt(txfResults[i].getText());
            isSubmitted[i] = true;
            txfResults[i].setStyle("-fx-background-color: yellow");
            dice.resetThrowCount();
            boolean isFinished = true;
            for (boolean b : isSubmitted) {
                if (!b)
                    isFinished = false;
            }
            if (isFinished)
                btnRoll.setDisable(true);
            else
                btnRoll.setDisable(false);
            updateText();
            unlockDice();
        }
    }

    // -------------------------------------------------------------------------

    public void updateImage() {
        for (int i = 0; i < diceImageViews.length; i++)
            diceImageViews[i].setImage(diceImages[dice.getValues()[i] - 1]);
    }

    public void updateText() {
        lblRolled.setText(dice.getThrowCount() + "/3");
        int[] results = dice.getResults();
        for (int i = 0; i < results.length; i++) {
            if (!isSubmitted[i])
                txfResults[i].setText("" + results[i]);
        }
        int sumSame = 0;
        for (int i = 0; i < 6; i++) {
            if (isSubmitted[i])
                sumSame += sum[i];
        }
        txfSumSame.setText("" + sumSame);
        int bonus = 0;
        if (sumSame >= 63) {
            bonus = 50;
            txfBonus.setText("" + bonus);
        }
        int sumOther = 0;
        for (int i = 6; i < sum.length; i++) {
            if (isSubmitted[i])
                sumOther += sum[i];
        }
        txfSumOther.setText("" + sumOther);
        int total = sumSame + bonus + sumOther;
        txfTotal.setText("" + total);

        boolean sameFinished = true;
        for (int i = 0; i < 6; i++) {
            if (!isSubmitted[i])
                sameFinished = false;
        }
        if (sameFinished) {
            txfSumSame.setStyle("-fx-background-color: yellow");
            txfBonus.setStyle("-fx-background-color: yellow");
        }

        boolean otherFinished = true;
        for (int i = 6; i < isSubmitted.length; i++) {
            if (!isSubmitted[i])
                otherFinished = false;
        }
        if (otherFinished)
            txfSumOther.setStyle("-fx-background-color: yellow");

        boolean isFinished = true;
        for (boolean b : isSubmitted) {
            if (!b)
                isFinished = false;
        }
        if (isFinished)
            txfTotal.setStyle("-fx-background-color: yellow");
    }

}
