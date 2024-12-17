package simplexity.villagerinfo.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import simplexity.villagerinfo.VillagerInfo;
import simplexity.villagerinfo.configurations.locale.LocaleHandler;
import simplexity.villagerinfo.configurations.locale.Message;
import simplexity.villagerinfo.util.Resolvers;

public class VillReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        VillagerInfo.getInstance().reloadConfig();
        VillagerInfo.getInstance().reloadVillInfoConfigs();
        LocaleHandler.getInstance().reloadLocale();
        sender.sendMessage(Resolvers.getInstance().prefixResolver(Message.MESSAGE_CONFIG_RELOADED.getMessage()));
        return true;
    }
}
