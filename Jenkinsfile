#!groovy
timestamps {
    node {
        catchError {
            checkout scm
            docker.image('maven:3.3.3-jdk-8').withRun('-it -v /var/lib/m2:/root/.m2', 'bash') {c ->
                sh """
                docker cp . ${c.id}:/root/netphony-topology
                docker exec ${c.id} mvn -f /root/netphony-topology clean package -P generate-full-jar
                docker cp ${c.id}:/root/netphony-topology/target .
                """
            }
            def tadsVersion = version() + ".${env.BUILD_NUMBER}"
            docker.withRegistry('https://5gex.tmit.bme.hu') {
                def image = docker.build("tads:${tadsVersion}", "-f Dockerfile.tads .")
                image.push()
                image.push('latest')
            }
        }
        step([$class: 'Mailer', recipients: '5gex-devel@tmit.bme.hu'])
    }
}

def version() {
  def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
  matcher ? matcher[0][1] : null
}
