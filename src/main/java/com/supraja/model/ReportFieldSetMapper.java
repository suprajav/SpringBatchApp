package main.java.com.supraja.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;


public class ReportFieldSetMapper implements FieldSetMapper<Report> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	
	@Override
	public Report mapFieldSet(FieldSet fieldSet) throws BindException {
		
		Report report = new Report();
		report.setId(fieldSet.readFloat(0));
		report.setSales(fieldSet.readBigDecimal(1));
		report.setQty(fieldSet.readInt(2));
	
		//default format yyyy-MM-dd
		//fieldSet.readDate(4);
		String date = fieldSet.readString(3);
		report.setStaffName(fieldSet.readString(4));
		try {
			report.setDate(dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return report;
	}	
}