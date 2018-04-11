package edu.illinois.cs.cs125.mp6.lib;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Class that recognizes photo imported from Android emulator.
 */
public final class RecognizePhoto {

    /**
     * Get the image width.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the width of the image or 0 on failure
     */
    public static int getWidth(final String json) {
        if (json == null) {
            return 0;
        } else {
            JsonParser parser = new JsonParser();
            JsonObject root = parser.parse(json).getAsJsonObject();
            JsonObject metaData = root.getAsJsonObject("metadata");
            int width = metaData.get("width").getAsInt();
            return width;
        }
    }

    /**
     * Get the image height.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the width of the image or 0 on failure
     */
    public static int getHeight(final String json) {
        if (json == null) {
            return 0;
        } else {
            JsonParser parser = new JsonParser();
            JsonObject root = parser.parse(json).getAsJsonObject();
            JsonObject metaData = root.getAsJsonObject("metadata");
            int width = metaData.get("height").getAsInt();
            return width;
        }
    }

    /**
     * Get the image file type.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the type of the image or null
     */
    public static String getFormat(final String json) {
        return "";
    }

    /**
     * Return the caption describing the image created by API.
     * @param json string from API.
     * @return caption.
     */
    public static java.lang.String getCaption(final java.lang.String json) {
        return json;
    }

    /**
     * Determine whether the image contains a dog. You should do this by examining
     * the tags returned by API. If tag with name "dog" exists, return true. Otherwise,
     * false.
     * @param json string from API.
     * @param minConfidence minimum confidence required for this determination.
     * @return boolean indicating whether image contains dog or false on failure.
     */
    public static boolean isADog(final java.lang.String json, final double minConfidence) {
        return true;
    }
    /**
     * Determine whether the image contains a cat. You should do this by examining
     * the tags returned by API. If tag with name "cat" exists, return true. Otherwise,
     * false.
     * @param json string from API.
     * @param minConfidence minimum confidence required for this determination.
     * @return boolean indicating whether image contains cat or false on failure.
     */
    public static boolean isACat(final java.lang.String json, final double minConfidence) {
        return false;
    }

    /**
     * Check if image has Rick Astley.
     * @param json string from API.
     * @return true if I Rickrolled yourself.
     */
    public static boolean isRick(final java.lang.String json) {
        return false;
    }
}

