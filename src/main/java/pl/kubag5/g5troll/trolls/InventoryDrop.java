package pl.kubag5.g5troll.trolls;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryDrop extends Troll {
    public InventoryDrop() {
        super("InventoryDrop", "Drops inventory");
        setIcon(Material.WHEAT_SEEDS);
        setShowInventoryWarning(true);
    }

    @Override
    public void execute(TrollEvent event) {
        String[] args = event.getArgs();
        Player p = Bukkit.getPlayer(args[0]);
        ItemStack[] contents = p.getInventory().getContents();
        p.getInventory().clear();
        for (ItemStack it : contents) {
            if (it != null) {
                p.getWorld().dropItemNaturally(p.getLocation(), it);
            }
        }
    }
}
