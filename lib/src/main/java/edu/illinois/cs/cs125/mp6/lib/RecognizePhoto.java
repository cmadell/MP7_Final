package edu.illinois.cs.cs125.mp6.lib;

import com.google.gson.JsonArray;
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
        if (json == null) {
            return null;
        } else {
            JsonParser parser = new JsonParser();
            JsonObject root = parser.parse(json).getAsJsonObject();
            JsonObject metaData = root.getAsJsonObject("metadata");
            String format = metaData.get("format").getAsString();
            return format;
        }
    }

    /**
     * Return the caption describing the image created by API.
     * @param json string from API.
     * @return caption.
     */
    public static java.lang.String getCaption(final java.lang.String json) {
        if (json == null) {
            return null;
        } else {
            JsonParser parser = new JsonParser();
            JsonObject root = parser.parse(json).getAsJsonObject();
            JsonObject first = root.getAsJsonObject("description").getAsJsonArray("captions")
                    .get(0).getAsJsonObject();
            String caption = first.get("text").getAsString();
            return caption;
        }
    }

    /**
     * Determine whether the image contains a dog. You should do this by examining
     * the tags returned by API. If tag with name "dog" exists with at least provided
     * confidence, return true. Otherwise, false.
     * @param json string from API.
     * @param minConfidence minimum confidence required for this determination.
     * @return boolean indicating whether image contains dog or false on failure.
     */
    public static boolean isADog(final java.lang.String json, final double minConfidence) {
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject root = parser.parse(json).getAsJsonObject();
        JsonArray tags = root.getAsJsonArray("tags");
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getAsJsonObject().get("name").getAsString().
                    equalsIgnoreCase("dog") && tags.get(i).
                    getAsJsonObject().get("confidence").
                    getAsDouble() >= minConfidence) {
                return true;
            }
        }
        return false;
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
        if (json == null) {
            return false;
        }
        JsonParser parser = new JsonParser();
        JsonObject root = parser.parse(json).getAsJsonObject();
        JsonArray tags = root.getAsJsonArray("tags");
        for (int i = 0; i < tags.size(); i++) {
                if (tags.get(i).getAsJsonObject().get("name").getAsString()
                        .equalsIgnoreCase("cat")
                    && tags.get(i).getAsJsonObject().get("confidence").
                    getAsDouble() >= minConfidence) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if image has Rick Astley.
     * @param json string from API.
     * @return true if I Rickrolled yourself.
     */
    public static boolean isRick(final java.lang.String json) {
        try {
            //if (json == null) {
            //    return false;
            //}
            JsonParser parser = new JsonParser();
            JsonObject root = parser.parse(json).getAsJsonObject();
            JsonArray categories = root.getAsJsonArray("categories");
            //if (categories.size() == 0) {
            //    return false;
            //}
            JsonArray celebrities = categories.get(0).getAsJsonObject().get("details")
                    .getAsJsonObject().getAsJsonArray("celebrities");
            for (int i = 0; i < celebrities.size(); i++) {
                //if (celebrities.get(i) == null) {
                //    return false;
                //}
                if (celebrities.get(i).getAsJsonObject().get("name").getAsString()
                        .equalsIgnoreCase("Rick Astley")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}


