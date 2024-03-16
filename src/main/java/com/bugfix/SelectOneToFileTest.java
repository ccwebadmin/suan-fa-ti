package com.bugfix;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.errors.EncodingException;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class SelectOneToFileTest {

    /* uses badsource and badsink */
//    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable {
//        String data;
//        data = ""; // Initialize data
//
//        /* Read data from a database*/
//        {
//            Connection connection = null;
//            PreparedStatement preparedStatement = null;
//            ResultSet resultSet = null;
//            try {
//                /* setup the connection */
//                connection = IO.getDBConnection();
//                /* prepare and execute a (hardcoded) query */
//                preparedStatement = connection.prepareStatement("select name from users where id=0");
//                resultSet = preparedStatement.executeQuery();
//                /* POTENTIAL FLAW:Read data from a database query resultset */
//                data = resultSet.getString(1);
//            } catch (SQLException exceptSql) {
//                IO.logger.log(Level.WARNING, "Error with SQL statement", exceptSql);
//            } finally {
//                /* Close databaseobjects */
//                try {
//                    if (resultSet != null) {
//                        resultSet.close();
//                    }
//                } catch (SQLException exceptSql) {
//                    IO.logger.log(Level.WARNING, "Error losing ResultSet", exceptSql);
//                }
//                try {
//                    if (preparedStatement != null) {
//                        preparedStatement.close();
//                    }
//                } catch (SQLException exceptSql) {
//                    IO.logger.log(Level.WARNING, "Error closing PreparedStatement", exceptSql);
//                }
//                try {
//                    if (connection != null) {
//                        connection.close();
//                    }
//                } catch (SQLException exceptSql) {
//                    IO.logger.log(Level.WARNING, "Error closing Connection", exceptSql);
//
//                }
//            }
//
//            if (data != null) {
///* POTENTIAL FLAW: Display
//of data in web page after using
//replaceAll() to remove script tags,
//which will still allow XSS with
//strings like <scr<script>ipt> (CWE
//182: Collapse of Data into Unsafe
//Value) */
//                response.getWriter().println("<br>bad():data = " + ESAPI.encoder().encodeForHTML(data.replaceAll("(<script>)", "")));
//            }
//        }
//    }
//
//    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable{
//        goodG2B(request, response);
//    }
//
//    /* goodG2B() - uses goodsource and badsink */
//    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable{
//        String data;
//        /* FIX: Use a hardcoded string
//         */
//        data = "foo";
//
//        if (data != null)
//        {
//            /* POTENTIAL FLAW: Display
//of data in web page after using
//replaceAll() to remove script tags,
//which will still allow XSS with
//strings like <scr<script>ipt> (CWE
//182: Collapse of Data into Unsafe
//Value) */
//            response.getWriter().println("<br>bad(): data = " + data.replaceAll("(<script>)", ""));
//        }
//    }

    /* Below is the main(). It is only
used when building this testcase on
* its own for testing or for
building a binary to use in testing
binary
* analysis tools. It is not used
when compiling all the testcases as
one
* application, which is how
source code analysis tools are tested.
*/


    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, EncodingException {
//        mainFromParent(args);
        System.out.println("9d4f700f-9b49-6d46-4f6e-c46c8aaa1b73".length());

        String data = "<script>alert(\"document.cookie\")</script>";
        String data2 = "打印任务名.pdf";

        System.out.println("<br>goodG2B(): data = " + ESAPI.encoder().encodeForHTML(data));
        System.out.println("<br>goodG2B(): data = " + ESAPI.encoder().encodeForHTML(data2));
        String url ="<script>http://10.1.50.244/group1/M00/00/08/CgEy9GS7LgyADRCwABQCv1ibMxg457.pdf";

        System.out.println(ESAPI.encoder().decodeFromURL(url));
        System.out.println(ESAPI.encoder().encodeForHTML(url.replaceAll("<script>","")));


        System.out.println(ESAPI.encoder().encodeForHTML("<a href='sdfs'></a> < script > alert(); </ script >"));

        int totalPages  =  (int)Math.ceil((double)2804 / (double)10);

        System.out.println(totalPages);
    }

}
