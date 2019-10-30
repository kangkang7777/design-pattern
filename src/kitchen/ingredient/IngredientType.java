package kitchen.ingredient;

/**
 * 
 */
public enum IngredientType 
{
    FISH("鱼"), EGG("鸡蛋"),FLOUR("面粉"),TOFU("豆腐"),VEGETABLES("蔬菜");

    String name;

    IngredientType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}