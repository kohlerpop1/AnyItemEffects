package com.kohlerpop1.ArmorEffectsMaven.Utils.Custom;

import com.kohlerpop1.ArmorEffectsMaven.Utils.ArmorType;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;

public final class ArmorUnEquipEvent extends PlayerEvent implements Cancellable
{
    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private final ArmorType type;
    private ItemStack oldPiece, newPiece;

    public ArmorUnEquipEvent(Player player, ArmorType type, ItemStack old, ItemStack newA)
    {
        super(player);
        this.type = type;
        this.oldPiece = old;
        this.newPiece = newA;
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
        return oldPiece;
    }

    public void setOldPiece(ItemStack oldPiece)
    {
        this.oldPiece = oldPiece;
    }

    public ItemStack getNewPiece()
    {
        return newPiece;
    }

    public void setNewPiece(ItemStack newPiece){
        this.newPiece = newPiece;
    }
}