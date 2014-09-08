package Problem_9;

//Write a program to generate a PDF document called Deck-of-Cards.pdf and print in it a standard deck of 52 
//cards, following one after another. Each card should be a rectangle holding its face and suit. A few examples are 
//shown below:
import java.io.FileOutputStream;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;


public class Generate_a_PDF_PDF_FILE {
public static void main(String[] args) {
  try {
	String FILE="52DeckCard.pdf";
    BaseFont base = BaseFont.createFont("Font/FreeSerif.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    Font font = new Font(base, 35f, Font.BOLD);
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(FILE));
    document.open();
    
    PdfPTable tables = new PdfPTable(4);
    tables.getDefaultCell().setBorder(0);
    String[] suits= new String[]{"\u2663","\u2666", "\u2764","\u2660",};
    String[] cards=new String[]{"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    
   
	
     	for(int c=0; c<cards.length;c++){
	      
	    	  for(int s=0;s<suits.length;s++) {
	    		  if(s==1 || s==2) {
	    			  font = new Font(base, 40f, Font.NORMAL, BaseColor.RED);
	    		  }
	    		  else {
	    			  font = new Font(base, 40f, Font.NORMAL, BaseColor.BLACK);
	    		  }
	    		  String suit=suits[s];
	    		  String card=cards[c];
	    		 
	    		  PdfPTable table = new PdfPTable(1);
	    	  PdfPCell cell = new PdfPCell(new Phrase(card+suit, font));
	    	  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setFixedHeight(150f);
				cell.setBorderColor(BaseColor.BLACK);
				
	    	  table.addCell(cell);
	    	  tables.addCell(table);
	    	  
				
	    	  document.add(cell);	    	  
	    	  
	    	  }
	    	  
	      
     	}
     	System.out.println("ok");
     	document.add(tables);
    document.close();
  } catch (Exception e) {
    e.printStackTrace();
  }
}

} 
