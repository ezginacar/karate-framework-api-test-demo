< !DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd" >

< html >
        < head >
        < meta http - equiv = "Content-Type" content = "text/html; charset=utf-8" / >
        < meta name = "viewport" content = "width=device-width, initial-scale=1.0" / >
        < title > Test Automation Results < /title>
    <style style="text/ css ">
        < /style>
</ head >
        < %
import groovy.json.JsonSlurper

% >

< body >
        < div style = "width:100%; padding-right:15px; padding-left:15px;margin-right:auto;margin-left:auto; font-family:verdana;" >
        < table style = "width:100%; margin-bottom: 1rem; background-color:transparent; border-collapse: collapse;" >
        < thead style = "text-align: center; color:#fff; background-color:#1C4771;border-color:#32383e;" >
        < tr >
        < th style = "text-align: center; border-bottom-width: 1px; border: 1px solid #E0DBDB;" colspan = "2" >
        < h1 >
        < b > AUTOMATION SUMMARY REPORT < /b>
                        </ h1 >
        < /th>
                </ tr >
        < tr >

        < th style = "color: <%=build.result == build.result.SUCCESS ? '#008000' : '#FF0000'%>; border-bottom-width: 1px; border: 1px solid #E0DBDB; " colspan = "2" >
        < h2 > < %= build.result == hudson.model.Result.SUCCESS ? "ALL TESTS PASSED" : "SOME TESTS FAILED OR THE JOB ENCOUNTERED A PROBLEM" % > < /h2>
                </ tr >
        < /thead>
            <tbody>


                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Project URL : </ td >
        < td style = "border: 1px solid #E0DBDB;" > < b > < a href = "${rooturl}${project.url}" > $ { rooturl } $ { project.url } < /a></ b > < /td>
                </ tr >

        < tr >
        < td style = "font-weight:bold; border: 1px solid #E0DBDB;" > Build No: < /td>
                    <td style="border: 1px solid #E0DBDB;"> ${build.number} </ td >
        < /tr>

                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Build Parameters : </ td >
        < td style = "border: 1px solid #E0DBDB;" > < b > < a href = "${rooturl}${build.url}parameters/" > See all parameters "</a></b></td>
        < /tr>

                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Date of build : </ td >
        < td style = "border: 1px solid #E0DBDB;" > $ { it.timestampString } < /td>
                </ tr >
        < tr >
        < td style = "font-weight:bold; border: 1px solid #E0DBDB;" > Build duration: < /td>
                    <td style="border: 1px solid #E0DBDB;">${build.durationString}</ td >
        < /tr>
                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Detailed Result : </ td >
< td style = "border: 1px solid #E0DBDB;" >
        < b > < a href = "${rooturl}${build.url}" > Click here to see Console Output < /a></ b >
        < /td><!--API/ target / karate.log-- >
        < /tr>
            </ tbody >
< /table>

<%    
       def url = "${rooturl}${project.url}ws/ API / target / surefire - reports / results - json.txt""
String jsonString = new File(url).getText('UTF-8')
def parser = new JsonSlurper()
def testsuite = parser.parseText(jsonString)
def skipped = Integer.valueOf(testsuite.getAt("scenarios")) - (Integer.valueOf(testsuite.getAt("failed")) + Integer.valueOf(testsuite.getAt("passed")))
        % >


        < table style = "width:100%; border-collapse: collapse;" >
        < thead style = "text-align: center;" >
        < tr style = "color:#fff; background-color:#1C4771;" >
        < th style = "border: 1px solid #E0DBDB;" colspan = "7" > < h4 > < b > Test Summary < /b></ h4 > < /th>
                </ tr >
        < tr style = "color:#fff; background-color:#1C4771;" >
        < th style = "font-weight:bold; border: 1px solid #E0DBDB;" > Total < /th>
                    <th style="font-weight:bold; border: 1px solid #E0DDB;">Failed</ th >
        < th style = "font-weight:bold; border: 1px solid #E0DBDB;" > Passed < /th>
                    <th style="font-weight:bold; border: 1px solid #E0DBDB;">Skipped</ th >
        < th style = "font-weight:bold; border: 1px solid #E0DBDB;" > Pass % < /th>
                </ tr >
        < /thead>
            <tbody style="text-align: center;">


                <tr>
                    <!--Aşağıda Automation_Environment ve Tag_Group değişkenleri build alınmadan önce seçim yaptığım parametre değerlerini temsil ediyor -->
                    <td style="border: 1px solid #E0DBDB;"> <%println(testsuite.getAt("scenarios"))%> </ td >
        < td style = "color:red; border: 1px solid #E0DBDB;" > < % println(testsuite.getAt("failed")) % > < /td>
                    <td style="color:green; border: 1px solid #E0DBDB;"> <%println(testsuite.getAt("passed"))%> </ td >
        < td style = "color:#FF7F00; border: 1px solid #E0DBDB;" > < % println(skipped) % > < /td>
                    <td style="border: 1px solid #E0DBDB;"><%println((Integer.valueOf(testsuite.getAt("scenarios")) - (Integer.valueOf(testsuite.getAt("failed")) - skipped  * 100)%></ td >
        < /tr>
            </ tbody >


        < /div>
</ body >
        < /html>
