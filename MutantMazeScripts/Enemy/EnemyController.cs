using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class EnemyController : MonoBehaviour
{
	public float lookRadius = 10f;
    public float attackDistance = 3f;
    public int playerLayer;

    public float attackRate = 2f;
    float nextAttackTime = 0f;

    public int numOfAttacks = 0;
    
    Animator anim;
	Transform target;
	NavMeshAgent agent;
    CharacterStats mystats;

    // Start is called before the first frame update
    void Start()
    {
    	target = PlayerManager.instance.player.transform;
        agent = GetComponent<NavMeshAgent>();
        anim = GetComponent<Animator>();
        mystats = GetComponent<CharacterStats>();

    }

    // Update is called once per frame
    void Update()
    {

        if(mystats.currentHealth <= 0)
        {
            return;
        }

        float distance = Vector3.Distance(target.position, transform.position);
        anim.SetFloat("Speed",0f);
        if (distance <= lookRadius && !anim.GetBool("Attacking"))
        {
        	agent.SetDestination(target.position);
            anim.SetFloat("Speed",1f);
        	if (distance <= attackDistance)
        	{
                FaceTarget();
                anim.SetFloat("Speed",0f);
                if(Time.time >= nextAttackTime)
                {
                    Attack();
                    nextAttackTime = Time.time + 1f/attackRate;
                }
        	}
        }
    }

    void FaceTarget ()
    {
    	Vector3 direction = (target.position - transform.position).normalized;
    	Quaternion lookRotation = Quaternion.LookRotation(new Vector3(direction.x, 0, direction.z));
    	transform.rotation = Quaternion.Slerp(transform.rotation, lookRotation, Time.deltaTime * 5f);

        Vector3 dir = target.position - transform.position;
        dir = target.transform.InverseTransformDirection(dir);
        float angle = Mathf.Atan2(dir.y, dir.x) * Mathf.Rad2Deg;
        if(angle < 90f)
        {
           // Debug.Log("Right");
        }
        else if(angle > 90f)
        {
           // Debug.Log("left");
        }
        //Debug.Log(angle);
    }

    void OnDrawGizmosSelected()
    {
    	Gizmos.color = Color.red;
    	Gizmos.DrawWireSphere(transform.position, lookRadius);
    }

    void Attack()
    {
        int attack = Random.Range(1,numOfAttacks+1);
        anim.SetInteger("AttackNum", attack);
        anim.SetTrigger("Attack");
    }

    void StartAttack()
    {
        anim.SetBool("Attacking", true);
    }

    void EndAttack()
    {
        anim.SetBool("Attacking", false);
    }

    private void OnTriggerEnter(Collider player)
    {
        if (player.gameObject.layer == playerLayer && anim.GetBool("Attacking")) 
        {
            player.GetComponent<CharacterStats>().TakeDamage(mystats.damage.GetValue());
        }
    }
}
