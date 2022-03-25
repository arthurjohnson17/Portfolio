using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CharacterStats : MonoBehaviour
{

    public float maxHealth = 100f;
	public float currentHealth; 
    public Stat damage;
    public float armour;
    public Stat speed;
    public HealthBar healthBar;
    public Animator anim;

    void Awake()
    {
    	currentHealth = maxHealth;
        healthBar.SetMaxHealth(maxHealth);
        anim = GetComponent<Animator>();
    }

    public virtual void TakeDamage(float damage)
    {
        if(currentHealth > 0)
        {
        	damage -= armour;
        	damage = Mathf.Clamp(damage, 0, int.MaxValue);
        	currentHealth -= damage;

            if(damage >= maxHealth/10f && currentHealth > 0f)
            {
                anim.SetTrigger("Hurt");
            }

            healthBar.SetHealth(currentHealth);
        	Debug.Log(transform.name+ " takes " + damage + " damage");

        	if ( currentHealth <= 0f)
        	{
        		Die();
        	}
        }
    }

    public virtual void Heal(float heal)
    {
        heal = Mathf.Clamp(heal, 0f, int.MaxValue);
        currentHealth += heal;
        healthBar.SetHealth(currentHealth);
        Debug.Log(transform.name+ " heals " + heal);

        if ( currentHealth >= maxHealth)
        {
            currentHealth = maxHealth;
        }
    }

    public virtual void Die()
    {
    	Debug.Log(transform.name + " died");
        anim.SetTrigger("Die");
        LockOnManager.instance.Unlock();
        StartCoroutine(Death(5));
    }
    IEnumerator Death (float delay)
    {
        yield return new WaitForSeconds(delay);
        Debug.Log("Enemey body destroyed");
        Destroy(gameObject);
    }
}
