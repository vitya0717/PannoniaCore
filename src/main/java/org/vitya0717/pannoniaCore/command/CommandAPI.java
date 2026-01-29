package org.vitya0717.pannoniaCore.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.Collections;
import java.util.List;

public class CommandAPI extends Command {


    public CommandAPI(String commandName, List<String> commandAliases, String permission, String description , String usageMessage) {
        super(commandName);
        this.setAliases(commandAliases); // Optional
        this.setPermission(permission); // Optional
        this.setDescription(description);
        this.setUsage(usageMessage);
    }

    public CommandAPI(String commandName, String permission, String description , String usageMessage) {
        super(commandName);
        this.setAliases(List.of()); // Optional
        this.setPermission(permission); // Optional
        this.setDescription(description);
        this.setUsage(usageMessage);
    }

    public CommandAPI(String commandName, String description , String usageMessage) {
        super(commandName);
        this.setAliases(List.of()); // Optional
        //this.setPermission(null); // Optional
        this.setDescription(description);
        this.setUsage(usageMessage);
    }

    public CommandAPI(String commandName, String description) {
        super(commandName);
        this.setAliases(List.of()); // Optional
        //this.setPermission(null); // Optional
        this.setDescription(description);
        //this.setUsage("");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        return false;
    }

    @Override
    public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
        return Collections.emptyList();
    }

}
