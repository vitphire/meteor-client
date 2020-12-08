package minegame159.meteorclient.newsettings;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class AbstSetting<T> {
    private final SettingGroup group;

    private final String name;
    private final String description;

    private final Object object;

    private final Field field;
    private final T defaultValue;

    private final Method onChanged;

    public AbstSetting(SettingGroup group, String name, String description, Object object, Field field, T defaultValue, Method onChanged) {
        this.group = group;
        this.name = name;
        this.description = description;
        this.object = object;
        this.field = field;
        this.defaultValue = defaultValue;
        this.onChanged = onChanged;
    }
}
