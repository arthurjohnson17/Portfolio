using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class MageCoin : MonoBehaviour
{
    public static MageCoin instance;

    public Transform playerpos;

    public Camera cam;
    public float range = 20f;

    public LayerMask collidingLayer;
    public LayerMask enemyLayer;
    public int damage = 10;

    public GameObject slash;

    private InputAction laAction;
    private InputAction haAction;

    private Animator anim;
    private PlayerInput playerInput;
    private PlayerManager pm;

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
        laAction.performed += _ => LAbility();
        haAction.canceled += _ => HAbility();
    }

    public void LAbility()
    {
        if (Checks(20f))
        {
            anim.SetTrigger("LAbility");
            Debug.Log("Mage Light");
            RaycastHit hit;
            Ray ray = new Ray(cam.transform.position, cam.transform.forward);

            if (Physics.Raycast(ray, out hit, range, enemyLayer))
            {
                PlayerStats.instance.LoseMana(20f);
                hit.collider.gameObject.GetComponent<CharacterStats>().TakeDamage(damage);
                Debug.Log("Hit " + hit.collider.name);
                GameObject impact = Instantiate(slash, hit.point, Quaternion.LookRotation(cam.transform.forward, cam.transform.up));
                Destroy(impact, 1f);
            }
        }
    }
    public void HAbility()
    {
        if (Checks(50f))
        {
            anim.SetTrigger("HAbility");
            RaycastHit hit;
            Ray ray = new Ray(cam.transform.position, cam.transform.forward);

            if (Physics.Raycast(ray, out hit, range, collidingLayer))
            {
                PlayerStats.instance.LoseMana(50f);
                playerpos.position = hit.point + new Vector3(0, 1, 0);
            }
        }
    }

    private bool Checks(float limit)
    {
        if (PlayerManager.instance.ability &&
            EquippedCoin.instance.equippedcoin == 2 &&
            PlayerController.instance.isGrounded &&
            PlayerStats.instance.currentMana >= limit)
        {
            return true;
        }
        return false;
    }
}
