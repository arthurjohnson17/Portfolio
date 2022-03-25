using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class LockOn : Interactable
{
	private PlayerInput playerInput;

	private InputAction lockonAction;

	public Transform locktarget;

    public override void Start()
    {
		playerpos = PlayerManager.instance.player.transform;
		playerInput = PlayerManager.instance.player.GetComponent<PlayerInput>();

		lockonAction = playerInput.actions["LockOn"];
	}
    public override void Interact()
	{
		base.Interact();

		LockingOn();
	}
	public override void OutofRange()
	{
		if (LockOnManager.instance.LockedOn(locktarget))
		{
			if (lockonAction.triggered)
			{
				Debug.Log("Unlocked from " + this.name);
				LockOnManager.instance.target = null;
				LockOnManager.instance.lockedOn = false;
				PlayerManager.instance.player.GetComponent<Animator>().SetFloat("LockOn", 0f);
			}
		}
	}
	public void LockingOn()
	{
		if (!LockOnManager.instance.lockedOn)
		{
			if (lockonAction.triggered)
			{
				Debug.Log("Locked onto " + this.name);
				LockOnManager.instance.target = locktarget;
				LockOnManager.instance.lockedOn = true;
				PlayerManager.instance.player.GetComponent<Animator>().SetFloat("LockOn", 1f);
			}
		}
		else if (LockOnManager.instance.LockedOn(locktarget))
		{
			if (lockonAction.triggered)
			{
				Debug.Log("Unlocked from " + this.name);
				LockOnManager.instance.Unlock();
			}
		}
	}
}