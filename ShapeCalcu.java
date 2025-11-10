import java.lang.Math;
import java.util.Scanner;

abstract class Shape{ // Shape class as parent class and abstract base class for Shape (ABSTRACTION + INHERITANCE).
    private String name; // encapsulated variable (ENCAPSULATION)
	
	// Variables that can be used directly in this class and its child classes.
	double area;
	double perimeter;

	 // Shape paremeterized constructor (parent class constructor)
	Shape(String name, double area, double perimeter){
        this.name = name;
		this.area = area;
		this.perimeter = perimeter;
    }
	
	 // Getter method to access encapsulated variable (ENCAPSULATION).
    public String getName(){
        return name;
    }
	
    public abstract void calculate(); // Abstract method for calculate to be implemented in subclasses (ABSTRACTION).

    // display() method uses class variables. No parameters inside to encapsulate the data and reduce the need to pass it explicitly each time.
	void display(){ 
        System.out.println("The area and perimeter of the "+this.name+" are:");
        System.out.println("AREA: "+area);
        System.out.println("PERIMETER: "+perimeter);
		
		System.out.println();
    }
}

class Rectangle extends Shape{ // Rectangle class that inherits from Shape class (INHERITANCE).
	double length; 
	double width;
	
	// Rectangle paremeterized constructor
	Rectangle(double length, double width){
		
		// call the parent class constructor to initialize the shape's name and sets initial values of area and perimeter.
		super("Rectangle", 0, 0);
		
		this.length = length; 	
		this.width = width;
    }

    @Override // Indicates that this method overrides an abstract method declared in the parent class Shape (ABSTRACTION).
    public void calculate(){ // calculate() method that calculates the area and perimeter of rectangle.
        area = length*width;
        perimeter = 2*(length+width);
		
        display(); // call the display() method
    }
}

class Square extends Shape{
	double side;
	
	Square(double side){ 
        super("Square", 0, 0);
		
		this.side = side;
    }

    @Override
    public void calculate(){ 
		area = side*side;
        perimeter = 4*side;
		
        display();
    }
}

class Parallelogram extends Shape{
    double base;
	double height;
	double side2;

    Parallelogram(double base, double height, double side2){ 
        super("Parallelogram", 0, 0);
		
		this.base = base;
		this.height = height;
		this.side2 = side2;
    }

    @Override 
    public void calculate(){ 
        area = base*height;
        perimeter = 2*(base+side2); 
		
        display();
    }
}

class Rhombus extends Shape{
	double diagonal1;
	double diagonal2;
	
	Rhombus(double diagonal1, double diagonal2){ 
		super("Rhombus", 0, 0); 
		
		this.diagonal1 = diagonal1;
		this.diagonal2 = diagonal2;
	}
	
    @Override
    public void calculate(){ 
		area = 0.5*diagonal1*diagonal2;
		perimeter = 2*Math.sqrt((diagonal1 * diagonal1) + (diagonal2 * diagonal2));
	  
		display();
    }
}

class Trapezium extends Shape{
	double height2;
	double parallel1;
	double parallel2;
	double nonparallel1;
	double nonparallel2;
	
	Trapezium(double height2, double parallel1, double parallel2, double nonparallel1, double nonparallel2){
		super("Trapezium", 0, 0);
		
		this.height2 = height2;
		this.parallel1 = parallel1;
		this.parallel2 = parallel2;
		this.nonparallel1 = nonparallel1;
		this.nonparallel2 = nonparallel2;
	}
	
    @Override 
    public void calculate(){
		area = 0.5*(parallel1+parallel2)*height2;
		perimeter = parallel1+parallel2+nonparallel1+nonparallel2;
		
		display();
    }
}

class Triangle extends Shape{
	double height3;
	double base2;
	double side3;
	
	Triangle(double height3, double base2, double side3){
		super("Triangle", 0, 0);
		
		this.height3 = height3;
		this.base2 = base2;
		this.side3 = side3;
	}
	
    @Override
    public void calculate(){
	  area = 0.5*base2*height3;
	  perimeter = height3+base2+side3;
	  
	  display();
    }
}

class IsoscelesTriangle extends Shape{
	double height4;
	double base3;
	double side4;
	
	IsoscelesTriangle(double height4, double base3, double side4){
		super("Isosceles Triangle", 0, 0);
		
		this.height4 = height4;
		this.base3 = base3;
		this.side4 = side4;
	}
	
    @Override 
    public void calculate(){
		area = 0.5*base3*height4;
		perimeter = (2*side4)+base3;
		
		display();
    }
}

class EquilateralTriangle extends Shape{
	double side5;
	
	EquilateralTriangle(double side5){
		super("Equilateral Triangle", 0, 0);
		
		this.side5 = side5;
	}
	
    @Override
    public void calculate(){
		area = (Math.sqrt(3)/4)*(side5*side5);
		perimeter = 3*side5;
		
		display();
    }
}

class Circle extends Shape{ // Circle class that inherits from Shape class (INHERITANCE).
	double radius;
	
	// Circle parameterized constructor
	Circle(double radius){ 
	
		// call the parent class constructor to initialize the shape's name and sets initial values of area and perimeter.
		super("Circle", 0, 0);
		
		this.radius = radius;
	}
	
    @Override // Indicates that this method overrides an abstract method declared in the parent class Shape (ABSTRACTION).
	public void calculate(){ // calculate() method that calculates the area and perimeter of circle.
		area = Math.PI*(radius*radius);
		perimeter = 2*Math.PI*radius;
		
		display(); // call the overridden display() for circle
    }
  	 
    @Override // Overriding display() in parent class for Circle to show "Circumference" instead of perimeter (POLYMORPHISM).
    void display() {
        System.out.println("\nThe area and circumference of the " + getName() + " are:");
        System.out.println("AREA: " + area);
        System.out.println("CIRCUMFERENCE: " + perimeter);

        System.out.println();
    }
}

public class ShapeCalcu{ // ShapeCalcu class as Main class

	// Handles invalid input by catching 'NumberFormatException' when the user enters non-numeric input (Error handling).
	
	// Validates non-numeric inputs for Shape Selection and "Would you like to calculate another shape?".
    static int validIntInput(Scanner scanner, String prompt) { // method to validate integer inputs
        while (true) { // keep asking until a valid input is entered
            
			 // TRY to read and convert input to a number (int)
			try {
                System.out.print(prompt); // display the prompt
                return Integer.parseInt(scanner.nextLine()); // parse and return the String input to integer 
            
			 // CATCHES non-numeric input and prompts the user to try again
			} catch (NumberFormatException e) {
                System.out.println("\nInvalid input! Please enter a valid choice based on the instruction.\n");
            }
        }
    }

	// Validates non-numeric inputs for non-numeric inputs in Shape's unique attributes (Base, Length, etc.)
	static double validInput(Scanner scanner, String prompt){ // method to validate double inputs
		while(true){  // keep asking until a valid input is entered
			
			// TRY to read and convert input to a number (double)
			try{ 
				System.out.print(prompt); // display the prompt from switch cases ("Enter base: ", "Enter length: ", etc.)
				return Double.parseDouble(scanner.nextLine()); // parse and return the String input to double 
			
			// CATCHES non-numeric input and prompts the user to try again
			}catch(NumberFormatException e){ 
				System.out.println("\nInvalid input! Please enter a valid number.\n");
			}
		}
	}

    public static void main(String[] args){ // main method
        Scanner scanner = new Scanner(System.in); // Scanner object
		
		int choiceToCalculate; // Variable used to determine whether the user wants to perform another calculation or exit the program.

        System.out.println("\n\t\t\tSHAPE CALCULATOR"); 
        System.out.println("\t\t──────────────────────────────");
        System.out.println("Description: This calculator calculates the area and perimeter of shapes.\n");

		do{
			System.out.println("\nSelect a shape:");
			System.out.println("1. Rectangle");
			System.out.println("2. Square");
			System.out.println("3. Parallelogram");
			System.out.println("4. Rhombus");
			System.out.println("5. Trapezium");
			System.out.println("6. Triangle");
			System.out.println("7. Isosceles Triangle");
			System.out.println("8. Equilateral Triangle");
			System.out.println("9. Circle");
            		
			int choice;
			do { // Loop validating if input is a number between 1-9. If not, user will be asked to select a number in the range.
    			choice = validIntInput(scanner, "Enter your shape (1-9): ");
    			if (choice < 1 || choice > 9) {
        			System.out.println("\nInvalid choice! Please select a number between 1 and 9.\n");
    			}
			} while (choice < 1 || choice > 9);

			System.out.println();

			// This will execute the area and perimeter based on user's choice of shape.
			switch(choice){
				case 1: 
					// call the validInput() method with the prompt and stores the result in the 'length' and 'width' variables
					double length = validInput(scanner, "Enter length: "); 
					double width = validInput(scanner, "Enter width: "); 
				
					System.out.println();
					
					Rectangle rectangle = new Rectangle(length, width); // Rectangle object
					rectangle.calculate(); // call the calculate() method within the Rectangle class
					break;
				
				case 2:
					double side = validInput(scanner, "Enter a side: ");
				
					System.out.println();
				
					Square square = new Square(side); 
					square.calculate();
					break;
			
				case 3:
					double base = validInput(scanner, "Enter base: ");
					double height  = validInput(scanner, "Enter height: ");
					double side2 = validInput(scanner, "Enter a side: ");
				
					System.out.println();
				
					Parallelogram parallelogram = new Parallelogram(base, height, side2); 
					parallelogram.calculate(); 
					break;
			
				case 4:
					double diagonal1 = validInput(scanner, "Enter first diagonal side: ");
					double diagonal2 = validInput(scanner, "Enter second diagonal side: ");
				 
					System.out.println();
				 	
					Rhombus rhombus = new Rhombus(diagonal1, diagonal2);
					rhombus.calculate();
					break;
			
				case 5:
					double height2 = validInput(scanner, "Enter height: ");
					double parallel1 = validInput(scanner, "Enter first parallel side: ");
					double parallel2 = validInput(scanner, "Enter second parallel side: ");
					double nonparallel1 = validInput(scanner, "Enter first nonparallel side: ");
					double nonparallel2 = validInput(scanner, "Enter second nonparallel side: ");
					
					System.out.println();
				 	
					Trapezium trapezium = new Trapezium(height2, parallel1, parallel2, nonparallel1, nonparallel2);
					trapezium.calculate(); 
					break;
				  	   
				case 6:
					double base2 = validInput(scanner, "Enter base: ");
					double height3 = validInput(scanner, "Enter height: ");
					double side3 = validInput(scanner, "Enter a side: ");
				
					System.out.println();
				
					Triangle triangle = new Triangle(base2, height3, side3);
					triangle.calculate();
					break;
					  
				case 7:
					double base3 = validInput(scanner, "Enter base: ");
					double height4 = validInput(scanner, "Enter height: ");
					double side4 = validInput(scanner, "Enter a side: ");
				
					System.out.println();
				
					IsoscelesTriangle isoscelesTriangle = new IsoscelesTriangle(base3, height4, side4);
					isoscelesTriangle.calculate();
					break;
					  
				case 8:
					double side5 = validInput(scanner, "Enter a side: ");
				
					System.out.println();
				
					EquilateralTriangle equilateralTriangle = new EquilateralTriangle(side5);
					equilateralTriangle.calculate();	 
					break; 
					  
				case 9:
					double radius = validInput(scanner, "Enter radius: ");
				
					System.out.println();
				
					Circle circle = new Circle(radius);
					circle.calculate(); 	 
					break; 
					  
				default:
					System.out.println("Invalid choice. Please select ONLY from 1 to 9.");
					System.out.println();
					break;
			}

			// uses the validIntInput() method for the continuation prompt
            choiceToCalculate = validIntInput(scanner, "Would you like to calculate another shape?\n- Enter 1 if YES -\n- Enter any other number to EXIT -\nYour choice: ");
        	
			}while(choiceToCalculate == 1);

        	System.out.println("\nThank you for using the Shape Calculator! ‪<3");
        	scanner.close(); // close scanner because it's a good practice
    }
}