package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import factory.driverFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepDefinitions"},
        features = {"src/test/java/features"},
        tags = "@login,@massa")
public class TestRunner extends driverFactory {
    @BeforeClass
    public static void start() {
        startDriver();
    }

    @AfterClass
    public static void finish() {
        quitDriver();
    }
}
