using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class Lift : Interactable
{
	[SerializeField]
	private PlayerInput playerInput;

	private InputAction interactAction;
	public Animator anim;
	public bool lift_up = false;

	public override void Start()
	{
		playerpos = PlayerManager.instance.player.transform;
		interactAction = playerInput.actions["Interact"];
	}
	public override void Interact()
	{
		base.Interact();

		Liftpress();
	}
	public void Liftpress()
	{
		if (interactAction.triggered &&
            (anim.GetCurrentAnimatorStateInfo(0).IsName("idle_low") ||
            anim.GetCurrentAnimatorStateInfo(0).IsName("idle_high")))
		{

			Debug.Log(anim.GetCurrentAnimatorStateInfo(0).IsName("idle_high"));
			if (!lift_up)
			{
				lift_up = true;
				anim.SetTrigger("Up");
			}
			else
			{
				lift_up = false;
				anim.SetTrigger("Down");
			}
		}
	}
}
