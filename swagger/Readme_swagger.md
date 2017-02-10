TAPI TOPOLOGY
===========
The yang source is  Snowmass-ONFOpenTransport/YANG/tapi-connectivity.yang  
The .swagger source is  Snowmass-ONFOpenTransport/SWAGGER/tapi-connectivity.swagger 
The swagger code is generated with the following command:
  ```bash
   java -jar swagger-codegen-cli-2.2.1.jar generate -i  tapi-topology.swagger -l jaxrs -o tapi-topo --api-package es.tid.topologyModuleBase.TAPITopoModel.api --model-package es.tid.topologyModuleBase.TAPITopoModel.model
 ```
 The swagger codege version used is 2.2.1 available in https://github.com/swagger-api/swagger-codegen/releases/tag/v2.2.1 
 Current tapi-connectivity.swagger has a bug (issue #124 in github https://github.com/OpenNetworkingFoundation/EAGLE-Open-Model-Profile-and-Tools/issues/124 )
 
