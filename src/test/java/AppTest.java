import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }
  //integration testing
  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Player 1:");
      submit(".btn");
      assertThat(pageSource()).contains("Outcome");
  }

  //unit testing
  @Test
  public void checkWinner_rockBeatsScissors_rockwins() {
    App testApp = new App();
    assertEquals("Rock", testApp.checkWinner("Rock", "Scissors"));
  }

  @Test
  public void checkWinner_paperWin_paperWins() {
    App testApp = new App();
    assertEquals("Paper", testApp.checkWinner("Rock", "Paper"));
  }

  @Test
  public void checkWinner_rockVSrock_tie() {
    App testApp = new App();
    assertEquals("Tie", testApp.checkWinner("Rock", "Rock"));
  }

  @Test
  public void checkWinner_ScissorsBeatsPaper_rockwins() {
    App testApp = new App();
    assertEquals("Scissors", testApp.checkWinner("Scissors", "Paper"));
  }

  @Test
  public void checkWinner_ScissorslosesToRock_rockwins() {
    App testApp = new App();
    assertEquals("Rock", testApp.checkWinner("Scissors", "Rock"));
  }

}
