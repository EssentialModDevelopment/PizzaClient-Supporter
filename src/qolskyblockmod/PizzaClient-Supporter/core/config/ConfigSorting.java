// 
// Decompiled by Procyon v0.5.36
// 

package qolskyblockmod.pizzaclient.core.config;

import gg.essential.vigilance.data.Category;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import gg.essential.vigilance.data.SortingBehavior;

public class ConfigSorting extends SortingBehavior
{
    private final List<String> categories;
    
    public ConfigSorting() {
        this.categories = Arrays.asList("Dungeons", "F7 Boss", "Macros", "Player", "Mining", "Keybinds", "Slayer", "Visuals", "Jokes", "Other");
    }
    
    public Comparator<Category> getCategoryComparator() {
        return Comparator.comparingInt(o -> this.categories.indexOf(o.getName()));
    }
}
