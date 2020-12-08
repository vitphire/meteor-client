package minegame159.meteorclient.newsettings;

import minegame159.meteorclient.newsettings.annotations.Setting;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class SettingFactory {
    /** Look for all settings in the object's class and return a list of setting groups with all the settings */
    public static List<SettingGroup> parse(Object object) {
        Class<?> klass = object.getClass();
        List<SettingGroup> groups = new ArrayList<>(1);

        for (Field field : klass.getDeclaredFields()) {
            Annotation[] annotations = field.getAnnotations();

            // Get setting annotation
            Setting settingAn = getAnnotation(annotations, Setting.class);
            if (settingAn == null) continue;

            // Get setting group
            SettingGroup group = getGroup(groups, settingAn.group());

            // Get on changed method
            Method onChanged = getOnChangedMethod(settingAn, klass);
        }

        return groups;
    }

    private static Method getOnChangedMethod(Setting settingAn, Class<?> klass) {
        if (settingAn.onChanged().isEmpty()) return null;

        for (Method method : klass.getDeclaredMethods()) {
            if (method.getName().equals(settingAn.onChanged()) && !Modifier.isStatic(method.getModifiers()) && method.getReturnType() == Void.class && method.getParameterCount() == 0) return method;
        }

        throw new RuntimeException("[Meteor Client] SettingFactory: Could not find method '" + settingAn.onChanged() + "' with 0 parameters and void return type in '" + klass.getName() + "'");
    }

    private static SettingGroup getGroup(List<SettingGroup> groups, String name) {
        for (SettingGroup group : groups) {
            if (group.name.equals(name)) return group;
        }

        SettingGroup group = new SettingGroup(name);
        groups.add(group);

        return group;
    }

    private static <T extends Annotation> T getAnnotation(Annotation[] annotations, Class<T> klass) {
        for (Annotation annotation : annotations) {
            if (annotation.getClass() == klass) return (T) annotation;
        }

        return null;
    }
}
