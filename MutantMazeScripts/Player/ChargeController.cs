using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class ChargeController : MonoBehaviour
{

    private InputAction chargeAction;

    private Animator anim;
    private PlayerInput playerInput;

    public GameObject chargeEffect;
    GameObject temp;

    private void Awake()
    {
        playerInput = GetComponent<PlayerInput>();
        anim = GetComponent<Animator>();
        chargeAction = playerInput.actions["Charge"];
    }
    private void OnEnable()
    {
        chargeAction.performed += _ => StartCharge();
        chargeAction.canceled += _ => CancelCharge();
    }

    private void OnDisable()
    {
        chargeAction.performed += _ => StartCharge();
        chargeAction.canceled += _ => CancelCharge();
    }

    private void StartCharge()
    {
        if (Checks())
        {
            Charge.instance.charging_mana = true;
            anim.SetBool("Charge", true);
            PlayerController.instance.enabled = false;
           // PlayerCombat.instance.enabled = false;
            temp = Instantiate(chargeEffect, PlayerManager.instance.player.transform);

        }
    }
    private void CancelCharge()
    {
        if (Checks())
        {
            Charge.instance.charging_mana = false;
            anim.SetBool("Charge", false);
            PlayerController.instance.enabled = true;
            //PlayerCombat.instance.enabled = true;
            Destroy(temp);
        }
    }
    private bool Checks()
    {
        if (!PlayerManager.instance.ability &&
            PlayerController.instance.isGrounded)
        {
            return true;
        }
        return false;
    }
}
