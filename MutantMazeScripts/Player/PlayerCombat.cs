using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerCombat : MonoBehaviour
{
    public static PlayerCombat instance;
    private PlayerInput playerInput;

    private InputAction laAction;
    private InputAction haAction;

    public float lastcall = 0f;
    public float combotime = 1f;
    public int combo = 0;

    private Animator anim;

    private void Awake()
    {
        instance = this;
        playerInput = GetComponent<PlayerInput>();
        laAction = playerInput.actions["LightAttack"];
        haAction = playerInput.actions["HeavyAttack"];
        anim = GetComponent<Animator>();
    }

    private void OnEnable()
    {
            laAction.canceled += _ => LAttack();
            haAction.canceled += _ => HAttack();
    }

    private void LAttack()
    {
        if (!PlayerManager.instance.ability && PlayerStats.instance.currentStamina>0)
        {
            anim.SetBool("AttackType", true);
            if (Time.unscaledTime > lastcall + combotime)
            {
                combo = 0;
                anim.SetInteger("Combo", combo);
                anim.SetTrigger("LAttack");
                PlayerStats.instance.LoseStamina(2f);
            }
            else
            {
                combo++;
                anim.SetInteger("Combo", combo);
                PlayerStats.instance.LoseStamina(2f);
            }

            lastcall = Time.unscaledTime;
        }
    }

    private void HAttack()
    {
        if (!PlayerManager.instance.ability && PlayerStats.instance.currentStamina > 0)
        {
            anim.SetBool("AttackType", false);
            if (Time.unscaledTime > lastcall + combotime)
            {
                combo = 0;
                anim.SetInteger("Combo", combo);
                anim.SetTrigger("HAttack");
                PlayerStats.instance.LoseStamina(5f);
            }
            else
            {
                combo++;
                anim.SetInteger("Combo", combo);
                PlayerStats.instance.LoseStamina(5f);
            }
            lastcall = Time.unscaledTime;
        }
    }

}
