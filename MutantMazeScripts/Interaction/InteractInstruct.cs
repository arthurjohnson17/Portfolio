using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class InteractInstruct : MonoBehaviour
{
    public float distance;
    public float radius;
    public Transform child;

    void Start()
    {
        radius = GetComponent<Interactable>().radius;
        child = this.gameObject.transform.GetChild(0);
    }
    void Update()
    {
        distance = GetComponent<Interactable>().distance;

        if (distance <= radius)
        {
            child.gameObject.SetActive(true);
        }
        else
        {
            child.gameObject.SetActive(false);
        }
    }
}
