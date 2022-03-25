using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class CoinUI : MonoBehaviour
{
    [SerializeField]
    private Image coin1;
    [SerializeField]
    private Image coin2;
    [SerializeField]
    private Image coin3;
    [SerializeField]
    private Image coin4;

    private void Start()
    {
        coin1 = transform.GetChild(0).GetComponent<Image>();
        coin2 = transform.GetChild(1).GetComponent<Image>();
        coin3 = transform.GetChild(2).GetComponent<Image>();
        coin4 = transform.GetChild(3).GetComponent<Image>();
    }

    private void Update()
    {
        int coin = EquippedCoin.instance.equippedcoin;
        if (coin == 1)
        {
            coin1.enabled = true;
            coin2.enabled = false;
            coin3.enabled = false;
            coin4.enabled = false;
        }
        else if (coin == 2)
        {
            coin1.enabled = false;
            coin2.enabled = true;
            coin3.enabled = false;
            coin4.enabled = false;
        }
        else if (coin == 3)
        {
            coin1.enabled = false;
            coin2.enabled = false;
            coin3.enabled = true;
            coin4.enabled = false;
        }
        else if (coin == 4)
        {
            coin1.enabled = false;
            coin2.enabled = false;
            coin3.enabled = false;
            coin4.enabled = true;
        }
        else
        {
            coin1.enabled = false;
            coin2.enabled = false;
            coin3.enabled = false;
            coin4.enabled = false;
        }
    }

}
