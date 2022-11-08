package com.cydeo.library.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-reports.html",
                  "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                  "rerun:target/rerun.txt",
                  "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/cydeo/library/step_def",
        dryRun = false,
        tags = "@all_accounts"
)

public class CukesRunner {

}
