echo "Hello"

set pathNew=%~dp0DeoTestAutomationjar.jar %*
echo %pathNew%
cd %pathNew%
java -jar %~dp0DeoTestAutomationjar.jar %*
@pause