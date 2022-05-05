# techOne

<div id="top"></div>


<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->
[![Contributors][contributors-shield]][contributors-url]
[![Forks][forks-shield]][forks-url]
[![Stargazers][stars-shield]][stars-url]
[![Issues][issues-shield]][issues-url]
[![MIT License][license-shield]][license-url]
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <a href="https://github.com/othneildrew/Best-README-Template">
    <img src="images/logo.png" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">techOne Number to Words converter</h3>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>






### Built With

* [React.js](https://reactjs.org/)
* [Java](https://java.com/)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- GETTING STARTED -->
## Getting Started

The application is designed to take a number input from the web based front end. This is sent to the backend and converted to the word values before being returned and displayed by the front end application.

### Prerequisites

* npm
  ```sh
  npm install npm@latest -g
  ```
* maven
  ```sh
  https://maven.apache.org/install.html
  ```
* java 11
  ```sh
  https://www.oracle.com/au/java/technologies/javase/jdk11-archive-downloads.html
  ```  

### Installation

1. Clone the repo
   ```sh
   git clone git@github.com:sam-chipp/techOne.git
   ```
2. Navigate to converter directory and run maven install
  ```sh
   cd converter
   mvn clean install
   java -jar target/converter-0.0.1-SNAPSHOT.jar
   ```
3. Move to ui (front end) directory and install.
  ```sh
   cd src/main/ui
   npm install
   npm start
   ```
4. Navigate in your browser to "localhost:3000"

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

The number to words converter accepts values greater than 0 and less than 1 trillion. Handling is in place to stop unwanted values. 

<p align="right">(<a href="#top">back to top</a>)</p>

