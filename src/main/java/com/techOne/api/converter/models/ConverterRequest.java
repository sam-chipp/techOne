package com.techOne.api.converter.models;

import com.techOne.api.converter.controller.ConverterController;

/**
 * The request object for the {@link ConverterController#converter}.
 */
public class ConverterRequest
{

    /** The number. */
    private double number;

    /**
     * Gets the number.
     * @return The number.
     */
    public double getNumber()
    {
        return number;
    }

    /**
     * Sets the number.
     * @param number The number.
     */
    public void setNumber(double number)
    {
        this.number = number;
    }
}
