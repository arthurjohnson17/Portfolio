using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using System.Threading;

public class PlayerManager : MonoBehaviour
{
	public static PlayerManager instance;
	void Awake ()
	{
		instance = this;
	}

	public GameObject player;
	public Transform respawn;
	public bool ability = false;

	public void RespawnPlayer()
	{
		Debug.Log("Respawning");
		player.transform.position = respawn.position;
		player.GetComponent<PlayerStats>().Heal(player.GetComponent<PlayerStats>().maxHealth);
	}
}
