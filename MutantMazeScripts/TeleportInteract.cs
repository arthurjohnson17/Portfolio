using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;
using UnityEngine.SceneManagement;


public class TeleportInteract : Interactable
{
	[SerializeField]
	private PlayerInput playerInput;

	private InputAction interactAction;

	public override void Start()
	{
		playerpos = PlayerManager.instance.player.transform;
		interactAction = playerInput.actions["Interact"];
	}
	public override void Interact()
	{
		base.Interact();

		GoFinal();
	}
	public void GoFinal()
    {
		if(interactAction.triggered)
        {
			SceneManager.LoadScene(3);
		}
	}

}

