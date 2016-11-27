package selenium;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import io.ddavison.conductor.Locomotive;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Config(browser = Browser.CHROME, url="http://ddavison.io/tests/getting-started-with-selenium.htm")
public class FrameworkTest extends Locomotive {
    @Test
    public void testClick() throws Exception {
        click("#click")
                .validatePresent("#click.success"); // adds the .success class after click
    }

    @Test
    public void testSetText() throws Exception {
        setText("#setTextField", "test")
                .validateText("#setTextField", "test");
    }

    @Test
    public void testCheckUncheck() throws Exception {
        check("#checkbox")
                .validateChecked("#checkbox")
                .uncheck("#checkbox")
                .validateUnchecked("#checkbox");
    }

    @Test
    public void testSelectOption() throws Exception {
        selectOptionByText("#select", "Third")
                .validateText("#select", "3")
                .selectOptionByValue("#select", "2")
                .validateText("#select", "2");
    }

    @Test
    public void testFrames() throws Exception {
        switchToFrame("frame")
                .validatePresent("#frame_content")
                .switchToDefaultContent()
                .validateNotPresent("#frame_content");
    }

    @Test
    public void testWindowSwitching() throws Exception {
        click("a[href='http://google.com']")
                .waitForWindow(".*Google.*")
                .validatePresent("[name='q']")
                .setText("[name='q']", "hello")
                .closeWindow()
                .validateNotPresent("[name='q']");
    }

    @Test
    public void testValidatingAttributes() throws Exception {
        validateAttribute("#click", "class", "^box$")
                .click("#click")
                .validateAttribute("#click", "class", ".*success.*");
    }

    @Test
    public void testVariables() throws Exception {
        store("initial_text", getText("#setTextField"))
                .validateTrue(get("initial_text").equals("some text")); // the text box defaults to the text "some text"
    }

    @Test
    public void testWaitingFor() throws Exception {
        By checkbox = By.cssSelector("#checkbox");
        check(checkbox)
                .waitForCondition(ExpectedConditions.elementSelectionStateToBe(
                        checkbox, true
                ));
    }

    @Test
    public void testGetTextFromTextArea() throws Exception {
        setText("#textArea", "some text")
                .validateText("#textArea", "some text");
    }
}