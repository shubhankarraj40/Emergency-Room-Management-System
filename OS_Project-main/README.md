<h1>Emergency Room Management System</h1>

<p>This project is a <strong>Spring Boot-based Emergency Room Management System</strong> that uses a <strong>priority queue</strong> to manage patient check-ins based on urgency levels. The front end is designed with <strong>HTML, CSS, and JavaScript</strong>, while the back end is powered by <strong>Java</strong> and <strong>Spring Boot</strong>, utilizing <strong>JPA</strong> for database interactions.</p>

<h2>Overview</h2>
<p>The system allows users to:</p>
<ul>
    <li>Check in patients with details such as name, date of birth, medical condition, and urgency level.</li>
    <li>Attend to patients based on the urgency of their condition.</li>
    <li>View a log of all attended patients.</li>
</ul>

<h2>Features</h2>
<ul>
    <li><strong>Priority Queue</strong>: Patients are attended to based on urgency, ensuring that the most critical cases are handled first.</li>
    <li><strong>REST API</strong>: Provides endpoints for patient check-in, attendance, and viewing the patient log.</li>
    <li><strong>Spring Boot Integration</strong>: Facilitates a robust back end with RESTful services.</li>
    <li><strong>Responsive Front-End</strong>: Designed using HTML, CSS, and JavaScript for an interactive and user-friendly experience.</li>
    <li><strong>Database Integration</strong>: Uses <strong>JPA</strong> with an in-memory H2 database (or configurable to MySQL) for storing patient information.</li>
</ul>

<h2>Technologies Used</h2>
<ul>
    <li><strong>Java</strong> (Spring Boot)</li>
    <li><strong>Spring Data JPA</strong></li>
    <li><strong>HTML5</strong>, <strong>CSS3</strong>, <strong>JavaScript</strong></li>
    <li><strong>Thymeleaf</strong> (for template rendering, if needed)</li>
    <li><strong>PriorityQueue</strong> (Java Collection Framework)</li>
    <li><strong>H2 Database</strong> (in-memory, or configurable to MySQL/PostgreSQL)</li>
</ul>

<h2>API Endpoints</h2>
<ul>
    <li><code>POST /api/checkin</code>: Check in a new patient.</li>
    <li><code>GET /api/attend</code>: Attend the next patient (highest priority).</li>
    <li><code>GET /api/log</code>: View the log of all attended patients.</li>
</ul>

<h2>Screenshots</h2>
<p><img src="https://github.com/user-attachments/assets/399524f2-17a0-4d5a-b8b4-011495638b76" alt="Emergency Room System Screenshot"></p>

<h2>Explanation for Each Java File</h2>

<h3>1. EmergencyRoomApplication.java</h3>
<p>This is the main class that launches the Spring Boot application. The <code>@SpringBootApplication</code> annotation marks it as the entry point for the Spring framework. When you run this file, it starts the embedded server (Tomcat) and initializes the application context. It enables Spring Boot’s auto-configuration and component scanning. By default, it looks for components in the same package and sub-packages.</p>

<h3>2. Patient.java (Model)</h3>
<p>This file defines the <code>Patient</code> class, which serves as a model representing the patient data in the system. It includes fields such as <code>id</code>, <code>firstName</code>, <code>lastName</code>, <code>dateOfBirth</code>, <code>medicalCondition</code>, <code>urgency</code>, and <code>timeAttended</code>. The class provides getter and setter methods, and it uses the <code>@Entity</code> annotation to map the class to a table in a database. This model is critical as it represents the core data entity used across the system.</p>

<h3>3. PatientRepository.java (Repository)</h3>
<p>This is a repository interface for the <code>Patient</code> entity. It extends <code>JpaRepository</code> to provide basic CRUD (Create, Read, Update, Delete) operations and query methods for the patient data. Spring Data JPA automatically implements this interface, making it easier to interact with the database without writing manual queries.</p>

<h3>4. PatientController.java (Controller)</h3>
<p>This is the controller class that handles HTTP requests from the front end. It uses <code>@RestController</code> to define RESTful API endpoints that interact with the <code>PatientService</code>. The class provides mappings for various routes such as checking in a patient (<code>POST /api/checkin</code>), attending a patient (<code>GET /api/attend</code>), and viewing the patient log (<code>GET /api/log</code>). This class plays a crucial role in the interaction between the front-end client and the back-end logic.</p>

<h3>5. PatientService.java (Service)</h3>
<p>This service class contains the business logic for the emergency room system. It defines methods such as <code>checkInPatient</code>, <code>attendPatient</code>, and <code>getPatientLog</code>, which are used by the controller to process user requests. The service interacts with the <code>PatientRepository</code> to perform database operations. By keeping the logic here, the code maintains a clean separation between the controller and the core business logic.</p>

<h3>6. PatientComparator.java</h3>
<p>This class defines the logic for comparing two patients based on their urgency levels. It implements <code>Comparator&lt;Patient&gt;</code> and is used by the priority queue to sort patients, ensuring that those with higher urgency are attended to first. This is a key part of the algorithm that drives the patient attendance order in the system.</p>
