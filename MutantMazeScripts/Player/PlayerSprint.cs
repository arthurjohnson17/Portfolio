using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerSprint : MonoBehaviour
{

    [SerializeField]
    private PlayerInput playerInput;

    private InputAction sprintAction;

    private PlayerController pc;

    private void Awake()
    {
        playerInput = GetComponent<PlayerInput>();
        sprintAction = playerInput.actions["Sprint"];
    }

    private void OnEnable()
    {
        sprintAction.performed += _ => StartSprint();
        sprintAction.canceled += _ => CancelSprint();
    }

    private void OnDisable()
    {
        sprintAction.performed -= _ => StartSprint();
        sprintAction.canceled -= _ => CancelSprint();
    }

    private void StartSprint()
    {
        if (!LockOnManager.instance.lockedOn)
        {
            PlayerController.instance.Sprint();
        }
    }

    private void CancelSprint ()
    {
        PlayerController.instance.Walk();
    }
}
