using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ItemPickUp : Interactable
{
	//public Item item;
	public bool isEquipped = false;
	public override void Interact()
	{
		base.Interact();

		PickUp();
	}

	void PickUp()
	{
		//isEquipped = EquipmentManager.instance.Detect(item);
		if(!isEquipped)
		{
			if(Input.GetKeyDown(KeyCode.E))
			{
				Debug.Log("Picking up item");
/*				bool wasPickedUp = Inventory.instance.Add(item);
				if(wasPickedUp)
				{
					Destroy(gameObject);
				}*/
			}
		}
	}
}
