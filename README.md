# JohnDeereTechnicalAssessment

<!-- ABOUT THE PROJECT -->

This project is for the technical showcase at John Deere. It will display the top 50 found words from "https://www.gutenberg.org/files/2701/2701-0.txt"

<p align="right">(<a href="#top">back to top</a>)</p>

### Built With
* [Maven](https://maven.apache.org/)
* [Spring](https://spring.io//)
* [Java11](https://www.oracle.com/java/technologies/downloads/)

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

Below are details explaining tools needed and steps necessary to build and install the project.

### Prerequisites
In order to build this project you will need to download maven and add it to your class path. Instructions can be found here.
* [Maven instructions](https://maven.apache.org/install.html)

<p align="right">(<a href="#top">back to top</a>)</p>


### Installation

Below is an example of how you can install and build the app. The following will done in your choice of terminal window

1. Clone the repo
   ```sh
   git clone https://github.com/RyanHowe083/JohnDeereTechnicalAssessment.git
   ```
2. Change directory to project folder
   ```
   cd JohnDeereTechnicalAssessment
   ```
3. Run a clean installation of the project`
   ```
   mvn clean install
   ```
4. Execute the Jar file
   ```
   java -jar target/john_deere_demo-0.0.1-SNAPSHOT.jar
   ```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

The application will display the top 50 words found in the url which points to the book Moby Dick. Some words were filtered out if overly common.
While testing the results compared to some simple websites results I noticed some special characters would throw off the count. I handled this by removing those characters, however I did not want to intrude so much as to essentially destroy certain words all together. I also found that quotation marks were not easy to remove so I elected to keep those such that the words whale and "whale are considered to not be the same.



<p align="right">(<a href="#top">back to top</a>)</p>
