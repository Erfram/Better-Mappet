package llamakot.bettermappet.capabilities.hand;

import llamakot.bettermappet.utils.ScriptVectorAngle;
import mchorse.mappet.api.scripts.user.data.ScriptVector;
import net.minecraft.nbt.NBTTagCompound;

public interface IHand {
    void setRotate(double angle, double x, double y, double z);
    ScriptVectorAngle getRotate();

    void setPosition(double x, double y, double z);
    ScriptVector getPosition();

    void setCanceled(boolean canceled);
    boolean isCanceled();

    NBTTagCompound serializeNBT();
    void deserializeNBT(NBTTagCompound tag);
}
