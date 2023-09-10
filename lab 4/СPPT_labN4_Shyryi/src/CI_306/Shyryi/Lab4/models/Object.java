package CI_306.Shyryi.Lab4.models;

import CI_306.Shyryi.Lab4.FileUtil;

public abstract class Object {
    private String material;
    protected Integer durability;
    private Integer maxDurability;
    protected Integer quality;

    public Object() {
        System.out.print("\nПустий об'єкт був створений");
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    public Object(String material, Integer durability, Integer quality, Integer maxDurability) {
        this.material = material;
        this.durability = durability;
        this.quality = quality;
        this.maxDurability = maxDurability;
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    public Object(Object other) {
        this.material = other.material;
        this.durability = other.durability;
        this.quality = other.quality;
        this.maxDurability = other.maxDurability;
        
        FileUtil.appendToFile("Логи.txt", "Був створений " + this.toString());
    }

    {
        this.material = "Невідомо";
        this.durability = 1000;
        this.quality = 30;
    }
    
    /**
     * Repairs the object's durability if it is below the desired level.
     *
     * @return True if the object was repaired; otherwise, false
     */
    public Boolean Repair() {
        if (((this.maxDurability * this.quality) / 100) > this.durability) {
            this.durability = (this.maxDurability * 100) / this.quality;
            return true;
        }
        return false;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getDurability() {
        return durability;
    }

    public void setDurability(Integer durability) {
        this.durability = durability;
    }
    
    public Integer getMaxDurability() {
        return maxDurability;
    }

    public void setMaxDurability(Integer maxDurability) {
        this.maxDurability = maxDurability;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }


    public String toHtml() {
        return "Об'єкт{" +
                "матеріал='" + material + '\'' +
                ", справність='" + durability + '\'' +
                ", якість=" + quality +
                '}';
    }
    
    @Override
    public String toString() {
        return "Об'єкт{" +
                "матеріал='" + material + '\'' +
                ", справність=" + durability +
                ", maxCправність=" + maxDurability +
                ", якість=" + quality +
                '}';
    }
}
