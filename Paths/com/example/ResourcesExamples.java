package com.example;


import java.nio.file.Paths;

public class ResourcesExamples{
    public static void main(String[] args) {
        final String SEPARATOR = "-----------------------";
        //For IDE you can set up Working directory in execution properties.

        System.out.println(SEPARATOR);

        //Bad way: not standard. Use /
        System.out.println(ResourcesExamples.class.getResource("\\."));
        System.out.println(SEPARATOR);

        //
        System.out.println(Paths.get(".").normalize().toAbsolutePath());
        System.out.println(Paths.get("/.").normalize().toAbsolutePath());
        System.out.println(SEPARATOR);

        //
        System.out.println(ResourcesExamples.class.getResource("."));
        System.out.println(ResourcesExamples.class.getResource("/."));
        System.out.println(SEPARATOR);
        //
        System.out.println(ResourcesExamples.class.getClassLoader().getResource("."));
        System.out.println(ResourcesExamples.class.getClassLoader().getResource("/."));
        System.out.println(SEPARATOR);

        //for jars
        //System.out.println(Configuration.class.getProtectionDomain().getCodeSource().getLocation().getPath());
    }
}
