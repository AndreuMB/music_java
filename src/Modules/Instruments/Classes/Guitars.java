package Modules.Instruments.Classes;

import Classes.Dates;
import Classes.Instruments;
import Utils.FunctionsDate;

public class Guitars extends Instruments {
	private String material;

	public Guitars(String id, String type, String maker, float price, Dates date1, Dates date2, String material,
			int this1) {
		super(id, type, maker, price, date1, date2, this1);
		this.material = material;

	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
//		return "Guitar [id=" + getId() + ", type=" + getType() + ", price=" + getPrice() + ", maker=" + getMaker()
//				+ ", material= " + material + ", dateini=" + FunctionsDate.Dateini() + ", datefin="
//				+ FunctionsDate.Datefin(getType1()) + ", days=" + getDays() + "]";
		return "Instruments [id=" + getId() + "\n type=" + getType() + "\n price=" + getPrice() + "\n maker="
				+ getMaker() + "\n material= " + material + "\n Date when made the order=" + FunctionsDate.Dateini()
				+ "\n Warranty finish=" + FunctionsDate.Datexpire(getDate2()) + "\n Days until arrive=" + getDays()
				+ "]";
	}

}
