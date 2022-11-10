def call(Map config=[:], Closure body) {
    node {
        git url: "https://github.com/zdia7/nodejs-jenkins-shared-library"
        stage("Install") {
            sh "npm install"
        }
        stage("Test") {
            sh "npm test"
        }
        stage("UploadArtifactNexus") {
            if (config.deploy) {
                sh "npm publish"
            }
        }
        body()
    }
}
