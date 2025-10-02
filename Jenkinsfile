pipeline {
    agent any
    
    environment {
        // Define the app image and Docker credentials
        appimage = "intdoc89/bankapp:latest"
        dockerhubpwd = credentials('dockerpwd') // Replace 'DOCKERHUB_PASSWORD' with the appropriate credentials ID
    }
    
    stages {
        stage('Checkout Code') {
            steps {
                // Checkout code from GitHub repository
                git 'https://github.com/zafar90/Multi-Tier-With-Database.git'
            }
        }
        
        stage('Build and Analyze') {
            steps {
                // Build the project and run SonarQube analysis
                sh """
                /opt/maven/bin/mvn verify org.sonarsource.scanner.maven:sonar-maven-plugin:sonar \
                -Dsonar.projectKey=zafar90_Multi-Tier-With-Database \
                -Dsonar.organization=zafar90-github \
                -Dsonar.host.url=https://sonarcloud.io \
                -Dsonar.login=a844f7e6d842f9a3c0e21718856cf5719bdfd6e1
                """
            }
        }

        stage('Test') {
            steps {
                // Run Maven package to ensure tests are executed
                sh "/opt/maven/bin/mvn package"
            }
        }

        stage('Build Docker Image') {
            steps {
                // Build the Docker image
                sh "docker build -t ${appimage} ."
            }
        }

        stage('Docker Login and Push') {
            steps {
                // Log in to DockerHub and push the image
                sh "docker login -u intdoc89 -p ${dockerhubpwd}"
                sh "docker push ${appimage}"
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                // Deploy the app using Ansible playbook
                //sh "ansible-playbook -i inventory.ini ds.yml"
                sh "kubectl apply -f ds.yml"
            }
        }
    }
}
