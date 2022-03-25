using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;


public class KnightCoin : MonoBehaviour
{
    public static KnightCoin instance;

    private InputAction laAction;
    private InputAction haAction;

    private Animator anim;
    private PlayerInput playerInput;
    private PlayerManager pm;

    public GameObject shield;
    public GameObject gravitySpell;

    public float range = 100f;
    public LayerMask collidingLayer;

    public Camera cam;
    public bool la = false;

    public CharacterStats playerstats;

    GameObject tempshield;
    GameObject tempgrav;

    void Awake()
    {
        instance = this;
        pm = PlayerManager.instance;
        playerInput = pm.player.GetComponent<PlayerInput>();
        laAction = playerInput.actions["LightAttack"];
        haAction = playerInput.actions["HeavyAttack"];
        anim = pm.player.GetComponent<Animator>();
        playerstats = pm.player.GetComponent<CharacterStats>();
    }

    private void OnEnable()
    {
        laAction.performed += _ => StartLA();
        //laAction.canceled += _ => CancelLA();
        haAction.canceled += _ => StartHA();
        /*haAction.canceled += _ => CancelHA();*/
    }
    private void OnDisable()
    {
        /*laAction.performed -= _ => StartLA();
        laAction.canceled -= _ => CancelLA()*/;

        /*        haAction.performed += _ => StartHA();
                haAction.canceled += _ => CancelHA();*/
    }

    public void StartLA()
    {
        if (Checks(0f))
        {
            if (!la)
            {
                playerstats.armour = 40f;
                anim.SetTrigger("LAbility");
                la= true;
                tempshield = Instantiate(shield, PlayerManager.instance.player.transform);
                Charge.instance.knight_shield = true;
            }
            else if(la)
            {
                StopLa();
            }
        }
    }
    public void StopLa()
    {
        playerstats.armour = 0f;
        Destroy(tempshield);
        la = false;
        Charge.instance.knight_shield = false;
    }
    public void StartHA()
    {
        if (Checks(50f))
        {
            Debug.Log("Knight Heavy");
            anim.SetTrigger("HAbility");
            RaycastHit hit;
            Ray ray = new Ray(cam.transform.position, cam.transform.forward);

            if (Physics.Raycast(ray, out hit, range, collidingLayer))
            {
                tempgrav = Instantiate(gravitySpell, hit.point, Quaternion.LookRotation(hit.normal));
                PlayerStats.instance.LoseMana(50f);
                Destroy(tempgrav, 10f);
            }
        }
    }
    /*    public void CancelHA()
        {
            if (Checks())
            {
                Destroy(tempgrav, 5f);
            }
        }*/
    private bool Checks(float limit)
    {
        if (PlayerManager.instance.ability &&
            EquippedCoin.instance.equippedcoin == 3 &&
            PlayerController.instance.isGrounded &&
            PlayerStats.instance.currentMana >= limit)
        {
            return true;
        }
        return false;
    }
}
