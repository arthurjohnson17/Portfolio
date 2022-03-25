using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class EnemySpawner : Interactable
{
	private PlayerInput playerInput;

	private InputAction interactAction;
	private Animator anim;
	public GameObject enemy;

	public Transform spawn1;
	public Transform spawn2;
	public Transform spawn3;
	public Transform spawn4;

	public override void Start()
	{
		playerpos = PlayerManager.instance.player.transform;
		anim = GetComponent<Animator>();
		playerInput = PlayerManager.instance.player.GetComponent<PlayerInput>();
		interactAction = playerInput.actions["Interact"];

	}
	public override void Interact()
	{
		base.Interact();

		Spawn();
	}

	public void Spawn()
	{
		if (interactAction.triggered)
		{
			Instantiate(enemy, spawn1);
			Instantiate(enemy, spawn2);
			Instantiate(enemy, spawn3);
			Instantiate(enemy, spawn4);
		}
	}
}
