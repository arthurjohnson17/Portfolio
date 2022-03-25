using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Checkpoint : Interactable
{
	public override void Interact()
	{
		base.Interact();

		Check();
	}

	private void Check()
    {
		PlayerManager.instance.respawn = this.transform;
    }


}
