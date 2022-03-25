using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;


public class LockOnManager : MonoBehaviour
{
	public static LockOnManager instance;
	public Transform target;
	public bool lockedOn = false;

	void Awake()
	{
		instance = this;
	}




	public bool LockedOn(Transform potential)
    {
		if(target == potential)
        {
			return true;
        }
		return false;
    }

	public void Unlock()
    {
		target = null;
		lockedOn = false;
		PlayerManager.instance.player.GetComponent<Animator>().SetFloat("LockOn", 0f);
	}
}
