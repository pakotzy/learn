# Description
Elastic stack for local logs aggregation.

# Usage
1. Clients must send beats to `logstash:5044` through `ELK` network.
2. Example `Dockerfile` with `Tomcat` and `Filebeat` is in `filebeat` folder.
3. Example `Log4j2` configuration is in `filebeat` folder.
