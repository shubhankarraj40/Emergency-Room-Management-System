document.addEventListener("DOMContentLoaded", () => {
    // Event listener for the 'Add Patient' form
    document.getElementById("addPatientForm").addEventListener("submit", (event) => {
        event.preventDefault();
        const formData = new FormData(event.target);
        fetch("/checkIn", {
            method: "POST",
            body: formData,
        })
        .then(response => response.text())
        .then(result => {
            document.getElementById("response").innerText = result;
            event.target.reset(); // Reset the form
            fetchPatientLog(); // Refresh patient log
        })
        .catch(error => console.error('Error:', error));
    });

    // Event listener for 'Attend Next Patient' button
    document.getElementById("attendNextButton").addEventListener("click", () => {
        fetch("/attendNext")
        .then(response => response.text())
        .then(result => {
            document.getElementById("attendNextResponse").innerText = result;
            fetchPatientLog(); // Refresh patient log after attending next patient
        })
        .catch(error => console.error('Error:', error));
    });

    // Function to fetch and display the patient log
    function fetchPatientLog() {
        fetch("/patientLog")
        .then(response => response.json())
        .then(data => {
            const logTableBody = document.getElementById("patientLogTableBody");
            logTableBody.innerHTML = ""; // Clear existing rows

            data.forEach(patient => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${patient.id}</td>
                    <td>${patient.firstName} ${patient.lastName}</td>
                    <td>${patient.dateOfBirth}</td>
                    <td>${patient.medicalCondition}</td>
                    <td>${patient.urgency}</td>
                    <td>${patient.timeAttended || 'Not yet attended'}</td>
                `;
                logTableBody.appendChild(row);
            });
        })
        .catch(error => console.error('Error:', error));
    }

    // Fetch patient log on page load
    fetchPatientLog();
});
