using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;

public class EquippedCoin : MonoBehaviour
{
	[SerializeField]
	private PlayerInput playerInput;

	public static EquippedCoin instance;

	public int equippedcoin = 0;

	private InputAction coin1Action;
	private InputAction coin2Action;
	private InputAction coin3Action;
	private InputAction coin4Action;

	public Animator anim;

	void Awake()
	{
		instance = this;
		coin1Action = playerInput.actions["EquipCoin1"];
		coin2Action = playerInput.actions["EquipCoin2"];
		coin3Action = playerInput.actions["EquipCoin3"];
		coin4Action = playerInput.actions["EquipCoin4"];
	}

	private void OnEnable()
	{
		coin1Action.performed += _ => EquipCoin(1);
		coin2Action.performed += _ => EquipCoin(2);
		coin3Action.performed += _ => EquipCoin(3);
		coin4Action.performed += _ => EquipCoin(4);

	}

	private void EquipCoin(int coin_num)
    {
		equippedcoin = coin_num;
		anim.SetInteger("Coin", coin_num);
	}
}
