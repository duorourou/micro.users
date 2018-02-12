pipeline {
  agent {
    node {
      label 'master'
    }
    
  }
  stages {
    stage('error') {
      steps {
        echo 'hello world'
      }
    }
  }
  environment {
    Aprofile = 'AUAT'
  }
}