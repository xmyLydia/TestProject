package Payment;
import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
public class suppXlsbean{
		private int topleft_row ;  
		private int topleft_column;  
		private int bottomright_row = 0;  
		private int bottomright_column = 0;   
		private int rowspan = 1;  
		private int colspan = 1;  
		private Range[] ranges = null;  
		private int min_row ;  
		private int max_row ;  
		private int min_column;  
		private int max_column;  
		 
		public void ReadRange(Sheet sheet,int row,int column){ 
		ranges = sheet.getMergedCells(); 
		for(Range space:ranges){ 
		this.topleft_row = space.getTopLeft().getRow(); 
		this.topleft_column = space.getTopLeft().getColumn(); 
		if(row != topleft_row || column != topleft_column){ 
		this.setRowspan(1); 
		this.setColspan(1); 
		} 
		if(row == topleft_row && column == topleft_column){ 
		this.setTopleft_row(this.topleft_row); 
		this.setTopleft_column(this.topleft_column); 
		this.setBottomright_row(space.getBottomRight().getRow()); 
		this.setBottomright_column(space.getBottomRight().getColumn()); 
		this.setRowspan(2); 
		this.setColspan(2); 
		break; 
		} 
		
		} 
		} 
		/** 
		* 
		* @return 
		*/ 
		public void setBetweenRowColumn(int row ,int column){ 
		for(Range space:ranges){ 
		//��ȡ�еķ�Χ 
		int min_row = space.getTopLeft().getRow(); // min row 
		int max_row = space.getBottomRight().getRow(); // max row 
		int min_column = space.getTopLeft().getColumn(); // min column 
		int max_column = space.getBottomRight().getColumn(); // max column 
		if(min_row <= row 
		&& row <= max_row){ 
		//��ȡ�еķ�Χ 
		if(min_column <= column 
		&& column <= max_column){ 
		this.setMin_row(min_row); // min row 
		this.setMax_row(max_row); // max row 
		this.setMin_column(min_column); // min column 
		this.setMax_column(max_column); // max column 
		break; 
		} 
		} 
		} 
		} 
		/** 
		* ��ȡ������ɫ��ֵ 
		* @param cell: ��ǰ��Ԫ�� 
		* @return 
		*/ 
		public String getBgcolor(Cell cell){ 
		int r = cell.getCellFormat().getBackgroundColour().getDefaultRed(); 
		int g = cell.getCellFormat().getBackgroundColour().getDefaultGreen(); 
		int b = cell.getCellFormat().getBackgroundColour().getDefaultBlue(); 
		return "#"+Integer.toHexString(r<<16|g<<8|b); 
		} 
		/** 
		* ��ȡ�������ɫ 
		* @param cell: ��ǰ��Ԫ�� 
		* @return 
		*/ 
		public String getFontColor(Cell cell){ 
		int r = cell.getCellFormat().getFont().getColour().getDefaultBlue(); 
		int g = cell.getCellFormat().getFont().getColour().getDefaultGreen(); 
		int b = cell.getCellFormat().getFont().getColour().getDefaultBlue(); 
		return "#"+Integer.toHexString(r<<16|g<<8|b); 
		} 
		public int getTopleft_row() { 
		return topleft_row; 
		} 
		public void setTopleft_row(int topleft_row) { 
		this.topleft_row = topleft_row; 
		} 
		public int getTopleft_column() { 
		return topleft_column; 
		} 
		public void setTopleft_column(int topleft_column) { 
		this.topleft_column = topleft_column; 
		} 
		public int getBottomright_row() { 
		return bottomright_row; 
		} 
		public void setBottomright_row(int bottomright_row) { 
		this.bottomright_row = bottomright_row; 
		} 
		public int getBottomright_column() { 
		return bottomright_column; 
		} 
		public void setBottomright_column(int bottomright_column) { 
		this.bottomright_column = bottomright_column; 
		} 
		public int getRowspan() { 
		return rowspan; 
		} 
		public void setRowspan(int rowspan) { 
		// rowspan :1 ��ʾ��; 2 ��ʾ��; 
		if(rowspan == 1){ 
		this.rowspan = 1; 
		} 
		if(rowspan == 2){ 
		this.rowspan =  this.getBottomright_row() - this.getTopleft_row() +1; 
		} 
		} 
		public int getColspan() { 
		return colspan; 
		} 
		public void setColspan(int colspan) { 
		// colspan :1 ��ʾ��; 2 ��ʾ��; 
		if(colspan == 1){ 
		this.colspan = 1; 
		} 
		if(colspan == 2){ 
		this.colspan =  this.getBottomright_column() - this.getTopleft_column() +1; 
		} 
		} 
		//------------------------��ȡ���ϲ��ĵ�Ԫ��ĵ�����ʾ��Χ���к���----------- 
		public Range[] getRanges() { 
		return ranges; 
		} 
		public void setRanges(Range[] ranges) { 
		this.ranges = ranges; 
		} 
		public int getMin_row() { 
		return min_row; 
		} 
		public void setMin_row(int min_row) { 
		this.min_row = min_row; 
		} 
		public int getMax_row() { 
		return max_row; 
		} 
		public void setMax_row(int max_row) { 
		this.max_row = max_row; 
		} 
		public int getMin_column() { 
		return min_column; 
		} 
		public void setMin_column(int min_column) { 
		this.min_column = min_column; 
		} 
		public int getMax_column() { 
		return max_column; 
		} 
		public void setMax_column(int max_column) { 
		this.max_column = max_column; 
		} 

	
}




