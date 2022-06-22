package com.kohlerpop1.ArmorEffectsMaven.Utils.Custom;

import com.kohlerpop1.ArmorEffectsMaven.Utils.ArmorType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public final class ArmorEquipEvent extends PlayerEvent implements Cancellable
{
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final ArmorType type;
    private ItemStack old, newA;

    public ArmorEquipEvent(Player player, ArmorType type, ItemStack old, ItemStack newA)
    {
        super(player);
        this.type = type;
        this.old = old;
        this.newA = newA;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public HandlerList getHandlers(){
        return handlers;
    }

    public void setCancelled(boolean cancel){
        this.cancel = cancel;
    }

    public boolean isCancelled(){
        return cancel;
    }

    public ArmorType getType(){
        return type;
    }

    public ItemStack getOldPiece(){
        return old;
    }

    public void setOldPiece(ItemStack oldPiece)
    {
        this.old = oldPiece;
    }

    public ItemStack getNewPiece()
    {
        return newA;
    }

    public void setNewPiece(ItemStack newPiece){
        this.newA = newPiece;
    }
}