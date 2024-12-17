package simplexity.villagerinfo.configurations.locale;

public enum Message {
    INSERT_PLUGIN_PREFIX("insert.plugin.prefix", "<#3256a8><bold>[</bold><#4dd5ff>Villager Info<#3256a8><bold>]<reset>"),
    INSERT_VILLAGER_INVENTORY_ITEM("insert.villager-inventory.item", "\n • <lang:item.minecraft.<item>> (<value>)"),
    INSERT_TOGGLE_HIGHLIGHT("insert.toggle.highlight", "Highlight"),
    INSERT_TOGGLE_OUTPUT("insert.toggle.output", "Output"),
    INSERT_TOGGLE_SOUND("insert.toggle.sound", "Sound"),
    INSERT_STATE_ENABLED("insert.state.enabled","<green>Enabled</green>"),
    INSERT_STATE_DISABLED("insert.state.enabled","<red>Disabled</red>"),
    INSERT_BOOLEAN_TRUE("insert.boolean.true","<grey>True"),
    INSERT_BOOLEAN_FALSE("insert.boolean.false","<grey>False"),
    INSERT_NOTHING_NONE("insert.nothing.none","<grey>None"),
    INSERT_NOTHING_NEVER("insert.nothing.never","<grey>Never"),
    INSERT_NOTHING_EMPTY("insert.nothing.empty","<grey>Empty"),
    INSERT_TIME_JUST_NOW("insert.time.just-now","<grey>Just Now"),
    INSERT_TIME_HOUR("insert.time.hour","<value>H "),
    INSERT_TIME_MINUTE("insert.time.minute","<value>m "),
    INSERT_TIME_SECOND("insert.time.second","<value>s "),
    INSERT_TIME_AGO("insert.time.ago","Ago"),
    INSERT_REPUTATION_POSITIVE("insert.reputation.positive","<green>▬</green>"),
    INSERT_REPUTATION_NEUTRAL("insert.reputation.neutral","<grey>•</grey>"),
    INSERT_REPUTATION_NEGATIVE("insert.reputation.negative","<red>▬</red>"),
    INSERT_REPUTATION_NUMERICAL_VALUE("insert.reputation.numerical-value","<white>[<value>]</white>"),
    INSERT_LOCATION_X("insert.location.x-axis","<value>x, "),
    INSERT_LOCATION_Y("insert.location.y-axis","<value>y, "),
    INSERT_LOCATION_Z("insert.location.z-axis","<value>z"),
    MESSAGE_TOGGLE_FEEDBACK("message.toggle-feedback","<gray><subcommand> <u><state>"),
    MESSAGE_CONFIG_RELOADED("message.config-reloaded", "<plugin_prefix> <gold>VillagerInfo Config and Locale Reloaded!"),
    ERROR_LOGGER_INVALID_LOCALE_KEY("error.invalid-locale-key", "Invalid locale key found: "),
    ERROR_NOT_ENOUGH_ARGUMENTS("error.not-enough-args", "<red>Not enough arguments were provided."),
    ERROR_NO_PERMISSION("error.no-permission", "<red>You don't have permission to use this command!"),
    ERROR_NO_KNOWN_SUBCOMMAND("error.no-known-subcommand", "<red>No known subcommand by the name of: "),
    HELP_MAIN("help.main","<plugin_prefix> <#4dd5ff> • How to use Villager Info\n<grey>Crouch-interact with a villager while one or more toggles are enabled to have a villager's information displayed"),
    HELP_TOGGLE_BASE("help.toggle-base", "\n<#4dd5ff><click:suggest_command:'/vi toggle'><hover:show_text:'<#4dd5ff>/vi toggle'><u> • /vi toggle</u></hover></click>\n<grey>Sets your preference on what parts of the plugin should be enabled for you"),
    HELP_TOGGLE_HIGHLIGHT("help.toggle-highlight","\n<#4dd5ff><click:suggest_command:'/vi toggle highlight'><hover:show_text:'<#4dd5ff>/vi toggle highlight'><u> • /vi toggle highlight</u>\n<grey>Sets your preference on whether or not you would like the plugin to highlight a villager's workstation when you crouch-interact with them"),
    HELP_TOGGLE_SOUND("help.toggle-sound","\n<#4dd5ff><click:suggest_command:'/vi toggle sound'><hover:show_text:'<#4dd5ff>/vi toggle sound'><u> • /vi toggle sound</u></hover></click>\n<grey>Sets your preference on whether or not you would like a sound to play when you crouch-interact with a villager"),
    HELP_TOGGLE_OUTPUT("help.toggle-output","\n<#4dd5ff><click:suggest_command:'/vi toggle output'><hover:show_text:'<#4dd5ff>/vi toggle output'><u> • /vi toggle output</u></hover></click>\n<grey>Sets your preference on whether or not you would like text output to display when you crouch-interact with a villager"),
    ERROR_MUST_BE_PLAYER("error.must-be-player", "<red>Sorry, you must be a player to use this command"),
    CONFIG_INVALID_PREFIX("config-invalid.prefix","Configuration Error: "),
    CONFIG_INVALID_SOUND("config-invalid.sound"," is not a valid sound! Setting sound to 'BLOCK_AMETHYST_BLOCK_BREAK' until a valid sound is provided"),
    CONFIG_INVALID_HIGHLIGHT_TIME("config-invalid.highlight-time","Invalid highlight time. If you would like to disable this feature, please set 'highlight-workstation' to 'false'. Otherwise please use an integer greater than zero. Setting value to 10s until a valid number is supplied"),
    CONFIG_INVALID_VOLUME("config-invalid.sound-volume","'sound-volume' must be between 0.0 and 2.0. Setting to 0.5 until a valid number is provided"),
    CONFIG_INVALID_PITCH("config-invalid.sound-pitch","'sound-pitch' must be between 0.0 and 2.0. Setting to 1.5 until a valid number is provided"),
    CONFIG_INVALID_MISSING_TOGGLES("config-invalid.missing-toggles","No info toggles could be found in the configuration file."),
    CONFIG_INVALID_MISSING_LOCALE_SECTION("config-invalid.missing-section","No locale section was found for: "),
    CONFIG_INVALID_MISSING_COLOR_SECTION("config-invalid.missing-highlight-color","No highlight colors section was found in your config."),
    CONFIG_INVALID_MATERIAL("config-invalid.not-a-material"," is not a material. Please be sure to check your syntax."),
    CONFIG_INVALID_CHECK_FOR_TABS("config-invalid.tab","Please check that you did not use TAB instead of SPACE"),
    CONFIG_INVALID_COLOR_DECLARED_INCORRECTLY("config-invalid.highlight-color-syntax","There was not 3 elements in your configuration for your highlight color. Please check that you have declared this in the RR, GG, BB format. Error caused by: "),
    CONFIG_INVALID_NO_FUNCTIONALITY_ENABLED("config-invalid.not-functional"," Your config settings have 'output-enabled', 'play-sound-on-output', and 'highlight-workstation-on-output' all set to false - this disables all functionality within this plugin."),
    READOUT_PURPUR_LOBOTOMIZED("readout.purpur.lobotomized", "<#05bff7><hover:show_text:'<aqua>Lobotomized: <grey><state>'>[<#c4fff7>Lobotomized</#c4fff7>]"),
    READOUT_ZOMBIE_VILLAGER_CONVERSION_TIME("readout.zombie-villager.conversion-time", "<#05bff7><hover:show_text:'<aqua>Conversion Time: <grey><time>'>[<#c4fff7>Time Until Converted</#c4fff7>]</hover>"),
    READOUT_ZOMBIE_VILLAGER_NOT_CURRENTLY_CONVERTING("readout.zombie-villager.not-currently-converting", "<#05bff7><hover:show_text:'<grey>Zombie Villager is Not Currently Converting'>[<#c4fff7>Time Until Converted</#c4fff7>]</hover>"),
    READOUT_BABY_AGE("readout.baby.age","<#05bff7><hover:show_text:'<aqua>Childhood Left: <grey><time>'>[<#c4fff7>Time Until Adult</#c4fff7>]"),
    READOUT_VILLAGER_PROFESSION("readout.villager.profession", "<#05bff7><hover:show_text:'<aqua>Profession: <grey><lang:entity.minecraft.villager.<value>>'>[<#c4fff7>Profession</#c4fff7>]"),
    READOUT_VILLAGER_HEALTH("readout.villager.health", "<#05bff7><hover:show_text:'<aqua>Health: <grey><value><aqua>/</aqua><value2>'>[<#c4fff7>Health</#c4fff7>]"),
    READOUT_VILLAGER_JOB_SITE("readout.villager.job-site", "<#05bff7><hover:show_text:'<aqua>POI: <grey><location>'>[<#c4fff7>Job Site</#c4fff7>]"),
    READOUT_VILLAGER_LAST_WORKED("readout.villager.last-worked", "<#05bff7><hover:show_text:'<aqua>Last Worked: <grey><time>'>[<#c4fff7>Last Worked At Workstation</#c4fff7>]"),
    READOUT_VILLAGER_RESTOCKS_TODAY("readout.villager.restocks-today", "<#05bff7><hover:show_text:'<aqua>Restocks: <grey><value>'>[<#c4fff7>Restocks Today</#c4fff7>]"),
    READOUT_VILLAGER_BED_LOCATION("readout.villager.bed-location", "<#05bff7><hover:show_text:'<aqua>Bed: <grey><location>'>[<#c4fff7>Home</#c4fff7>]"),
    READOUT_VILLAGER_LAST_SLEPT("readout.villager.last-slept", "<#05bff7><hover:show_text:'<aqua>Last Slept: <grey><time>'>[<#c4fff7>Last Slept</#c4fff7>]"),
    READOUT_VILLAGER_INVENTORY("readout.villager.inventory", "<#05bff7><hover:show_text:'<aqua>Inventory: <grey><contents>'>[<#c4fff7>Villager Inventory</#c4fff7>]"),
    READOUT_PLAYER_REPUTATION("readout.villager.reputation", "<#05bff7><hover:show_text:'<#05bff7>[<#c4fff7>Player Reputation</#c4fff7>]'><value>"),
    READOUT_NOTHING_TO_DISPLAY("readout.villager.nothing-to-display", "<grey>No information to display on this villager");
    private final String path;
    private String message;

    Message(String path, String message) {
        this.path = path;
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
