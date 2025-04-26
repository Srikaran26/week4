import java.util.*;

interface MealPlan{
    String MealType();
    List<String> getMeals();
}

class VegetarianMeal implements MealPlan{
    @Override
    public String MealType(){
        return "Vegetarian Meal";
    }

    public List<String> getMeals(){
        return Arrays.asList("Panner Curry","Vegatable Stir-Fry","lentil Soup");
    }
}

class VeganMeal implements MealPlan{
    @Override
    public String MealType(){
        return "Vegan Meal";
    }
    public List<String> getMeals(){
        return Arrays.asList("Tofu Salad","Chickpea stew","Quinoa Bowl");
    }
}

class Meal<T extends MealPlan>{
    private boolean beforeGym;
    private T mealPlan;

    public Meal(boolean beforeGym, T mealPlan) {
        this.beforeGym = beforeGym;
        this.mealPlan = mealPlan;
    }

    public boolean isBeforeGym() {
        return beforeGym;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public String display(){
        return "Food before Gym: "+beforeGym+"\nMeal Plan: "+mealPlan.MealType()+"\nMeals: "+String.join(", ",mealPlan.getMeals());
    }
}

class MealPlanner{
    public static <T extends MealPlan> Meal<T> generateMealPlan(boolean beforeGym,T mealPlan){
        if(mealPlan.getMeals().isEmpty()){
            throw new IllegalArgumentException("Meal plan has no meals.");
        }
        return new Meal<>(beforeGym,mealPlan);
    }
}
public class MealPlanGenerator {
    public static void main(String[] args) {
        VeganMeal vegan=new VeganMeal();
        VegetarianMeal veg=new VegetarianMeal();

        Meal<VeganMeal> m1=MealPlanner.generateMealPlan(true,vegan);
        Meal<VegetarianMeal> m2=MealPlanner.generateMealPlan(false,veg);

        List<Meal<? extends MealPlan>> plans=Arrays.asList(m1,m2);

        for(Meal<? extends MealPlan> plan: plans){
            System.out.println(plan.display());
        }
    }
}
