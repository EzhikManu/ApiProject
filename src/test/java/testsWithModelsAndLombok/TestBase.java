package testsWithModelsAndLombok;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.CredentialsConfig;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({AllureJunit5.class})
public class TestBase {
    CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    String login = credentials.login();
    String password = credentials.password();

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        Configuration.remote = String.format("https://%s:%s@selenoid.autotests.cloud/wd/hub/", login, password);
    }

}
