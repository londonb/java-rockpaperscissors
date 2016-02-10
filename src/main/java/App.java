import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

  }

  public static String checkWinner(String player1, String player2) {
    String winner = "";
    String tie = "Tie";
    if (player1.equals("Rock")) {
      if (player2.equals("Scissors")) {
        winner = player1;
      } else if (player2.equals("Paper")) {
        winner = player2;
      } else {
        winner = tie;
      }
    } else if (player1.equals("Scissors")) {
      if (player2.equals("Paper")) {
        winner = player1;
      } else if (player2.equals("Rock")) {
        winner = player2;
      } else {
        winner = tie;
      }
    } else {
      if (player2.equals("Rock")) {
        winner = player1;
      } else if (player2.equals("Scissors")) {
        winner = player2;
      } else {
        winner = tie;
      }
    }
    return winner;
  }
}  
