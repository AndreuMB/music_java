package Modules.Instruments.Classes;

import Classes.Dates;
import Classes.Instruments;
import Utils.FunctionsDate;

public class Keyboards extends Instruments {
	boolean wheels;

	public Keyboards(String id, String type, String maker, float price, Dates date1, Dates date2, boolean wheels,
			int this1) {
		super(id, type, maker, price, date1, date2, this1);

		this.wheels = wheels;
	}

	public boolean isWheels() {
		return wheels;
	}

	public void setWheels(boolean wheels) {
		this.wheels = wheels;
	}

	@Override
	public String toString() {
//		return "Keyboards [id= " + getId() + ", type=" + getType() + ", price=" + getPrice() + ", maker=" + getMaker()
//				+ ", wheels= " + wheels + ", dateini=" + FunctionsDate.Dateini() + ", datefin="
//				+ FunctionsDate.Datefin(getType1()) + ", days=" + getDays() + "]";
		return "Instruments [id=" + getId() + "\n type=" + getType() + "\n price=" + getPrice() + "\n maker="
				+ getMaker() + "\n wheels= " + wheels + "\n Date when made the order=" + FunctionsDate.Dateini()
				+ "\n Warranty finish=" + FunctionsDate.Datexpire(getDate2()) + "\n Days until arrive=" + getDays()
				+ "]";
	}

}
