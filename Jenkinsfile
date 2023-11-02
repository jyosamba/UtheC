pipeline {
        agent any
 environment {
        registry = "jaymeid/uthec"
        registryCredentials = "dockerhub_id"
        dockerImage = ""
    }
        tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "M3"
        }

        stages {
          stage('Compile') {
              steps {
                 // Run Maven on a Unix agent.
                 sh "mvn clean compile"
              }
           }
        stage('Test') {
                steps {
                    // Run Maven on a Unix agent.
                    sh "mvn test"
                }
            }
        stage('SonarQube') {
                environment {
                        scannerHome = tool 'sonarqube'
                }
                steps {
                        withSonarQubeEnv('sonar-qube-1') {
                                sh "${scannerHome}/bin/sonar-scanner"
                        }
                }
        }
                stage('Package') {
                steps {
                    // Run Maven on a Unix agent.
                    sh "mvn package"
                }
            }
                 stage ('Build Docker Image'){
                steps{
                    script {
                        dockerImage = docker.build(registry)
                    }
                }
            }
        }
}
