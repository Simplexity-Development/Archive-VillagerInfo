package simplexity.villagerinfo.configurations.locale;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import simplexity.villagerinfo.VillagerInfo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings({"ResultOfMethodCallIgnored", "CallToPrintStackTrace", "CollectionAddAllCanBeReplacedWithConstructor"})
public class LocaleHandler {

    private static LocaleHandler instance;
    private final String fileName = "locale.yml";
    private final File dataFile = new File(VillagerInfo.getInstance().getDataFolder(), fileName);
    private FileConfiguration locale = new YamlConfiguration();

    private LocaleHandler() {
        try {
            dataFile.getParentFile().mkdirs();
            dataFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        reloadLocale();
    }

    public static LocaleHandler getInstance() {
        if (instance == null) {
            instance = new LocaleHandler();
        }
        return instance;
    }

    public void reloadLocale() {
        try {
            locale.load(dataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        populateLocale();
        sortLocale();
        saveLocale();
    }


    private void populateLocale() {
        Set<Message> missing = new HashSet<>(Arrays.asList(Message.values()));
        for (Message message : Message.values()) {
            if (locale.contains(message.getPath())) {
                message.setMessage(locale.getString(message.getPath()));
                missing.remove(message);
            }
        }

        for (Message message : missing) {
            locale.set(message.getPath(), message.getMessage());
        }


    }

    private void sortLocale() {
        FileConfiguration newLocale = new YamlConfiguration();
        List<String> keys = new ArrayList<>();
        keys.addAll(locale.getKeys(true));
        Collections.sort(keys);
        for (String key : keys) {
            newLocale.set(key, locale.getString(key));
        }
        locale = newLocale;
    }

    private void saveLocale() {
        try {
            locale.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
