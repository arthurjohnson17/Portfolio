using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class DoorInteraction : Interactable
{
	[SerializeField]
	private PlayerInput playerInput;

	private InputAction interactAction;
	private Animator anim;
	public bool door_open = false;

	public override void Start()
	{
		playerpos = PlayerManager.instance.player.transform;
		anim = GetComponent<Animator>();
		interactAction = playerInput.actions["Interact"];
	}
	public override void Interact()
	{
		base.Interact();

		OpenDoor();
	}
	public override void OutofRange()
	{
		if (door_open)
		{
			anim.SetTrigger("Close");
			door_open = false;
		}
	}
	public void OpenDoor()
	{
		if (interactAction.triggered)
		{
			if (!door_open)
			{
				anim.SetTrigger("Open");
				door_open = true;
			}
			else
			{
				anim.SetTrigger("Close");
				door_open = false;
			}
		}
	}
}

