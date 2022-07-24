package performanceTests

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

class PerfTest extends Simulation {


  val caseStudy = scenario("case study performance test").exec(karateFeature("classpath:features/CaseStudy.feature"))

  setUp(
    caseStudy.inject(rampUsers(3) during (5))
  )
}