using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class Charge : MonoBehaviour
{
    public static Charge instance;

    public bool charging_mana;
    public bool queen_heal = false;
    public bool queen_stamina = false;
    public bool knight_shield = false;
    public bool king_sword = false;

    private PlayerStats ps;

    private void Awake()
    {
        instance = this;
        ps = GetComponent<PlayerStats>();
    }

    private void FixedUpdate()
    {
        ChargeMana();
        QueenHeal();
        QueenStamina();
        KnightShield();
        KingSword();
        ChargeStamina();
    }

    private void ChargeMana()
    {
        if (charging_mana)
        {
            ps.AddMana(0.2f);
        }
    }
    private void QueenHeal()
    {
        if(queen_heal && ps.currentMana>0 && ps.currentHealth<ps.maxHealth)
        {
            ps.Heal(0.2f);
            ps.LoseMana(0.2f);
        }
    }
    private void QueenStamina()
    {
        if(queen_stamina && ps.currentMana > 0  && ps.currentStamina<ps.maxStamina)
        {
            ps.AddStamina(0.2f);
            ps.LoseMana(0.2f);
        }
    }

    private void KnightShield()
    {
        if(knight_shield && ps.currentMana > 0)
        {
            ps.LoseMana(0.1f);
        }
        else if(knight_shield && ps.currentMana <= 0)
        {
            KnightCoin.instance.StopLa();
        }
    }

    private void KingSword()
    {
        if (king_sword && ps.currentMana > 0)
        {
            ps.LoseMana(0.1f);
        }
        else if (king_sword && ps.currentMana <= 0)
        {
            KingCoin.instance.StopLa();
        }
    }

    private void ChargeStamina()
    {
        ps.AddStamina(0.01f);
    }
}
