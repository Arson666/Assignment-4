//Class: CMSC203 CRN 24307 
//Program: Assignment #4
//Instructor: Ping-Wei Tsai 
//Summary of Description: this program displays property information
//Due Date: 10/24/2021 
//Integrity Pledge: I pledge that I have completed the programming assignment independently. 
//I have not copied the code from a student or any source. 
//Student’s Name: Anna Downey 

public class Property 
{
	String city; 
	String owner;
	String name;
	double rentAmount; 
	Plot plot;
	
	Property()
	{
		city = ""; 
		owner = "";
		name = "";
		rentAmount = 0; 
		plot = new Plot(0, 0, 1, 1);
	}

	public Property(Property p)
	{
        this.name = p.getName();
        this.city = p.getCity();
        this.owner = p.getOwner();
        this.rentAmount = p.getRentAmount();
        this.plot = p.getPlot();
	}

	public Property(String name, String city, double rentAmount, String owner)
	{
		 this.name = name;
	     this.city = city;
	     this.rentAmount = rentAmount;
	     this.owner = owner;
	}

	public Property(String name, String city, double rentAmount, String owner, int x, int y, int width, int depth) 
	{
		this.name = name;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
	}

	public String getCity()
	{
		return city;
	}

	public String getOwner() 
	{
		return owner;
	}

	public String getName()  
	{
		return name;
	}
	
	Plot getPlot() 
	{ 
		return plot;
	}

	public double getRentAmount()  
	{
		return rentAmount;
	}

	public void setPlot(int x, int y, int width, int depth) 
	{
		this.plot = new Plot(x, y, width, depth);
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public void setOwner(String owner) 
	{
		this.owner = owner;
	}

	public void setName(String name)  
	{
		this.name = name;
	}

	public void setRentAmount(double rentAmount) 
	{
		this.rentAmount = rentAmount;
	}
	
	public String toString() 
	{
		return "Property Name: " + name + "\n" + "Located in: " + city + "\n" + "Belonging to: " + owner
				+ "\n" + "Rent Amount: " + rentAmount + " ";
	}
}
