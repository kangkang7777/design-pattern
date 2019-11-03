package kitchen.ingredient;

public class FancyCut implements CutInterface  {

    private Ingredient ingredient;
    public FancyCut(Ingredient obj)
    {
        ingredient = obj;
    }
    @Override
    public void displayCut() {
        if(ingredient.getIngredientType() == IngredientType.EGG)
        {
            System.out.println("厨师使用神来一击，对"+ingredient.getName()+"完成了打碎以及搅拌。");
        }
        else if(ingredient.getIngredientType() == IngredientType.FLOUR)
        {
            System.out.println("厨师使用推拿掌法，将"+ingredient.getName()+"和成活面。");
        }
        else
        {
            System.out.println("厨师使用刀法飞龙在天，对"+ingredient.getName()+"完成了切片。");
        }
    }

    @Override
    public boolean isCut() {
        return true;
    }
}
