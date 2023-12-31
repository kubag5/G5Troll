package pl.kubag5.g5troll.trolls;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Burn extends Troll {
    public Burn() {
        super("Burn", "Burn player", "5");
        setUsage("/troll execute Burn {player} {seconds}");
        setIcon(Material.FLINT_AND_STEEL);
        setShowKillWarning(true);
    }

    @Override
    public void execute(TrollEvent event) {
        String[] args = event.getArgs();
        Player p = Bukkit.getPlayer(args[0]);
        int a = Integer.parseInt(getArg(0));
        try {
            a = Integer.parseInt(args[1]);
        } catch (Exception ignored) {}
        p.setFireTicks(a*20);
    }
}
