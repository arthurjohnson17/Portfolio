using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class KingUltimate : MonoBehaviour
{
    public int enemyLayer = 6;
    public PlayerStats playerstats;
    public int boost = 0;

    void Start()
    {        playerstats = PlayerManager.instance.player.GetComponent<PlayerStats>();

    }

    private void OnTriggerEnter(Collider enemy)
    {
        if (enemy.gameObject.layer == enemyLayer )
        {
            int damage = playerstats.GetComponent<PlayerStats>().damage.GetValue() + boost;
            Debug.Log(this.name + " hit " + enemy.name);
            enemy.GetComponent<CharacterStats>().TakeDamage(damage);
        }
    }
}
