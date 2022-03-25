using UnityEngine;
using UnityEngine.InputSystem;
using Cinemachine;


public class CamSwitch : MonoBehaviour
{
    public static CamSwitch instance;
    [SerializeField]
    private PlayerInput playerInput;
    [SerializeField]
    private Canvas reticle;

    private CinemachineVirtualCamera virtualCamera;
    private InputAction abilityAction;
    private PlayerManager pm;
    private Animator anim;

    private void Awake()
    {
        instance = this;
        virtualCamera = GetComponent<CinemachineVirtualCamera>();
        abilityAction = playerInput.actions["Ability"];
        pm = PlayerManager.instance;
        anim = pm.player.GetComponent<Animator>();

    }

    private void OnEnable()
    {
        abilityAction.performed += _ => StartAim();
        abilityAction.canceled += _ => CancelAim();
    }

    private void OnDisable()
    {
        abilityAction.performed -= _ => StartAim();
        abilityAction.canceled -= _ => CancelAim();
    }

    private void StartAim()
    {
        if (!anim.GetBool("Charge"))
        {

            virtualCamera.Priority = 11;
            reticle.enabled = true;
            /*Time.timeScale = 0.1f;*/
            pm.ability = true;
            PlayerController.instance.enabled = false;
           // PlayerCombat.instance.enabled = false;
            anim.SetBool("Ability", true);
        }
    }

    private void CancelAim()
    {
        if (!anim.GetBool("Charge"))
        {
            virtualCamera.Priority = 9;
            reticle.enabled = false;
            /*Time.timeScale = 1f;*/
            pm.ability = false;
            PlayerController.instance.enabled = true;
            //PlayerCombat.instance.enabled = true;
            anim.SetBool("Ability", false);
        }
    }
}
