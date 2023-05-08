import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homework {

    static EdgeDriver driver;

    @BeforeAll
    public static void setBeforeAll() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
    }

    @BeforeEach
    public void openBeforeEach() {
        driver = new EdgeDriver();
        driver.get("https://www.tkani-feya.ru/");
    }

    @AfterEach
    public void closeAfterEach() {
        driver.close();
    }

    @Test
    public void shouldSearchFullTitleTextile() {
        driver.findElement(By.name("find")).sendKeys("Шелк атласный" + Keys.ENTER);

        assertEquals(driver.getCurrentUrl(), "https://www.tkani-feya.ru/fabrics/?find=%D0%A8%D0%B5%D0%BB%D0%BA+" +
                "%D0%B0%D1%82%D0%BB%D0%B0%D1%81%D0%BD%D1%8B%D0%B9");

        for (WebElement el: driver.findElements(By.cssSelector(".class .name"))) {
            assertTrue(el.getText().contains("Шелк атласный"));
        }

    }

    @Test
    public void shouldSearchspace() {
        driver.findElement(By.name("find")).sendKeys(" " + Keys.ENTER);

        assertEquals(driver.getCurrentUrl(), "https://www.tkani-feya.ru/fabrics/?find=+");
    }


}
