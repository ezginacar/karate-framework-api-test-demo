<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">

<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Test Automation Results</title>
    <style style="text/css">
        </style>
</head>
        <%
import groovy.json.JsonSlurper
%>

<body>
        <div style="width:100%; padding-right:15px; padding-left:15px;margin-right:auto;margin-left:auto; font-family:verdana;">
        <table style="width:100%; margin-bottom: 1rem; background-color:transparent; border-collapse: collapse;">
        <thead style="text-align: center; color:#fff; background-color:#1C4771;border-color:#32383e;">
        <tr>
        <th style="text-align: center; border-bottom-width: 1px; border: 1px solid #E0DBDB;" colspan="2">
        <h1>
        <b>AUTOMATION SUMMARY REPORT</b>
                        </h1>
        </th>
                </tr>
        <tr>

        <th style="color: <%=build.result == build.result.SUCCESS ? '#008000' : '#FF0000'%>; border-bottom-width: 1px; border: 1px solid #E0DBDB; " colspan="2">
        <h2><%= build.result == hudson.model.Result.SUCCESS ? "ALL TESTS PASSED" : "SOME TESTS FAILED OR THE JOB ENCOUNTERED A PROBLEM" %></h2>
                </tr>
        </thead>
            <tbody>

                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Adress </td>
        <td style="border: 1px solid #E0DBDB;"><b><a href=${project.url}+"/ws/API/target/surefire-reports"></a>"${project.url}"+"/ws/API/target/surefire-reports/results-json.txt"</b></td>
        </tr>

                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Build URL : </td>
        <td style="border: 1px solid #E0DBDB;"><b><a href=${build.url}></a>${build.url}</b></td>
                </tr>
        <tr>
        <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Project URL : </td>
                    <td style="border: 1px solid #E0DBDB;"><b><a href="${project.url}">${project.url}</a></b></td>
</tr>
                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Build No : </td>
        <td style="border: 1px solid #E0DBDB;"> ${build.number} </td>
                </tr>
        <tr>
        <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Date of build : </td>
                    <td style="border: 1px solid #E0DBDB;">${it.timestampString}</td>
        </tr>
                <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Build duration : </td>
<td style="border: 1px solid #E0DBDB;">${build.durationString}</td>
                </tr>
        <tr>
        <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Detailed Result : </td>
                    <td style="border: 1px solid #E0DBDB;"><b><a href="${build.url}"> Click here to see Console Output</a></b></td>
        </tr>

               <tr>
                    <td style="font-weight:bold; border: 1px solid #E0DBDB;"> Environment : </td>
<td style="border: 1px solid #E0DBDB;">${params.Env} </td>
                </tr>

        </tbody>
        </table>


        </div>
</body>
</html>
