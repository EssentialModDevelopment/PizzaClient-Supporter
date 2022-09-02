// 
// Decompiled by Procyon v0.5.36
// 

package qolskyblockmod.pizzaclient.commands;

import qolskyblockmod.pizzaclient.features.macros.ai.pathfinding.Pathfinding;
import qolskyblockmod.pizzaclient.features.macros.ai.pathfinding.util.BetterBlockPos;
import qolskyblockmod.pizzaclient.features.player.TPAuraHelper;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;

public class PathfindCommand extends CommandBase
{
    public String func_71517_b() {
        return "pathfind";
    }
    
    public String func_71518_a(final ICommandSender sender) {
        return null;
    }
    
    public int func_82362_a() {
        return 0;
    }
    
    public void func_71515_b(final ICommandSender sender, final String[] args) {
        if (args.length < 3) {
            return;
        }
        final int x = Integer.parseInt(args[0]);
        final int y = Integer.parseInt(args[1]);
        final int z = Integer.parseInt(args[2]);
        TPAuraHelper.update();
        if (args.length == 4) {
            Pathfinding.runAStarPathfinder(new BetterBlockPos(x, y, z));
        }
        else {
            Pathfinding.runPathfinder(new BetterBlockPos(x, y, z));
        }
    }
}
