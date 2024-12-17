package simplexity.villagerinfo.util;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bukkit.Location;
import simplexity.villagerinfo.VillagerInfo;
import simplexity.villagerinfo.configurations.locale.Message;

public class Resolvers {
    MiniMessage miniMessage = VillagerInfo.getInstance().getMiniMessage();
    private static Resolvers instance;

    private Resolvers() {
    }

    public static Resolvers getInstance() {
        if (instance == null) instance = new Resolvers();
        return instance;
    }

    public Component prefixResolver(String message) {
        return miniMessage.deserialize(message, Placeholder.parsed("plugin_prefix", Message.INSERT_PLUGIN_PREFIX.getMessage()));
    }

    public TagResolver locationBuilder(Location location) {
        Component locationComponent;
        if (location == null) {
            locationComponent = miniMessage.deserialize(Message.INSERT_NOTHING_NONE.getMessage());
        } else {
            String x = String.valueOf(location.getBlockX());
            String y = String.valueOf(location.getBlockY());
            String z = String.valueOf(location.getBlockZ());
            Component compX = miniMessage.deserialize(Message.INSERT_LOCATION_X.getMessage(), Placeholder.parsed("value", x));
            Component compY = miniMessage.deserialize(Message.LOCATION_Y_FORMAT.getMessage(), Placeholder.parsed("value", y));
            Component compZ = miniMessage.deserialize(Message.INSERT_LOCATION_Z.getMessage(), Placeholder.parsed("value", z));
            locationComponent = compX.append(compY).append(compZ);
        }
        return TagResolver.resolver(Placeholder.component("location", locationComponent));
    }

    public TagResolver playerReputationResolver(int repNum) {
        Component reputationComponent = Component.empty();
        int minVal = -14;
        int maxVal = 15;
        int devNum = repNum / 50;
        boolean isPos = Math.abs(devNum) == devNum;
        for (int i = minVal; i <= maxVal; i++) {
            if (i == 0) {
                reputationComponent = reputationComponent.append(miniMessage.deserialize(Message.INSERT_REPUTATION_NUMERICAL_VALUE.getMessage(), Placeholder.parsed("value", String.valueOf(repNum))));
                continue;
            }
            if (Math.abs(i) != i) {
                if (!isPos && i < 0 && i >= devNum) {
                    reputationComponent = reputationComponent.append(miniMessage.deserialize(Message.INSERT_REPUTATION_NEGATIVE.getMessage()));
                    continue;
                }
                reputationComponent = reputationComponent.append(miniMessage.deserialize(Message.INSERT_REPUTATION_NEUTRAL.getMessage()));
            }
            if (Math.abs(i) == i) {
                if (isPos && i > 0 && i <= devNum) {
                    reputationComponent = reputationComponent.append(miniMessage.deserialize(Message.INSERT_REPUTATION_POSITIVE.getMessage()));
                    continue;
                }
                reputationComponent = reputationComponent.append(miniMessage.deserialize(Message.INSERT_REPUTATION_NEUTRAL.getMessage()));
            }
        }
        return TagResolver.resolver(Placeholder.component("reputation_bar", reputationComponent));
    }


    public TagResolver timeFormatter(Long timeDifferenceInSeconds) {
        Component finalTimeComponent;
        if (timeDifferenceInSeconds == null) {
            finalTimeComponent = miniMessage.deserialize(Message.INSERT_NOTHING_NEVER.getMessage());
        } else {
            long s = timeDifferenceInSeconds % 60;
            long m = (timeDifferenceInSeconds / 60) % 60;
            long h = (timeDifferenceInSeconds / (60 * 60)) % 24;
            finalTimeComponent = Component.empty();
            boolean componentEmpty = true;
            if (h > 0) {
                componentEmpty = false;
                String hours = String.valueOf(h);
                finalTimeComponent = finalTimeComponent.append(miniMessage.deserialize(Message.INSERT_TIME_HOUR.getMessage(), Placeholder.parsed("value", hours)));
            }
            if (m > 0) {
                componentEmpty = false;
                String minutes = String.valueOf(m);
                finalTimeComponent = finalTimeComponent.append(miniMessage.deserialize(Message.INSERT_TIME_MINUTE.getMessage(), Placeholder.parsed("value", minutes)));
            }
            if (s > 0) {
                componentEmpty = false;
                String seconds = String.valueOf(s);
                finalTimeComponent = finalTimeComponent.append(miniMessage.deserialize(Message.INSERT_TIME_SECOND.getMessage(), Placeholder.parsed("value", seconds)));
            }
            if (componentEmpty) {
                finalTimeComponent = finalTimeComponent.append(miniMessage.deserialize(Message.INSERT_TIME_JUST_NOW.getMessage()));
            } else {
                finalTimeComponent = finalTimeComponent.append(miniMessage.deserialize(Message.INSERT_TIME_AGO.getMessage()));
            }
        }
        return TagResolver.resolver(Placeholder.component("time", finalTimeComponent));
    }
}
