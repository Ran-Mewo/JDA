/*
 * Copyright 2015 Austin Keener, Michael Ritter, Florian Spieß, and the JDA contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.dv8tion.jda.api.interactions;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Represents where commands can be used.
 */
public enum InteractionContextType
{
    UNKNOWN("-1"),
    /**
     * Allows execution in a guild.
     */
    GUILD("0"),
    /**
     * Allows execution in the bot DMs.
     */
    BOT_DM("1"),
    /**
     * Allows execution in a private channel other than the bot DMs,
     * includes friend DMs and Group DMs.
     */
    PRIVATE_CHANNEL("2");

    /**
     * Contains all interaction types
     */
    public static final Set<InteractionContextType> ALL = Collections.unmodifiableSet(EnumSet.of(GUILD, BOT_DM, PRIVATE_CHANNEL));

    private final String key;

    InteractionContextType(String key) {
        this.key = key;
    }

    /**
     * The raw value of this interaction context.
     *
     * @return The raw value
     */
    @Nonnull
    public String getType()
    {
        return key;
    }

    /**
     * Gets the interaction context corresponding to the key,
     * returns {@link #UNKNOWN} if no entry matches.
     *
     * @param  key
     *         The key to match against
     *
     * @return The interaction context corresponding to the key
     */
    @Nonnull
    public static InteractionContextType fromKey(@Nonnull String key)
    {
        for (InteractionContextType value : values())
        {
            if (value.key.equals(key))
                return value;
        }
        return UNKNOWN;
    }
}
