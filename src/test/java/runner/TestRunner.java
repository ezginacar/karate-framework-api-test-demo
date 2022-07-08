package runner;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.ReportUtil;


@KarateOptions(
        features = "src/test/resources/features",
        tags = "@caseStudy"
)
 class TestRunner {
    ReportUtil reportUtil = new ReportUtil();
    @Test
    void run(){
        System.setProperty("karate.env", "test");
        Results results = Runner.parallel(getClass(), 1);
        reportUtil.generateReport(results.getReportDir());
        Assertions.assertEquals(0 , results.getFailCount());


    }
}
