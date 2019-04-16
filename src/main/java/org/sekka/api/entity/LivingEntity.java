package org.sekka.api.entity;

import org.sekka.api.util.Location;

public interface LivingEntity {

    double getEyeHeight();

    double getEyeHeight(boolean ignorePose);

    Location getEyeLocation();

    /*   List<Block> getLineOfSight(Set<Material> transparent, int maxDistance);

       Block getTargetBlock(Set<Material> transparent, int maxDistance);

       List<Block> getLastTwoTargetBlocks(Set<Material> transparent, int maxDistance);
   */
    int getRemainingAir();

    void setRemainingAir(int ticks);

    int getMaximumAir();

    void setMaximumAir(int ticks);

    int getMaximumNoDamageTicks();

    void setMaximumNoDamageTicks(int ticks);

    double getLastDamage();

    void setLastDamage(double damage);

    int getNoDamageTicks();

    void setNoDamageTicks(int ticks);

    Player getKiller();

/*
    boolean addPotionEffect(PotionEffect effect);

    boolean addPotionEffect(PotionEffect effect, boolean force);

    boolean addPotionEffects(Collection<PotionEffect> effects);

    boolean hasPotionEffect(PotionEffectType type);

    PotionEffect getPotionEffect(PotionEffectType type);

    void removePotionEffect(PotionEffectType type);

    Collection<PotionEffect> getActivePotionEffects();
*/

    boolean hasLineOfSight(Entity other);

    boolean getRemoveWhenFarAway();

    void setRemoveWhenFarAway(boolean remove);

    //EntityEquipment getEquipment();

    void setCanPickupItems(boolean pickup);

    boolean getCanPickupItems();

    boolean isLeashed();

    Entity getLeashHolder() throws IllegalStateException;

    boolean setLeashHolder(Entity holder);

    boolean isGliding();

    void setGliding(boolean gliding);

    void setAI(boolean ai);

    boolean hasAI();

    void setCollidable(boolean collidable);

    boolean isCollidable();
}
