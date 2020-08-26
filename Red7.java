import java.util.Random;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * An implementation of the game Red7, by Asmadi Games.  Only includes two card colors: violet and indigo.  Thanks to Asmadi Games for granting me permission to use their game rules for educational purposes.  This implementation is intended to be terrible, and will be updated during the semester in a Software Engineering course.
 *
 * @author Kyle Burke <kwburke@plymouth.edu>
 */
public class Red7 extends Application {
    
    /**
     * Main method to run the game.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Start the game.
     */
    public void start(Stage primaryStage) {
    
        primaryStage.setTitle("Red 7");
        
        boolean[] dealtViolets = new boolean[7];
        for (int i = 0; i < 7; i++) {
            dealtViolets[i] = false;
        }
        
        boolean[] indigosDealt = new boolean[] {false, false, false, false, false, false, false};
        
        int[] playerAHandNums = new int[2];
        int[] BHandNums = new int[2];
        int[] APaletteNums = new int[1];
        int[] playerBPaletteNumbers = new int[1];
        
        String[] AHandColors = new String[2];
        String[] playerBHandColors = new String[2];
        String[] BPaletteColors = new String[1];
        String[] playerAPaletteColors = new String[1];
        
        String canvasColor = "Red";
        
        Random randGen = new Random();
        
        boolean x = false;
        int number = -5;
        String color = "Nothing";
        while (!x) {
            number = randGen.nextInt(7) + 1;
            int cardColor = randGen.nextInt(2) + 1;
            color = "Indigo";
            if (cardColor == 1) {
                color = "Violet";
            }
            if (color.equals("Violet")) {
                x = !dealtViolets[number - 1];
            } else {
                x = !indigosDealt[number - 1];
            }
        }
        if (color.equals("Violet")) {
            dealtViolets[number - 1] = true;
        } else {
            indigosDealt[number - 1] = true;
        }
        APaletteNums[0] = number;
        playerAPaletteColors[0] = color;
        
        x=false;
        while (!x) {
            number = randGen.nextInt(7) + 1;
            int cardColor = randGen.nextInt(2) + 1;
            color = "Indigo";
            if (cardColor == 1) {
                color = "Violet";
            }
            if (color.equals("Violet")) {
                x = !dealtViolets[number - 1];
            } else {
                x = !indigosDealt[number - 1];
            }
        }
        if (color.equals("Violet")) {
            dealtViolets[number - 1] = true;
        } else {
            indigosDealt[number - 1] = true;
        }
        playerBPaletteNumbers[0] = number;
        BPaletteColors[0] = color;
        
        x=false;
        while (!x) {
            number = randGen.nextInt(7) + 1;
            int cardColor = randGen.nextInt(2) + 1;
            color = "Indigo";
            if (cardColor == 1) {
                color = "Violet";
            }
            if (color.equals("Violet")) {
                x = !dealtViolets[number - 1];
            } else {
                x = !indigosDealt[number - 1];
            }
        }
        if (color.equals("Violet")) {
            dealtViolets[number - 1] = true;
        } else {
            indigosDealt[number - 1] = true;
        }
        playerAHandNums[0] = number;
        AHandColors[0] = color;
        
        x=false;
        while (!x) {
            number = randGen.nextInt(7) + 1;
            int cardColor = randGen.nextInt(2) + 1;
            color = "Indigo";
            if (cardColor == 1) {
                color = "Violet";
            }
            if (color.equals("Violet")) {
                x = !dealtViolets[number - 1];
            } else {
                x = !indigosDealt[number - 1];
            }
        }
        if (color.equals("Violet")) {
            dealtViolets[number - 1] = true;
        } else {
            indigosDealt[number - 1] = true;
        }
        playerAHandNums[1] = number;
        AHandColors[1] = color;
        
        x=false;
        while (!x) {
            number = randGen.nextInt(7) + 1;
            int cardColor = randGen.nextInt(2) + 1;
            color = "Indigo";
            if (cardColor == 1) {
                color = "Violet";
            }
            if (color.equals("Violet")) {
                x = !dealtViolets[number - 1];
            } else {
                x = !indigosDealt[number - 1];
            }
        }
        if (color.equals("Violet")) {
            dealtViolets[number - 1] = true;
        } else {
            indigosDealt[number - 1] = true;
        }
        BHandNums[0] = number;
        playerBHandColors[0] = color;
        
        x=false;
        while (!x) {
            number = randGen.nextInt(7) + 1;
            int cardColor = randGen.nextInt(2) + 1;
            color = "Indigo";
            if (cardColor == 1) {
                color = "Violet";
            }
            if (color.equals("Violet")) {
                x = !dealtViolets[number - 1];
            } else {
                x = !indigosDealt[number - 1];
            }
        }
        if (color.equals("Violet")) {
            dealtViolets[number - 1] = true;
        } else {
            indigosDealt[number - 1] = true;
        }
        BHandNums[1] = number;
        playerBHandColors[1] = color;
        
        VBox board = new VBox();
        board.setSpacing(2);
        Text handText = new Text("Player A's Hand");
        board.getChildren().add(handText);
        Pane aHandCards = new HBox();
        board.getChildren().add(aHandCards);
        StackPane aHandCard0Pane = new StackPane();
        Rectangle aHandCard0 = new Rectangle(125, 175, Color.VIOLET);
        if (AHandColors[0].equals("Indigo")) {
            aHandCard0.setFill(Color.INDIGO);
        }
        aHandCard0Pane.getChildren().add(aHandCard0);
        Text cardNumberText = new Text("" +  playerAHandNums[0]);
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
        cardNumberText.setFill(Color.WHITE);
        aHandCard0Pane.getChildren().add(cardNumberText);
        aHandCards.getChildren().add(aHandCard0Pane);
        
        
        StackPane aHandCard1Pane = new StackPane();
        aHandCard0 = new Rectangle(125, 175, Color.VIOLET);
        if (AHandColors[1].equals("Indigo")) {
            aHandCard0.setFill(Color.INDIGO);
        }
        aHandCard1Pane.getChildren().add(aHandCard0);
        cardNumberText = new Text("" + playerAHandNums[1]);
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
        cardNumberText.setFill(Color.WHITE);
        aHandCard1Pane.getChildren().add(cardNumberText);
        aHandCards.getChildren().add(aHandCard1Pane);
        
        board.getChildren().add(new Separator());
        
        board.getChildren().add(new Text("Player A's Palette"));
        StackPane aPalette = new StackPane();
        Rectangle aPaletteR = new Rectangle(125, 175, Color.VIOLET);
        if (playerAPaletteColors[0].equals("Indigo")) {
            aPaletteR.setFill(Color.INDIGO);
        }
        aPalette.getChildren().add(aPaletteR);
        cardNumberText = new Text("" + APaletteNums[0]);
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
        cardNumberText.setFill(Color.WHITE);
        aPalette.getChildren().add(cardNumberText);
        board.getChildren().add(aPalette);
        
        board.getChildren().add(new Separator());
        
        board.getChildren().add(new Text("Canvas"));
        
        board.getChildren().add(new Rectangle(175, 125, Color.RED));
        
        board.getChildren().add(new Separator());
        
        board.getChildren().add(new Text("Player B's Palette"));
        StackPane bPalette = new StackPane();
        Rectangle bPaletteR = new Rectangle(125, 175, Color.VIOLET);
        if (BPaletteColors[0].equals("Indigo")) {
            bPaletteR.setFill(Color.INDIGO);
        }
        bPalette.getChildren().add(bPaletteR);
        cardNumberText = new Text("" + playerBPaletteNumbers[0]);
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
        cardNumberText.setFill(Color.WHITE);
        bPalette.getChildren().add(cardNumberText);
        board.getChildren().add(bPalette);
        
        board.getChildren().add(new Separator());
        
        board.getChildren().add(new Text("Player B's Hand"));
        HBox bHandCards = new HBox();
        board.getChildren().add(bHandCards);
        
        StackPane bHandCard0Pane = new StackPane();
        Rectangle bHandCard0R = new Rectangle(125, 175, Color.VIOLET);
        if (playerBHandColors[0].equals("Indigo")) {
            bHandCard0R.setFill(Color.INDIGO);
        }
        bHandCard0Pane.getChildren().add(bHandCard0R);
        cardNumberText = new Text("" + BHandNums[0]);
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
        cardNumberText.setFill(Color.WHITE);
        bHandCard0Pane.getChildren().add(cardNumberText);
        bHandCards.getChildren().add(bHandCard0Pane);
        
        StackPane bHandCard1Pane = new StackPane();
        Rectangle bHandCard1R = new Rectangle(125, 175, Color.VIOLET);
        if (playerBHandColors[1].equals("Indigo")) {
            bHandCard1R.setFill(Color.INDIGO);
        }
        bHandCard1Pane.getChildren().add(bHandCard1R);
        cardNumberText = new Text("" + BHandNums[1]);
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
        cardNumberText.setFill(Color.WHITE);
        bHandCard1Pane.getChildren().add(cardNumberText);
        bHandCards.getChildren().add(bHandCard1Pane);
        
        
        primaryStage.setScene(new Scene(board));
        primaryStage.show();
        primaryStage.sizeToScene();
        
        
        boolean firstFirst = APaletteNums[0] < playerBPaletteNumbers[0] || (APaletteNums[0] == playerBPaletteNumbers[0] && playerAPaletteColors[0].equals("Violet"));
        
        stillPlaying: while(true) {
            ArrayList<String> playChoices = new ArrayList<String>();
            ArrayList<String> choiceChosen = new ArrayList<String>();
            if (firstFirst) {
                System.out.println("Player A's turn...");
                while (true) {
                    playChoices.clear();
                    if (playerAHandNums.length > 0) {
                        playChoices.add("Play only to Palette");
                        playChoices.add("Play only to Canvas");
                    }
                    if (playerAHandNums.length > 1) {
                        playChoices.add("Play to Palette and Canvas");
                    }
                    playChoices.add("Concede");
                    choiceChosen.clear();
                    ChoiceDialog<String> dialog = new ChoiceDialog<String>(playChoices.get(0), playChoices);
                    dialog.setTitle("Player A's turn.");
                    dialog.setHeaderText("Player A, Choose your move.");
                    dialog.setContentText("Options:");
                    dialog.showAndWait().ifPresent( (response) -> {
                        choiceChosen.add(response);
                    });
                    /*
                    while (choiceChosen.size() < 1) {
                        System.out.println("Waiting...");
                    }
                    */
                    String chosen = choiceChosen.get(0);
                    System.out.println("chosen: " + chosen);
                    if (chosen.equals("Concede")) {
                        System.out.println("Player A Loses!");
                        break stillPlaying;
                    } else if (chosen.equals("Play only to Palette")) {
                        ArrayList<String> handChoices = new ArrayList<String>();
                        handChoices.add("Go back");
                        for (int i = 0; i < playerAHandNums.length; i++) {
                            handChoices.add("Play card " + i + ": " + AHandColors[i] + " " + playerAHandNums[i] + " to palette");
                        }
                        
                        dialog = new ChoiceDialog<String>("Go back", handChoices);
                        dialog.setHeaderText("Which card will you move to the Palette?");
                        dialog.setContentText("Options:");
                        dialog.showAndWait().ifPresent( (response) -> {
                            choiceChosen.add(response);
                            System.out.println("response: " + response);
                        });
                        chosen = choiceChosen.get(1);
                        if (chosen.equals("Go back")) {
                            System.out.println("Backing up...");
                            continue;
                        } else if (chosen.charAt(10) == '0') {
                            String colorPick = AHandColors[0];
                            int numberPick = playerAHandNums[0];
                            int handIndex = 0;
                            boolean playOkay = false;
                            if (canvasColor.equals("Red")) {
                                String bHighestColor = BPaletteColors[0];
                                int bHighestNumber = playerBPaletteNumbers[0];
                                for (int i = 1; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                        bHighestColor = BPaletteColors[i];
                                        bHighestNumber = playerBPaletteNumbers[i];
                                    }
                                }
                                String aHighestColor = colorPick;
                                int aHighestNumber = numberPick;
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                        aHighestNumber = APaletteNums[i];
                                        aHighestColor = playerAPaletteColors[i];
                                    }
                                }
                                if (aHighestNumber > bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                            } else if (canvasColor.equals("Indigo")) {
                                boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                                boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                                String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                                int bMaxStreak = 0;
                                int bStreakTop = 0;
                                int currentStreak = 0;
                                int aMaxStreak = 0;
                                int aStreakTop = 0;
                                String aStreakTopColor = "";
                                for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                    numsB[playerBPaletteNumbers[i]] = true;
                                }
                                for (int i = 1; i < numsB.length; i++) {
                                    if (numsB[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=bMaxStreak) {
                                            bMaxStreak = currentStreak;
                                            bStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                for (int i = 0; i < APaletteNums.length; i++) {
                                    numsA[APaletteNums[i]] = true;
                                    if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                        colorsA[i] = playerAPaletteColors[i];
                                    }
                                }
                                numsA[numberPick] = true;
                                if (colorsA[numberPick].equals("") || colorPick.equals("Indigo")) {
                                    colorsA[numberPick] = colorPick;
                                }
                                for (int i = 1; i < numsA.length; i++) {
                                    if (numsA[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=aMaxStreak) {
                                            aMaxStreak = currentStreak;
                                            aStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                aStreakTopColor = colorsA[aStreakTop];
                                if (aMaxStreak > bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop > bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                                
                            } else if (canvasColor.equals("Violet")) {
                                int numBSmall = 0;
                                int highSmallB = 0;
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] < 4) {
                                        numBSmall ++;
                                        if (playerBPaletteNumbers[i] > highSmallB) {
                                            highSmallB = playerBPaletteNumbers[i];
                                        }
                                    }
                                }
                                int numASmall = 0;
                                int highSmallA = 0;
                                String highSmallAColor = "";
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] < 4) {
                                        numASmall ++;
                                        if (APaletteNums[i] > highSmallA) {
                                            highSmallA = APaletteNums[i];
                                            highSmallAColor = playerAPaletteColors[i];
                                        }
                                    }
                                }
                                if (numberPick < 4) {
                                    numASmall ++;
                                    if (numberPick > highSmallA) {
                                        highSmallA = numberPick;
                                        highSmallAColor = colorPick;
                                    }
                                }
                                if (numASmall > numBSmall || (numASmall == numBSmall && highSmallA > highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                                
                            }
                            
                            
                            if (playOkay) {
                                System.out.println("Made a legal play to the Palette!");
                                
                                String[] newAPaletteColors = new String[playerAPaletteColors.length + 1];
                                int[] newAPaletteNums = new int[APaletteNums.length + 1];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    newAPaletteColors[i] = playerAPaletteColors[i];
                                    newAPaletteNums[i] = APaletteNums[i];
                                }
                                newAPaletteColors[newAPaletteColors.length-1] = colorPick;
                                newAPaletteNums[newAPaletteNums.length - 1] = numberPick;
                                APaletteNums = new int[newAPaletteNums.length];
                                playerAPaletteColors = new String[newAPaletteColors.length];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    APaletteNums[i] = newAPaletteNums[i];
                                    playerAPaletteColors[i] = newAPaletteColors[i];
                                }  
                                
                                String[] newAHandColors = new String[playerAHandNums.length - 1];
                                int[] newAHandNums = new int[playerAHandNums.length - 1];
                                int j = 0;
                                for (int i = 0; i < playerAHandNums.length; i ++) {
                                    if (i != handIndex) {
                                        newAHandColors[j] = AHandColors[i];
                                        newAHandNums[j] = playerAHandNums[i];
                                        j++;
                                    }
                                }
                                AHandColors = new String[newAHandColors.length];
                                playerAHandNums = new int[newAHandNums.length];
                                for (int i = 0; i < AHandColors.length; i++) {
                                    AHandColors[i] = newAHandColors[i];
                                    playerAHandNums[i] = newAHandNums[i];
                                }
                                
                                break;
                                
                            }
                        } else if (chosen.charAt(10) == '1') {
                            String colorPick = AHandColors[1];
                            int numberPick = playerAHandNums[1];
                            int handIndex = 1;
                            boolean playOkay = false;
                            if (canvasColor.equals("Red")) {
                                String bHighestColor = BPaletteColors[0];
                                int bHighestNumber = playerBPaletteNumbers[0];
                                for (int i = 1; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                        bHighestColor = BPaletteColors[i];
                                        bHighestNumber = playerBPaletteNumbers[i];
                                    }
                                }
                                String aHighestColor = colorPick;
                                int aHighestNumber = numberPick;
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                        aHighestNumber = APaletteNums[i];
                                        aHighestColor = playerAPaletteColors[i];
                                    }
                                }
                                if (aHighestNumber > bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                            } else if (canvasColor.equals("Indigo")) {
                                boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                                boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                                String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                                int bMaxStreak = 0;
                                int bStreakTop = 0;
                                int currentStreak = 0;
                                int aMaxStreak = 0;
                                int aStreakTop = 0;
                                String aStreakTopColor = "";
                                for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                    numsB[playerBPaletteNumbers[i]] = true;
                                }
                                for (int i = 1; i < numsB.length; i++) {
                                    if (numsB[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=bMaxStreak) {
                                            bMaxStreak = currentStreak;
                                            bStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                for (int i = 0; i < APaletteNums.length; i++) {
                                    numsA[APaletteNums[i]] = true;
                                    if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                        colorsA[i] = playerAPaletteColors[i];
                                    }
                                }
                                numsA[numberPick] = true;
                                if (colorsA[numberPick].equals("") || colorPick.equals("Indigo")) {
                                    colorsA[numberPick] = colorPick;
                                }
                                for (int i = 1; i < numsA.length; i++) {
                                    if (numsA[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=aMaxStreak) {
                                            aMaxStreak = currentStreak;
                                            aStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                aStreakTopColor = colorsA[aStreakTop];
                                if (aMaxStreak > bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop > bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                                
                            } else if (canvasColor.equals("Violet")) {
                                int numBSmall = 0;
                                int highSmallB = 0;
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] < 4) {
                                        numBSmall ++;
                                        if (playerBPaletteNumbers[i] > highSmallB) {
                                            highSmallB = playerBPaletteNumbers[i];
                                        }
                                    }
                                }
                                int numASmall = 0;
                                int highSmallA = 0;
                                String highSmallAColor = "";
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] < 4) {
                                        numASmall ++;
                                        if (APaletteNums[i] > highSmallA) {
                                            highSmallA = APaletteNums[i];
                                            highSmallAColor = playerAPaletteColors[i];
                                        }
                                    }
                                }
                                if (numberPick < 4) {
                                    numASmall ++;
                                    if (numberPick > highSmallA) {
                                        highSmallA = numberPick;
                                        highSmallAColor = colorPick;
                                    }
                                }
                                if (numASmall > numBSmall || (numASmall == numBSmall && highSmallA > highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                            }
                            
                            
                            if (playOkay) {
                                System.out.println("Made a legal play to the Palette!");
                                
                                String[] newAPaletteColors = new String[playerAPaletteColors.length + 1];
                                int[] newAPaletteNums = new int[APaletteNums.length + 1];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    newAPaletteColors[i] = playerAPaletteColors[i];
                                    newAPaletteNums[i] = APaletteNums[i];
                                }
                                newAPaletteColors[newAPaletteColors.length-1] = colorPick;
                                newAPaletteNums[newAPaletteNums.length - 1] = numberPick;
                                APaletteNums = new int[newAPaletteNums.length];
                                playerAPaletteColors = new String[newAPaletteColors.length];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    APaletteNums[i] = newAPaletteNums[i];
                                    playerAPaletteColors[i] = newAPaletteColors[i];
                                }  
                                
                                String[] newAHandColors = new String[playerAHandNums.length - 1];
                                int[] newAHandNums = new int[playerAHandNums.length - 1];
                                int j = 0;
                                for (int i = 0; i < playerAHandNums.length; i ++) {
                                    if (i != handIndex) {
                                        newAHandColors[j] = AHandColors[i];
                                        newAHandNums[j] = playerAHandNums[i];
                                        j++;
                                    }
                                }
                                AHandColors = new String[newAHandColors.length];
                                playerAHandNums = new int[newAHandNums.length];
                                for (int i = 0; i < AHandColors.length; i++) {
                                    AHandColors[i] = newAHandColors[i];
                                    playerAHandNums[i] = newAHandNums[i];
                                }
                                
                                break;
                            }
                        }
                        
                        System.out.println("That move did not help you to win.  Let's try that again...  (canvasColor: " + canvasColor + ")");
                        
                        
                        
                    } else if (chosen.equals("Play only to Canvas")) {
                        ArrayList<String> handChoices = new ArrayList<String>();
                        handChoices.add("Go back");
                        for (int i = 0; i < playerAHandNums.length; i++) {
                            handChoices.add("Play card " + i + ": " + AHandColors[i] + " " + playerAHandNums[i] + " to canvas");
                        }
                        
                        dialog = new ChoiceDialog<String>("Go back", handChoices);
                        dialog.setHeaderText("Which card will you move to the Canvas?");
                        dialog.setContentText("Options:");
                        dialog.showAndWait().ifPresent( (response) -> {
                            choiceChosen.add(response);
                            System.out.println("response: " + response);
                        });
                        chosen = choiceChosen.get(1);
                        if (chosen.equals("Go back")) {
                            System.out.println("Backing up...");
                            continue;
                        } else if (chosen.charAt(10) == '0') {
                            String colorPick = AHandColors[0];
                            int numberPick = playerAHandNums[0];
                            int handIndex = 0;
                            boolean playOkay = false;
                            if (colorPick.equals("Red")) {
                                String bHighestColor = BPaletteColors[0];
                                int bHighestNumber = playerBPaletteNumbers[0];
                                for (int i = 1; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                        bHighestColor = BPaletteColors[i];
                                        bHighestNumber = playerBPaletteNumbers[i];
                                    }
                                }
                                String aHighestColor = "";
                                int aHighestNumber = 0;
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                        aHighestNumber = APaletteNums[i];
                                        aHighestColor = playerAPaletteColors[i];
                                    }
                                }
                                if (aHighestNumber > bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                            } else if (colorPick.equals("Indigo")) {
                                boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                                boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                                String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                                int bMaxStreak = 0;
                                int bStreakTop = 0;
                                int currentStreak = 0;
                                int aMaxStreak = 0;
                                int aStreakTop = 0;
                                String aStreakTopColor = "";
                                for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                    numsB[playerBPaletteNumbers[i]] = true;
                                }
                                for (int i = 1; i < numsB.length; i++) {
                                    if (numsB[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=bMaxStreak) {
                                            bMaxStreak = currentStreak;
                                            bStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                for (int i = 0; i < APaletteNums.length; i++) {
                                    numsA[APaletteNums[i]] = true;
                                    if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                        colorsA[i] = playerAPaletteColors[i];
                                    }
                                }
                                for (int i = 1; i < numsA.length; i++) {
                                    if (numsA[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=aMaxStreak) {
                                            aMaxStreak = currentStreak;
                                            aStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                aStreakTopColor = colorsA[aStreakTop];
                                if (aMaxStreak > bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop > bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                                
                            } else if (colorPick.equals("Violet")) {
                                int numBSmall = 0;
                                int highSmallB = 0;
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] < 4) {
                                        numBSmall ++;
                                        if (playerBPaletteNumbers[i] > highSmallB) {
                                            highSmallB = playerBPaletteNumbers[i];
                                        }
                                    }
                                }
                                int numASmall = 0;
                                int highSmallA = 0;
                                String highSmallAColor = "";
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] < 4) {
                                        numASmall ++;
                                        if (APaletteNums[i] > highSmallA) {
                                            highSmallA = APaletteNums[i];
                                            highSmallAColor = playerAPaletteColors[i];
                                        }
                                    }
                                }
                                if (numASmall > numBSmall || (numASmall == numBSmall && highSmallA > highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                                
                            }
                            
                            
                            if (playOkay) {
                                System.out.println("Made a legal play to the canvas!");
                                
                                canvasColor = colorPick;
                                
                                /*
                                String[] newAPaletteColors = new String[playerAPaletteColors.length + 1];
                                int[] newAPaletteNums = new int[APaletteNums.length + 1];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    newAPaletteColors[i] = playerAPaletteColors[i];
                                    newAPaletteNums[i] = APaletteNums[i];
                                }
                                newAPaletteColors[newAPaletteColors.length-1] = colorPick;
                                newAPaletteNums[newAPaletteNums.length - 1] = numberPick;
                                APaletteNums = new int[newAPaletteNums.length];
                                playerAPaletteColors = new String[newAPaletteColors.length];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    APaletteNums[i] = newAPaletteNums[i];
                                    playerAPaletteColors[i] = newAPaletteColors[i];
                                } */ 
                                
                                String[] newAHandColors = new String[playerAHandNums.length - 1];
                                int[] newAHandNums = new int[playerAHandNums.length - 1];
                                int j = 0;
                                for (int i = 0; i < playerAHandNums.length; i ++) {
                                    if (i != handIndex) {
                                        newAHandColors[j] = AHandColors[i];
                                        newAHandNums[j] = playerAHandNums[i];
                                        j++;
                                    }
                                }
                                AHandColors = new String[newAHandColors.length];
                                playerAHandNums = new int[newAHandNums.length];
                                for (int i = 0; i < AHandColors.length; i++) {
                                    AHandColors[i] = newAHandColors[i];
                                    playerAHandNums[i] = newAHandNums[i];
                                }
                                
                                break;
                                
                            }
                        } else if (chosen.charAt(10) == '1') {
                            String colorPick = AHandColors[1];
                            int numberPick = playerAHandNums[1];
                            int handIndex = 1;
                            boolean playOkay = false;
                            if (canvasColor.equals("Red")) {
                                String bHighestColor = BPaletteColors[0];
                                int bHighestNumber = playerBPaletteNumbers[0];
                                for (int i = 1; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                        bHighestColor = BPaletteColors[i];
                                        bHighestNumber = playerBPaletteNumbers[i];
                                    }
                                }
                                String aHighestColor = colorPick;
                                int aHighestNumber = numberPick;
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                        aHighestNumber = APaletteNums[i];
                                        aHighestColor = playerAPaletteColors[i];
                                    }
                                }
                                if (aHighestNumber > bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                            } else if (canvasColor.equals("Indigo")) {
                                boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                                boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                                String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                                int bMaxStreak = 0;
                                int bStreakTop = 0;
                                int currentStreak = 0;
                                int aMaxStreak = 0;
                                int aStreakTop = 0;
                                String aStreakTopColor = "";
                                for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                    numsB[playerBPaletteNumbers[i]] = true;
                                }
                                for (int i = 1; i < numsB.length; i++) {
                                    if (numsB[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=bMaxStreak) {
                                            bMaxStreak = currentStreak;
                                            bStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                for (int i = 0; i < APaletteNums.length; i++) {
                                    numsA[APaletteNums[i]] = true;
                                    if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                        colorsA[i] = playerAPaletteColors[i];
                                    }
                                }
                                for (int i = 1; i < numsA.length; i++) {
                                    if (numsA[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=aMaxStreak) {
                                            aMaxStreak = currentStreak;
                                            aStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                aStreakTopColor = colorsA[aStreakTop];
                                if (aMaxStreak > bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop > bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                                
                            } else if (canvasColor.equals("Violet")) {
                                int numBSmall = 0;
                                int highSmallB = 0;
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] < 4) {
                                        numBSmall ++;
                                        if (playerBPaletteNumbers[i] > highSmallB) {
                                            highSmallB = playerBPaletteNumbers[i];
                                        }
                                    }
                                }
                                int numASmall = 0;
                                int highSmallA = 0;
                                String highSmallAColor = "";
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] < 4) {
                                        numASmall ++;
                                        if (APaletteNums[i] > highSmallA) {
                                            highSmallA = APaletteNums[i];
                                            highSmallAColor = playerAPaletteColors[i];
                                        }
                                    }
                                }
                                if (numberPick < 4) {
                                    numASmall ++;
                                    if (numberPick > highSmallA) {
                                        highSmallA = numberPick;
                                        highSmallAColor = colorPick;
                                    }
                                }
                                if (numASmall > numBSmall || (numASmall == numBSmall && highSmallA > highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Indigo"))) {
                                    playOkay = true;
                                }
                            }
                            
                            
                            if (playOkay) {
                                System.out.println("Made a legal play to the canvas!");
                                
                                canvasColor = colorPick;
                                /*
                                
                                String[] newAPaletteColors = new String[playerAPaletteColors.length + 1];
                                int[] newAPaletteNums = new int[APaletteNums.length + 1];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    newAPaletteColors[i] = playerAPaletteColors[i];
                                    newAPaletteNums[i] = APaletteNums[i];
                                }
                                newAPaletteColors[newAPaletteColors.length-1] = colorPick;
                                newAPaletteNums[newAPaletteNums.length - 1] = numberPick;
                                APaletteNums = new int[newAPaletteNums.length];
                                playerAPaletteColors = new String[newAPaletteColors.length];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    APaletteNums[i] = newAPaletteNums[i];
                                    playerAPaletteColors[i] = newAPaletteColors[i];
                                }  */
                                
                                String[] newAHandColors = new String[playerAHandNums.length - 1];
                                int[] newAHandNums = new int[playerAHandNums.length - 1];
                                int j = 0;
                                for (int i = 0; i < playerAHandNums.length; i ++) {
                                    if (i != handIndex) {
                                        newAHandColors[j] = AHandColors[i];
                                        newAHandNums[j] = playerAHandNums[i];
                                        j++;
                                    }
                                }
                                AHandColors = new String[newAHandColors.length];
                                playerAHandNums = new int[newAHandNums.length];
                                for (int i = 0; i < AHandColors.length; i++) {
                                    AHandColors[i] = newAHandColors[i];
                                    playerAHandNums[i] = newAHandNums[i];
                                }
                                
                                break;
                            }
                        }
                        
                        System.out.println("That move did not help you to win.  Let's try that again...  (canvasColor: " + canvasColor + ")");
                        
                        
                        
                    } else if (chosen.equals("Play to Palette and Canvas")) {
                        ArrayList<String> handChoices = new ArrayList<String>();
                        handChoices.add("Go back");
                        for (int i = 0; i < playerAHandNums.length; i++) {
                            handChoices.add("Play card " + i + ": " + AHandColors[i] + " " + playerAHandNums[i] + " to palette first...");
                        }
                        
                        dialog = new ChoiceDialog<String>("Go back", handChoices);
                        dialog.setHeaderText("First choose for the Palette.");
                        dialog.setContentText("Options:");
                        dialog.showAndWait().ifPresent( (response) -> {
                            choiceChosen.add(response);
                            System.out.println("response: " + response);
                        });
                        chosen = choiceChosen.get(1);
                        if (chosen.equals("Go back")) {
                            System.out.println("Backing up...");
                            continue;
                        } else {
                            boolean playOkay = false;
                            int hand2PaletteIndex = 0;
                            try {
                                hand2PaletteIndex = Integer.parseInt(chosen.charAt(10) + "");
                            } catch (Exception e) {
                                System.err.println("Ooops!  Couldn't get a character!");
                            }
                            String colorPick = AHandColors[hand2PaletteIndex];
                            int numberPick = playerAHandNums[hand2PaletteIndex];
                            handChoices.clear();
                            handChoices.add("Go back");
                            for (int i = 0; i < playerAHandNums.length; i++) {
                                if (i != hand2PaletteIndex) {
                                    handChoices.add("Play card " + i + ": " + AHandColors[i] + " " + playerAHandNums[i] + " to the canvas second.");
                                }
                            }
                        
                            dialog = new ChoiceDialog<String>("Go back", handChoices);
                            dialog.setHeaderText("Next, choose for the canvas.");
                            dialog.setContentText("Options:");
                            dialog.showAndWait().ifPresent( (response) -> {
                                choiceChosen.add(response);
                                System.out.println("response: " + response);
                            });
                            chosen = choiceChosen.get(2);
                            if (chosen.equals("Go back")) {
                                System.out.println("Backing up...");
                                continue;
                            } else {
                                int hand2CanvasIndex = 0;
                                try {
                                    hand2CanvasIndex = Integer.parseInt(chosen.charAt(10) + "");
                                } catch (Exception e) {
                                    System.err.println("Couldn't get a character when looking for the canvas card!");
                                }
                                String canvasColorPick = AHandColors[hand2CanvasIndex];
                                
                                if (canvasColorPick.equals("Red")) {
                                    String bHighestColor = BPaletteColors[0];
                                    int bHighestNumber = playerBPaletteNumbers[0];
                                    for (int i = 1; i < BPaletteColors.length; i++) {
                                        if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                            bHighestColor = BPaletteColors[i];
                                            bHighestNumber = playerBPaletteNumbers[i];
                                        }
                                    }
                                    String aHighestColor = colorPick;
                                    int aHighestNumber = numberPick;
                                    for (int i = 0; i < playerAPaletteColors.length; i++) {
                                        if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                            aHighestNumber = APaletteNums[i];
                                            aHighestColor = playerAPaletteColors[i];
                                        }
                                    }
                                    if (aHighestNumber > bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Indigo"))) {
                                        playOkay = true;
                                    }
                                } else if (canvasColorPick.equals("Indigo")) {
                                    boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                                    boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                                    String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                                    int bMaxStreak = 0;
                                    int bStreakTop = 0;
                                    int currentStreak = 0;
                                    int aMaxStreak = 0;
                                    int aStreakTop = 0;
                                    String aStreakTopColor = "";
                                    for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                        numsB[playerBPaletteNumbers[i]] = true;
                                    }
                                    for (int i = 1; i < numsB.length; i++) {
                                        if (numsB[i]) {
                                            currentStreak += 1;
                                            if (currentStreak >=bMaxStreak) {
                                                bMaxStreak = currentStreak;
                                                bStreakTop = i;
                                            }
                                        } else {
                                            currentStreak = 0;
                                        }
                                    }
                                    numsA[numberPick] = true;
                                    colorsA[numberPick] = colorPick;
                                    for (int i = 0; i < APaletteNums.length; i++) {
                                        numsA[APaletteNums[i]] = true;
                                        if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                            colorsA[i] = playerAPaletteColors[i];
                                        }
                                    }
                                    for (int i = 1; i < numsA.length; i++) {
                                        if (numsA[i]) {
                                            currentStreak += 1;
                                            if (currentStreak >=aMaxStreak) {
                                                aMaxStreak = currentStreak;
                                                aStreakTop = i;
                                            }
                                        } else {
                                            currentStreak = 0;
                                        }
                                    }
                                    aStreakTopColor = colorsA[aStreakTop];
                                    if (aMaxStreak > bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop > bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Indigo"))) {
                                        playOkay = true;
                                    }
                                    
                                } else if (canvasColorPick.equals("Violet")) {
                                    int numBSmall = 0;
                                    int highSmallB = 0;
                                    for (int i = 0; i < BPaletteColors.length; i++) {
                                        if (playerBPaletteNumbers[i] < 4) {
                                            numBSmall ++;
                                            if (playerBPaletteNumbers[i] > highSmallB) {
                                                highSmallB = playerBPaletteNumbers[i];
                                            }
                                        }
                                    }
                                    int numASmall = 0;
                                    int highSmallA = 0;
                                    String highSmallAColor = "";
                                    if (numberPick < 4) {
                                        numASmall ++;
                                        highSmallA = numberPick;
                                        highSmallAColor = colorPick;
                                    }
                                    for (int i = 0; i < playerAPaletteColors.length; i++) {
                                        if (APaletteNums[i] < 4) {
                                            numASmall ++;
                                            if (APaletteNums[i] > highSmallA) {
                                                highSmallA = APaletteNums[i];
                                                highSmallAColor = playerAPaletteColors[i];
                                            }
                                        }
                                    }
                                    if (numASmall > numBSmall || (numASmall == numBSmall && highSmallA > highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Indigo"))) {
                                        playOkay = true;
                                    }
                                    
                                }
                            
                            
                                if (playOkay) {
                                    System.out.println("Made a legal play to both the palette and canvas!");
                                    
                                    canvasColor = canvasColorPick;
                                    
                                    String[] newAPaletteColors = new String[playerAPaletteColors.length + 1];
                                    int[] newAPaletteNums = new int[APaletteNums.length + 1];
                                    for (int i = 0; i < playerAPaletteColors.length; i++) {
                                        newAPaletteColors[i] = playerAPaletteColors[i];
                                        newAPaletteNums[i] = APaletteNums[i];
                                    }
                                    newAPaletteColors[newAPaletteColors.length-1] = colorPick;
                                    newAPaletteNums[newAPaletteNums.length - 1] = numberPick;
                                    APaletteNums = new int[newAPaletteNums.length];
                                    playerAPaletteColors = new String[newAPaletteColors.length];
                                    for (int i = 0; i < playerAPaletteColors.length; i++) {
                                        APaletteNums[i] = newAPaletteNums[i];
                                        playerAPaletteColors[i] = newAPaletteColors[i];
                                    } 
                                    
                                    AHandColors = new String[0];
                                    playerAHandNums = new int[0];
                                    
                                    break;
                                    
                                }
                            }
                        }
                        
                        System.out.println("That move did not help you to win.  Let's try that again...  (canvasColor: " + canvasColor + ")");
                    }
                }
                
            }
            
            board = new VBox();
            board.setSpacing(2);
            handText = new Text("Player A's Hand");
            board.getChildren().add(handText);
            aHandCards = new HBox();
            board.getChildren().add(aHandCards);
            for (int i = 0; i < AHandColors.length; i++) {
                StackPane aHandCardPane = new StackPane();
                Rectangle aHandCardR = new Rectangle(125, 175, Color.VIOLET);
                if (AHandColors[i].equals("Indigo")) {
                    aHandCardR.setFill(Color.INDIGO);
                }
                aHandCardPane.getChildren().add(aHandCardR);
                cardNumberText = new Text("" +  playerAHandNums[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                aHandCardPane.getChildren().add(cardNumberText);
                aHandCards.getChildren().add(aHandCardPane);
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Player A's Palette"));
            
            HBox aPaletteCards = new HBox();
            board.getChildren().add(aPaletteCards);
            for (int i = 0; i < playerAPaletteColors.length; i++) {
                aPalette = new StackPane();
                aPaletteR = new Rectangle(125, 175, Color.VIOLET);
                if (playerAPaletteColors[i].equals("Indigo")) {
                    aPaletteR.setFill(Color.INDIGO);
                }
                aPalette.getChildren().add(aPaletteR);
                cardNumberText = new Text("" + APaletteNums[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                aPalette.getChildren().add(cardNumberText);
                aPaletteCards.getChildren().add(aPalette);
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Canvas"));
            
            if (canvasColor.equals("Red")) {
                board.getChildren().add(new Rectangle(175, 125, Color.RED));
            } else if (canvasColor.equals("Indigo")) {
                board.getChildren().add(new Rectangle(175, 125, Color.INDIGO));
            } else  if (canvasColor.equals("Violet")) {
                board.getChildren().add(new Rectangle(175, 125, Color.VIOLET));
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Player B's Palette"));
            
            HBox bPaletteCards = new HBox();
            board.getChildren().add(bPaletteCards);
            for (int i = 0; i < BPaletteColors.length; i++) {
                bPalette = new StackPane();
                bPaletteR = new Rectangle(125, 175, Color.VIOLET);
                if (BPaletteColors[i].equals("Indigo")) {
                    bPaletteR.setFill(Color.INDIGO);
                }
                bPalette.getChildren().add(bPaletteR);
                cardNumberText = new Text("" + playerBPaletteNumbers[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                bPalette.getChildren().add(cardNumberText);
                bPaletteCards.getChildren().add(bPalette);
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Player B's Hand"));
            bHandCards = new HBox();
            board.getChildren().add(bHandCards);
            
            for (int i = 0; i < playerBHandColors.length; i++) {
                StackPane bHandCardPane = new StackPane();
                Rectangle bHandCardR = new Rectangle(125, 175, Color.VIOLET);
                if (playerBHandColors[i].equals("Indigo")) {
                    bHandCardR.setFill(Color.INDIGO);
                }
                bHandCardPane.getChildren().add(bHandCardR);
                cardNumberText = new Text("" + BHandNums[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                bHandCardPane.getChildren().add(cardNumberText);
                bHandCards.getChildren().add(bHandCardPane);
            }
            
            
            primaryStage.setScene(new Scene(board));
            primaryStage.show();
            primaryStage.sizeToScene();
            
            firstFirst = true;
            
            System.out.println("Player B's turn...");
            
            while (true) {
                playChoices.clear();
                if (BHandNums.length > 0) {
                    playChoices.add("Play only to Palette");
                    playChoices.add("Play only to Canvas");
                }
                if (BHandNums.length > 1) {
                    playChoices.add("Play to Palette and Canvas");
                }
                playChoices.add("Concede");
                choiceChosen.clear();
                ChoiceDialog<String> dialog = new ChoiceDialog<String>(playChoices.get(0), playChoices);
                dialog.setTitle("Player B's turn.");
                dialog.setHeaderText("Player B, Choose your move.");
                dialog.setContentText("Options:");
                dialog.showAndWait().ifPresent( (response) -> {
                    choiceChosen.add(response);
                });
                /*
                while (choiceChosen.size() < 1) {
                    System.out.println("Waiting...");
                }
                */
                String chosen = choiceChosen.get(0);
                System.out.println("chosen: " + chosen);
                if (chosen.equals("Concede")) {
                    System.out.println("Player B Loses!");
                    break stillPlaying;
                } else if (chosen.equals("Play only to Palette")) {
                    ArrayList<String> handChoices = new ArrayList<String>();
                    handChoices.add("Go back");
                    for (int i = 0; i < BHandNums.length; i++) {
                        handChoices.add("Play card " + i + ": " + playerBHandColors[i] + " " + BHandNums[i] + " to palette");
                    }
                    
                    dialog = new ChoiceDialog<String>("Go back", handChoices);
                    dialog.setHeaderText("Which card will you move to the Palette?");
                    dialog.setContentText("Options:");
                    dialog.showAndWait().ifPresent( (response) -> {
                        choiceChosen.add(response);
                        System.out.println("response: " + response);
                    });
                    chosen = choiceChosen.get(1);
                    if (chosen.equals("Go back")) {
                        System.out.println("Backing up...");
                        continue;
                    } else {
                        int handIndex = 0;
                        try {
                            handIndex = Integer.parseInt(chosen.charAt(10) + "");
                        } catch (Exception e) {
                            System.err.println("Couldn't parse the integer for player B choosing a hand card!");
                        }
                        String colorPick = playerBHandColors[handIndex];
                        int numberPick = BHandNums[handIndex];
                        boolean playOkay = false;
                        if (canvasColor.equals("Red")) {
                            String bHighestColor = colorPick;
                            int bHighestNumber = numberPick;
                            for (int i = 0; i < BPaletteColors.length; i++) {
                                if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                    bHighestColor = BPaletteColors[i];
                                    bHighestNumber = playerBPaletteNumbers[i];
                                }
                            }
                            String aHighestColor = playerAPaletteColors[0];
                            int aHighestNumber = APaletteNums[0];
                            for (int i = 0; i < playerAPaletteColors.length; i++) {
                                if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                    aHighestNumber = APaletteNums[i];
                                    aHighestColor = playerAPaletteColors[i];
                                }
                            }
                            if (aHighestNumber < bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Violet"))) {
                                playOkay = true;
                            }
                        } else if (canvasColor.equals("Indigo")) {
                            boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                            boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                            String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                            int bMaxStreak = 0;
                            int bStreakTop = 0;
                            int currentStreak = 0;
                            int aMaxStreak = 0;
                            int aStreakTop = 0;
                            String aStreakTopColor = "";
                            numsB[numberPick] = true;
                            for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                numsB[playerBPaletteNumbers[i]] = true;
                            }
                            for (int i = 1; i < numsB.length; i++) {
                                if (numsB[i]) {
                                    currentStreak += 1;
                                    if (currentStreak >= bMaxStreak) {
                                        bMaxStreak = currentStreak;
                                        bStreakTop = i;
                                    }
                                } else {
                                    currentStreak = 0;
                                }
                            }
                            for (int i = 0; i < APaletteNums.length; i++) {
                                numsA[APaletteNums[i]] = true;
                                if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                    colorsA[i] = playerAPaletteColors[i];
                                }
                            }
                            for (int i = 1; i < numsA.length; i++) {
                                if (numsA[i]) {
                                    currentStreak += 1;
                                    if (currentStreak >= aMaxStreak) {
                                        aMaxStreak = currentStreak;
                                        aStreakTop = i;
                                    }
                                } else {
                                    currentStreak = 0;
                                }
                            }
                            aStreakTopColor = colorsA[aStreakTop];
                            if (aMaxStreak < bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop < bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Violet"))) {
                                playOkay = true;
                            }
                            
                        } else if (canvasColor.equals("Violet")) {
                            int numBSmall = 0;
                            int highSmallB = 0;
                            if (numberPick < 4) {
                                numBSmall ++;
                                highSmallB = numberPick;
                            }
                            for (int i = 0; i < BPaletteColors.length; i++) {
                                if (playerBPaletteNumbers[i] < 4) {
                                    numBSmall ++;
                                    if (playerBPaletteNumbers[i] > highSmallB) {
                                        highSmallB = playerBPaletteNumbers[i];
                                    }
                                }
                            }
                            int numASmall = 0;
                            int highSmallA = 0;
                            String highSmallAColor = "";
                            for (int i = 0; i < playerAPaletteColors.length; i++) {
                                if (APaletteNums[i] < 4) {
                                    numASmall ++;
                                    if (APaletteNums[i] > highSmallA) {
                                        highSmallA = APaletteNums[i];
                                        highSmallAColor = playerAPaletteColors[i];
                                    }
                                }
                            }
                            if (numASmall < numBSmall || (numASmall == numBSmall && highSmallA < highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Violet"))) {
                                playOkay = true;
                            }
                            
                        }
                        
                        
                        if (playOkay) {
                            System.out.println("Made a legal play to the Palette!");
                            
                            String[] newBPaletteColors = new String[BPaletteColors.length + 1];
                            int[] newBPaletteNums = new int[playerBPaletteNumbers.length + 1];
                            for (int i = 0; i < BPaletteColors.length; i++) {
                                newBPaletteColors[i] = BPaletteColors[i];
                                newBPaletteNums[i] = playerBPaletteNumbers[i];
                            }
                            newBPaletteColors[newBPaletteColors.length-1] = colorPick;
                            newBPaletteNums[newBPaletteNums.length - 1] = numberPick;
                            playerBPaletteNumbers = new int[newBPaletteNums.length];
                            BPaletteColors = new String[newBPaletteColors.length];
                            for (int i = 0; i < BPaletteColors.length; i++) {
                                playerBPaletteNumbers[i] = newBPaletteNums[i];
                                BPaletteColors[i] = newBPaletteColors[i];
                            }  
                            
                            String[] newBHandColors = new String[BHandNums.length - 1];
                            int[] newBHandNums = new int[BHandNums.length - 1];
                            int j = 0;
                            for (int i = 0; i < BHandNums.length; i ++) {
                                if (i != handIndex) {
                                    newBHandColors[j] = playerBHandColors[i];
                                    newBHandNums[j] = BHandNums[i];
                                    j++;
                                }
                            }
                            playerBHandColors = new String[newBHandColors.length];
                            BHandNums = new int[newBHandNums.length];
                            for (int i = 0; i < playerBHandColors.length; i++) {
                                playerBHandColors[i] = newBHandColors[i];
                                BHandNums[i] = newBHandNums[i];
                            }
                            
                            break;
                            
                        }
                    } 
                    
                    System.out.println("That move did not help you to win.  Let's try that again...  (canvasColor: " + canvasColor + ")");
                    
                    
                    
                } else if (chosen.equals("Play only to Canvas")) {
                    ArrayList<String> handChoices = new ArrayList<String>();
                    handChoices.add("Go back");
                    for (int i = 0; i < BHandNums.length; i++) {
                        handChoices.add("Play card " + i + ": " + playerBHandColors[i] + " " + BHandNums[i] + " to canvas");
                    }
                    
                    dialog = new ChoiceDialog<String>("Go back", handChoices);
                    dialog.setHeaderText("Which card will you move to the Canvas?");
                    dialog.setContentText("Options:");
                    dialog.showAndWait().ifPresent( (response) -> {
                        choiceChosen.add(response);
                        System.out.println("response: " + response);
                    });
                    chosen = choiceChosen.get(1);
                    if (chosen.equals("Go back")) {
                        System.out.println("Backing up...");
                        continue;
                    } else if (chosen.charAt(10) == '0') {
                        int handIndex = 0;
                        try {
                            handIndex = Integer.parseInt(chosen.charAt(10) + "");
                        } catch (Exception e) {
                            System.out.println("Couldn't parse the int.");
                        }
                        String colorPick = playerBHandColors[handIndex];
                        int numberPick = BHandNums[handIndex];
                        boolean playOkay = false;
                        if (colorPick.equals("Red")) {
                            String bHighestColor = BPaletteColors[0];
                            int bHighestNumber = playerBPaletteNumbers[0];
                            for (int i = 1; i < BPaletteColors.length; i++) {
                                if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                    bHighestColor = BPaletteColors[i];
                                    bHighestNumber = playerBPaletteNumbers[i];
                                }
                            }
                            String aHighestColor = "";
                            int aHighestNumber = 0;
                            for (int i = 0; i < playerAPaletteColors.length; i++) {
                                if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                    aHighestNumber = APaletteNums[i];
                                    aHighestColor = playerAPaletteColors[i];
                                }
                            }
                            if (aHighestNumber < bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Violet"))) {
                                playOkay = true;
                            }
                        } else if (colorPick.equals("Indigo")) {
                            boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                            boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                            String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                            int bMaxStreak = 0;
                            int bStreakTop = 0;
                            int currentStreak = 0;
                            int aMaxStreak = 0;
                            int aStreakTop = 0;
                            String aStreakTopColor = "";
                            for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                numsB[playerBPaletteNumbers[i]] = true;
                            }
                            for (int i = 1; i < numsB.length; i++) {
                                if (numsB[i]) {
                                    currentStreak += 1;
                                    if (currentStreak >=bMaxStreak) {
                                        bMaxStreak = currentStreak;
                                        bStreakTop = i;
                                    }
                                } else {
                                    currentStreak = 0;
                                }
                            }
                            for (int i = 0; i < APaletteNums.length; i++) {
                                numsA[APaletteNums[i]] = true;
                                if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                    colorsA[i] = playerAPaletteColors[i];
                                }
                            }
                            for (int i = 1; i < numsA.length; i++) {
                                if (numsA[i]) {
                                    currentStreak += 1;
                                    if (currentStreak >=aMaxStreak) {
                                        aMaxStreak = currentStreak;
                                        aStreakTop = i;
                                    }
                                } else {
                                    currentStreak = 0;
                                }
                            }
                            aStreakTopColor = colorsA[aStreakTop];
                            if (aMaxStreak < bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop < bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Violet"))) {
                                playOkay = true;
                            }
                            
                        } else if (colorPick.equals("Violet")) {
                            int numBSmall = 0;
                            int highSmallB = 0;
                            for (int i = 0; i < BPaletteColors.length; i++) {
                                if (playerBPaletteNumbers[i] < 4) {
                                    numBSmall ++;
                                    if (playerBPaletteNumbers[i] > highSmallB) {
                                        highSmallB = playerBPaletteNumbers[i];
                                    }
                                }
                            }
                            int numASmall = 0;
                            int highSmallA = 0;
                            String highSmallAColor = "";
                            for (int i = 0; i < playerAPaletteColors.length; i++) {
                                if (APaletteNums[i] < 4) {
                                    numASmall ++;
                                    if (APaletteNums[i] > highSmallA) {
                                        highSmallA = APaletteNums[i];
                                        highSmallAColor = playerAPaletteColors[i];
                                    }
                                }
                            }
                            if (numASmall < numBSmall || (numASmall == numBSmall && highSmallA < highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Violet"))) {
                                playOkay = true;
                            }
                            
                        }
                        
                        
                        if (playOkay) {
                            System.out.println("Made a legal play to the canvas!");
                            
                            canvasColor = colorPick;
                            
                            /*
                            String[] newAPaletteColors = new String[playerAPaletteColors.length + 1];
                            int[] newAPaletteNums = new int[APaletteNums.length + 1];
                            for (int i = 0; i < playerAPaletteColors.length; i++) {
                                newAPaletteColors[i] = playerAPaletteColors[i];
                                newAPaletteNums[i] = APaletteNums[i];
                            }
                            newAPaletteColors[newAPaletteColors.length-1] = colorPick;
                            newAPaletteNums[newAPaletteNums.length - 1] = numberPick;
                            APaletteNums = new int[newAPaletteNums.length];
                            playerAPaletteColors = new String[newAPaletteColors.length];
                            for (int i = 0; i < playerAPaletteColors.length; i++) {
                                APaletteNums[i] = newAPaletteNums[i];
                                playerAPaletteColors[i] = newAPaletteColors[i];
                            } */ 
                            
                            String[] newBHandColors = new String[BHandNums.length - 1];
                            int[] newBHandNums = new int[BHandNums.length - 1];
                            int j = 0;
                            for (int i = 0; i < BHandNums.length; i ++) {
                                if (i != handIndex) {
                                    newBHandColors[j] = playerBHandColors[i];
                                    newBHandNums[j] = BHandNums[i];
                                    j++;
                                }
                            }
                            playerBHandColors = new String[newBHandColors.length];
                            BHandNums = new int[newBHandNums.length];
                            for (int i = 0; i < playerBHandColors.length; i++) {
                                playerBHandColors[i] = newBHandColors[i];
                                BHandNums[i] = newBHandNums[i];
                            }
                            
                            break;
                            
                        }
                    }
                    
                    System.out.println("That move did not help you to win.  Let's try that again...  (canvasColor: " + canvasColor + ")");
                    
                    
                    
                } else if (chosen.equals("Play to Palette and Canvas")) {
                    ArrayList<String> handChoices = new ArrayList<String>();
                    handChoices.add("Go back");
                    for (int i = 0; i < BHandNums.length; i++) {
                        handChoices.add("Play card " + i + ": " + playerBHandColors[i] + " " + BHandNums[i] + " to palette first...");
                    }
                    
                    dialog = new ChoiceDialog<String>("Go back", handChoices);
                    dialog.setHeaderText("First choose for the Palette.");
                    dialog.setContentText("Options:");
                    dialog.showAndWait().ifPresent( (response) -> {
                        choiceChosen.add(response);
                        System.out.println("response: " + response);
                    });
                    chosen = choiceChosen.get(1);
                    if (chosen.equals("Go back")) {
                        System.out.println("Backing up...");
                        continue;
                    } else {
                        boolean playOkay = false;
                        int hand2PaletteIndex = 0;
                        try {
                            hand2PaletteIndex = Integer.parseInt(chosen.charAt(10) + "");
                        } catch (Exception e) {
                            System.err.println("Ooops!  Couldn't get a character!");
                        }
                        String colorPick = playerBHandColors[hand2PaletteIndex];
                        int numberPick = BHandNums[hand2PaletteIndex];
                        handChoices.clear();
                        handChoices.add("Go back");
                        for (int i = 0; i < BHandNums.length; i++) {
                            if (i != hand2PaletteIndex) {
                                handChoices.add("Play card " + i + ": " + playerBHandColors[i] + " " + BHandNums[i] + " to the canvas second.");
                            }
                        }
                    
                        dialog = new ChoiceDialog<String>("Go back", handChoices);
                        dialog.setHeaderText("Next, choose for the canvas.");
                        dialog.setContentText("Options:");
                        dialog.showAndWait().ifPresent( (response) -> {
                            choiceChosen.add(response);
                            System.out.println("response: " + response);
                        });
                        chosen = choiceChosen.get(2);
                        if (chosen.equals("Go back")) {
                            System.out.println("Backing up...");
                            continue;
                        } else {
                            int hand2CanvasIndex = 0;
                            try {
                                hand2CanvasIndex = Integer.parseInt(chosen.charAt(10) + "");
                            } catch (Exception e) {
                                System.err.println("Couldn't get a character when looking for the canvas card!");
                            }
                            String canvasColorPick = AHandColors[hand2CanvasIndex];
                            
                            if (canvasColorPick.equals("Red")) {
                                String bHighestColor = colorPick;
                                int bHighestNumber = numberPick;
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] > bHighestNumber || (playerBPaletteNumbers[i] == bHighestNumber && BPaletteColors[i].equals("Indigo"))) {
                                        bHighestColor = BPaletteColors[i];
                                        bHighestNumber = playerBPaletteNumbers[i];
                                    }
                                }
                                String aHighestColor = playerAPaletteColors[0];
                                int aHighestNumber = APaletteNums[0];
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] > aHighestNumber || (APaletteNums[i] == aHighestNumber && playerAPaletteColors[i].equals("Indigo"))) {
                                        aHighestNumber = APaletteNums[i];
                                        aHighestColor = playerAPaletteColors[i];
                                    }
                                }
                                if (aHighestNumber < bHighestNumber || (aHighestNumber == bHighestNumber && aHighestColor.equals("Violet"))) {
                                    playOkay = true;
                                }
                            } else if (canvasColorPick.equals("Indigo")) {
                                boolean[] numsB = new boolean[] {false, false, false, false, false, false, false, false};
                                boolean[] numsA = new boolean[] {false, false, false, false, false, false, false, false};
                                String[] colorsA = new String[] {"", "", "", "", "", "", "", ""};
                                int bMaxStreak = 0;
                                int bStreakTop = 0;
                                int currentStreak = 0;
                                int aMaxStreak = 0;
                                int aStreakTop = 0;
                                String aStreakTopColor = "";
                                numsB[numberPick] = true;
                                for (int i = 0; i < playerBPaletteNumbers.length; i++) {
                                    numsB[playerBPaletteNumbers[i]] = true;
                                }
                                for (int i = 1; i < numsB.length; i++) {
                                    if (numsB[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=bMaxStreak) {
                                            bMaxStreak = currentStreak;
                                            bStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                for (int i = 0; i < APaletteNums.length; i++) {
                                    numsA[APaletteNums[i]] = true;
                                    if (colorsA[APaletteNums[i]].equals("") || playerAPaletteColors[i].equals("Indigo")) {
                                        colorsA[i] = playerAPaletteColors[i];
                                    }
                                }
                                for (int i = 1; i < numsA.length; i++) {
                                    if (numsA[i]) {
                                        currentStreak += 1;
                                        if (currentStreak >=aMaxStreak) {
                                            aMaxStreak = currentStreak;
                                            aStreakTop = i;
                                        }
                                    } else {
                                        currentStreak = 0;
                                    }
                                }
                                aStreakTopColor = colorsA[aStreakTop];
                                if (aMaxStreak < bMaxStreak || (aMaxStreak == bMaxStreak && aStreakTop < bStreakTop) || (aMaxStreak == bMaxStreak && aStreakTop == bStreakTop && aStreakTopColor.equals("Violet"))) {
                                    playOkay = true;
                                }
                                
                            } else if (canvasColorPick.equals("Violet")) {
                                int numBSmall = 0;
                                int highSmallB = 0;
                                if (numberPick < 4) {
                                    numBSmall++;
                                    highSmallB = numberPick;
                                }
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    if (playerBPaletteNumbers[i] < 4) {
                                        numBSmall ++;
                                        if (playerBPaletteNumbers[i] > highSmallB) {
                                            highSmallB = playerBPaletteNumbers[i];
                                        }
                                    }
                                }
                                int numASmall = 0;
                                int highSmallA = 0;
                                String highSmallAColor = "";
                                for (int i = 0; i < playerAPaletteColors.length; i++) {
                                    if (APaletteNums[i] < 4) {
                                        numASmall ++;
                                        if (APaletteNums[i] > highSmallA) {
                                            highSmallA = APaletteNums[i];
                                            highSmallAColor = playerAPaletteColors[i];
                                        }
                                    }
                                }
                                if (numASmall < numBSmall || (numASmall == numBSmall && highSmallA < highSmallB) || (numASmall == numBSmall && highSmallA == highSmallB && highSmallAColor.equals("Violet"))) {
                                    playOkay = true;
                                }
                                
                            }
                        
                        
                            if (playOkay) {
                                System.out.println("Made a legal play to both the palette and canvas!");
                                
                                canvasColor = canvasColorPick;
                                
                                String[] newBPaletteColors = new String[BPaletteColors.length + 1];
                                int[] newBPaletteNums = new int[BPaletteColors.length + 1];
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    newBPaletteColors[i] = BPaletteColors[i];
                                    newBPaletteNums[i] = playerBPaletteNumbers[i];
                                }
                                newBPaletteColors[newBPaletteColors.length-1] = colorPick;
                                newBPaletteNums[newBPaletteNums.length - 1] = numberPick;
                                playerBPaletteNumbers = new int[newBPaletteNums.length];
                                BPaletteColors = new String[newBPaletteColors.length];
                                for (int i = 0; i < BPaletteColors.length; i++) {
                                    playerBPaletteNumbers[i] = newBPaletteNums[i];
                                    BPaletteColors[i] = newBPaletteColors[i];
                                } 
                                
                                playerBHandColors = new String[0];
                                BHandNums = new int[0];
                                
                                break;
                                
                            }
                        }
                    }
                    
                    System.out.println("That move did not help you to win.  Let's try that again...  (canvasColor: " + canvasColor + ")");
                }
            }
            
            
            
            
            
            board = new VBox();
            board.setSpacing(2);
            handText = new Text("Player A's Hand");
            board.getChildren().add(handText);
            aHandCards = new HBox();
            board.getChildren().add(aHandCards);
            for (int i = 0; i < AHandColors.length; i++) {
                StackPane aHandCardPane = new StackPane();
                Rectangle aHandCardR = new Rectangle(125, 175, Color.VIOLET);
                if (AHandColors[i].equals("Indigo")) {
                    aHandCardR.setFill(Color.INDIGO);
                }
                aHandCardPane.getChildren().add(aHandCardR);
                cardNumberText = new Text("" +  playerAHandNums[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                aHandCardPane.getChildren().add(cardNumberText);
                aHandCards.getChildren().add(aHandCardPane);
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Player A's Palette"));
            
            aPaletteCards = new HBox();
            board.getChildren().add(aPaletteCards);
            for (int i = 0; i < playerAPaletteColors.length; i++) {
                aPalette = new StackPane();
                aPaletteR = new Rectangle(125, 175, Color.VIOLET);
                if (playerAPaletteColors[i].equals("Indigo")) {
                    aPaletteR.setFill(Color.INDIGO);
                }
                aPalette.getChildren().add(aPaletteR);
                cardNumberText = new Text("" + APaletteNums[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                aPalette.getChildren().add(cardNumberText);
                aPaletteCards.getChildren().add(aPalette);
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Canvas"));
            
            if (canvasColor.equals("Red")) {
                board.getChildren().add(new Rectangle(175, 125, Color.RED));
            } else if (canvasColor.equals("Indigo")) {
                board.getChildren().add(new Rectangle(175, 125, Color.INDIGO));
            } else  if (canvasColor.equals("Violet")) {
                board.getChildren().add(new Rectangle(175, 125, Color.VIOLET));
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Player B's Palette"));
            
            bPaletteCards = new HBox();
            board.getChildren().add(bPaletteCards);
            for (int i = 0; i < BPaletteColors.length; i++) {
                bPalette = new StackPane();
                bPaletteR = new Rectangle(125, 175, Color.VIOLET);
                if (BPaletteColors[i].equals("Indigo")) {
                    bPaletteR.setFill(Color.INDIGO);
                }
                bPalette.getChildren().add(bPaletteR);
                cardNumberText = new Text("" + playerBPaletteNumbers[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                bPalette.getChildren().add(cardNumberText);
                bPaletteCards.getChildren().add(bPalette);
            }
            
            board.getChildren().add(new Separator());
            
            board.getChildren().add(new Text("Player B's Hand"));
            bHandCards = new HBox();
            board.getChildren().add(bHandCards);
            
            for (int i = 0; i < playerBHandColors.length; i++) {
                StackPane bHandCardPane = new StackPane();
                Rectangle bHandCardR = new Rectangle(125, 175, Color.VIOLET);
                if (playerBHandColors[i].equals("Indigo")) {
                    bHandCardR.setFill(Color.INDIGO);
                }
                bHandCardPane.getChildren().add(bHandCardR);
                cardNumberText = new Text("" + BHandNums[i]);
                cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 50.0));
                cardNumberText.setFill(Color.WHITE);
                bHandCardPane.getChildren().add(cardNumberText);
                bHandCards.getChildren().add(bHandCardPane);
            }
            
            
            primaryStage.setScene(new Scene(board));
            primaryStage.show();
            primaryStage.sizeToScene();
        }
        
        System.out.println("Game over!");
        
    }


} //end of Red7
