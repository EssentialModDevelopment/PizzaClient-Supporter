// 
// Decompiled by Procyon v0.5.36
// 

package qolskyblockmod.pizzaclient.core.events;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import java.util.List;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.common.eventhandler.Event;

public class ChestBackgroundDrawnEvent extends Event
{
    public Container chest;
    public String displayName;
    public int chestSize;
    public List<Slot> slots;
    public IInventory chestInv;
    
    public ChestBackgroundDrawnEvent(final Container chest, final String displayName, final int chestSize, final List<Slot> slots, final IInventory chestInv) {
        this.chest = chest;
        this.displayName = displayName;
        this.chestSize = chestSize;
        this.slots = slots;
        this.chestInv = chestInv;
    }
}
