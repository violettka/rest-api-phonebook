package de.phonebook;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:target/cucumber-reports.json" })
public class PhonebookTest {
}
