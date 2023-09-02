package pdf.pdfExport.src.HTMLEditor;

public class PDFManager 
{
	
	private HTMLEditor editor;
	private PDFExporter exporter;
	
	/**
	 * @param srcPath ��Դ�ļ���·��
	 * @param expPath ����pdf�ļ���·��
	 * @scores Ϊ����
	 * */
	public PDFManager(int[] scores) 
	{
		
		try 
		{
			editor=new HTMLEditor(scores);
			editor.createHTMLCopy();
			exporter=new PDFExporter();
		} 
		catch (SizeUnmatchExeception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		int [] tem={4,4,5,3,6,2,5,2,5,3,3,3,3};

		PDFManager temp=new PDFManager(tem);
	    temp.makePDF();
	}
	
	public void makePDF() 
	{
		exporter.exportPdf();
	}

}
