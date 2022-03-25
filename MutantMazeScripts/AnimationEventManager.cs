using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AnimationEventManager : MonoBehaviour
{
    public Animator anim;

    void Start()
    {
        anim = GetComponent<Animator>();
    }

    public void StartAttack()
    {
        anim.SetBool("Attacking", true);
    }


    public void EndAttack()
    {
        anim.SetBool("Attacking", false);
    }

    void Respawn()
    {
        PlayerManager.instance.RespawnPlayer();
    }

    public void EnableMove()
    {
        GetComponent<PlayerController>().enabled = true;
    }

    public void DisableMove()
    {
        GetComponent<PlayerController>().enabled = false;
    }

    public void EndCombo()
    {
        anim.SetInteger("Combo", 0);
        PlayerCombat.instance.combo = 0;
       // PlayerCombat.instance.lastcall = 0f;
    }

    public void ChargeMana()
    {
        PlayerStats.instance.AddMana(100f);
    }
    public void ResetCombo()
    {
        anim.SetInteger("Combo", 0);
        PlayerCombat.instance.lastcall = 0f;
    }

    public void EndDodge()
    {
        PlayerController.instance.playerSpeed = PlayerController.instance.walkSpeed;
    }
}
