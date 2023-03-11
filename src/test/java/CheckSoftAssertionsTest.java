import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.byLinkText;

public class CheckSoftAssertionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
    }
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

        open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".js-wiki-more-pages-link").click();
        $(byLinkText("SoftAssertions")).shouldBe(visible);
        $(byLinkText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5"), text(jUnitCodeExample));
    }
}
