package llamakot.bettermappet;

import mchorse.mclib.McLib;
import mchorse.mclib.config.ConfigManager;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(
    modid = BetterMappet.MOD_ID,
    name = BetterMappet.NAME,
    version = BetterMappet.VERSION,
    dependencies = "required-after:mclib@[@MCLIB@,);" +
            "required-after:mixinbooter[@MIXINBOOTER@,);" +
            "required-after:mappet@[@MAPPET@,);",
    updateJSON = "https://raw.githubusercontent.com/TorayLife/MappetExtras/master/version.json"
)
public class BetterMappet {
    public BetterMappet() {
    }

    public static final String MOD_ID = "bettermappet";
    public static final String NAME = "BetterMappet";

    public static final String VERSION = "@VERSION@";

    public static final Logger logger = LogManager.getLogger(MOD_ID);
    public static final int mainColor = 0xFFAA00;
    public ConfigManager configs;

    @Mod.Instance
    public static BetterMappet instance;

    @SidedProxy(serverSide = "llamakot.bettermappet.CommonProxy", clientSide = "llamakot.bettermappet.ClientProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        McLib.EVENT_BUS.register(this);

        this.configs = new ConfigManager();

        File configFolder = Loader.instance().getConfigDir();
        configFolder.mkdir();

        this.configs.register(configFolder);

        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}