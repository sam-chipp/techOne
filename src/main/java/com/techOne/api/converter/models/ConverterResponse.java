package com.techOne.api.converter.models;

import org.glassfish.jersey.internal.guava.Preconditions;

/**
 * The response object.
 */
public class ConverterResponse
{
    /** The number. */
    private String words;

    public ConverterResponse (final String words)
    {
        this.words = Preconditions.checkNotNull(words, "words cannot be null");
    }

    /**
     * Gets the number.
     * @return The number.
     */
    public String getWords()
    {
        return words;
    }
}
