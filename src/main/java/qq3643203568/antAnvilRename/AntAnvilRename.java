package qq3643203568.antAnvilRename;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import qq3643203568.antAnvilRename.Event.AnvilRenameListener;

public final class AntAnvilRename extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new AnvilRenameListener(this),this);
        getServer().getPluginCommand("antanvilrename").setExecutor(this);
        getLogger().info("禁止铁砧内修改彩色名字插件已加载");
        getLogger().info("作者QQ:3643203568");

    }

    @Override
    public void onDisable() {
        getLogger().info("禁止铁砧内修改彩色名字插件已卸载");
        getLogger().info("作者QQ:3643203568");
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.isOp()){
            if (command.getName().equalsIgnoreCase("antanvilrename")){
                reloadConfig();
                sender.sendMessage("配置文件已重载");
            }
        }
        return super.onCommand(sender, command, label, args);
    }
}
