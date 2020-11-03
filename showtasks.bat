call runcrud.bat

if "%ERRORLEVEL%" == "0" goto run_google
echo *** cannot run my script***
goto fail

:run_google
call "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe" http://localhost:8080/crud/v1/task/getTasks

if "%ERRORLEVEL%" == "0" goto end
echo *** cannot run google and show tasks***
goto fail

:fail
echo.
echo THERE WERE ERRORS

:end
echo ***IS FINISHED***
