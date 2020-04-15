package Classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Dates {
	private String date;
	private int day;
	private int month;
	private int year;
	private String dateini;
	private int restmonth;
	private int dayini;
	private int dayfin;
	private int monthini;
	private int monthfin;
	private String dateU;
	private int dayU;
	private int monthU;
	private int yearU;
	public String datexpire;
//
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public void setDate(String date) {
		this.date = date;
	}

//	public String getdate() {
//		return date;
//	}

	public int getDay() {
		return day;
	}

	public String getDateU() {
		return dateU;
	}

	public void setDateU(String dateU) {
		this.dateU = dateU;
	}

	public int getDayU() {
		return dayU;
	}

	public void setDayU(int dayU) {
		this.dayU = dayU;
	}

	public int getMonthU() {
		return monthU;
	}

	public void setMonthU(int monthU) {
		this.monthU = monthU;
	}

	public int getYearU() {
		return yearU;
	}

	public void setYearU(int yearU) {
		this.yearU = yearU;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDatexpire() {
		return datexpire;
	}

	public void setDatexpire(String datexpire) {
		this.datexpire = datexpire;
	}

	public String CalendartoString() {
		Calendar cal = Calendar.getInstance();
		return (cal.getTime().toString());
	}

	public String dateUser(String putDate) {

		String[] SplitArray = null;

		SplitArray = putDate.split("/");

		this.dayU = Integer.parseInt(SplitArray[0]);
		this.monthU = (Integer.parseInt(SplitArray[1]) - 1);
		this.yearU = Integer.parseInt(SplitArray[2]);
//		this.dateU = putDate;
		this.dateU = this.dayU + "/" + this.monthU + "/" + this.yearU;
		System.out.println(this.dayU + "\n" + this.monthU + "\n" + this.yearU + "\n" + this.dateU);
		return dateU;

	}

	public Calendar StringToCalendar(String date1) {
		Calendar dateCalendar = new GregorianCalendar();
		Date dateDate = null;
		try {
			dateDate = formato.parse(date1);
			dateCalendar.setTime(dateDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Calendar dateini = dateCalendar;
		return dateini;

	}

	public String dateSys() {
		Calendar date = Calendar.getInstance();
		System.out.println(date);
//		String datef = Calendar.MONTH + Calendar.DAY_OF_MONTH + Calendar.YEAR;
		String day = Integer.toString(date.get(Calendar.DATE));
		String month = Integer.toString(date.get(Calendar.MONTH) + 1);
		String year = Integer.toString(date.get(Calendar.YEAR));
		String datet = day + "/" + month + "/" + year;
		System.out.println(datet + "what month output?");
		this.date = datet;
		return datet;
	}

//	public int dateSysint() {
//		Calendar date = Calendar.getInstance();
//		System.out.println(date);
////		String datef = Calendar.MONTH + Calendar.DAY_OF_MONTH + Calendar.YEAR;
//		String day = Integer.toString(date.get(Calendar.DATE));
//		String month = Integer.toString(date.get(Calendar.MONTH));
//		String year = Integer.toString(date.get(Calendar.YEAR));
//		String datet = day + "/" + month + "/" + year;
//		System.out.println(datet);
//		this.date = datet;
//		return day;
//	}

	public int RestYears() {
		int rest, year, year2;
		Calendar cal1 = new GregorianCalendar();

		cal1 = (StringToCalendar(dateSys()));

		year = cal1.get(Calendar.YEAR);
		System.out.println(year + "what is is 2000");
		year2 = this.year;

		rest = year - year2;

		return rest;
	}

//	public int RestYearsU() {
//		year = cal1.get(Calendar.YEAR);
//	}

	public int RestMonths() {
		int rest, month, month2;
		Calendar cal1 = new GregorianCalendar();
		Calendar date2 = Calendar.getInstance();
		cal1 = (StringToCalendar(date));
		System.out.println("date= " + date);
		System.out.println("cal1= " + date);
		month = cal1.get((Calendar.MONTH));
		System.out.println("month= " + month);
		month2 = date2.get((Calendar.MONTH));
		month2 = month2 + 1;
		System.out.println(month2 + "-" + month);
		rest = month2 - month;
		System.out.println(rest);
		this.monthini = month;
		this.monthfin = month2;
		this.restmonth = rest;
		return rest;
	}

	public boolean compDates(String Date2) {
		Calendar cal1 = new GregorianCalendar();
		cal1 = (StringToCalendar(dateSys()));
		System.out.println(dateSys() + " datesys in comp");
//		Calendar cal1 = this.deStringToCalendar(date);
		Calendar cal2 = StringToCalendar(Date2);
		System.out.println("cal 1 " + cal1);
		System.out.println("cal 2 " + cal2);

		if (cal1.before(cal2)) {
			System.out.println("here return true");
			return true;
		} else
			System.out.println("here return false");
		return false;
	}

	public String arrivedate(int type1) {

		int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Calendar date = Calendar.getInstance();
		int day = date.get(Calendar.DATE);
		int month = date.get(Calendar.MONTH);
		int year = date.get(Calendar.YEAR);
		switch (type1) {
		case 0:
			day = (int) (day + 30 + (Math.random() * 20));
			System.out.println(day + " " + type1 + " days");
			break;
		case 1:
			day = (int) (day + 3 + (Math.random() * 3));
			System.out.println(day + " " + type1 + " days");
			break;
		case 2:
			day = (int) (day + 15 + (Math.random() * 10));
			System.out.println(day + " days \n" + type1 + " type");
			break;
		}
		if (month == 12) {
			if (day > months[12]) {
				year = year + 1;
			}

		}
		if (day > months[month]) {
			while (day > months[month]) {
				if (month == 2) {
					months[2] = 28;
					System.out.println("feb");
					if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) {
						months[2] = 29;
					}
				}
				day = day - months[month];
				month = month + 1;
				System.out.println(day);
				if (month > 11) {
					year = year + 1;
					month = 1;

					System.out.println(month);
				}
			}
		}
//		if (month == 2) {
//			int feb = 28;
//			System.out.println("feb");
//			if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) {
//				feb = 29;
//			}
//			if ((day < 1) || (day > feb)) {
//			}
//		} else if ((day < 1) || (day > months[month])) {
//		}
		this.year = year;
		this.month = month;
		this.day = day;
		String date1 = day + "/" + month + "/" + year;
		System.out.println(date1 + " date1 arrive date");
		System.out.println(date1 + " days \n" + type1 + " type");
		this.dateini = date1;
		return date1;
	}

	public int comparedate(Dates date) {
		System.out.println(date.datexpire + " IS THIS");
		String dateS = date.datexpire.toString();
		System.out.println(this.datexpire + "this date");
		System.out.println(dateS + "datestring");
		Calendar date1 = new GregorianCalendar();
		Calendar date2 = Calendar.getInstance();
		date1 = (StringToCalendar(dateS));
		date2 = (StringToCalendar(this.datexpire));

//		date1 = this.StringtoCalendar();

//		date1 = date1.get(Calendar.);
//		date2 = date2.get(Calendar.DATE);
		int i = 0;
		if (date1.before(date2)) { // when date1 is after to date2
			i = 1;
		} else if (date1.after(date2)) { // when date1 is before to date2
			i = -1;
		} else if (date1.compareTo(date2) == 0) { // When date1 and date2 are equals
			i = 0;
		}

		return i;
	}

	public int RestDays() {
		int rest, day, day2;
		Calendar cal1 = new GregorianCalendar();
		Calendar date2 = Calendar.getInstance();
		cal1 = (StringToCalendar(date));
		System.out.println(date);
		day = cal1.get(Calendar.DATE);
		day2 = date2.get(Calendar.DATE);
		System.out.println(day + "-" + day2);
		rest = day - day2;
		System.out.println(rest);
		this.dayini = day2;
		this.dayfin = day;
		return rest;
	}

	public int RestDates() {
		int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		this.RestDays();
		this.RestMonths();
		int result = 0;
		int month = months[this.monthini];
		int daysf = month - this.dayini; // days to finish the month
		result = daysf + this.dayfin;
		System.out.println("dayfin = " + this.dayfin + " daysf = " + daysf);
		System.out.println(result + "wooork???");
		return result;
	}

	public int restdates(Dates date1) {

		int yearsys;
		int year2;
		Calendar date = Calendar.getInstance();

		yearsys = date.get(Calendar.YEAR);

//		year2 = date2.deStringToInt(date2.toString());
		year2 = 2;

		return (yearsys - year2);

	}

	public Dates(String date1) {
		String[] SplitArray = null;
		String fechaform = null;
		this.datexpire = date1;
		/* if(Ppal.conf.getNumdecimal()=="1"){ */
		SplitArray = date1.split("/");

		this.day = Integer.parseInt(SplitArray[0]);
		this.month = Integer.parseInt(SplitArray[1]);
		this.year = Integer.parseInt(SplitArray[2]);

		fechaform = day + "/" + month + "/" + year;
		System.out.println(fechaform);
		this.date = fechaform;
		System.out.println(this.date + " saved in date");
	}

	public void expire() {
		System.out.println(this.date + "this.date");
		datexpire = this.date;
		System.out.println(datexpire + "datexpire inside class");
	}

	public boolean v_date() {

		int[] months = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((this.month < 0) || (this.month > 11)) {
			return false;
		}
		if (month == 2) {
			months[2] = 28;
			System.out.println("feb");
			if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0)) {
				months[2] = 29;
			}
			if ((day < 1) || (day > month)) {
				return false;
			}
		} else if ((day < 1) || (day > months[month])) {
			return false;
		}
		System.out.println("true");
		return true;

	}

//	public String calen2String(Calendar date) {
//		System.out.println("comehere");
//		int day, month, year;
//		String sdate = null, sdate2 = "XX/XX/XX";
//
//		try {
//			day = date.get(Calendar.DATE);
//			month = ((date.get(Calendar.MONTH)) + 1);
//			year = date.get(Calendar.YEAR);
//			sdate = day + "/" + month + "/" + year;
//		} catch (Exception e) {
//			System.out.println(sdate2);
//			return sdate2;
//		}
//		System.out.println(sdate);
//		return sdate;
//
//	}
}
