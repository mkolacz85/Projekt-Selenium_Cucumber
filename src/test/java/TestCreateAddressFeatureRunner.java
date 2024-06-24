import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/main/resources/features/Exercise1/my-store-create-address.feature",
        plugin = {"pretty", "html:google-report.html"}
)
public class TestCreateAddressFeatureRunner {
}
