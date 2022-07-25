package runner;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@KarateOptions(
        features = "src/test/resources/features",
        tags = "@case"
)
class UiTestRunner {

    @Test
    void run(){
        Results results = Runner.parallel(getClass(), 1);
        Assertions.assertEquals(0 , results.getFailCount());


    }
}