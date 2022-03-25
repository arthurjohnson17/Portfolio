using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Portal : MonoBehaviour
{
    public int playerLayer;
    public Transform location;
    private void OnTriggerEnter(Collider player)
    {
        if (player.gameObject.layer == playerLayer)
        {
            player.transform.position = location.position;
        }
    }
}
