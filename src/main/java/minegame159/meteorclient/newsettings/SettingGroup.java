package minegame159.meteorclient.newsettings;

import minegame159.meteorclient.utils.Utils;

public class SettingGroup {
    public final String name;
    public final String title;

    public SettingGroup(String name) {
        this.name = name;
        this.title = Utils.nameToTitle(name);
    }
}
