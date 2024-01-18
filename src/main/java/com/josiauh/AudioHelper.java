package com.josiauh;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;


public class AudioHelper {
    public static SoundEvent burn = registerSound("burn");
    public static SoundEvent hate = registerSound("hate");
    public static SoundEvent illness = registerSound("illness");
    public static SoundEvent loser = registerSound("loser");
    public static SoundEvent notouch = registerSound("notouch");
    public static SoundEvent you = registerSound("you");
    static SoundEvent registerSound(String id) {
        SoundEvent sound = SoundEvent.of(new Identifier("jrand", id));
        return Registry.register(Registries.SOUND_EVENT, new Identifier("jrand", id), sound);
    }
}
