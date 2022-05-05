package com.techOne.api.converter.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.jvnet.hk2.annotations.Service;

import java.util.Map;

/**
 * A service for converting numerical values to the equivalant words. Number must be greater than 0 and less than 1 trillion.
 */
@Service
public class ConverterService
{

    /** Values less than 20. */
    private static final ImmutableList<String> subTwenty =
            ImmutableList.of("", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN");

    /** A list of word values respresenting powers of 10 upto 90. */
    private static final ImmutableList<String> tens =
            ImmutableList.of("", "", "TWENTY", "THIRTY", "FOURTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY");

    /** A map of powers and there respective numerical values. */
    private static final ImmutableMap<String, Integer> powers =
            ImmutableMap.of(
                    "BILLION ", 1000000000,
                    "MILLION ", 1000000,
                    "THOUSAND ", 1000);

    /**
     * Gets the word values for the given number.
     * @param number The number represented as a string.
     * @return A string containing the word values for the number.
     */
    public String convert(final double number)
    {

        // The natural number ...
        final int left = (int) number;

        final StringBuilder res = new StringBuilder();

        // First we add values for the powers (billion, million, thousands) ...

        if (left > 0)
        {
            for (Map.Entry<String, Integer> entry: powers.entrySet())
            {
                /* The 3 digit value corresponding to the related power. */
                final long threeDidgitSection = (left / entry.getValue() % 1000);

                res.append(convertForValue(threeDidgitSection, "", entry.getKey()));
            }

            // Next we add the values under 1000 ...

            res.append(convertForValue((left / 100) % 10, "", "HUNDRED "));

            if (left < 100)
            {
                res.append(convertForValue((left % 100), "", ""));
            }
            else
            {
                res.append(convertForValue((left % 100), "AND ", ""));
            }

            res.append("DOLLARS");
        }

        // Finally we use the numbers right of the decimal to add our cents ...

        final double right = Math.round((number - Math.floor(number)) * 100);

        if (right > 0)
        {
            final String centSuffix = right == 1 ? "CENT" : "CENTS";
            res.append(convertForValue((long) right, " AND ", centSuffix));
        }

        return res.toString();
    }

    /**
     * Gets the word values for the given 3 digit number.
     * @param n The number.
     * @param prefix The prefix to be appended before the values.
     * @param suffix The suffix to be appended after the values.
     * @return The word values for the given number eg. ONE HUNDRED EIGHTY-THREE BILLION
     */
    private String convertForValue(final long n, final String prefix, final String suffix)
    {
        if (n == 0)
        {
            return "";
        }

        final StringBuilder val = new StringBuilder();

        val.append(prefix);

        if (n / 100 > 0)
        {
            val.append(subTwenty.get((int) n / 100));
            val.append(" HUNDRED ");
        }

        final int remainder = (int) n % 100;

        if (remainder > 19)
        {
            val.append(tens.get(remainder / 10));

            final String one = subTwenty.get(remainder % 10);
            if (!one.isEmpty())
            {
                val.append("-");
                val.append(one);
            }
            val.append(" ");
        }
        else
        {
            val.append(subTwenty.get(remainder));
            val.append(" ");
        }

        val.append(suffix);

        return val.toString();
    }
}
