using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerStats : CharacterStats
{
    public static PlayerStats instance;
    public float maxStamina = 100;
    public float currentStamina;
    public StaminaBar staminaBar;

    public float maxMana = 100;
    public float currentMana;
    public ManaBar manaBar;
    void Start()
    {
        instance = this;
        currentStamina = maxStamina;
        staminaBar.SetMaxStamina(maxStamina);
        currentMana = maxMana;
        manaBar.SetMaxMana(maxMana);
    }

    public override void Die()
    {
        Debug.Log(transform.name + " died");
        anim.SetTrigger("Die");
        LockOnManager.instance.Unlock();
        GetComponent<PlayerController>().enabled = false;
    }

    public void LoseStamina(float stamina)
    {
        currentStamina -= stamina;
        staminaBar.SetStamina(currentStamina);
       // Debug.Log(transform.name+ " loses " + stamina + " stamina");
    }

    public void AddStamina(float stamina)
    {
        if (currentStamina < maxStamina)
        {
            currentStamina += stamina;
            if ( currentStamina >= maxStamina)
            {
                currentStamina = maxStamina;
            }
            staminaBar.SetStamina(currentStamina);
        }
    }
    public void LoseMana(float mana)
    {
        currentMana -= mana;
        manaBar.SetMana(currentMana);
        // Debug.Log(transform.name+ " loses " + stamina + " stamina");
    }

    public void AddMana(float mana)
    {
        if (currentMana < maxMana)
        {
            currentMana += mana;
            if (currentMana >= maxMana)
            {
                currentMana = maxMana;
            }
            manaBar.SetMana(currentMana);
        }
    }
}
