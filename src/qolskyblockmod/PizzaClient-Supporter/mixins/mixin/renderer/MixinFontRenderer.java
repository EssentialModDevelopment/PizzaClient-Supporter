// 
// Decompiled by Procyon v0.5.36
// 

package qolskyblockmod.pizzaclient.mixins.mixin.renderer;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import qolskyblockmod.pizzaclient.util.graphics.custom.names.RightSideRainbowString;
import java.util.Locale;
import net.minecraft.util.StringUtils;
import qolskyblockmod.pizzaclient.util.graphics.custom.ModMessageString;
import qolskyblockmod.pizzaclient.util.graphics.custom.CustomString;
import qolskyblockmod.pizzaclient.util.graphics.custom.names.RainbowString;
import qolskyblockmod.pizzaclient.PizzaClient;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;

@Mixin({ FontRenderer.class })
public class MixinFontRenderer
{
    @Inject(method = { "drawString(Ljava/lang/String;FFIZ)I" }, at = { @At("HEAD") }, cancellable = true)
    private void onDrawString(final String text, final float x, final float y, final int color, final boolean shadow, final CallbackInfoReturnable<Integer> cir) {
        if (text == null) {
            cir.setReturnValue((Object)0);
            return;
        }
        if (PizzaClient.mc.field_71441_e != null) {
            if (RainbowString.rgbList.containsKey(text)) {
                final CustomString custom = RainbowString.rgbList.get(text);
                if (custom != null) {
                    cir.setReturnValue((Object)custom.render(text, (int)x, (int)y, color, shadow));
                }
                return;
            }
            if (text.startsWith("§rPizzaClient > ")) {
                ModMessageString.addToList(text);
                return;
            }
            for (final String s : StringUtils.func_76338_a(text).replace("'", " ").replace(":", "").split(" ")) {
                if (s.length() > 2) {
                    final String lowerCase = s.toLowerCase(Locale.ROOT);
                    if (RainbowString.rgbNames.containsKey(lowerCase)) {
                        if (text.endsWith(s)) {
                            new RightSideRainbowString(text, s, lowerCase);
                            cir.setReturnValue((Object)RainbowString.rgbList.get(text).render(text, (int)x, (int)y, color, shadow));
                            return;
                        }
                        new RainbowString(text, s, lowerCase);
                        cir.setReturnValue((Object)RainbowString.rgbList.get(text).render(text, (int)x, (int)y, color, shadow));
                        return;
                    }
                }
            }
            RainbowString.rgbList.put(text, null);
        }
    }
}
