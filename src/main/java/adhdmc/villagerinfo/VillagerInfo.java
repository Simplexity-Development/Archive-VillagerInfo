package adhdmc.villagerinfo;

import adhdmc.villagerinfo.Commands.CommandHandler;
import adhdmc.villagerinfo.Commands.SubCommands.HelpCommand;
import adhdmc.villagerinfo.Commands.SubCommands.ReloadCommand;
import adhdmc.villagerinfo.Commands.SubCommands.ToggleCommand;
import adhdmc.villagerinfo.Config.ConfigValidator;
import adhdmc.villagerinfo.Config.Defaults;
import adhdmc.villagerinfo.Config.LocaleConfig;
import adhdmc.villagerinfo.VillagerHandling.VillagerHandler;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerInfo extends JavaPlugin {
    public static VillagerInfo plugin;
    public static LocaleConfig localeConfig;
    //These are for the PDC stuff because I manage to not be able to keep '0' and '1' straight in my head, for which is true or false
    public static final String isEnabled = "isEnabled";
    public static final String isDisabled = "isDisabled";
    //Permissions
    public static final String toggleCommandPermission = "villagerinfo.toggle";
    public static final String reloadCommandPermission = "villagerinfo.reload";
    public static final String usePermission = "villagerinfo.use";

    @Override
    public void onEnable() {
        plugin = this;
        localeConfig = new LocaleConfig(this);
        localeConfig.getlocaleConfig();
        int pluginId = 13653; // bStats ID
        getServer().getPluginManager().registerEvents(new VillagerHandler(), this);
        this.getCommand("vill").setExecutor(new CommandHandler());
        this.saveDefaultConfig();
        Defaults.localeDefaults();
        Defaults.configDefaults();
        localeConfig.saveConfig();
        ConfigValidator.configValidator();
        registerCommands();
    }

    public void onDisable() {
        VillagerHandler.workstationShulker.forEach((uuid, shulker) -> shulker.remove());
        VillagerHandler.villagerPDC.forEach((uuid, persistentDataContainer) -> persistentDataContainer.set(new NamespacedKey(VillagerInfo.plugin, "IsHighlighted"), PersistentDataType.STRING, isDisabled));
        VillagerHandler.workstationShulker.clear();
    }

    private void registerCommands() {
        CommandHandler.subcommandList.put("help", new HelpCommand());
        CommandHandler.subcommandList.put("toggle", new ToggleCommand());
        CommandHandler.subcommandList.put("reload", new ReloadCommand());
    }
}
