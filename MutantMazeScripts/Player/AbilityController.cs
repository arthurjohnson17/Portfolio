using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class AbilityController : MonoBehaviour
{
    private InputAction laAction;
    private InputAction haAction;
    private InputAction chargeAction;


    private Animator anim;
    private PlayerInput playerInput;
    private PlayerStats ps;

    private void Awake()
    {
        playerInput = GetComponent<PlayerInput>();
        laAction = playerInput.actions["LightAttack"];
        haAction = playerInput.actions["HeavyAttack"];
        anim = GetComponent<Animator>();
        chargeAction = playerInput.actions["Charge"];
    }

    private void OnEnable()
    {
        laAction.performed += _ => LAbility();
        haAction.canceled += _ => HAbility();
        chargeAction.performed += _ => StartCharge();
        chargeAction.canceled += _ => CancelCharge();
    }
    private void OnDisable()
    {
        chargeAction.performed -= _ => StartCharge();
        chargeAction.canceled -= _ => CancelCharge();
    }

    private void LAbility()
    {
        ps = PlayerStats.instance;
        if (PlayerManager.instance.ability && ps.currentMana >= 20f)
        {
            anim.SetTrigger("LAbility");

        }
    }

    private void HAbility()
    {
        ps = PlayerStats.instance;
        if (PlayerManager.instance.ability && ps.currentMana >= 50f)
        {
            anim.SetTrigger("HAbility");

        }
    }
    private void StartCharge()
    {
        PlayerController.instance.enabled = false;
        PlayerCombat.instance.enabled = false;
        anim.SetBool("Charge", true);
        Debug.Log("Charging");

    }

    private void CancelCharge()
    {
        PlayerController.instance.enabled = true;
        PlayerCombat.instance.enabled = true;
        anim.SetBool("Charge", false);
    }
}
