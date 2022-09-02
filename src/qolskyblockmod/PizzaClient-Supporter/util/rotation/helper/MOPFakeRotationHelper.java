// 
// Decompiled by Procyon v0.5.36
// 

package qolskyblockmod.pizzaclient.util.rotation.helper;

import qolskyblockmod.pizzaclient.util.rotation.Rotation;
import qolskyblockmod.pizzaclient.PizzaClient;
import qolskyblockmod.pizzaclient.util.rotation.fake.FakeRotation;
import qolskyblockmod.pizzaclient.util.PlayerUtil;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition;

public class MOPFakeRotationHelper
{
    public MovingObjectPosition bestPos;
    private double bestRotation;
    private final float maxDist;
    private final Vec3 player;
    
    public MOPFakeRotationHelper() {
        this.bestRotation = 9.9999999E7;
        this.maxDist = 20.25f;
        this.player = PlayerUtil.getPositionEyes();
        if (FakeRotation.lastPitch == 69420.0f) {
            FakeRotation.lastYaw = PizzaClient.mc.field_71439_g.field_70177_z;
            FakeRotation.lastPitch = PizzaClient.mc.field_71439_g.field_70125_A;
        }
    }
    
    public MOPFakeRotationHelper(final float dist) {
        this.bestRotation = 9.9999999E7;
        this.maxDist = dist * dist;
        this.player = PlayerUtil.getPositionEyes();
        if (FakeRotation.lastPitch == 69420.0f) {
            FakeRotation.lastYaw = PizzaClient.mc.field_71439_g.field_70177_z;
            FakeRotation.lastPitch = PizzaClient.mc.field_71439_g.field_70125_A;
        }
    }
    
    public void compare(final MovingObjectPosition pos) {
        if (this.player.func_72436_e(pos.field_72307_f) <= this.maxDist) {
            final double dist = Rotation.getRotationDifference(pos.field_72307_f, FakeRotation.lastYaw, FakeRotation.lastPitch).sum();
            if (dist < this.bestRotation) {
                this.bestPos = pos;
                this.bestRotation = dist;
            }
        }
    }
    
    public boolean isNotNull() {
        return this.bestPos != null;
    }
}
