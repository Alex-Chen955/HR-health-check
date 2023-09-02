package comc.proj.controller;



import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet", value = "/Servlet")
public class questionnaireResult extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        double mean1=0, mean2=0, mean3=0;
        int result1=0, result2=0, result3=0, result4=0, result5=0, result6=0,result7=0, result8=0, result9=0, result10=0;
        int result11=0, result12=0, result13=0;
        int scores[]={0,0,0,0,0,0,0,0,0,0,0,0,0};
        //get the parameter
        String section1=request.getParameter("section1");
        String section2=request.getParameter("section2");
        String section3=request.getParameter("section3");
        String section4=request.getParameter("section4");
        String section5=request.getParameter("section5");
        String section6=request.getParameter("section6");
        String section7=request.getParameter("section7");
        String section8=request.getParameter("section8");
        String section9=request.getParameter("section9");
        String section10=request.getParameter("section10");
        String section11=request.getParameter("section11");
        String section12=request.getParameter("section12");
        String section13=request.getParameter("section13");
        //get the mean score
        result1=Integer.parseInt(section1);
        result2=Integer.parseInt(section2);
        result3=Integer.parseInt(section3);
        result4=Integer.parseInt(section4);
        result5=Integer.parseInt(section5);
        result6=Integer.parseInt(section6);
        result7=Integer.parseInt(section7);
        result8=Integer.parseInt(section8);
        result9=Integer.parseInt(section9);
        result10=Integer.parseInt(section10);
        result11=Integer.parseInt(section11);
        result12=Integer.parseInt(section12);
        result13=Integer.parseInt(section13);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
        System.out.println(result10);
        System.out.println(result11);
        System.out.println(result12);
        System.out.println(result13);
        scores[0]=(int)result1;
        scores[1]=(int)result2;
        scores[2]=(int)result3;
        scores[3]=(int)result4;
        scores[4]=(int)result5;
        scores[5]=(int)result6;
        scores[6]=(int)result7;
        scores[7]=(int)result8;
        scores[8]=(int)result9;
        scores[9]=(int)result10;
        scores[10]=(int)result11;
        scores[11]=(int)result12;
        scores[12]=(int)result13;

        /*
        调用reportManager类创建pdf
         */
        pdf.pdfExport.src.HTMLEditor.PDFManager pdfManager= new pdf.pdfExport.src.HTMLEditor.PDFManager(scores);
        pdfManager.makePDF();
        response.sendRedirect("/hr/download.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
