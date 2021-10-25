//Class: CMSC203 CRN 24307 
//Program: Assignment #4
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program displays property information
//Due Date: 10/24/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

public class ManagementCompany 
{
	int MAX_PROPERTY = 5; 
	int MGMT_WIDTH = 10;
	int MGMT_DEPTH = 10;
	double mgmFeePer;
	String name;
	String taxID;
	
	Property[] properties;
	Plot plot;
	
	ManagementCompany()
	{
        mgmFeePer = 0;
        name = "";
        taxID = "";
        properties = new Property[MAX_PROPERTY];
        plot = new Plot(0, 0, 1, 1);
    }

	public ManagementCompany(String name, String taxID, double mgmFeePer)
	{
		this.mgmFeePer = mgmFeePer;
		this.name = name;
		this.taxID = taxID;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, 10, 10);
	}

	public ManagementCompany(String name, String taxID, double mgmFeePer, int x, int y, int width, int depth) 
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFeePer;
		this.plot = new Plot(x, y, width, depth);
		this.properties = new Property[MAX_PROPERTY];
	}

	public ManagementCompany(ManagementCompany otherCompany) 
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.plot = otherCompany.plot;
		this.properties = otherCompany.properties;
	}

	public int addProperty(Property property) 
	{
		Property prop = new Property(property);

		int state = 0;

		for (int i = 0; i < MAX_PROPERTY; i++) {

			properties[i] = property;

			if (property.equals(null)) {
				state = -2;
			} else if (properties[0].getPlot().encompasses(properties[i].getPlot())) {
				state = -3;

			} else if (properties[i].getPlot().overlaps(properties[0].getPlot())) {
				state = -4;
			} else if (properties.length == MAX_PROPERTY) {
				state = -1;
			} else if (!prop.equals(null)) {
				properties[i] = prop;
				state = i;
			}
		}
		return state;
	}

	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) 
	{
		Property prop = new Property(name, city, rent, owner, x, y, width, depth);

		int state = 0;

		for (int i = 0; i < properties.length; i++) {
			if (prop.equals(null)) {
				state = -2;
			} else if (properties[0].getPlot().encompasses(properties[i].getPlot())) {
				state = -3;

			} else if (properties[i].getPlot().overlaps(properties[0].getPlot())) {
				state = -4;
			} else if (properties.length == MAX_PROPERTY) {
				state = -1;
			} else if (!properties[i].equals(null)) {
				properties[i] = prop;
				state = i;
			}
		}

		return state;

	}

	public String displayPropertyAtindex(int i)  
	{
		return "Property Name:" + properties[i].getName() + "\nLocated in " + properties[i].getCity() + "\nBelonging to: "
				+ properties[i].getOwner() + "\nRent Amount: " + properties[i].getRentAmount();
	}

	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}

	public double maxRentProp() 
	{
		Property prop = new Property();
		double hRent = 0;

		for (int i = 0; i < properties.length; i++) 
		{
			properties[i] = prop;
			if (properties[0].getRentAmount() < properties[i].getRentAmount()) 
			{
				hRent = properties[i].getRentAmount();
			}
		}
		return hRent;
	}

	public int maxRentPropertyIndex()  
	{
		Property prop = new Property();

		int hIndex = 0;
		for (int i = 0; i < properties.length; i++) {
			properties[i] = prop;
			if (properties[i].getRentAmount() > properties[0].getRentAmount()) {
				hIndex = i;
			}
		}
		return hIndex;
	}

	public String toString()  
	{
		Property prop = new Property();

		String str = "";
		for (int i = 0; i < properties.length; i++) {
			properties[i] = prop;
			str = properties[i].toString();
		}
		return str;
	}

	public double totalRent()
	{
		int tot = 0;

		Property prop = new Property();

		for (int i = 0; i < properties.length; i++) {
			properties[i] = prop;
			tot += properties[i].getRentAmount();
		}
		return tot;
	}
	
}
