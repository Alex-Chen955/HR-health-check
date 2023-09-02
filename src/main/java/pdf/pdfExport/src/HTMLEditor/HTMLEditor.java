package pdf.pdfExport.src.HTMLEditor;

/**
 *锟斤拷要一锟斤拷写锟诫报锟斤拷锟侥憋拷锟侥凤拷锟斤拷
 * */

import java.io.*;
import java.util.*;

 class HTMLEditor 
{	
	 
	private File copy;
	private File targetFile;
	
	
	private int[] scores=new int[13];
	private final int[] totalValue= {8,8,10,6,12,4,10,4,10,6,6,6,6};

	public static void main(String[] args) throws Exception 
	{
		int[] replaceValue=new int[13];
		replaceValue[1]=5;
		replaceValue[2]=6;
		HTMLEditor editor=new HTMLEditor(replaceValue);
		editor.createHTMLCopy();
	}
	
	
	
	/**
	 * 选锟斤拷岜伙拷锟斤拷频锟侥匡拷锟斤拷募锟斤拷锟斤拷锟斤拷锟絫emp锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷应锟侥硷拷锟侥革拷锟斤拷
	 * @throws SizeUnmatchExeception 
	 * */
	HTMLEditor(int[] values) throws SizeUnmatchExeception  
	{	
		
		fillScores(values);
		targetFile=new File("E:\\workspace\\HRhealthcheck\\src\\main\\java\\pdf\\pdfExport\\src\\reportFrame.html");
	    copy=new File("E:\\workspace\\HRhealthcheck\\src\\main\\java\\pdf\\pdfExport\\src\\temp\\"+"report.html");
		if(copy.exists())copy.delete();
		try {
			copy.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(targetFile.exists());
		System.out.println(copy.exists());
	}
	 
	/**
	 * 锟睫改诧拷锟揭革拷锟斤拷锟侥硷拷
	 * */
	 void createHTMLCopy() 
	{
		try 
		{
			FileReader fr=new FileReader(targetFile);
			BufferedReader br=new BufferedReader(fr);
			FileWriter fw=new FileWriter(copy);
			BufferedWriter bw=new BufferedWriter(fw);
		
			String str;
			while((str=br.readLine())!=null) //锟斤拷锟侥硷拷锟斤拷锟斤拷写锟诫复锟斤拷锟侥硷拷
			{
				if(str.matches(".*key([0-9]{1,2}).*")) fillValue(str,bw);//锟斤拷锟斤拷屑锟斤拷幕锟斤拷锟斤拷婊�
				else if(str.matches(".* part[0-9]{1,2}.*")) writeReportText(str,bw);
				else bw.write(str);
				bw.newLine();
			}
			br.close();
			bw.close();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	 
	/**
	 * 锟斤拷锟斤拷值锟芥换为锟斤拷锟捷匡拷锟斤拷锟斤拷锟斤拷
	 * @throws IOException 
	 * */
	private void fillValue(String str, BufferedWriter bw) throws IOException 
	{
		String tem;
		Scanner sc=new Scanner(str);
		
		while(sc.hasNext()) 
		{
			tem=sc.next();
			if(tem.matches("key([0-9]{1,2})"))	
			{
				tem=tem.substring(3);
				int idx=toInt(tem);
				if(idx<13) bw.write(Integer.toString(scores[idx]*20+5));
			}
			else bw.write(tem);
		}
		sc.close();
	} 
	
	
	/**
	 * 锟斤拷锟斤拷锟斤拷写锟斤拷锟侥憋拷
	 * @throws FileNotFoundException 
	 * */
	private void writeReportText(String part,BufferedWriter bw) throws IOException 
	{
		part=part.trim();
		File content=new File("E:\\workspace\\HRhealthcheck\\src\\main\\java\\pdf\\pdfExport\\report\\"+part+"\\"+calScoreInterval(part) );
		FileReader fr=new FileReader(content);
		BufferedReader br=new BufferedReader(fr);
		String context;
		while((context=br.readLine())!=null) 
		{
			bw.write(context);
			bw.newLine();
		}
		fr.close();
	}
	
	/**
	 * 锟皆讹拷锟斤拷锟斤拷锟斤拷锟斤拷锟�
	 * */
	private String calScoreInterval(String part) 
	{
		int idx=toInt(part.substring(4));
		if(scores[idx]==3)return "good.txt";
		else if(scores[idx]==2) return "soso.txt";
		else return "bad.txt";
	}
	
	/**
	 * 锟斤拷锟街凤拷锟斤拷锟斤拷锟絠nteger锟斤拷没什么锟斤拷锟斤拷锟斤拷
	 * */
	private int toInt(String numstr)
	{
		int ans=0;
		char [] numc=numstr.toCharArray();
		for(int i=0;i<numstr.length();i++) 
		{
			int temp=numc[i]-'0';
			ans*=10;
			ans+=temp;
		}
		return ans;
	}
	
	private void fillScores(int[] values) throws SizeUnmatchExeception 
	{
		if(values.length!=13) throw new SizeUnmatchExeception();
		for(int i=0;i<13;i++) 
		{
			if(values[i]>=totalValue[i]/3*2) scores[i]=3;
			else if(values[i]>=totalValue[i]/3) scores[i]=2;
			else scores[i]=1;
		}
	}
	
}

