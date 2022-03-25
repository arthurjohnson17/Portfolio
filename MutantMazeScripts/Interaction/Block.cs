using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Block : MonoBehaviour
{
    public int playerLayer;
    private void OnTriggerEnter(Collider player)
    {
        if (player.gameObject.layer == playerLayer)
        {
            player.GetComponent<CharacterStats>().TakeDamage(100);
        }
    }
}
