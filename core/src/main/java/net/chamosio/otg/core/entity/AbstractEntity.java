package net.chamosio.otg.core.entity;

public abstract class AbstractEntity {

    public Hitbox hitbox;

    public abstract void update();

    public Hitbox getHitbox() {return this.hitbox;}
}
