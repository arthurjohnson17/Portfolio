using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Interactable : MonoBehaviour
{
	public float radius = 3f;
	public Transform interactionTransform;
	public float distance;

	// bool isFocus = false;
	public Transform playerpos;

	public virtual void Start()
	{
		playerpos = PlayerManager.instance.player.transform;
	}

	bool hasInteracted = false;

	public virtual void Interact ()
	{
		//Debug.Log("Interacting with " + transform.name);
	}
	public virtual void OutofRange()
	{
		//Debug.Log("Interacting with " + transform.name);
	}

	void Update ()
	{
		if (!hasInteracted)
		{
			distance = Vector3.Distance(playerpos.position, interactionTransform.position);
			if (distance <= radius)
			{
				Interact();
				//hasInteracted = true;
			}
			else
            {
				OutofRange();
            }
		}
	}

	void OnDrawGizmosSelected()
	{
		if(interactionTransform == null)
		{
			interactionTransform = transform;
		}
		Gizmos.color = Color.green;
		Gizmos.DrawWireSphere(transform.position, radius);
	}
}
