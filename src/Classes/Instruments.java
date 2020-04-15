package Classes;

import Utils.FunctionsDate;

public abstract class Instruments implements Comparable<Instruments> {

	private String id;
	private String type;
	private float price;
	private String maker;
	private Dates date1;
	private Dates date2;
//	private String dateini;
//	private String datefin;
	private int days;
	private int type1;

	public Instruments(String id, String type, String maker, float price, Dates date1, Dates date2, int type1) {
		super();
		this.id = id;
		this.type = type;
		this.price = price;
		this.maker = maker;
		this.date1 = date1;
		this.date2 = date2;
		this.type1 = type1;
		this.days1();
//		this.days = days;
//		this.dateini = dateini;
//		this.datefin = datefin;

	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public Dates getDate1() {
		return date1;
	}

	public void setDate1(Dates date1) {
		this.date1 = date1;
	}

	public Dates getDate2() {
		return date2;
	}

	public void setDate2(Dates date2) {
		this.date2 = date2;
		this.days1();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDays() {
		return this.days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getType1() {
		return type1;
	}

	public void setType1(int type1) {
		this.type1 = type1;
	}

	public void days1() {
//		this.days = Dates.restdates(date1);
		this.days = FunctionsDate.dataArrival(type1).RestDates();
//		this.days = 10;
		System.out.println(days + "type= " + type1);

//		return this.days;
	}

	public int compareTo(Instruments param) {// para ordenar los empleados por nombre
		if (this.getId().compareTo(param.getId()) > 0)
			return 1;
		if (this.getId().compareTo(param.getId()) < 0)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return "Instruments [id=" + id + "\n type=" + type + "\n price=" + price + "\n maker=" + maker
				+ "\n Date when made the order=" +
//				FunctionsDate.Dateini()
				date1 + "\n Warranty finish=" +
//				FunctionsDate.Datefin(type1)
				date2 + "\n Days until arrive=" + this.days + "]";
	}

}
