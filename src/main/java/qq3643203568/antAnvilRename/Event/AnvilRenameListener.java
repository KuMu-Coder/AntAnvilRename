package qq3643203568.antAnvilRename.Event;

import com.destroystokyo.paper.event.inventory.PrepareResultEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class AnvilRenameListener implements Listener {
    private final JavaPlugin plugin;
    public AnvilRenameListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onAnvilRename(PrepareResultEvent event){

        AnvilInventory inventory = (AnvilInventory) event.getInventory();

        Player player = (Player) event.getView().getPlayer();

        ItemStack ywp = inventory.getItem(0);
        if (ywp == null){return;}


        ItemStack resultItem = event.getResult();
        if (resultItem == null){return;}

        ItemMeta itemMeta = ywp.getItemMeta();
        ItemMeta resultItemMeta = resultItem.getItemMeta();

        if (itemMeta.getDisplayName() == null){return;}
        if (resultItemMeta.getDisplayName() == null){return;}
        if (itemMeta.getDisplayName().contains("§")&& !itemMeta.getDisplayName().equals(resultItemMeta.getDisplayName())){
            if (!player.isOp()){
                event.setResult(null);
                player.sendMessage(plugin.getConfig().getString("MessageTip").replaceAll("&","§"));
            }
        }
    }
}
