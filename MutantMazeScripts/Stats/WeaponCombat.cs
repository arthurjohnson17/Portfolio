using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WeaponCombat : MonoBehaviour
{
    public static WeaponCombat instance;
    public Animator anim;
    public int enemyLayer = 6;
    public PlayerStats playerstats;
    public int boost = 0;

    private void Awake()
    {
        instance = this;
    }
    void Start()
    {
        anim = PlayerManager.instance.player.GetComponent<Animator>();
        playerstats = PlayerManager.instance.player.GetComponent<PlayerStats>();

    }

    private void OnTriggerEnter(Collider enemy)
    {
        if (enemy.gameObject.layer == enemyLayer && anim.GetBool("Attacking")) 
        {
            int damage = playerstats.GetComponent<PlayerStats>().damage.GetValue() + boost;
            Debug.Log(this.name + " hit " + enemy.name);
            enemy.GetComponent<CharacterStats>().TakeDamage(damage);
        }
    }
}
