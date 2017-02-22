# Example 1: TM with XML Plugin and TAPI Plugin
- First of all, compile the full-jar if you have not done so
```bash
 mvn package -P generate-full-jar
```
Execute the server
```bash
sudo java -Dlog4j.configurationFile=target/examples/log4j2.xml  -jar target/topology-1.3.4-SNAPSHOT-shaded.jar target/TM_TAPI_example1/TMConfTAPI.xml
```
Make the query
```bash
curl http://localhost:8089/config/context/topology -X GET -i -H "Content-Type: application/json" -H "Accept: application/json"
```
