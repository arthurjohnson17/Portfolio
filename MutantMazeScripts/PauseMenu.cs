using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.InputSystem;

public class PauseMenu : MonoBehaviour
{
    public static bool GameIsPaused = false;

    public GameObject pauseMenuUI;

    public PlayerInput playerInput;

    private InputAction pauseAction;

    public GameObject controls;
    public GameObject abilities;

    void Start()
    {
        pauseAction = playerInput.actions["Pause"];
        Resume();
        controls.SetActive(false);
        abilities.SetActive(false);
    }

    void Update()
    {
        if(pauseAction.triggered)
        {
            if(GameIsPaused)
            {
                Resume();
            }
            else
            {
                Pause();
            }
        }
    }

    public void Resume()
    {
        pauseMenuUI.SetActive(false);
        Time.timeScale = 1f;
        GameIsPaused = false;
        Cursor.visible = false;

    }

    void Pause()
    {
        pauseMenuUI.SetActive(true);
        Time.timeScale = 0f;
        GameIsPaused = true;
        Cursor.visible = true;
    }

    public void GoMain()
    {
        SceneManager.LoadScene(0);
    }

    public void QuitGame()
    {
        Debug.Log("QUIT!");
        Application.Quit();
    }

    public void Controls()
    {
        controls.SetActive(true);
        abilities.SetActive(false);
    }

    public void Abilities()
    {
        controls.SetActive(false);
        abilities.SetActive(true);
    }

}
