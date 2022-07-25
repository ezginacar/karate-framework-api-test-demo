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
 class ApiTestRunner {
    ReportUtil reportUtil = new ReportUtil();
    @Test
    void run(){
        Results results = Runner.parallel(getClass(), 1);
        reportUtil.generateReport(results.getReportDir());
        Assertions.assertEquals(0 , results.getFailCount());


    }
}
