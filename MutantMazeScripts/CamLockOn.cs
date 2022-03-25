using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.InputSystem;
using Cinemachine;

public class CamLockOn : MonoBehaviour
{
    private LockOnManager lom;
    private PlayerManager pm;
    private CinemachineVirtualCamera virtualCamera;
    [SerializeField]
    private Canvas reticle;

    private void Start()
    {
        lom = LockOnManager.instance;
        pm = PlayerManager.instance;
        virtualCamera = GetComponent<CinemachineVirtualCamera>();
    }

    private void Update()
    {
        if(lom.lockedOn && !pm.ability)
        {
            reticle.enabled = true;
            virtualCamera.Priority = 11;
        }
        else
        {
            reticle.enabled = false;
            virtualCamera.Priority = 9;
        }
    }
}
