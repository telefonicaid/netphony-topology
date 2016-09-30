#!groovy
timestamps {
    node {
        checkout scm
        docker.image('maven:3.3.3-jdk-8').withRun('-it -v /var/lib/m2:/root/.m2', 'bash') {c ->
            sh """
            docker cp . ${c.id}:/root/netphony-topology
            docker exec ${c.id} mvn -f /root/netphony-topology package -P generate-full-jar
            docker cp ${c.id}:/root/netphony-topology/target .
            """
        }
        def tadsVersion = version()
        docker.withRegistry('https://registry.5gex:5000') {
            def image = docker.build("tads:${tadsVersion}", "-f Dockerfile.tads .")
            image.push()
            image.push('latest')
        }
    }
}

def version() {
  def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
  matcher ? matcher[0][1] : null
}
