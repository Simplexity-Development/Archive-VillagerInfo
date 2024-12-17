package simplexity.villagerinfo.commands.villagerinfo.subcommands.toggle.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import simplexity.villagerinfo.commands.util.SubCommand;
import simplexity.villagerinfo.configurations.locale.Message;
import simplexity.villagerinfo.events.PlayerToggleEvent;
import simplexity.villagerinfo.util.PDCTag;
import simplexity.villagerinfo.util.Perm;
import simplexity.villagerinfo.util.Resolvers;

import java.util.List;

public class HighlightToggle extends SubCommand {
    public HighlightToggle() {
        super(Perm.VILL_COMMAND_TOGGLE_HIGHLIGHT.getPerm(), Message.HELP_TOGGLE_HIGHLIGHT.getMessage());
    }


    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof org.bukkit.entity.Player player)) {
            sender.sendMessage(Resolvers.getInstance().prefixResolver(Message.ERROR_MUST_BE_PLAYER.getMessage()));
            return;
        }
        PlayerToggleEvent toggleHighlightEvent = callHighlightToggleEvent(player);
        if (toggleHighlightEvent == null) return;
        byte toggleState = toggleHighlightEvent.getCurrentToggleState();
        if (toggleState == (byte) 0) {
            toggleHighlightEvent.setDisabled();
            return;
        }
        if (toggleState == (byte) 1) {
            toggleHighlightEvent.setEnabled();
        }
    }

    public PlayerToggleEvent callHighlightToggleEvent(org.bukkit.entity.Player player) {
        PlayerToggleEvent toggleHighlightEvent = new PlayerToggleEvent(player, PDCTag.PLAYER_TOGGLE_HIGHLIGHT_ENABLED.getPdcTag(), Message.INSERT_TOGGLE_HIGHLIGHT.getMessage());
        Bukkit.getServer().getPluginManager().callEvent(toggleHighlightEvent);
        if (toggleHighlightEvent.isCancelled()) return null;
        return toggleHighlightEvent;
    }

    @Override
    public List<String> subCommandTabCompletions(CommandSender sender) {
        return List.of();
    }
}
