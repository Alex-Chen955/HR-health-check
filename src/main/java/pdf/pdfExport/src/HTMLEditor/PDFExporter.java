package pdf.pdfExport.src.HTMLEditor;

import java.io.*;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;



 class PDFExporter 
 {
	
	PDFExporter()
	{
		File inputSource=new File("E:\\workspace\\HRhealthcheck\\src\\main\\webapp\\report.pdf");
		if(inputSource.exists())inputSource.delete();
	}
	
	 void exportPdf() 
	{
		File inputSource=new File("E:\\workspace\\HRhealthcheck\\src\\main\\java\\pdf\\pdfExport\\src\\temp\\report.html");
		File outputPDF=new File("E:\\workspace\\HRhealthcheck\\src\\main\\webapp\\report.pdf");
		
//		ConverterProperties converterProperties = new ConverterProperties();
        try 
        {
			HtmlConverter.convertToPdf(new FileInputStream(inputSource), 
			new FileOutputStream(outputPDF), null);
		}
        catch (IOException e) 
        {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
