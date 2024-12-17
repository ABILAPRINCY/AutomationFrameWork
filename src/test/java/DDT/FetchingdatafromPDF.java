package DDT;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
public class FetchingdatafromPDF {

	public static void main(String[] args)throws Throwable
	{
		File fis = new File("C:\\Users\\josep\\eclipse-workspace\\AdvancedSelenium\\src\\test\\resources\\DATA\\multipage-pdf.pdf");
		PDDocument doc = PDDocument.load(fis);
		int pages = doc.getNumberOfPages();
		System.out.println(pages);

		PDFTextStripper pdfData = new PDFTextStripper();
		String readData = pdfData.getText(doc);
		System.out.println(readData);

		//	pdfData.setStartPage(3);
		//	String readData = pdfData.getText(doc);
		//	System.out.println(readData);

		//pdfData.setStartPage(3);
		//pdfData.setEndPage(3);
		//String readData = pdfData.getText(doc);
		//System.out.println(readData);
	
	
	}

}
