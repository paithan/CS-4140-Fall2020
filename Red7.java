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
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import javafx.scene.Node;

/**
 * An implementation of the game Red7, by Asmadi Games.  Only includes two card colors: violet and indigo.  Thanks to Asmadi Games for granting me permission to use their game rules for educational purposes.  This implementation is intended to be terrible, and will be updated during the semester in a Software Engineering course.
 *
 * @author Kyle Burke <kwburke@plymouth.edu>
 */
public class Red7 extends Application {
    
    //starting hand size
    private static final int STARTING_HAND_SIZE = 2;
    
    
    
    
    //returns an all-false boolean array of length 7
    private boolean[] createDealtInColorArray() {
        return new boolean[7];
    }
    
    
    
    //returns an HBox with the cards in it.
    private Node getHorizontalCardsNode(Collection<Card> cards) {
        Pane cardsBox = new HBox();
        for (Card card : cards) {
            cardsBox.getChildren().add(card.getNode());
        }
        return cardsBox;
    }
    
    
    //copies a collection of cards
    private Collection<Card> copyCards(Collection<Card> original) {
        Collection<Card> copy = new ArrayList<Card>();
        for (Card card : original) {
            copy.add(card);
        }
        return copy;
    }
    
    //adds an HBox with the cards to the children of the given pane
    private void addCardsHorizontally(Collection<Card> cards, Pane pane) {
        Pane cardsBox = new HBox();
        for (Card card : cards) {
            cardsBox.getChildren().add(card.getNode());
        }
        pane.getChildren().add(cardsBox);
    }
    
    
    //draws the board on the stage
    private void drawBoard(Stage stage, Collection<Card> playerAHand, Collection<Card> playerBHand, Collection<Card> playerAPalette, Collection<Card> playerBPalette, CardColor ruleColor) {
        
        //Creates overall GUI
        VBox board = new VBox();
        board.setSpacing(2);
        
        //Creates GUI for player A's hand
        Text handText = new Text("Player A's Hand");
        board.getChildren().add(handText);
        
        Text cardNumberText;
        
        
        this.addCardsHorizontally(playerAHand, board);
        
        
        board.getChildren().add(new Separator());
        
        
        //Creating GUI for Player A's Palette
        board.getChildren().add(new Text("Player A's Palette"));
        
        this.addCardsHorizontally(playerAPalette, board);
        
        board.getChildren().add(new Separator());
        
        board.getChildren().add(new Text("Canvas"));
        
        // draw the canvas card
        StackPane canvasNode = new StackPane();
        
        //add the colored rectangle to the bottom
        Rectangle colorRect = new Rectangle(175, 125, ruleColor.getGuiColor());
        canvasNode.getChildren().add(colorRect);
        
        //add the text number on top
        cardNumberText = new Text("\n\n\n\n\n" + ruleColor.getRule());
        cardNumberText.setFont(Font.font("System", FontWeight.BOLD, 10.0));
        cardNumberText.setFill(Color.WHITE);
        canvasNode.getChildren().add(cardNumberText);
        
        board.getChildren().add(canvasNode);
        
        
        
        board.getChildren().add(new Separator());
        
        
        board.getChildren().add(new Text("Player B's Palette"));
        
        this.addCardsHorizontally(playerBPalette, board);
        
        board.getChildren().add(new Separator());
        
        
        
        board.getChildren().add(new Text("Player B's Hand"));
        
        this.addCardsHorizontally(playerBHand, board);
        
        stage.setScene(new Scene(board));
        stage.show();
        stage.sizeToScene();
    }
    
    //Returns whether the first collection is larger than the second.  (First compare sizes, then highest number, then color of that highest number card.
    private static boolean beats(Collection<Card> fittingA, Collection<Card> fittingB) {
        System.out.println("fittingA: " + fittingA);
        System.out.println("fittingB: " + fittingB);
        if (fittingA.size() == fittingB.size()) {
            //go to the tiebreakers
            Card aHighest = Collections.max(fittingA);
            System.out.println("aHighest: " + aHighest);
            Card bHighest = Collections.max(fittingB);
            System.out.println("bHighest: " + bHighest);
            int comparison = aHighest.compareTo(bHighest);
            if (comparison == 0) {
                throw new RuntimeException("We compared two sets of cards that shared the highest card: " + aHighest + ", " + bHighest);
            }
            return comparison > 0;
            
        } else {
            return fittingA.size() > fittingB.size();
        }
    }
    
    

    /**
     * Start the game.
     */
    public void start(Stage primaryStage) {
    
    
        //TODO: remove this in the end
        Map<String, CardColor> stringToColor = new HashMap<String, CardColor>();
        stringToColor.put("Red", new CardColor.Red());
        stringToColor.put("Indigo", new CardColor.Indigo());
        stringToColor.put("Violet", new CardColor.Violet());
    
        primaryStage.setTitle("Red 7");
        
        Deck deck = new Deck();
        
        
        Collection<Card> playerAHand = new ArrayList<Card>();
        Collection<Card> playerBHand = new ArrayList<Card>();
        Collection<Card> playerAPalette = new ArrayList<Card>();
        Collection<Card> playerBPalette = new ArrayList<Card>();
        
        //TODO: delete these later
        int[] playerAHandNums = new int[2];
        int[] BHandNums = new int[2];
        int[] APaletteNums = new int[1];
        int[] playerBPaletteNumbers = new int[1];
        
        String[] AHandColors = new String[2];
        String[] playerBHandColors = new String[2];
        String[] BPaletteColors = new String[1];
        String[] playerAPaletteColors = new String[1];
        
        String canvasColor = "Red";
        CardColor ruleColor = new CardColor.Red();
        
        Random randGen = new Random();
        
        
        
        //deal the first card
        Card nextCard = deck.dealCard();
        playerAPalette.add(nextCard);
        
        //TODO: remove when unneeded
        String color = nextCard.getColor().toString();
        int number = nextCard.getNumber();
        
        //TODO: remove these
        APaletteNums[0] = number;
        playerAPaletteColors[0] = color;
        
        
        //deal the second card
        nextCard = deck.dealCard();
        playerBPalette.add(nextCard);
        
        //TODO: delete these later
        color = nextCard.getColor().toString();
        number = nextCard.getNumber();
        playerBPaletteNumbers[0] = number;
        BPaletteColors[0] = color;
        
        
        
        //deal the cards to player A's hand
        for (int i = 0; i < STARTING_HAND_SIZE; i ++) {
            //get the next card
            nextCard = deck.dealCard();
            playerAHand.add(nextCard);
            
            //TODO: remove these
            color = nextCard.getColor().toString();
            number = nextCard.getNumber();
            //add to A's hand
            playerAHandNums[i] = number;
            AHandColors[i] = color;
            
        }
        
        
        //deal the cards to player B's hand
        for (int i = 0; i < STARTING_HAND_SIZE; i ++) {
            //get the next card
            nextCard = deck.dealCard();
            playerBHand.add(nextCard);
            
            //TODO: remove these
            color = nextCard.getColor().toString();
            number = nextCard.getNumber();
            //add to A's hand
            BHandNums[i] = number;
            playerBHandColors[i] = color;
            
        }
        
        //now all the cards are dealt 
        
        
        //variables declared that are used later.
        VBox board;
        Text handText;
        Text cardNumberText;
        Pane aHandCards; 
        StackPane aPalette; 
        Rectangle aPaletteR; 
        StackPane bPalette; 
        Rectangle bPaletteR; 
        HBox bHandCards; 
        
        
        this.drawBoard(primaryStage, playerAHand, playerBHand, playerAPalette, playerBPalette, ruleColor);
        
        
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
//                            if (canvasColor.equals("Red")) {
                            if (ruleColor.equals(new CardColor.Red())) {
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
//                            } else if (canvasColor.equals("Indigo")) {
                            } else if (ruleColor.equals(new CardColor.Indigo())) {
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
                                
//                            } else if (canvasColor.equals("Violet")) {
                            } else if (ruleColor.equals(new CardColor.Violet())) {
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
//                            if (canvasColor.equals("Red")) {
                            if (ruleColor.equals(new CardColor.Red())) {
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
//                            } else if (canvasColor.equals("Indigo")) {
                            } else if (ruleColor.equals(new CardColor.Indigo())) {
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
                                
//                            } else if (canvasColor.equals("Violet")) {
                            } else if (ruleColor.equals(new CardColor.Violet())) {
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
                        
                        System.out.println("That move did not help you to win.  Let's try that again...  (ruleColor: " + ruleColor + ")");
                        
                        
                        
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
                                
                                //canvasColor = colorPick;
                                ruleColor = stringToColor.get(colorPick);
                                
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
//                            if (canvasColor.equals("Red")) {
                            if (ruleColor.equals(new CardColor.Red())) {
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
                            //} else if (canvasColor.equals("Indigo")) {
                            } else if (ruleColor.equals(new CardColor.Indigo())) {
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
                                
                            //} else if (canvasColor.equals("Violet")) {
                            } else if (ruleColor.equals(new CardColor.Violet())) {
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
                                
                                //canvasColor = colorPick;
                                ruleColor = stringToColor.get(colorPick);
                                
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
                        
                        System.out.println("That move did not help you to win.  Let's try that again...  (ruleColor: " + ruleColor + ")");
                        
                        
                        
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
                                    
                                    //canvasColor = canvasColorPick;
                                    ruleColor = stringToColor.get(canvasColorPick);
                                    
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
                        
                        System.out.println("That move did not help you to win.  Let's try that again...  (ruleColor: " + ruleColor + ")");
                    }
                }
                
            }
            
            
            this.drawBoard(primaryStage, playerAHand, playerBHand, playerAPalette, playerBPalette, ruleColor);
            
            HBox aPaletteCards = new HBox();
            HBox bPaletteCards = new HBox();
            
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
                        Card cardPick = new Card(colorPick, numberPick);
                        boolean playOkay = false;
                        
                        
                        //create a copy of player B's palette with the new card to try to play
                        Collection<Card> bAttempt = copyCards(playerBPalette);
                        bAttempt.add(cardPick);
                        
                        Collection<Card> fittingA = ruleColor.getFittingCards(playerAPalette);
                        Collection<Card> fittingB = ruleColor.getFittingCards(bAttempt);
                        playOkay = beats(fittingB, fittingA);
                        
                        
                        /*
                        if (ruleColor.equals(new CardColor.Red())) {
                        
                            
                            
                            
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
                        //} else if (canvasColor.equals("Indigo")) {
                        } else if (ruleColor.equals(new CardColor.Indigo())) {
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
                            
                        //} else if (canvasColor.equals("Violet")) {
                        } else if (ruleColor.equals(new CardColor.Violet())) {
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
                            
                        }*/
                        
                        
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
                            
                            playerBPalette.add(cardPick);
                            //TODO: remove the cardPick from player B's hand.
                            
                            break;
                            
                        }
                    } 
                    
                    System.out.println("That move did not help you to win.  Let's try that again...  (ruleColor: " + ruleColor + ")");
                    
                    
                    
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
                            
//                            canvasColor = colorPick;
                            ruleColor = stringToColor.get(colorPick);
                            
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
                    
                    System.out.println("That move did not help you to win.  Let's try that again...  (ruleColor: " + ruleColor + ")");
                    
                    
                    
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
                                ruleColor = stringToColor.get(canvasColorPick);
                                
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
            
            
            
            this.drawBoard(primaryStage, playerAHand, playerBHand, playerAPalette, playerBPalette, ruleColor);
            
        }
        
        System.out.println("Game over!");
        
    }
    
    /**
     * Main method to run the game.
     */
    public static void main(String[] args) {
        unitTest();
        launch(args);
    }
    
    //unit test
    private static void unitTest() {
        System.out.println("********* Starting Unit Test *************");
        
        //testing the beats method
        Collection<Card> fittingA = new ArrayList<Card>();
        Collection<Card> fittingB = new ArrayList<Card>();
        fittingA.add(new Card("Red", 7));
        System.out.println(Red7.beats(fittingA, fittingB) + "   (Should be true.)"); 
        fittingB.add(new Card("Indigo", 3));
        System.out.println(Red7.beats(fittingA, fittingB) + "   (Should be true.)"); 
        fittingB.add(new Card("Violet", 6));
        System.out.println(Red7.beats(fittingA, fittingB) + "   (Should be false.)"); 
        fittingA.add(new Card("Violet", 1));
        System.out.println(Red7.beats(fittingA, fittingB) + "   (Should be true.)"); 
        System.out.println("********* Unit Test Complete *************");
    }


} //end of Red7
