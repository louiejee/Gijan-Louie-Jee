import java.util.Scanner;

class JosephusChicken{
  
 final static double adultMealPrice = 100.00;
 final static double kiddieMealPrice = 250.00;
 final static double pesoToDollar = 56.00;

 public static void main(String[] args) {
   System.out.println("Josephus Chicken");
    Scanner sc = new Scanner(System.in);
    
    /*Josephus Chicken
       AdultMeal = PHP 100.00
       KiddieMeal = PHP 250.00
    */
    
    System.out.println("Number of Adult Meals: ");
    int numberOfAdultMeal = sc.nextInt();
    
    System.out.println("Number of Kiddie Meals: ");
    int numberOfKiddieMeal = sc.nextInt();
    
    System.out.println("Number of Adult Meal: "+numberOfAdultMeal);
    System.out.println("Number of Kiddie Meal: "+numberOfKiddieMeal+"\n");
    
    double adultMealTotalPrice = numberOfAdultMeal * adultMealPrice;
    double kiddieMealTotalPrice = numberOfKiddieMeal * kiddieMealPrice;
    
    System.out.println("Total Adult Meal Price: "+adultMealTotalPrice);
    System.out.println("Total Adult Meal Price: "+kiddieMealTotalPrice);
    
    double adultMealPriceToDollar = adultMealTotalPrice / pesoToDollar;
    double kiddiePriceToDollar = kiddieMealTotalPrice / pesoToDollar;
    
    System.out.println("Total Adult Meal Price in Dollar: "+adultMealPriceToDollar);
    System.out.println("Total Kiddie Meal Price in Dollar: "+kiddiePriceToDollar);    
    

    }
 
}
