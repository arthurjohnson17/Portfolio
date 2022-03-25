using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class KingCoin : MonoBehaviour
{
    public static KingCoin instance;

    public PlayerStats ps;
    public Transform weapon;
    GameObject temp;
    GameObject tempult;
    private InputAction laAction;
    private InputAction haAction;

    private Animator anim;
    private PlayerInput playerInput;

    public GameObject swordEffect;
    public GameObject ultEffect;
    public bool la = false;
    private Animator anim_sword;
    private Transform playerpos;

    private void Awake()
    {
        instance = this;
        ps = PlayerStats.instance;
        playerInput = PlayerManager.instance.player.GetComponent<PlayerInput>();
        laAction = playerInput.actions["LightAttack"];
        haAction = playerInput.actions["HeavyAttack"];
        anim = PlayerManager.instance.player.GetComponent<Animator>();
        anim_sword = swordEffect.GetComponent<Animator>();
        playerpos = PlayerManager.instance.player.transform;
    }

    private void OnEnable()
    {
        laAction.performed += _ => LAbility();
        haAction.canceled += _ => HAbility();
        
    }

    public void LAbility()
    {
        if (Checks(0f))
        {
            if (!la)
            {
                WeaponCombat.instance.boost = 40;
                la = true;
                temp = Instantiate(swordEffect, weapon);
                Charge.instance.king_sword = true;
                anim_sword.SetTrigger("Draw");
            }
            else if (la)
            {
                StopLa();
            }
        }
    }

    public void StopLa()
    {
        WeaponCombat.instance.boost = 0;
        Destroy(temp);
        la = false;
        Charge.instance.king_sword = false;
    }
    public void HAbility()
    {
        if(Checks(50f))
        {
            tempult = Instantiate(ultEffect, playerpos);
            PlayerStats.instance.LoseMana(50f);
            Destroy(tempult, 3f);
            Debug.Log("KingLight on");
        }

    }
    private bool Checks(float limit)
    {
        if (PlayerManager.instance.ability &&
            EquippedCoin.instance.equippedcoin == 1 &&
            PlayerController.instance.isGrounded &&
            PlayerStats.instance.currentMana >= limit)
        {
            return true;
        }
        return false;
    }
}
