package com.printstat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LangManager 
{
    private static final Map<UUID, String> langMap = new HashMap<>();
    public static final UUID CONSOLE_UUID = UUID.nameUUIDFromBytes("CONSOLE".getBytes());

    public static void setLanguage(UUID uuid, String lang) 
    {
        if (lang.equalsIgnoreCase("en") || lang.equalsIgnoreCase("kr")) 
        {
            langMap.put(uuid, lang.toLowerCase());
        }
    }

    public static String getLanguage(UUID uuid) 
    {
        return langMap.getOrDefault(uuid, "kr");
    }
}
