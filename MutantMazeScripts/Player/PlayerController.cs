using UnityEngine;
using UnityEngine.InputSystem;
using Cinemachine;

[RequireComponent(typeof(CharacterController), typeof(PlayerInput))]
public class PlayerController : MonoBehaviour
{
    public static PlayerController instance;

    
    public float walkSpeed = 2.0f;
    
    public float runSpeed = 5.0f;
    [SerializeField]
    private float jumpHeight = 2.0f;
    [SerializeField]
    private float gravityValue = -9.81f;
    [SerializeField]
    private float dodgeSpeed = 10f;


    
    public float playerSpeed = 2.0f;
    private CharacterController controller;
    private PlayerInput playerInput;
    private Vector3 playerVelocity;
    public Camera cam;
    public CinemachineVirtualCamera cinecam;


    private InputAction moveAction;
    private InputAction jumpAction;
    private InputAction dodgeAction;


    private Animator anim;
    public Transform groundCheck;
    public float groundDistance = 0.4f;
    public LayerMask groundMask;
    public bool isGrounded;
    private LockOnManager lom;

    private float turnSmoothTime = 0.1f;
    private float turnSmoothVelocity;

    private void Awake()
    {
        instance = this;
    }
    private void Start()
    {
        controller = GetComponent<CharacterController>();
        playerInput = GetComponent<PlayerInput>();
        moveAction = playerInput.actions["Movement"];
        jumpAction = playerInput.actions["Jump"];
        dodgeAction = playerInput.actions["Dodge"];
        anim = GetComponent<Animator>();
        lom = LockOnManager.instance;

    }

    void Update()
    {
        isGrounded = Physics.CheckSphere(groundCheck.position, groundDistance, groundMask);
        Grounded();
        if (isGrounded && playerVelocity.y < 0)
        {
            playerVelocity.y = -1f;
        }

        Dodge();

        Vector2 input = moveAction.ReadValue<Vector2>();
        Vector3 move = new Vector3(input.x, 0, input.y);
        Vector3 move_o = move;
        anim.SetFloat("Forward", move.z*playerSpeed);
        anim.SetFloat("Sideways", move.x*playerSpeed);
        anim.SetFloat("Speed", move.magnitude*playerSpeed);





        if (lom.lockedOn)
        {
            Vector3 direction = (lom.target.transform.position - transform.position).normalized;
            Quaternion lookRotation = Quaternion.LookRotation(new Vector3(direction.x, 0, direction.z));
            transform.rotation = Quaternion.Slerp(transform.rotation, lookRotation, Time.deltaTime * 5f);
            Vector3 normal = new Vector3(0, 1, 0);
            Vector3 tangent = Vector3.Cross(normal, direction);
            move = move.x * tangent + move.z * direction;
            cinecam.LookAt = lom.target.transform;
        }
        else
        {
            move = move.x * cam.transform.right.normalized + move.z * cam.transform.forward.normalized;
            float targetAngle = Mathf.Atan2(move_o.x, move_o.z) * Mathf.Rad2Deg + cam.transform.eulerAngles.y;
            float angle = Mathf.SmoothDampAngle(transform.eulerAngles.y, targetAngle, ref turnSmoothVelocity, turnSmoothTime);
            transform.rotation = Quaternion.Euler(0f, angle, 0f);
        }

        move.y = 0f;
        controller.Move(move * Time.deltaTime * playerSpeed);

        if (jumpAction.triggered && isGrounded)
        {
            playerVelocity.y += Mathf.Sqrt(jumpHeight * -3.0f * gravityValue);
        }


        playerVelocity.y += gravityValue * Time.deltaTime;
        controller.Move(playerVelocity * Time.deltaTime);
    }

    private void Grounded()
    {
        if (isGrounded)
        {
            anim.SetBool("Grounded", true);
        }
        else
            anim.SetBool("Grounded", false);
    }

    private void Dodge()
    {
        if (isGrounded && dodgeAction.triggered)
        {
            playerSpeed = dodgeSpeed;
            anim.SetTrigger("Dodge");
        }
    }

    public void Sprint()
    {
        playerSpeed = runSpeed;
    }

    public void Walk()
    {
        playerSpeed = walkSpeed;
    }
}