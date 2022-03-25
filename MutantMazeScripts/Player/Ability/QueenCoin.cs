using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;


public class QueenCoin : MonoBehaviour
{
    public static QueenCoin instance;

    private InputAction laAction;
    private InputAction haAction;

    private Animator anim;
    private PlayerInput playerInput;
    private PlayerManager pm;

    public GameObject healEffect;
    GameObject tempheal;
    public GameObject staminaEffect;
    GameObject tempstam;
    private bool heal = false;

    void Awake()
    {
        instance = this;
        pm = PlayerManager.instance;
        playerInput = pm.player.GetComponent<PlayerInput>();
        laAction = playerInput.actions["LightAttack"];
        haAction = playerInput.actions["HeavyAttack"];
        anim = pm.player.GetComponent<Animator>();
    }

    private void OnEnable()
    {
        laAction.performed += _ => StartLA();
        laAction.canceled += _ => CancelLA();

        haAction.performed += _ => StartHA();
        haAction.canceled += _ => CancelHA();
    }
    private void OnDisable()
    {
        laAction.performed -= _ => StartLA();
        laAction.canceled -= _ => CancelLA();

        haAction.performed -= _ => StartHA();
        haAction.canceled -= _ => CancelHA();
    }

    public void StartLA()
    {
        if (Checks())
        {
            Debug.Log("Queen Light");
            anim.SetTrigger("LAbility");
            Charge.instance.queen_stamina = true;
            tempstam = Instantiate(staminaEffect, PlayerManager.instance.player.transform);
        }
    }
    public void CancelLA()
    {

            Charge.instance.queen_stamina = false;
            Destroy(tempstam);

    }
    public void StartHA()
    {
        if (Checks() && !heal)
        {
            anim.SetTrigger("HAbility");
            Charge.instance.queen_heal = true;
            tempheal = Instantiate(healEffect, PlayerManager.instance.player.transform);
            heal = true;
        }
    }
    public void CancelHA()
    {
            Charge.instance.queen_heal = false;
            Destroy(tempheal);
            heal = false;
    }
    private bool Checks()
    {
        if(PlayerManager.instance.ability &&
            EquippedCoin.instance.equippedcoin == 4 &&
            PlayerController.instance.isGrounded)
        {
            return true;
        }
        return false;
    }
}
