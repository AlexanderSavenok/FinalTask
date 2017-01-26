package reporting;


import core.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;

public class Utils {
    @Attachment(value = "(0)", type = "image/pmg")

    public static byte[] makeScreenshot(String name) {
        return ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.BYTES);
    }
}
