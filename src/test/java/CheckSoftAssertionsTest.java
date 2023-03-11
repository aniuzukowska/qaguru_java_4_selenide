import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byLinkText;

public class CheckSoftAssertionsTest {

    @Test
    void isThereExampleJUnit5InSoftAssertions(){
        String jUnitCodeExample= "@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}";

        Configuration.browserSize="1920x1080";
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $(byLinkText("SoftAssertions")).shouldBe(visible);
        $(byLinkText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5"), text(jUnitCodeExample));
    }
}
