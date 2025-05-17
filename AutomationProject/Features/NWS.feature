Feature: NWS
@nws @weather
Scenario: Switch tab
Given NWS portal is open
Then user switches to below tab
|TabName|
|Overview|
|Examples|
|Updates|
|Specification|
