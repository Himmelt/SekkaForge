import org.sekka.api.Sekka;
import org.sekka.api.event.Listener;
import org.sekka.api.event.entity.player.FillBucketEvent;
import org.sekka.api.plugin.Plugin;

/**
 * @author Himmelt
 */
@Plugin(
        id = "sekkatest",
        name = "SekkaTest",
        version = "0.0.1"
)
public class TestPlugin {

    public TestPlugin() {
        System.out.println("<init> TestPlugin");
        Sekka.registerListener(this);
    }

    @Listener
    public void on(FillBucketEvent event) {
        System.out.println("FillBucketEvent");
        System.out.println(event);
        System.out.println(event.getPlayer());
        event.getPlayer().sendRawMessage("FillBucketEvent");
        event.setCancelled(true);
    }
}
