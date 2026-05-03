package revilo.reach.loaders.helper;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cpw.mods.fml.common.discovery.ASMDataTable;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Loader {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public static @interface PreInit {

        int priority() default 0;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public static @interface Init {

        int priority() default 0;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public static @interface PostInit {

        int priority() default 0;
    }

    private static ASMDataTable asmData;

    public static void runPreInitLoaders(FMLPreInitializationEvent event) {
        asmData = event.getAsmData();
        runLoaders(PreInit.class);
    }

    public static void runInitLoaders(FMLInitializationEvent event) {
        runLoaders(Init.class);
    }

    public static void runPostInitLoaders(FMLPostInitializationEvent event) {
        runLoaders(PostInit.class);
    }

    @SuppressWarnings("unchecked")
    private static void runLoaders(Class<? extends Annotation> annotationClass) {

        Set<ASMDataTable.ASMData> data = asmData.getAll(annotationClass.getName());

        List<LoaderEntry> loaders = new ArrayList<>();

        for (ASMDataTable.ASMData asm : data) {

            try {

                String className = asm.getClassName();

                Class<?> clazz = Class.forName(className);

                if (!Runnable.class.isAssignableFrom(clazz)) {

                    throw new RuntimeException(className + " must implement Runnable");
                }

                Map<String, Object> annotationInfo = asm.getAnnotationInfo();

                int priority = 0;

                Object value = annotationInfo.get("priority");

                if (value instanceof Integer) {
                    priority = (Integer) value;
                }

                loaders.add(new LoaderEntry((Class<? extends Runnable>) clazz, priority));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        loaders.sort(Comparator.comparingInt(LoaderEntry::getPriority));

        for (LoaderEntry entry : loaders) {

            try {

                Runnable runnable = entry.getClazz()
                    .getDeclaredConstructor()
                    .newInstance();

                runnable.run();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class LoaderEntry {

        private final Class<? extends Runnable> clazz;
        private final int priority;

        public LoaderEntry(Class<? extends Runnable> clazz, int priority) {
            this.clazz = clazz;
            this.priority = priority;
        }

        public Class<? extends Runnable> getClazz() {
            return clazz;
        }

        public int getPriority() {
            return priority;
        }
    }
}
